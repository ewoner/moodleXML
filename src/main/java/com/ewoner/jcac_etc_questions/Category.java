package com.ewoner.jcac_etc_questions;

import java.util.Collections;
import java.util.List;


public class Category {

    private List<Question> questions;
    private String name;

    /**
     * @return the questions
     */
    public List<Question> getQuestions() {
        return Collections.unmodifiableList( questions );

    }

    /**
     * @param questions the questions to set
     */
    public void setQuestions( List<Question> questions ) {
        this.questions = questions;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName( String name ) {
        this.name = name;
    }

}
