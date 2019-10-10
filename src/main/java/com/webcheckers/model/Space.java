package com.webcheckers.model;


/**
 * Author: Atharva Shivankar (ads8046@rit.edu)
 */
public class Space {

    private int cellIdx;
    private int rowIndex;

    private final int max = 7;
    private final int min = 0;

    private boolean isEmpty;
    private Piece currentPiece;

    public Space ( int cellIdx, int rowIndex, boolean isEmpty) {
        this.cellIdx = cellIdx;
        this.isEmpty = true;
        this.currentPiece = null;
        this.rowIndex = rowIndex;
    }

    /**
     * Checks if the space is open for a
     * valid move
     *
     * @return bool
     */
    public boolean isValid(){
        return ((this.getCellIdx() % 2) == 0) && ((this.rowIndex % 2) == 0);
    }

    /**
     * Returns the cell index of the current space
     *
     * @return int
     */
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

    /**
     * Setter - occupies a space
     */
    public void setSpaceOccupied(){
        this.isEmpty = false;
    }

    /**
     * Checks if a space is empty
     *
     * @return bool
     */
    public boolean isEmpty() {
        return this.isEmpty;
    }


    /**
     * Returns the piece object occupying the current
     * space or null if empty
     *
     * @return current piece
     */
    public Piece getCurrentPiece(){
        if (isEmpty) {
            return null;
        }
        return currentPiece;
    }

}
