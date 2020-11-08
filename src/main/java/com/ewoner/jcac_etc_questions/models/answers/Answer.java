package com.ewoner.jcac_etc_questions.models.answers;

public class Answer {

    private double fraction;
    private String feedback;

    public Answer() {
        this( 0.0, "" );
    }

    public Answer( double fraction ) {
        this( fraction, "" );
    }

    public Answer( double fraction, String feedback ) {
        this.fraction = fraction;
        this.feedback = feedback;
    }

    /**
     * @return the fraction
     */
    public double getFraction() {
        return fraction;
    }

    /**
     * @param fraction the fraction to set
     */
    public void setFraction( double fraction ) {
        this.fraction = fraction;
    }

    /**
     * @return the feedback
     */
    public String getFeedback() {
        return feedback;
    }

    /**
     * @param feedback the feedback to set
     */
    public void setFeedback( String feedback ) {
        this.feedback = feedback;
    }
}
