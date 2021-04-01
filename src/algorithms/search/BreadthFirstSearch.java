package algorithms.search;

import java.util.*;

public class BreadthFirstSearch extends ASearchingAlgorithm{

    protected Queue<AState> queue = new LinkedList<>();

    @Override
    public String getName() {
        return "BFS";
    }


    @Override
    public Solution solve(ISearchable s) {
        Solution sol = new Solution();
        HashSet<String> visited = new HashSet<>(); // for visited neighbors  TODO: is it ok to assume Object??

        queue.clear();

        visited.add(s.getStartState().getState().toString()); // add the first node
        queue.add(s.getStartState());

        while (!queue.isEmpty()){
            AState curr = queue.remove();
            numOfNodesEvaluated++;

            if (curr.equals(s.getGoalState())){ // if node is the goal node

//                ArrayList<AState> solutionStack = getSolPath(curr); // create path from end to start
//                while (!solutionStack.isEmpty()){ // add the path to solution from start to end
//                    sol.addState(solutionStack.remove);
               // }

                sol.setPath(curr);

                return sol;
            }

            ArrayList<AState> possibleStates = s.getAllSuccessors(curr); // get possible neighbors to move to

            for (AState successor: possibleStates ) {
                String successorString = successor.getState().toString();
                if (!visited.contains(successorString)) { // check if already visited
                    visited.add(successorString);
                    queue.add(successor);
                }
            }

            possibleStates.clear();

        }
        return sol;
    }

//    private ArrayList<AState> getSolPath(AState curr) {
//
//        ArrayList<AState> solutionPath = new ArrayList<>();
//
//        while (curr != null){
//            solutionPath.add(curr);
//            curr = curr.parent;
//        }
//
//        Collections.reverse(solutionPath);
//        return solutionPath;
//    }


}