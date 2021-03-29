import algorithms.mazeGenerators.*;
import algorithms.search.*;


public class main {
    public static void main(String[] args) {

        Maze newMaze = new MyMazeGenerator().generate(200,200);
        //System.out.println(newMaze);
        //DepthFirstSearch dfs = new DepthFirstSearch();
        BreadthFirstSearch bfs = new BreadthFirstSearch();
//        Maze newMaze = new EmptyMazeGenerator().generate(4,4);
//        int[][] maze ={{0,0,1,1},
//                        {0,0,0,0},
//                        {0,1,0,1},
//                        {0,0,0,1}
//        };
//
//        newMaze.setStartPosition(new Position(0,0));
//        newMaze.setGoalPosition(new Position(3,2));
//        newMaze.setMaze(maze);

        BestFirstSearch best = new BestFirstSearch();
        SearchableMaze smaze = new SearchableMaze(newMaze);
        long start = System.currentTimeMillis();
        Solution sol1 = bfs.solve(smaze);
        long end = System.currentTimeMillis();
//
//        System.out.println(newMaze);
//        for (AState s : sol1.getSolutionPath()
//        ) {
//            System.out.println(s);
//        }

        System.out.println("Number of nodes evaluated: " + bfs.getNumberOfNodesEvaluated());
        System.out.println("Number of Steps: "+ sol1.getSolutionPath().size());
        System.out.println("Time: "+ (end-start)/1000);

        System.out.println("BEST----------------");
        Solution sol2 = best.solve(smaze);


        for (AState s : sol2.getSolutionPath()
        ) {
            System.out.println(s);
        }

        System.out.println("Number of nodes evaluated: " + best.getNumberOfNodesEvaluated());
        System.out.println("Number of Steps: "+ sol2.getSolutionPath().size());
        System.out.println("Time: "+ (end-start)/1000);




    }
}
