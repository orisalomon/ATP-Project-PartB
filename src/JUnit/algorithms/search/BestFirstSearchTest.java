package algorithms.search;

import algorithms.mazeGenerators.*;
import maze3D.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BestFirstSearchTest {

    @Test
    void testName() {
        BestFirstSearch best = new BestFirstSearch();
        assertEquals("BEST-FS",best.getName());
    }

    @Test
    void testEmptyMaze() {
        BestFirstSearch best = new BestFirstSearch();
        SearchableMaze sm = new SearchableMaze(new EmptyMazeGenerator().generate(100,100));
        assertNotEquals(0,best.solve(sm).getSolutionPath().size());
    }

    @Test
    void testSimpleMaze() {
        BestFirstSearch best = new BestFirstSearch();
        SearchableMaze sm = new SearchableMaze(new SimpleMazeGenerator().generate(100,100));
        assertNotEquals(0,best.solve(sm).getSolutionPath().size());
    }

    @Test
    void testMyMaze() {
        BestFirstSearch best = new BestFirstSearch();
        SearchableMaze sm = new SearchableMaze(new MyMazeGenerator().generate(100,100));
        assertNotEquals(0,best.solve(sm).getSolutionPath().size());
    }

    @Test
    void test2DSolvingTime() {
        BestFirstSearch best = new BestFirstSearch();
        SearchableMaze sm = new SearchableMaze(new MyMazeGenerator().generate(1000,1000));
        long start = System.currentTimeMillis();
        best.solve(sm);
        long end = System.currentTimeMillis();

        assertTrue((end-start)/1000 <= 60);
    }

    @Test
    void test3DSolvingTime() {
        BestFirstSearch best = new BestFirstSearch();
        SearchableMaze3D sm = new SearchableMaze3D(new MyMaze3DGenerator().generate(350,350,350));
        long start = System.currentTimeMillis();
        best.solve(sm);
        long end = System.currentTimeMillis();

        assertTrue((end-start)/1000 <= 60);
    }

    @Test
    void test2DCostBFS() {
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
        try{best.solve(s); assertFalse(true);}
        catch (Exception ignored){};

    }
}