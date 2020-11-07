package com.ewoner.jcac_etc_questions;

import java.util.List;

class QuestionMatching extends Question {
	private boolean shuffleAnswers;
	private List<MatchingPair> answers;

    /**
     * @return the shuffleAnswers
     */
    public boolean isShuffleAnswers() {
        return shuffleAnswers;
    }

    /**
     * @param shuffleAnswers the shuffleAnswers to set
     */
    public void setShuffleAnswers(boolean shuffleAnswers) {
        this.shuffleAnswers = shuffleAnswers;
    }

    /**
     * @return the answers
     */
    public List<MatchingPair> getAnswers() {
        return answers;
    }

    /**
     * @param answers the answers to set
     */
    public void setAnswers(List<MatchingPair> answers) {
        this.answers = answers;
    }
	
}