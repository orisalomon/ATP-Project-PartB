import algorithms.mazeGenerators.*;
import algorithms.search.*;


public class main {
    public static void main(String[] args) {
        long start1 = System.currentTimeMillis();
        Maze newMaze = new PrimMazeGenerator().generate(1000,1000);
        long end1 = System.currentTimeMillis();
       System.out.println((end1-start1)/1000);
        //DepthFirstSearch dfs = new DepthFirstSearch();
//        BreadthFirstSearch bfs = new BreadthFirstSearch();
//
////        BestFirstSearch best = new BestFirstSearch();
//          SearchableMaze smaze = new SearchableMaze(newMaze);
//        long start = System.currentTimeMillis();
//        Solution sol1 = bfs.solve(smaze);
//        long end = System.currentTimeMillis();

//        System.out.println(newMaze);
//        for (AState s : sol1.getSolutionPath()
//        ) {
//            System.out.println(s);
//        }

//        System.out.println("Number of nodes evaluated: " + bfs.getNumberOfNodesEvaluated());
//        System.out.println("Number of Steps: "+ sol1.getSolutionPath().size());
//        System.out.println("Time: "+ (end-start)/1000);

//        System.out.println("BEST----------------");
//        Solution sol2 = best.solve(smaze);


//        for (AState s : sol2.getSolutionPath()
//        ) {
//            System.out.println(s);
//        }
//
//        System.out.println("Number of nodes evaluated: " + best.getNumberOfNodesEvaluated());
//        System.out.println("Number of Steps: "+ sol2.getSolutionPath().size());
//        System.out.println("Time: "+ (end-start)/1000);




    }
}
