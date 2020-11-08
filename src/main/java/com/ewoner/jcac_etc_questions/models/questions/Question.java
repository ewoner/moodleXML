package com.ewoner.jcac_etc_questions.models.questions;

import com.ewoner.jcac_etc_questions.models.TextFormatEnum;


public abstract class Question {

    private String name;
    private String text;
    private TextFormatEnum textFormat;
    private QuestionTypeEnum type;
    private String id;
    private double points;
    private double penalty;
    private boolean hidden;

    private Question( QuestionTypeEnum type ) {
        this( type, "", "" );
    }

    public Question( QuestionTypeEnum type, String name, String text ) {
        this.type = type;
        this.name = name;
        this.text = text;
        this.textFormat = TextFormatEnum.html;
        this.id = "";
        points = 1.0;
        penalty = 1.0;
        hidden = false;
    }

    private Question() {
        this( QuestionTypeEnum.NONE, "", "" );
        textFormat = TextFormatEnum.html;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText( String text ) {
        this.text = text;
    }

    public TextFormatEnum getTextFormat() {
        return textFormat;
    }

    public void setTextFormat( TextFormatEnum textFormat ) {
        this.textFormat = textFormat;
    }

    public QuestionTypeEnum getType() {
        return type;
    }

    public void setType( QuestionTypeEnum type ) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId( String id ) {
        this.id = id;
    }

    public double getPoints() {
        return points;
    }

    public void setPoints( double points ) {
        this.points = points;
    }

    public double getPenalty() {
        return penalty;
    }

    public void setPenalty( double penalty ) {
        this.penalty = penalty;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden( boolean hidden ) {
        this.hidden = hidden;
    }

}
