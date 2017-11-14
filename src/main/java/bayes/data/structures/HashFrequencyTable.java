package bayes.data.structures;

/**
 * Created by Rashmi on 9/29/2017.
 */
public class HashFrequencyTable extends BasicFrequencyTable
{
	public HashFrequencyTable( ClassAttribute classAttribute, String attributeName, String[] classValues, int attributeCardinality )
	{
		super( classAttribute, attributeName, attributeCardinality );
	}

	public int getAttributeIndex( String value )
	{
		return 0;
	}

	public double getProbabilty( String attributeValue, String classValue )
	{
		return 0;
	}

	public double getProbabilty( int attributeIndex, String classValue )
	{
		return 0;
	}

	public double getProbabilty( String attributeValue, int classIndex )
	{
		return 0;
	}

	public double getProbabilty( int attributeIndex, int classIndex )
	{
		return 0;
	}
}
