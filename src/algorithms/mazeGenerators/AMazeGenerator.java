package algorithms.mazeGenerators;

public abstract class AMazeGenerator implements IMazeGenerator {

    @Override
    public long measureAlgorithmTimeMillis(int rows, int cols) {
        //        if(rows < 2 || cols < 2){
//            throw new Exception("row and cols must be positive ints greater than 2");
//        }
        long start = System.currentTimeMillis();
        generate(rows,cols);
        long end = System.currentTimeMillis();
        return end-start;

    }
}
