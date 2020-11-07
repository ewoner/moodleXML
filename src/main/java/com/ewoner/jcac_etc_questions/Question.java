package com.ewoner.jcac_etc_questions;

class Question {
	private QuestionTypeEnum type;
	private String name;
	private QuestionTextFormatEnum textFormat;
	private String text;

    /**
     * @return the type
     */
    public QuestionTypeEnum getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(QuestionTypeEnum type) {
        this.type = type;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the textFormat
     */
    public QuestionTextFormatEnum getTextFormat() {
        return textFormat;
    }

    /**
     * @param textFormat the textFormat to set
     */
    public void setTextFormat(QuestionTextFormatEnum textFormat) {
        this.textFormat = textFormat;
    }

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }
	
	
}