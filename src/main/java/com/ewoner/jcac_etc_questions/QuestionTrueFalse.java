package com.ewoner.jcac_etc_questions;

public class QuestionTrueFalse extends Question {

    private boolean answer;

    public QuestionTrueFalse() {
        this( "", "" );
    }

    public QuestionTrueFalse( String name, String text ) {
        this( name, text, true );

    }

    public QuestionTrueFalse( String name, String text, boolean answer ) {
        super( QuestionTypeEnum.TrueFalse, name, text );
        this.answer = answer;
    }

    /**
     * @return the answer
     */
    public boolean getAnswer() {
        return answer;
    }

    /**
     * @param answer the answer to set
     */
    public void setAnswer( boolean answer ) {
        this.answer = answer;
    }
}
