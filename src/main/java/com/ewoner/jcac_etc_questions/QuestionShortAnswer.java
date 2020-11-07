package com.ewoner.jcac_etc_questions;


import java.util.List;

class QuestionShortAnswer extends Question  {
	private boolean usecase;
	private List<Answer> answers;

    /**
     * @return the usecase
     */
    public boolean isUsecase() {
        return usecase;
    }

    /**
     * @param usecase the usecase to set
     */
    public void setUsecase(boolean usecase) {
        this.usecase = usecase;
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