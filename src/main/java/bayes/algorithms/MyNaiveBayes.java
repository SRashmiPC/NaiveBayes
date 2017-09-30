package bayes.algorithms;

import bayes.data.structures.BasicFrequencyTable;
import bayes.data.structures.TablePool;

/**
 * Created by Rashmi on 9/30/2017.
 */
public class MyNaiveBayes
{
	TablePool tablePool;
	double[] posteriorProbabilities;

	public void startCalculation( String[] attributeValues )
	{
		int classCardinality = BasicFrequencyTable.getClassCardinality();
		this.posteriorProbabilities = new double[classCardinality];
		int numberOfAttributes = tablePool.getNumberOfAttributes();
		for ( int i = 0; i < classCardinality; i++ )
		{
			double posteriorProbability = tablePool.getClassProbability( i );
			// for each attribute we get probabilities from frequency table
			for ( int j = 0; j < numberOfAttributes; j++ )
			{
				posteriorProbability *= tablePool.getProbability( j, attributeValues[j], i );
			}
			posteriorProbabilities[i] = posteriorProbability;
		}
	}

	public void startCalculation( int[] attributeValueIndexes )
	{
		int classCardinality = BasicFrequencyTable.getClassCardinality();
		this.posteriorProbabilities = new double[classCardinality];
		int numberOfAttributes = tablePool.getNumberOfAttributes();
		for ( int i = 0; i < classCardinality; i++ )
		{
			double posteriorProbability = tablePool.getClassProbability( i );
			// for each attribute we get probabilities from frequency table
			for ( int j = 0; j < numberOfAttributes; j++ )
			{
				posteriorProbability *= tablePool.getProbability( attributeValueIndexes[j], j, i );
			}
			posteriorProbabilities[i] = posteriorProbability;
		}
	}
}
