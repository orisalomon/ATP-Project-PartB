import algorithms.mazeGenerators.*;
import algorithms.search.*;


public class main {
    public static void main(String[] args) {

        Maze newMaze = new MyMazeGenerator().generate(200,200);
        //System.out.println(newMaze);
        BreadthFirstSearch bfs = new BreadthFirstSearch();
        SearchableMaze smaze = new SearchableMaze(newMaze);
        long start = System.currentTimeMillis();
        Solution sol = bfs.solve(smaze);
        long end = System.currentTimeMillis();
        System.out.println("Number of nodes evaluated: " + bfs.getNumberOfNodesEvaluated());
        System.out.println("Number of Steps: "+ sol.getSolutionPath().size());
        System.out.println("Time: "+ (end-start)/1000);

//        for (AState s : sol.getSolutionPath()
//             ) {
//            System.out.println(s);
//        }




    }
}
