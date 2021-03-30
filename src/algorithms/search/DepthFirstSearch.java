package algorithms.search;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DepthFirstSearch extends ASearchingAlgorithm{
    @Override
    public String getName() {
        return "DFS";
    }

    @Override
    public int getNumberOfNodesEvaluated() {
        return numOfNodesEvaluated;
    }

    @Override
    public Solution solve(ISearchable s) {
        Solution sol = new Solution();
        Stack<AState> stack = new Stack<>();
        HashSet<Object> visited = new HashSet<>(); // for visited neighbors

        visited.add(s.getStartState().currState);
        stack.add(s.getStartState());

        while (!stack.isEmpty()){
            AState curr = stack.pop();
            numOfNodesEvaluated++;

            if (curr.equals(s.getGoalState())){
                Stack<AState> solutionStack = getSolPath(curr);
                while (!solutionStack.isEmpty()){
                    sol.addState(solutionStack.pop());
                }
                return sol;
            }


            for (AState successor: s.getAllSuccessors(curr)) {

                if (!visited.contains(successor.currState)) {
                    visited.add(successor.currState);
                    stack.add(successor);
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
