package algorithms.maze3D;

public interface IMazeGenerator3D {
    /**
     * -- generate --
     * creates a depth X row X columns size 3D maze
     * @param depth - depth size of generated maze
     * @param row - rows number of generated maze
     * @param column - columns number of generated maze
     * @return maze3D object
     */
    Maze3D generate(int depth, int row, int column) throws Exception;

    /**
     * -- measureAlgorithmTimeMillis --
     * measures the time that takes to create a depth X row X columns size 3D maze
     * @param depth - depth size of generated maze
     * @param row - rows number of generated maze
     * @param column - columns number of generated maze
     * @return the time in milliSeconds
     */
    long measureAlgorithmTimeMillis(int depth, int row, int column) throws Exception;
}
