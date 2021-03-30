import algorithms.search.AState;
import algorithms.search.BreadthFirstSearch;
import algorithms.search.SearchableMaze;
import algorithms.search.Solution;
import maze3D.Maze3D;
import maze3D.MyMaze3DGenerator;
import maze3D.SearchableMaze3D;

public class main3D {

    public static void main(String[] args) {
        long start1 = System.currentTimeMillis();
        Maze3D maze = new MyMaze3DGenerator().generate(50,50,50);
        long end1 = System.currentTimeMillis();
        System.out.println((end1-start1)/1000);


        BreadthFirstSearch bfs = new BreadthFirstSearch();
//
////        BestFirstSearch best = new BestFirstSearch();
        SearchableMaze3D smaze = new SearchableMaze3D(maze);
        long start = System.currentTimeMillis();
        Solution sol1 = bfs.solve(smaze);
        long end = System.currentTimeMillis();
        System.out.println((end-start)/1000);

        //System.out.println(maze);
        for (AState s : sol1.getSolutionPath()
        ) {
            System.out.println(s);
        }
    }
}
