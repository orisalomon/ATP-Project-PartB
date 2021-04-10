package algorithms.mazeGenerators;

public abstract class AMazeGenerator implements IMazeGenerator {

    /**
     * -- measureAlgorithmTimeMillis --
     * measures the time that takes to create a rows X columns size maze
     * @param rows - rows number of generated maze
     * @param cols - columns number of generated maze
     * @return the time in milliSeconds
     */
    @Override
    public long measureAlgorithmTimeMillis(int rows, int cols) throws Exception {
        if(rows < 2 || cols < 2){
            throw new Exception("row and cols must be positive ints greater than 2");
        }
        long start = System.currentTimeMillis();
        generate(rows,cols);
        long end = System.currentTimeMillis();
        return end-start;

    }
}
