package com.ewoner.jcac_etc_questions;


public class QuestionMatching extends QuestionAbstractMultiAnswer<AnswerMatchingPair> {

    private boolean shuffleAnswers;

    public QuestionMatching() {
        this( "", "" );
    }

    public QuestionMatching( String name, String text ) {
        super( QuestionTypeEnum.Matching, name, text );
        this.shuffleAnswers = true;
    }

    public boolean isShuffleAnswers() {
        return shuffleAnswers;
    }

    public void setShuffleAnswers( boolean shuffleAnswers ) {
        this.shuffleAnswers = shuffleAnswers;
    }
}
