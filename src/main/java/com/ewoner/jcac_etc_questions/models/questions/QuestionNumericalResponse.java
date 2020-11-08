package com.ewoner.jcac_etc_questions.models.questions;

import com.ewoner.jcac_etc_questions.models.answers.Unit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class QuestionNumericalResponse extends Question {

    private double tolerance;
    private List<Unit> units;

    public QuestionNumericalResponse() {
        this( "", "", 0.0, null );
    }

    public QuestionNumericalResponse( String name, String text ) {
        this( name, text, 0.0, null );
    }

    public QuestionNumericalResponse( String name, String text, double tolerance ) {
        this( name, text, tolerance, null );
    }

    public QuestionNumericalResponse( String name, String text, double tolerance, List<Unit> units ) {
        super( QuestionTypeEnum.NumericalResponse, name, text );
        this.tolerance = tolerance;
        this.units = units;
    }

    /**
     * @return the tolerance
     */
    public double getTolerance() {
        return tolerance;
    }

    /**
     * @param tolerance the tolerance to set
     */
    public void setTolerance( double tolerance ) {
        this.tolerance = tolerance;
    }

    /**
     * @return the units
     */
    public List<Unit> getUnits() {
        return Collections.unmodifiableList( units );
    }

    /**
     * @param units the units to set
     */
    public void setUnits( List<Unit> units ) {
        this.units = new ArrayList<>( units.size() );
        this.units.addAll( units );
    }

    public boolean hasUnits() {
        return ( this.units != null && this.units.isEmpty() == false );
    }
}
