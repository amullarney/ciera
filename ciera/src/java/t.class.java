T_b("package ");
T_b(package_name);
T_b(";");
T_b("\n");
T_b(import_block);
T_b("\n");
T_b("public class ");
T_b(class_name);
T_b(" extends ModelInstance {");
T_b("\n");
T_b("   ");
T_b(" ");
T_b("\n");
T_b("    ");
T_b("private static final int classNumber = ");
T_b(class_number);
T_b(";");
T_b("\n");
T_b("    ");
T_b("private static final String keyLetters = \"");
T_b(class_kl);
T_b("\";");
T_b("\n");
T_b("    ");
T_b("private static final Class<?> setClass = ");
T_b(set_class);
T_b(".class;");
T_b("\n");
T_b("   ");
T_b(" ");
T_b("\n");
T_b("    ");
T_b("// empty instance");
T_b("\n");
T_b("    ");
T_b("public static final ");
T_b(class_name);
T_b(" empty");
T_b(class_name);
T_b(" = new Empty");
T_b(class_name);
T_b("();");
T_b("\n");
T_b("   ");
T_b(" ");
T_b("\n");
T_b("    ");
T_b("// class attributes");
T_b("\n");
T_b(attribute_block);
T_b("\n");
T_b("   ");
T_b(" ");
T_b("\n");
T_b("    ");
T_b("// associations");
T_b("\n");
T_b(assoc_attr_block);
T_b("\n");
T_b("   ");
T_b(" ");
T_b("\n");
T_b(rto_functions_block);
T_b("\n");
T_b("    ");
T_b("// constructor");
T_b("\n");
T_b("    ");
T_b("public ");
T_b(class_name);
T_b("() {");
T_b("\n");
if ( has_ism ) {
T_b("        ");
T_b("super( new ");
T_b(class_name);
T_b("InstanceStateMachine() );");
T_b("\n");
} else {
T_b("        ");
T_b("super();");
T_b("\n");
}
T_b(attr_init_block);
T_b("\n");
T_b("    ");
T_b("}");
T_b("\n");
T_b("   ");
T_b(" ");
T_b("\n");
T_b("    ");
T_b("// attribute accessors");
T_b("\n");
T_b(accessors_block);
T_b("\n");
T_b("    ");
T_b("// selections");
T_b("\n");
T_b(selections_block);
T_b("\n");
T_b("   ");
T_b(" ");
T_b("\n");
T_b("    ");
T_b("// relates");
T_b("\n");
T_b(relates_block);
T_b("\n");
T_b("   ");
T_b(" ");
T_b("\n");
T_b("    ");
T_b("// unrelates");
T_b("\n");
T_b(unrelates_block);
T_b("\n");
T_b("    ");
T_b("@Override");
T_b("\n");
T_b("    ");
T_b("public int getClassNumber() {");
T_b("\n");
T_b("        ");
T_b("return classNumber;");
T_b("\n");
T_b("    ");
T_b("}");
T_b("\n");
T_b("   ");
T_b(" ");
T_b("\n");
T_b("    ");
T_b("@Override");
T_b("\n");
T_b("    ");
T_b("public String getKeyLetters() {");
T_b("\n");
T_b("        ");
T_b("return keyLetters;");
T_b("\n");
T_b("    ");
T_b("}");
T_b("\n");
T_b("    ");
T_b("public static Class<?> getSetClass() {");
T_b("\n");
T_b("        ");
T_b("return setClass;");
T_b("\n");
T_b("    ");
T_b("}");
T_b("\n");
T_b("}");
T_b("\n");
T_b("class Empty");
T_b(class_name);
T_b(" extends ");
T_b(class_name);
T_b(" implements EmptyInstance {");
T_b("\n");
T_b("    ");
T_b("// selections");
T_b("\n");
T_b(empty_selections_block);
T_b("\n");
T_b("    ");
T_b("// relates");
T_b("\n");
T_b(empty_relates_block);
T_b("\n");
T_b("    ");
T_b("// unrelates");
T_b("\n");
T_b(empty_unrelates_block);
T_b("\n");
T_b("}");
T_b("\n");
