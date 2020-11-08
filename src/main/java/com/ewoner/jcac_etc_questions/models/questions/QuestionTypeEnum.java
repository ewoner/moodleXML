package com.ewoner.jcac_etc_questions.models.questions;

public enum QuestionTypeEnum {
    MultipleChoice( "multichoice" ),
    TrueFalse( "truefalse" ),
    ShortAnswer,
    NumericalResponse,
    Matching,
    Essay,
    Cloze,
    DescriptionResonse,
    RandomMatching,
    Category( "category" ),
    NONE;

    private final String xmlString;

    private QuestionTypeEnum() {
        xmlString = this.name();
    }

    private QuestionTypeEnum( String xmlString ) {
        this.xmlString = xmlString;
    }

    public String getXMLString() {
        return this.xmlString;
    }
}
