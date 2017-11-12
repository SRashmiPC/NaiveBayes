package bayes.Test;

/**
 * Created by Rashmi on 11/9/2017.
 */
public class CrossValidation
{
	private final int numberOfFolds;
	/**
	 * we keep precition and recall for each iteration in an array
	 * first dimention represent the i, iteration
	 * second dimention (size 2) is for precision and recall
	 */
	private double[][] stat;

	public CrossValidation( int numberOfFolds )
	{
		this.numberOfFolds = numberOfFolds;
		this.stat = new double[numberOfFolds][2];
	}

}
