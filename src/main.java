import algorithms.mazeGenerators.*;
import algorithms.search.*;


public class main {
    public static void main(String[] args) {

        Maze newMaze = new MyMazeGenerator().generate(100,100);
        System.out.println(newMaze);
        BreadthFirstSearch bfs = new BreadthFirstSearch();
        SearchableMaze smaze = new SearchableMaze(newMaze);
        Solution sol = bfs.solve(smaze);
//        int i = 0;
//        System.out.println(i);
        //System.out.println(newMaze);

        for (AState s : sol.getSolutionPath()
             ) {
            System.out.println(s);
        }



    }
}
