package com.ewoner.jcac_etc_questions;


import java.util.List;

class QuestionNumericalResponse extends Question {
	private List<Unit> units;
	private double tolerance;

    /**
     * @return the units
     */
    public List<Unit> getUnits() {
        return units;
    }

    /**
     * @param units the units to set
     */
    public void setUnits(List<Unit> units) {
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
    public void setTolerance(double tolerance) {
        this.tolerance = tolerance;
    }
}