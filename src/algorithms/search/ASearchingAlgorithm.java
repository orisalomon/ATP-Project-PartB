package algorithms.search;


public abstract class ASearchingAlgorithm implements ISearchingAlgorithm{

    protected int numOfNodesEvaluated = 0;  // field for the number of nodes that the algorithm evaluated.

    /**
     * using the protected field numOfNodesEvaluated
     * @return int - the number of nodes that the algorithm evaluated.
     */
    public int getNumberOfNodesEvaluated() {return numOfNodesEvaluated;}

}
