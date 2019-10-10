package com.webcheckers.model;

import java.util.Iterator;

/**
 *
 * @author: Mason Zhong
 */

public class Row implements Iterable {

    private int index;
    private int currentSpace = 0;
    private Space spaces[];

    public Row(int index) {
        spaces = new Space[8];
        this.index = index;
        int i = 0;
        for (Space s: spaces) {
            if (index == 4 || index == 5) {
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


    public int getIndex() {
        return this.index;
    }

    public Iterator<Space> iterator() {
        return new SpaceIterator(this.spaces);
    }

}