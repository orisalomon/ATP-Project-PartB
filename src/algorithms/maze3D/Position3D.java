package algorithms.maze3D;

import java.util.Objects;

public class Position3D {
    private int row;
    private int col;
    private int depth;

    public Position3D( int depth, int row, int col) {
        this.row = row;
        this.depth = depth;
        this.col = col;
    }

    public int getDepthIndex(){return depth;}
    public int getRowIndex(){return row;}
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
