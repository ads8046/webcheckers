package com.webcheckers.model;

public class Space {
    private int cellIdx;
    private final int max = 7;
    private final int min = 0;

    public Space (int cellIdx) {
        this.cellIdx = cellIdx;
    }

    public int getCellIdx(int index) {
        if (min <= index && index <= max){
            return index;
        }
        else {
            try {
                throw new Exception(" ERROR: Index should be between 0 to 7");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }


}
