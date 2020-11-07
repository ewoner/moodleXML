package com.ewoner.jcac_etc_questions;

import java.util.List;

class MultipleChoiceQuestion extends Question {
	
	private boolean single;
	private boolean shuffeAnswers;
	private String correctFeedback;
	private String partiallyCorrectFeedback;
	private AnswerNumberingEnum answerNumbering;
	
	private List<Answer> answers;

    /**
     * @return the single
     */
    public boolean isSingle() {
        return single;
    }

    /**
     * @param single the single to set
     */
    public void setSingle(boolean single) {
        this.single = single;
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
    public void setShuffeAnswers(boolean shuffeAnswers) {
        this.shuffeAnswers = shuffeAnswers;
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
    public void setCorrectFeedback(String correctFeedback) {
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
    public void setPartiallyCorrectFeedback(String partiallyCorrectFeedback) {
        this.partiallyCorrectFeedback = partiallyCorrectFeedback;
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
    public void setAnswerNumbering(AnswerNumberingEnum answerNumbering) {
        this.answerNumbering = answerNumbering;
    }

    /**
     * @return the answers
     */
    public List<Answer> getAnswers() {
        return answers;
    }

    /**
     * @param answers the answers to set
     */
    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}