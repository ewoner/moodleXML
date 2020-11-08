package com.ewoner.jcac_etc_questions.models.questions;

import com.ewoner.jcac_etc_questions.models.TextFormatEnum;


public abstract class QuestionFeedback extends Question {

    private String feedback;
    private TextFormatEnum feedbackFormat;

    private QuestionFeedback() {
        this( QuestionTypeEnum.NONE, "", "" );
    }

    public QuestionFeedback( QuestionTypeEnum type, String name, String text ) {
        super( type, name, text );
        this.feedback = "";
        this.feedbackFormat = TextFormatEnum.html;
    }

    public QuestionFeedback( String feedback ) {
        this( QuestionTypeEnum.NONE, "", "" );

    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback( String feedback ) {
        this.feedback = feedback;
    }

    public TextFormatEnum getFeedbackFormat() {
        return feedbackFormat;
    }

    public void setFeedbackFormat( TextFormatEnum feedbackFormat ) {
        this.feedbackFormat = feedbackFormat;
    }
}
