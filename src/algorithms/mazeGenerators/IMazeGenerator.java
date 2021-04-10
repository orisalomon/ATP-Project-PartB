package algorithms.mazeGenerators;

public interface IMazeGenerator {
    /**
     * creates a rows X cols maze
     * @param rows - rows number of generated maze
     * @param cols - columns number of generated maze
     * @return maze object
     */
    Maze generate(int rows, int cols) throws Exception;
    /**
     * measures the time that takes to create a rows X columns size maze
     * @param rows - rows number of generated maze
     * @param cols - columns number of generated maze
     * @return the time in milliSeconds
     */
    long measureAlgorithmTimeMillis(int rows, int cols) throws Exception;
}
