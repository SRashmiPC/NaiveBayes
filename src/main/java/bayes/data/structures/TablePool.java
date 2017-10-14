package bayes.data.structures;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Rashmi on 9/30/2017.
 */
public class TablePool
{
	/**
	 * this class is a direct dependency of Naive Byes Algorithm
	 */
	private Map<String, BasicFrequencyTable> attributeMap;
	private int numberOfAttributes;
	private String[] attributeList;
	private Class classAttribute;

	public TablePool( Class classAttribute, String... attributeList )
	{
		this.classAttribute = classAttribute;
		this.numberOfAttributes = attributeList.length;
		this.attributeList = attributeList;
		this.attributeMap = new HashMap<String, BasicFrequencyTable>();
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

	public void add( String attributeName, BasicFrequencyTable basicFrequencyTable )
	{
		this.attributeMap.put( attributeName, basicFrequencyTable );
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
		return this.classAttribute.getClassValueProbability( classValueIndex );
	}

	public double getClassProbability( String classValue )
	{
		return getClassProbability( this.classAttribute.getClassMap().get( classValue ) );
	}
}
