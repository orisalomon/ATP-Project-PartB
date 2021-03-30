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
        HashSet<AState> visited = new HashSet<>(); // for visited neighbors

        visited.add(s.getStartState()); // add the first node
        queue.add(s.getStartState());

        while (!queue.isEmpty()){
            AState curr = queue.remove();
            numOfNodesEvaluated++;

            if (curr.equals(s.getGoalState())){ // if node is the goal node
                Stack<AState> solutionStack = getSolPath(curr); // create path from end to start
                while (!solutionStack.isEmpty()){ // add the path to solution from start to end
                    sol.addState(solutionStack.pop());
                }
                return sol;
            }

            ArrayList<AState> possibleStates = s.getAllPossibleStates(curr); // get possible neighbors to move to

            for (AState successor: possibleStates ) {

                if (!visited.contains(successor)) { // check if already visited
                    visited.add(successor);
                    queue.add(successor);
                }
            }

        }
        return sol;
    }

    private Stack<AState> getSolPath(AState curr) {

        Stack<AState> solutionStack = new Stack<>();

        while (curr != null){
            solutionStack.push(curr);
            curr = curr.parent;
        }

        return solutionStack;
    }
}
