package algorithms.maze3D;


public abstract class AMaze3DGenerator implements IMazeGenerator3D{

    public long measureAlgorithmTimeMillis(int depth, int row, int column){
        //        if(depth < 2 || row < 2 || column < 2){
//            throw new Exception("depth, row and cols must be positive ints greater than 2");
//        }
        long start = System.currentTimeMillis();
        generate(depth,row,column);
        long end = System.currentTimeMillis();
        return end-start;
    }
}
