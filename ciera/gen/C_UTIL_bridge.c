/*----------------------------------------------------------------------------
 * File:  C_UTIL_bridge.c
 *
 * Description:
 * Methods for bridging to an external entity.
 *
 * External Entity:  utilities (C_UTIL)
 * 
 * your copyright statement can go here (from te_copyright.body)
 *--------------------------------------------------------------------------*/

#include "ciera_sys_types.h"
#include "CSV_bridge.h"
#include "LOG_bridge.h"
#include "STR_bridge.h"
#include "STRING_bridge.h"
#include "T_bridge.h"
#include "TRACE_bridge.h"
#include "C_UTIL_bridge.h"
#include "C_UTIL_bridge.h"
#include "ciera_sys_types.h"


/*
 * Bridge:  organizeImports
 */

#define MAX_IMPORTS 1024
#define MAX_LINE    256

#include <string.h>
#include <stdlib.h>

int internal_C_UTIL_compare_strings( const void * a, const void * b ) {
  // alphanumeric comparison of strings
  // empty strings always last
  if ( '\0' == *((const char *)a) ) return 1;
  else if ( '\0' == *((const char *)b) ) return -1;
  else return strcmp( (const char *)a, (const char *)b );
}

c_t *
C_UTIL_organizeImports( c_t * p_s )
{

  // set up a buffer for the imports
  char * string = p_s;
  char buf[MAX_IMPORTS][MAX_LINE];
  memset( buf, 0, MAX_IMPORTS * MAX_LINE );

  // load lines one by one (ignore blank lines)
  int index = 0;
  int newline_index = STR_indexof( string, "\n" );
  while ( -1 != newline_index ) {
    if ( newline_index > 0 ) {
      memcpy( buf[index], STR_substr( 0, newline_index, string ), newline_index );
      index++;
    }
    string = string + newline_index + 1;
    newline_index = STR_indexof( string, "\n" );
  }

  // sort
  qsort( buf, MAX_IMPORTS, MAX_LINE, internal_C_UTIL_compare_strings );

  // load the return string
  char prev_base[MAX_LINE];
  memset( prev_base, 0, MAX_LINE );
  *p_s = '\0';
  for ( int i = 0; i < MAX_IMPORTS; i++ ) {
    if ( '\0' == buf[i][0] ) break; // empty strings at the end
    int dot_index = STR_indexof( buf[i], "." );
    if ( -1 == dot_index ) dot_index = STR_indexof( buf[i], ";" );
    if ( strcmp( prev_base, STR_substr( 0, dot_index, buf[i] ) ) && '\0' != prev_base[0] ) {
      strcat( p_s, "\n" ); // add an extra line between imports with different base packages
    }
    strcat( p_s, buf[i] );
    strcat( p_s, "\n" );
    memset( prev_base, 0, MAX_LINE );
    memcpy( prev_base, STR_substr( 0, dot_index, buf[i] ), dot_index );
  }

  return p_s;

}
