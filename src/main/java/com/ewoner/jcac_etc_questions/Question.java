package com.ewoner.jcac_etc_questions;

public class Question {

    private String name;
    private String text;
    private QuestionTextFormatEnum textFormat;
    private QuestionTypeEnum type;

    private Question( QuestionTypeEnum type ) {
        this( type, "", "" );
    }

    public Question( QuestionTypeEnum type, String name, String text ) {
        this.type = type;
        this.name = name;
        this.text = text;
        this.textFormat = QuestionTextFormatEnum.html;
    }

    private Question() {
        this( null, "", "" );
        textFormat = null;
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
    public void setName( String name ) {
        this.name = name;
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
    public void setText( String text ) {
        this.text = text;
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
    public void setTextFormat( QuestionTextFormatEnum textFormat ) {
        this.textFormat = textFormat;
    }

    /**
     * @return the type
     */
    public QuestionTypeEnum getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType( QuestionTypeEnum type ) {
        this.type = type;
    }

}
