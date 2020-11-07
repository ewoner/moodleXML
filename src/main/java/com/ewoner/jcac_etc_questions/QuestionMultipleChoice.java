package com.ewoner.jcac_etc_questions;


public class QuestionMultipleChoice extends QuestionAbstractMultiAnswer {

    private AnswerNumberingEnum answerNumbering;
    private String correctFeedback;
    private String partiallyCorrectFeedback;
    private boolean shuffeAnswers;
    private boolean single;

    public QuestionMultipleChoice() {
        this( "", "", "", "" );
    }

    public QuestionMultipleChoice( String name, String text ) {
        this( name, text, "", "" );
    }

    public QuestionMultipleChoice( String name, String text, String correctFeedback ) {
        this( name, text, correctFeedback, "" );
    }

    public QuestionMultipleChoice( String name, String text,
            String correctFeedback, String partiallyCorrectFeedback ) {
        this( name, text, correctFeedback, partiallyCorrectFeedback, true );
    }

    public QuestionMultipleChoice( String name, String text,
            String correctFeedback, String partiallyCorrectFeedback,
            boolean single ) {
        super( QuestionTypeEnum.MultipleChoice, name, text );
        this.shuffeAnswers = true;
    }

    /**
     * @return the answerNumbering
     */
    public AnswerNumberingEnum getAnswerNumbering() {
        return answerNumbering;
    }

    /**
     * @param answerNumbering the answerNumbering to set
     */
    public void setAnswerNumbering( AnswerNumberingEnum answerNumbering ) {
        this.answerNumbering = answerNumbering;
    }

    /**
     * @return the correctFeedback
     */
    public String getCorrectFeedback() {
        return correctFeedback;
    }

    /**
     * @param correctFeedback the correctFeedback to set
     */
    public void setCorrectFeedback( String correctFeedback ) {
        this.correctFeedback = correctFeedback;
    }

    /**
     * @return the partiallyCorrectFeedback
     */
    public String getPartiallyCorrectFeedback() {
        return partiallyCorrectFeedback;
    }

    /**
     * @param partiallyCorrectFeedback the partiallyCorrectFeedback to set
     */
    public void setPartiallyCorrectFeedback( String partiallyCorrectFeedback ) {
        this.partiallyCorrectFeedback = partiallyCorrectFeedback;
    }

    /**
     * @return the shuffeAnswers
     */
    public boolean isShuffeAnswers() {
        return shuffeAnswers;
    }

    /**
     * @param shuffeAnswers the shuffeAnswers to set
     */
    public void setShuffeAnswers( boolean shuffeAnswers ) {
        this.shuffeAnswers = shuffeAnswers;
    }

    /**
     * @return the single
     */
    public boolean isSingle() {
        return single;
    }

    /**
     * @param single the single to set
     */
    public void setSingle( boolean single ) {
        this.single = single;
    }
}
