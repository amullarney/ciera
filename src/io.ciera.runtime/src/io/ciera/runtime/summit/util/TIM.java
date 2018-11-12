package io.ciera.runtime.summit.util;

import io.ciera.runtime.summit.exceptions.XtumlException;
import io.ciera.runtime.summit.statemachine.EventHandle;
import io.ciera.runtime.summit.time.TimerHandle;
import io.ciera.runtime.summit.types.Date;
import io.ciera.runtime.summit.types.TimeStamp;

public interface TIM {

    public Date create_date(int day, int hour, int minute, int month, int second, int year) throws XtumlException;

    public TimeStamp current_clock() throws XtumlException;

    public Date current_date() throws XtumlException;

    public int get_day(Date date) throws XtumlException;

    public int get_month(Date date) throws XtumlException;

    public int get_year(Date date) throws XtumlException;

    public int get_hour(Date date) throws XtumlException;

    public int get_minute(Date date) throws XtumlException;

    public int get_second(Date date) throws XtumlException;

    public boolean timer_add_time(int microseconds, TimerHandle timer_inst_ref) throws XtumlException;

    public boolean timer_cancel(TimerHandle timer_inst_ref) throws XtumlException;

    public int timer_remaining_time(TimerHandle timer_inst_ref) throws XtumlException;

    public boolean timer_reset_time(int microseconds, TimerHandle timer_inst_ref) throws XtumlException;

    public TimerHandle timer_start(EventHandle event_inst, int microseconds) throws XtumlException;

    public TimerHandle timer_start_recurring(EventHandle event_inst, int microseconds) throws XtumlException;

}
