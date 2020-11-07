package com.ewoner.jcac_etc_questions;

enum AnswerNumberingEnum {
	none("none"),
	abc("abc"),
	ABCD("ABCD"),
	numbers("123");
	
	
	AnswerNumberingEnum ( String xml ) {
		this.xml = xml;
	}
	
	private final String xml;
	
	public String getXML (){
		return xml;
	}
}

