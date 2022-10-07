
package com.ewoner.jcac_etc_questions.models.feedback;

/**
 *
 * @author student
 */
public enum FeedbackTypeEnum {
    General,
    Correct,
    Partial,
    Incorrect,
    Answer;

    private final String xmlString;

    private FeedbackTypeEnum() {
        xmlString = this.name().toLowerCase() + "feedback";
    }

    public String getXMLString() {
        return this.xmlString;
    }

}
