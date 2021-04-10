package algorithms.search;

import java.util.*;

public class DepthFirstSearch extends ASearchingAlgorithm{

    /**
     * -- getName --
     * get the algorithm name.
     * @return String - name.
     */
    @Override
    public String getName() {
        return "DepthFirstSearch";
    }

    /**
     * -- getNumberOfNodesEvaluated --
     * returns the number of nodes that the algorithm has been found. // TODO: why need it here?
     * @return int.
     */
    @Override
    public int getNumberOfNodesEvaluated() {
        return numOfNodesEvaluated;
    }

    /**
     * -- solve --
     * searching algorithm can solve a searching problem and return solution.
     * @param s - searching problem.
     * @return Solution
     */
    @Override
    public Solution solve(ISearchable s) throws Exception {
        if(s == null){
            throw new Exception("Searchable problem must not be null");
        }
        Solution sol = new Solution();
        Stack<AState> stack = new Stack<>();
        HashSet<AState> visited = new HashSet<>(); // for visited neighbors

        // clear history results
        stack.clear();
        numOfNodesEvaluated = 0;

        visited.add(s.getStartState());  // add first state
        stack.add(s.getStartState());

        while (!stack.isEmpty()){
            AState curr = stack.pop();
            numOfNodesEvaluated++;

            if (curr.equals(s.getGoalState())){  // if found goal, create path and return answer.
                sol.setPath(curr);
                return sol;
            }

            ArrayList<AState> possibleStates = s.getAllSuccessors(curr);  // get all the successors
            for (AState successor: possibleStates) {
                if (!visited.contains(successor)) {
                    visited.add(successor);   // if not visited yet then add them to the stack and visited lists.
                    stack.add(successor);
                }
            }

            possibleStates.clear();  // clear successors.
        }
        return sol;
    }
}
