package com.webcheckers.model;

public class Space {
    private int cellIdx;
    private int rowIndex;

    private final int max = 7;
    private final int min = 0;

    private boolean isEmpty;
    private Piece currentPiece;



    public Space ( int cellIdx, int rowIndex, boolean isEmpty, Piece currentPiece  ) {
        this.cellIdx = cellIdx;
        this.isEmpty = true;
        this.currentPiece = null;
        this.rowIndex = rowIndex;

    }

    public boolean isValid(){
        return ((this.getCellIdx() % 2) == 0) && ((this.rowIndex % 2) == 0);
    }

    public int getCellIdx() {
        if (min <= cellIdx && cellIdx <= max){
            return this.cellIdx;
        }
        else {
            try {
                throw new Exception(" ERROR: Space index must be between 0 to 7");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public void setSpaceOccupied(){
        this.isEmpty = false;
    }

    public boolean isEmpty() {
        return this.isEmpty;
    }

    public Piece getCurrentPiece(){
        if (isEmpty) {
            return null;
        }
        return currentPiece;
    }

}
