
import algorithms.search.*;

import algorithms.search.Solution;
import maze3D.Maze3D;
import maze3D.MyMaze3DGenerator;
import maze3D.SearchableMaze3D;

public class main3D {

    public static void main(String[] args) {
        long start1 = System.currentTimeMillis();
        Maze3D maze = new MyMaze3DGenerator().generate(500,500,500);
        long end1 = System.currentTimeMillis();
        System.out.println("Generation time: "+ (end1-start1)/1000);


      BreadthFirstSearch bfs = new BreadthFirstSearch();
  //       DepthFirstSearch dfs = new DepthFirstSearch();
//        BestFirstSearch best = new BestFirstSearch();
        SearchableMaze3D smaze = new SearchableMaze3D(maze);
//        System.out.println(maze);

        long start = System.currentTimeMillis();
        Solution sol1 = bfs.solve(smaze);
        long end = System.currentTimeMillis();
        System.out.println("Solving time: "+ (end-start)/1000);

//        System.out.println(maze);
//
//        for (AState s : sol1.getSolutionPath()
//        ) {
//            System.out.println(s);
//        }
    }
}
