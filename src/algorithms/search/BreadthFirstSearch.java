package algorithms.search;

import java.util.*;

public class BreadthFirstSearch extends ASearchingAlgorithm{

    // field
    protected Queue<AState> queue = new LinkedList<>();

    /**
     * -- getName --
     * get the algorithm name
     * @return String- name.
     */
    @Override
    public String getName() {
        return "BreadthFirstSearch";
    }


    /**
     * -- solve --
     * searching algorithm can solve a searching problem and return solution.
     * @param s - searching problem.
     * @return Solution
     */
    @Override
    public Solution solve(ISearchable s) {
        //        if(s == null){
//            throw new Exception("parameter must not be null");
//        }
        Solution sol = new Solution();
        HashSet<AState> visited = new HashSet<>(); // for visited neighbors

        // clear history results
        queue.clear();
        numOfNodesEvaluated = 0;

        visited.add(s.getStartState()); // add the first node
        queue.add(s.getStartState());

        while (!queue.isEmpty()){
            AState curr = queue.remove();
            numOfNodesEvaluated++;

            if (curr.equals(s.getGoalState())){ // if node is the goal node
                sol.setPath(curr);
                return sol;
            }

            ArrayList<AState> possibleStates = s.getAllSuccessors(curr); // get possible neighbors to move to

            for (AState successor: possibleStates ) {
                if (!visited.contains(successor)) { // check if already visited
                    visited.add(successor);
                    queue.add(successor);
                }
            }

            possibleStates.clear();  // clear successors.

        }
        return sol;
    }
}