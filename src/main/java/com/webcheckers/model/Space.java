package com.webcheckers.model;

/**
 * Class for a space in the row
 */
public class Space {

    private int cellIdx;
    private int rowIndex;

    private final int max = 7;
    private final int min = 0;

    private boolean isEmpty;
    private Piece currentPiece;

    /**
     * Creates an empty space
     * @param cellIdx cell index
     * @param rowIndex row index in the board
     * @param isEmpty space occupancy by a piece
     */
    public Space (int cellIdx, int rowIndex, boolean isEmpty) {
        this.cellIdx = cellIdx;
        this.rowIndex = rowIndex;
        this.isEmpty = isEmpty;
        if (isEmpty) {
            this.currentPiece = null;
        } else if (cellIdx < 3) {
            this.currentPiece = new Piece(Piece.PieceColors.RED);
        } else {
            this.currentPiece = new Piece(Piece.PieceColors.WHITE);
        }
    }

    /**
     * Checks if the space is open for a
     * valid move
     *
     * @return bool
     */
    public boolean isValid(){
        return ((this.getCellIdx() % 2) == 0) && ((this.rowIndex % 2) == 0) && isEmpty();
    }

    /**
     * Returns the cell index of the current space
     * @return cell index
     */
    public int getCellIdx() {
        return this.cellIdx;
//        if (min <= cellIdx && cellIdx <= max){
//            return this.cellIdx;
//        }
//        else {
//            try {
//                throw new Exception(" ERROR: Space index must be between 0 to 7");
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return 0;
    }

    /**
     * Sets the occupancy of the space
     */
    public void setSpaceOccupied() {
        this.isEmpty = false;
    }

    /**
     * Checks if a space is empty
     * @return true if space is empty, false otherwise
     */
    public boolean isEmpty() {
        return this.isEmpty;
    }


    /**
     * Returns the piece object occupying the current
     * space or null if empty
     * @return current piece
     */
    public Piece getPiece() {
//        if (isEmpty) {
//            return null;
//        }
        return currentPiece;
    }

}
