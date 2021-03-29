package algorithms.search;

import java.util.*;

public class BreadthFirstSearch extends ASearchingAlgorithm{



    @Override
    public String getName() {
        return "BFS";
    }


    @Override
    public Solution solve(ISearchable s) {
        Solution sol = new Solution();
        Queue<AState> queue = new LinkedList<>();
        HashSet<AState> visited = new HashSet<>(); // for visited neighbors

        visited.add(s.getStartState());
        queue.add(s.getStartState());

        while (!queue.isEmpty()){
            AState curr = queue.remove();
            numOfNodesEvaluated++;

            if (curr.equals(s.getGoalState())){
                Stack<AState> solutionStack = getSolPath(curr);
                while (!solutionStack.isEmpty()){
                    sol.addState(solutionStack.pop());
                }
                return sol;
            }


            for (AState successor: s.getAllPossibleStates(curr)) {

                if (!visited.contains(successor)) {
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
