package algorithms.maze3D;

import java.util.Objects;

public class Position3D {
    private int row;
    private int col;
    private int depth;

    /**
     * --- Constructor ---
     * @param depth - depth location (index)
     * @param row - row location (index)
     * @param col - col location (index)
     */
    public Position3D( int depth, int row, int col) throws Exception {
        if(depth < 0 || row < 0 || col < 0){
            throw new Exception("depth, row and cols must be positive ints");
        }
        this.row = row;
        this.depth = depth;
        this.col = col;
    }

    /**
     *
     * @return depth index
     */
    public int getDepthIndex(){return depth;}
    /**
     *
     * @return row index
     */
    public int getRowIndex(){return row;}
    /**
     *
     * @return column index
     */
    public int getColumnIndex(){return col;}

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position3D position = (Position3D) o;
        return row == position.row && col == position.col && position.depth==depth;
    }
    public String toString() {
        return "{"+depth+","+row+","+col+"}";
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col, depth);
    }
}
