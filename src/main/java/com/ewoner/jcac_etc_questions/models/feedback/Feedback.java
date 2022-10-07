package com.ewoner.jcac_etc_questions.models.feedback;

import com.ewoner.jcac_etc_questions.models.text.Text;

public class Feedback {

    private FeedbackTypeEnum type;
    private Text text;

    public Feedback() {
        this( new Text(), FeedbackTypeEnum.General );
    }

    public Feedback( Text text, FeedbackTypeEnum type ) {
        this.text = text;
        this.type = type;
    }

    /**
     * @return the type
     */
    public FeedbackTypeEnum getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType( FeedbackTypeEnum type ) {
        this.type = type;
    }

    /**
     * @return the feedback
     */
    public Text getText() {
        return text;
    }

    /**
     * @param text the feedback to set
     */
    public void setText( Text text ) {
        this.text = text;
    }

    public String toXML( String tagString ) {
        return getText().toXML( tagString );
    }

    public String toXML() {
        return getText().toXML( getType().getXMLString() );

    }

}
