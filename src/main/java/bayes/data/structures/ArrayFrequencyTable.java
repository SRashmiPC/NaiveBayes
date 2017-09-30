package bayes.data.structures;

import java.util.Map;

/**
 * Created by Rashmi on 8/29/2017.
 */
public class ArrayFrequencyTable extends BasicFrequencyTable
{
	private Map<String, Integer> attributeMap;
	/**
	 * table is represented by an 2d array
	 * first dimension is class variable
	 * second dimension is predictorvarable
	 */
	private double[][] table;

	public ArrayFrequencyTable( String className, String attributeName, String[] classValues, String[] attributeValues )
	{
		super( className, attributeName, classValues, attributeValues.length );
		generateMap( attributeValues );
		table = new double[classValues.length][attributeValues.length];
	}

	public void generateMap( String[] attributeValues )
	{
		int len = attributeValues.length;
		for ( int i = 0; i < len; i++ )
		{
			attributeMap.put( attributeValues[i], i );
		}
	}

	int getAttributeIndex( String value )
	{
		return ( int ) attributeMap.get( value );
	}

	public double getProbabilty( String attributeValue, String classValue )
	{
		return table[getClassIndex( classValue )][attributeMap.get( attributeValue )];
	}

	double getProbabilty( int attributeIndex, String classValue )
	{
		return table[getClassIndex( classValue )][attributeIndex];
	}

	double getProbabilty( String attributeValue, int classIndex )
	{
		return table[classIndex][getAttributeIndex( attributeValue )];
	}

	double getProbabilty( int attributeIndex, int classIndex )
	{
		return table[classIndex][classIndex];
	}

	public void setProbability( String classValue, String attributeValue, int frequency )
	{

	}
}
