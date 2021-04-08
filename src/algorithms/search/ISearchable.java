package algorithms.search;

import java.util.ArrayList;

public interface ISearchable {
    /**
     * -- getStartState --
     * @return AState
     */
    AState getStartState();

    /**
     * -- getGoalState --
     * @return AState
     */
    AState getGoalState();

    /**
     * -- getAllSuccessors --
     * @param s - AState - the state to search all the successors from.
     * @return ArrayList<AState> - list of all the successors of the state s.
     */
    ArrayList<AState> getAllSuccessors(AState s);
}
