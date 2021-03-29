import algorithms.mazeGenerators.*;
import algorithms.search.*;


public class main {
    public static void main(String[] args) {

        Maze newMaze = new MyMazeGenerator().generate(30,30);
        //System.out.println(newMaze);
        //DepthFirstSearch dfs = new DepthFirstSearch();
        BreadthFirstSearch bfs = new BreadthFirstSearch();
        SearchableMaze smaze = new SearchableMaze(newMaze);
        long start = System.currentTimeMillis();
        Solution sol = bfs.solve(smaze);
        long end = System.currentTimeMillis();

//        System.out.println(newMaze);
//        for (AState s : sol.getSolutionPath()
//        ) {
//            System.out.println(s);
//        }

        System.out.println("Number of nodes evaluated: " + bfs.getNumberOfNodesEvaluated());
        System.out.println("Number of Steps: "+ sol.getSolutionPath().size());
        System.out.println("Time: "+ (end-start)/1000);


    }
}
