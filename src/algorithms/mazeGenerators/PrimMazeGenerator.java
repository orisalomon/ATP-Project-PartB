package algorithms.mazeGenerators;

import java.util.ArrayList;
import java.util.Random;


import algorithms.search.AState;
import algorithms.search.MazeState;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class PrimMazeGenerator extends AMazeGenerator{


        @Override
        public Maze generate(int rows, int cols) {

            Random rand = new Random();
            ArrayList<Position> wallsList = new ArrayList<>();

            Position start = new Position(1, 0);
            Position goal = new Position(rows/2,cols-1);

            Maze maze = new Maze(rows,cols,start,goal);

            boolean put = true;
            for (int i = 0; i<rows; i++){
                for (int j = 0; j<cols; j++){
                    if(put){maze.maze[i][j] = 1;} else{ maze.maze[i][j] = 2;}
                    if(j==cols-1 && cols%2==0)
                        put = !put;
                    put = !put;
                }
            }

//        int randRow = rand.nextInt(cols);
//        int randCol = rand.nextInt(rows);
//        maze.maze[randRow][randCol] = 0;
//        addWalls(wallsList,maze,randRow,randCol);

            maze.maze[start.getRowIndex()][start.getColumnIndex()] = 0;
            addWalls(wallsList,maze,start.getRowIndex(),start.getColumnIndex());


            while (!wallsList.isEmpty()){
                Position randWall = wallsList.remove(rand.nextInt(wallsList.size()));
                Position otherSide = new Position(-1,-1);
                boolean wallDiv = wallDevided(randWall,maze,otherSide);
                if(wallDiv){
                    maze.maze[otherSide.getRowIndex()][otherSide.getColumnIndex()] = 0;
                    maze.maze[randWall.getRowIndex()][randWall.getColumnIndex()] = 0;
                    addWalls(wallsList,maze,otherSide.getRowIndex(),otherSide.getColumnIndex());
                }
            }

            maze.maze[goal.getRowIndex()][goal.getColumnIndex()] = 0;
            maze.maze[goal.getRowIndex()][goal.getColumnIndex()-1] = 0;

            for(int i = 0; i< rows;i++){
                for(int j = 0; j<cols;j++){
                    if(maze.maze[i][j] == 2){maze.maze[i][j]=1;}
                }
            }

            return maze;
        }

        private boolean wallDevided(Position randWall, Maze maze, Position otherSide) {
            int rRow = randWall.getRowIndex();
            int rCol = randWall.getColumnIndex();
            if(rRow-1 >= 0 && maze.maze[rRow-1][rCol] == 0 && rRow+1 < maze.getRows() && maze.maze[rRow+1][rCol] == 2){
                otherSide.setRow(rRow+1);
                otherSide.setCol(rCol);
                return true;
            }
            if(rRow-1 >= 0 && maze.maze[rRow-1][rCol] == 2 && rRow+1 < maze.getRows() && maze.maze[rRow+1][rCol] == 0){
                otherSide.setRow(rRow-1);
                otherSide.setCol(rCol);
                return true;
            }
            if(rCol-1 >= 0 && maze.maze[rRow][rCol-1] == 0 && rCol+1 < maze.getRows() && maze.maze[rRow][rCol+1] == 2){
                otherSide.setRow(rRow);
                otherSide.setCol(rCol+1);
                return true;
            }
            if(rCol-1 >= 0 && maze.maze[rRow][rCol-1] == 2 && rCol+1 < maze.getRows() && maze.maze[rRow][rCol+1] == 0){
                otherSide.setRow(rRow);
                otherSide.setCol(rCol-1);
                return true;
            }
            return false;
        }

        private void addWalls(ArrayList<Position> wallsList, Maze maze, int randRow, int randCol) {
            if(randRow-1 >= 0 && maze.maze[randRow-1][randCol] == 1){
                wallsList.add(new Position(randRow-1,randCol));
            }
            if(randRow+1 < maze.getRows()  && maze.maze[randRow+1][randCol] == 1){
                wallsList.add(new Position(randRow+1,randCol));
            }
            if(randCol-1 >= 0  && maze.maze[randRow][randCol-1] == 1){
                wallsList.add(new Position(randRow,randCol-1));
            }
            if(randCol+1 < maze.getCols() && maze.maze[randRow][randCol+1] == 1){
                wallsList.add(new Position(randRow,randCol+1));
            }

        }

    }


