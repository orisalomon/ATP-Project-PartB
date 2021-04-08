import algorithms.mazeGenerators.*;
import algorithms.search.*;


public class main {
    public static void main(String[] args) {
        long start1 = System.currentTimeMillis();
        Maze maze = new MyMazeGenerator().generate(100,100);
        Maze maze2 = new MyMazeGenerator().generate(100,100);

        long end1 = System.currentTimeMillis();

        System.out.println("Generation time: "+ (end1-start1)/1000);


       BreadthFirstSearch bfs = new BreadthFirstSearch();
        DepthFirstSearch dfs = new DepthFirstSearch();
        BestFirstSearch best = new BestFirstSearch();
        SearchableMaze smaze = new SearchableMaze(maze);
        SearchableMaze smaze2 = new SearchableMaze(maze2);
        // System.out.println(maze);

        System.out.println("---------------BFS-----------------");
        long start = System.currentTimeMillis();
        Solution sol1 = bfs.solve(smaze);
        System.out.println(String.format("'%s' algorithm - nodes evaluated: %s", bfs.getName(), bfs.getNumberOfNodesEvaluated()));
        Solution sol12 = bfs.solve(smaze2);
        long end = System.currentTimeMillis();

        System.out.println("Solution length: "+ sol1.getSolutionPath().size() );
        System.out.println("Cost: "+ sol1.getSolutionPath().get(sol1.getSolutionPath().size()-1).getPrice() );
        System.out.println("Solving time: "+ (end-start)/1000);

        System.out.println(String.format("'%s' algorithm - nodes evaluated: %s", bfs.getName(), bfs.getNumberOfNodesEvaluated()));
        System.out.println("Solution length: "+ sol12.getSolutionPath().size() );
        System.out.println("Cost: "+ sol12.getSolutionPath().get(sol12.getSolutionPath().size()-1).getPrice() );
        System.out.println("Solving time: "+ (end-start)/1000);

//        System.out.println(maze);
//
//        for (AState s : sol1.getSolutionPath()
//        ) {
//            System.out.println(s);
//        }
/*
        System.out.println("---------------DFS-----------------");
        long start2 = System.currentTimeMillis();
        Solution sol2 = dfs.solve(smaze);
        long end2 = System.currentTimeMillis();
        System.out.println(String.format("'%s' algorithm - nodes evaluated: %s", dfs.getName(), dfs.getNumberOfNodesEvaluated()));
        System.out.println("Solution length: "+ sol2.getSolutionPath().size() );
        System.out.println("Solving time: "+ (end2-start2)/1000);

        System.out.println("---------------BEST-----------------");
        long start3 = System.currentTimeMillis();
        Solution sol3 = best.solve(smaze);
        long end3 = System.currentTimeMillis();
        System.out.println(String.format("'%s' algorithm - nodes evaluated: %s", best.getName(), best.getNumberOfNodesEvaluated()));
        System.out.println("Solution length: "+ sol3.getSolutionPath().size() );
        System.out.println("Cost: "+ sol3.getSolutionPath().get(sol3.getSolutionPath().size()-1).getPrice() );
        System.out.println("Solving time: "+ (end3-start3)/1000);

//        for (AState s : sol3.getSolutionPath()
//        ) {
//            System.out.println(s);
//        }


*/
    }


}
