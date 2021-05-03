package algorithms.mazeGenerators;

import java.io.Serializable;
import java.util.Objects;

public class Position implements Serializable {
    private int row;
    private int col;

    /**
     * --- Constructor ---
     * @param row - row location (index)
     * @param col - col location (index)
     */
    public Position(int row, int col) throws Exception {
        if(row < 0 || col < 0){
            throw new Exception("row and cols must be positive ints");
        }
        this.row = row;
        this.col = col;
    }
    /**
     *
     * @return row index
     */
    public int getRowIndex() {
        return row;
    }
    /**
     *
     * @return column index
     */
    public int getColumnIndex() {
        return col;
    }

    @Override
    public String toString() {
        return "{"+row+","+col+"}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return row == position.row && col == position.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }

}

