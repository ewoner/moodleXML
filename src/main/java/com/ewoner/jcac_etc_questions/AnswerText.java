package com.ewoner.jcac_etc_questions;

public class AnswerText extends Answer {

    private String text;

    public AnswerText() {
        this( "" );
    }

    public AnswerText( String text ) {
        this.text = text;
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
}
