package algorithms.search;

public interface ISearchingAlgorithm {

    /**
     * -- getName --
     * @return String
     */
    String getName();

    /**
     * -- getNumberOfNodesEvaluated --
     * @return int
     */
    int getNumberOfNodesEvaluated();

    /**
     * -- solve --
     * searching algorithm can solve a searching problem and return solution.
     * @param domain - searching problem.
     * @return Solution
     */
    Solution solve(ISearchable domain);
}
