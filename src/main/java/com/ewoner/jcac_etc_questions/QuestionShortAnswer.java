package com.ewoner.jcac_etc_questions;

import java.util.ArrayList;
import java.util.List;


public class QuestionShortAnswer extends QuestionAbstractMultiAnswer<AnswerText> {

    private boolean usecase;

    public QuestionShortAnswer() {
        this( "", "" );
    }

    public QuestionShortAnswer( String name, String text ) {
        this( name, text, new ArrayList<>(), false );
    }

    public QuestionShortAnswer( String name, String text, List<AnswerText> answers ) {
        this( name, text, answers, false );
    }

    public QuestionShortAnswer( String name, String text, List<AnswerText> answers, boolean usecase ) {
        super( QuestionTypeEnum.ShortAnswer, name, text );
        this.setAnswers( answers );
        this.usecase = usecase;
    }

    /**
     * @return the usecase
     */
    public boolean isUsecase() {
        return usecase;
    }

    /**
     * @param usecase the usecase to set
     */
    public void setUsecase( boolean usecase ) {
        this.usecase = usecase;
    }
}
