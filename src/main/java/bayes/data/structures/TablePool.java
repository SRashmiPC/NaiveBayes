package bayes.data.structures;

import java.util.Map;

/**
 * Created by Rashmi on 9/30/2017.
 */
public class TablePool
{
	/**
	 * this class is a direct dependency of Naive Byes Algorithm
	 */
	Map<String, BasicFrequencyTable> attributeMap;
	int numberOfAttributes;
	String[] attributeList;

	public TablePool( String... attributeList )
	{
		this.numberOfAttributes = attributeList.length;
		this.attributeList = attributeList;
	}

	public Map<String, BasicFrequencyTable> getAttributeMap()
	{
		return attributeMap;
	}

	public void setAttributeMap( Map<String, BasicFrequencyTable> attributeMap )
	{
		this.attributeMap = attributeMap;
	}

	public int getNumberOfAttributes()
	{
		return numberOfAttributes;
	}

	public void setNumberOfAttributes( int numberOfAttributes )
	{
		this.numberOfAttributes = numberOfAttributes;
	}

	public void generateAtributeMap( String... attributeList )
	{
		//TODO: generete map with relevant Frequency Tables
	}

	public BasicFrequencyTable getTable( String attribute )
	{
		return attributeMap.get( attribute );
	}

	public double getProbability( String attribute, String attributeValue, String classValue )
	{
		return getTable( attribute ).getProbabilty( attributeValue, classValue );
	}

	public double getProbability( int attributeIndex, int attributeValueIndex, int classValueIndex )
	{
		return getTable( attributeList[attributeIndex] ).getProbabilty( attributeValueIndex, classValueIndex );
	}

	public double getProbability( int attributeIndex, String attributeValue, int classIndex )
	{
		return getTable( attributeList[attributeIndex] ).getProbabilty( attributeValue, classIndex );
	}

	public int getAttributeCardinality( int attributeIndex )
	{
		return getTable( attributeList[attributeIndex] ).getAttributeCardinality();
	}

	public int getAttributeCardinality( String attribute )
	{
		return getTable( attribute ).getAttributeCardinality();
	}

	public double getClassProbability( int classValueIndex )
	{
		return 0;
	}

	public double getClassProbability( String classValue )
	{
		return 0;
	}
}
