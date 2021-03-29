package algorithms.search;

import java.util.*;

public class BreadthFirstSearch extends ASearchingAlgorithm{


    private class Node{
        Node parent;
        AState state;

        public Node(Node parent, AState state) {
            this.parent = parent;
            this.state = state;
        }
    }

    @Override
    public String getName() {
        return "BFS";
    }


    @Override
    public Solution solve(ISearchable s) {
        Solution sol = new Solution();
        Queue<Node> queue = new LinkedList<>();
        //ArrayList<AState> visited = new ArrayList<>();  // for visited neighbors
        Dictionary visited = new Hashtable();

        Node n = new Node(null,s.getStartState());
        visited.put(s.getStartState().currState,1);
        queue.add(n);

        while (!queue.isEmpty()){
            Node curr = queue.remove();
            numOfNodesEvaluated++;
            //sol.addState(curr);

            if (curr.state.currState.equals(s.getGoalState().currState)){
                Stack<AState> solutionStack = getSolPath(curr);
                while (!solutionStack.isEmpty()){
                    sol.addState(solutionStack.pop());
                }
                return sol;
            }


            for (AState successor: s.getAllPossibleStates(curr.state)) {
                /*
                int visit_flag = 0;
                for (AState checkVisit: visited
                     ) {
                    if (successor.currState.equals(checkVisit.currState)){visit_flag = 1;break;}
                }
                */
                if (visited.get(successor) == null) {

                    //if (visit_flag == 0){
                    Node successorNode = new Node(curr, successor);
                    visited.put(successor.currState, 1);
                    queue.add(successorNode);
                }
            }

        }
        return sol;
    }

    private Stack<AState> getSolPath(Node curr) {

        Stack<AState> solutionStack = new Stack<>();

        while (curr != null){
            solutionStack.push(curr.state);
            curr = curr.parent;
        }

        return solutionStack;
    }
}
