package com.webcheckers.model;

import java.util.Iterator;

/**
 * Class for a Row in the board
 *
 */

public class Row implements Iterable {

    private int index;
    private Space spaces[];

    /**
     * Creates a row and populates it with spaces
     * @param index
     */
    public Row(int index) {
        spaces = new Space[8];
        this.index = index;
        int i = 0;
        for (Space s: spaces) {
            if (index == 3 || index == 4) {
                spaces[i] = new Space(index, i, true);
            } else if (index % 2 == 0) {
                if (i % 2 == 0) {
                    spaces[i] = new Space(index, i, true);
                } else if (i % 2 == 1) {
                    spaces[i] = new Space(index, i, false);
                }
            } else if (index % 2 == 1) {
                if (i % 2 == 0) {
                    spaces[i] = new Space(index, i, false);
                } else if (i % 2 == 1) {
                    spaces[i] = new Space(index, i, true);
                }
            }
            i++;
        }
    }

    /**
     * Gets the index of the row
     * @return index of the row
     */
    public int getIndex() {
        return this.index;
    }

    /**
     * Creates and returns an iterator that iterates through the spaces in a row
     * @return an iterator that iterates through the spaces in a row
     */
    public Iterator<Space> iterator() {
        return new SpaceIterator(this.spaces);
    }

}