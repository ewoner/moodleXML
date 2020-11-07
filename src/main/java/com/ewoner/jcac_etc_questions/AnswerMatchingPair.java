package com.ewoner.jcac_etc_questions;

public class AnswerMatchingPair extends AnswerText {

    private String answer;

    public AnswerMatchingPair() {
        this( "", "" );
    }

    public AnswerMatchingPair( String text, String answer ) {
        super( text );
        this.answer = answer;

    }

    /**
     * @return the answer
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * @param answer the answer to set
     */
    public void setAnswer( String answer ) {
        this.answer = answer;
    }

}
