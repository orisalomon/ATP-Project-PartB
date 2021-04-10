package algorithms.search;

import algorithms.mazeGenerators.*;
import algorithms.maze3D.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BestFirstSearchTest {

    @Test
    void testName() {
        BestFirstSearch best = new BestFirstSearch();
        assertEquals("BestFirstSearch",best.getName());
    }

    @Test
    void testEmptyMaze() throws Exception {
        BestFirstSearch best = new BestFirstSearch();
        SearchableMaze sm = new SearchableMaze(new EmptyMazeGenerator().generate(100,100));
        assertNotEquals(0,best.solve(sm).getSolutionPath().size());
    }

    @Test
    void testSimpleMaze() throws Exception {
        BestFirstSearch best = new BestFirstSearch();
        SearchableMaze sm = new SearchableMaze(new SimpleMazeGenerator().generate(100,100));
        assertNotEquals(0,best.solve(sm).getSolutionPath().size());
    }

    @Test
    void testMyMaze() throws Exception {
        BestFirstSearch best = new BestFirstSearch();
        SearchableMaze sm = new SearchableMaze(new MyMazeGenerator().generate(100,100));
        assertNotEquals(0,best.solve(sm).getSolutionPath().size());
    }

    @Test
    void test2DSolvingTime() throws Exception {
        BestFirstSearch best = new BestFirstSearch();
        SearchableMaze sm = new SearchableMaze(new MyMazeGenerator().generate(1000,1000));
        long start = System.currentTimeMillis();
        best.solve(sm);
        long end = System.currentTimeMillis();

        assertTrue((end-start)/1000 <= 60);
    }

    @Test
    void test3DSolvingTime() throws Exception {
        BestFirstSearch best = new BestFirstSearch();
        SearchableMaze3D sm = new SearchableMaze3D(new MyMaze3DGenerator().generate(100,100,100));
        long start = System.currentTimeMillis();
        best.solve(sm);
        long end = System.currentTimeMillis();

        assertTrue((end-start)/1000 <= 60);
    }

    @Test
    void test2DCostBFS() throws Exception {
        BestFirstSearch best = new BestFirstSearch();
        BreadthFirstSearch bfs = new BreadthFirstSearch();
        Maze maze = new MyMazeGenerator().generate(1000,1000);
        SearchableMaze sm = new SearchableMaze(maze);
        Solution bestSol = best.solve(sm);
        Solution bfsSol = bfs.solve(sm);

        assertTrue(bestSol.getSolutionPath().get(bestSol.getSolutionPath().size()-1).price <= bfsSol.getSolutionPath().get(bfsSol.getSolutionPath().size()-1).price);
    }

    @Test
    void testNull() {
        BestFirstSearch best = new BestFirstSearch();
        ISearchable s = null;
        try{best.solve(s);fail();}
        catch (Exception ignored){};

    }
}