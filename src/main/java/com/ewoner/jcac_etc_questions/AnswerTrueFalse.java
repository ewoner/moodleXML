package com.ewoner.jcac_etc_questions;

class AnswerTreFalse extends Answer {
	private double fraction;
	private String feedback;
	private boolean text;

    /**
     * @return the fraction
     */
    public double getFraction() {
        return fraction;
    }

    /**
     * @param fraction the fraction to set
     */
    public void setFraction(double fraction) {
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
    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    /**
     * @return the text
     */
    public boolean isText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(boolean text) {
        this.text = text;
    }
}
