package ${pkg};

  public class ${self.msg_name} {
    private String messageName;
${data_block}
${code_block}
    public void setMessageName( String messageName ) {
	  this.messageName = messageName;
    }
    public String getMessageName() {
	  return messageName;
    }
}
