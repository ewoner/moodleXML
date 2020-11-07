enum AnswerNumberingEnum {
	none("none",
	abc("abc"),
	ABCD("ABCD"),
	numbers("123");
	
	AnswerNumberingEnum() {
		this(name());
	}
	AnswerNumberingEum ( String xml ) {
		this.xml = xml;
	}
	
	private String xml;
	
	public String getXML (){
		return xml;
	}
}

