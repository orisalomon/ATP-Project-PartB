package algorithms.maze3D;


public abstract class AMaze3DGenerator implements IMaze3DGenerator {


    /**
     * -- measureAlgorithmTimeMillis --
     * measures the time that takes to create a depth X row X columns size 3D maze
     * @param depth - depth size of generated maze
     * @param row - rows number of generated maze
     * @param column - columns number of generated maze
     * @return the time in milliSeconds
     */
    public long measureAlgorithmTimeMillis(int depth, int row, int column) throws Exception {
                if(depth < 2 || row < 2 || column < 2){
            throw new Exception("depth, row and cols must be positive ints greater than 2");
        }
        long start = System.currentTimeMillis();
        generate(depth,row,column);
        long end = System.currentTimeMillis();
        return end-start;
    }
}
