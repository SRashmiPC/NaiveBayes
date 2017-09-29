package bayes.data.structures;

import java.util.Map;

/**
 * Created by Rashmi on 9/28/2017.
 */
public abstract class BasicFrequencyTable
{
	String className;
	String attributeName;
	int classCardinality;
	int attributeCardinality;
	Map<String, Integer> classMap;

	public BasicFrequencyTable( String className, String attributeName, String[] classValues, int attributeCardinality )
	{
		this.className = className;
		this.attributeName = attributeName;
		generateClassMap( classValues );
		this.classCardinality = classValues.length;
		this.attributeCardinality = attributeCardinality;
	}

	public void generateClassMap( String[] classValues )
	{
		int len = classValues.length;
		for ( int i = 0; i < len; i++ )
		{
			classMap.put( classValues[i], i );
		}
	}

	public int getClassIndex( String value )
	{
		return ( int ) classMap.get( value );
	}

	abstract int getAttributeIndex( String value );

	abstract double getProbabilty( String attributeValue, String classValue );

}
