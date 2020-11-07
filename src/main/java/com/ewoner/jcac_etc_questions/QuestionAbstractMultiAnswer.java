/*
 * The MIT License
 *
 * Copyright 2020 Brion Lang.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.ewoner.jcac_etc_questions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


/**
 *
 * @author Brion Lang
 * @version 0.0.0
 * @param <A>
 */
public abstract class QuestionAbstractMultiAnswer<A extends Answer> extends Question implements MultiAnswerQuestion<A> {

    List<A> answers = new ArrayList<>();

    public QuestionAbstractMultiAnswer( QuestionTypeEnum type, String name, String text ) {
        super( type, name, text );
    }

    @Override
    public boolean addAllAnswers( Collection<A> answersToAdd ) {
        return this.answers.addAll( answers );
    }

    @Override
    public boolean addAnswer( A answerToAdd ) {
        return this.answers.add( answerToAdd );
    }

    @Override
    public List<Answer> getAnswers() {
        return Collections.unmodifiableList( answers );
    }

    @Override
    public void setAnswers( List<A> answers ) {
        this.answers = new ArrayList<>( answers.size() );
        this.answers.addAll( answers );
    }

    @Override
    public int numOfAnswers() {
        return this.answers.size();
    }

    @Override
    public boolean removeAnswer( A answerToRemove ) {
        return this.answers.remove( answerToRemove );
    }

    @Override
    public Answer removeAnswer( int index ) {
        return this.answers.get( index );
    }
}
