package bayes.data.structures;

/**
 * Created by Rashmi on 9/29/2017.
 */
public class HashFrequencyTable extends BasicFrequencyTable
{
	public HashFrequencyTable( String className, String attributeName, String[] classValues, int attributeCardinality )
	{
		super( className, attributeName, classValues, attributeCardinality );
	}

	int getAttributeIndex( String value )
	{
		return 0;
	}

	public double getProbabilty( String attributeValue, String classValue )
	{
		return 0;
	}
}
