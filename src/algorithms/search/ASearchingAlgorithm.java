package algorithms.search;

public abstract class ASearchingAlgorithm implements ISearchingAlgorithm{

    protected int numOfNodesEvaluated = 0;

    public int getNumberOfNodesEvaluated() {return numOfNodesEvaluated;}

}
