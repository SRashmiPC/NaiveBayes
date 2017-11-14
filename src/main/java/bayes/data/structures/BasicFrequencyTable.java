package bayes.data.structures;

import java.util.Map;

/**
 * Created by Rashmi on 9/28/2017.
 */
public abstract class BasicFrequencyTable
{
	private ClassAttribute classAttribute;
	private String className;

	private String attributeName; //name of predictor attribute
	private int attributeCardinality;

	public BasicFrequencyTable( ClassAttribute classAttribute, String attributeName, int attributeCardinality )
	{
		this.classAttribute = classAttribute;
		this.attributeName = attributeName;
		this.attributeCardinality = attributeCardinality;
	}

	public void setClassName( String className )
	{
		this.className = className;
	}

	public void setClassCardinality( int classCardinality )
	{
		this.classAttribute.setClassCardinality( classCardinality );
	}

	public Map<String, Integer> getClassMap()
	{
		return this.classAttribute.getClassMap();
	}

	public void setClassMap( Map<String, Integer> classMap )
	{
		this.classAttribute.setClassMap( classMap );
	}

	public void setAttributeName( String attributeName )
	{
		this.attributeName = attributeName;
	}

	public void setAttributeCardinality( int attributeCardinality )
	{
		this.attributeCardinality = attributeCardinality;
	}

	public String getClassName()
	{
		return this.className;
	}

	public String getAttributeName()
	{
		return this.attributeName;
	}

	public int getClassCardinality()
	{
		return this.classAttribute.getClassCardinality();
	}

	public int getAttributeCardinality()
	{
		return this.attributeCardinality;
	}

	public int getClassIndex( String value )
	{
		return ( int ) this.classAttribute.getClassMap().get( value );
	}

	public abstract int getAttributeIndex( String value );

	public abstract double getProbabilty( String attributeValue, String classValue );

	public abstract double getProbabilty( int attributeIndex, String classValue );

	public abstract double getProbabilty( String attributeValue, int classIndex );

	public abstract double getProbabilty( int attributeIndex, int classIndex );

}
