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
package com.ewoner;

import java.util.Objects;


/**
 *
 * @author Brion Lang
 */
public class pair<T, U> {

    public final T first;
    public final U second;

    public pair( T first, U second ) {
        this.first = first;
        this.second = second;
    }

    public pair( pair<T, U> p ) {
        this.first = p.first;
        this.second = p.second;
    }

    @Override
    public boolean equals( Object ob ) {
        if ( ob instanceof pair ) {
            pair obP = ( pair ) ob;
            if ( this.first.equals( obP.first ) && this.second.equals( obP.second ) ) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode( this.first );
        hash = 47 * hash + Objects.hashCode( this.second );
        return hash;
    }
}
