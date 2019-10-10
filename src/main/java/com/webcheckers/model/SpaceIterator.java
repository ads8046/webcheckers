package com.webcheckers.model;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Author: Atharva Shivankar (ads8046@rit.edu)
 */
public class SpaceIterator implements Iterator<Space>{
    private Space spaces[];
    private int currentSpace = 0;

    public SpaceIterator(Space spaces[]){
        this.spaces = spaces;
    }

    @Override
    public boolean hasNext() {
        return currentSpace < spaces.length;
    }

    @Override
    public Space next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return spaces[currentSpace++];
    }
}
