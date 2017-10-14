package bayes.data.structures;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Rashmi on 9/28/2017.
 */
public abstract class BasicFrequencyTable
{
	private static String className;
	private static int classCardinality;
	private static Map<String, Integer> classMap;//maps classAttribute's values to indexes
	private static int[] classValueFrequencies;
	private static boolean allocated = false;

	private String attributeName; //name of predictor attribute
	private int attributeCardinality;

	public BasicFrequencyTable( String className, String attributeName, String[] classValues, int attributeCardinality )
	{
		if ( !allocated )
		{
			BasicFrequencyTable.className = className;
			BasicFrequencyTable.classMap = new HashMap<String, Integer>();
			BasicFrequencyTable.generateClassMap( classValues );
			BasicFrequencyTable.classCardinality = classValues.length;
			BasicFrequencyTable.classValueFrequencies = new int[classCardinality];
			BasicFrequencyTable.allocated = true;
		}
		this.attributeCardinality = attributeCardinality;
	}

	public static void setClassName( String className )
	{
		BasicFrequencyTable.className = className;
	}

	public static void setClassCardinality( int classCardinality )
	{
		BasicFrequencyTable.classCardinality = classCardinality;
	}

	public static Map<String, Integer> getClassMap()
	{
		return classMap;
	}

	public static void setClassMap( Map<String, Integer> classMap )
	{
		BasicFrequencyTable.classMap = classMap;
	}

	public static int[] getClassValueFrequencies()
	{
		return classValueFrequencies;
	}

	public static void setClassValueFrequencies( int[] classValueFrequencies )
	{
		BasicFrequencyTable.classValueFrequencies = classValueFrequencies;
	}

	public void setAttributeName( String attributeName )
	{
		this.attributeName = attributeName;
	}

	public void setAttributeCardinality( int attributeCardinality )
	{
		this.attributeCardinality = attributeCardinality;
	}

	public static String getClassName()
	{
		return BasicFrequencyTable.className;
	}

	public String getAttributeName()
	{
		return attributeName;
	}

	public static int getClassCardinality()
	{
		return BasicFrequencyTable.classCardinality;
	}

	public int getAttributeCardinality()
	{
		return attributeCardinality;
	}

	public static void generateClassMap( String[] classValues )
	{
		int len = classValues.length;
		for ( int i = 0; i < len; i++ )
		{

			classMap.put( classValues[i], i );
		}
	}

	public static void populateClassValueFrequencies( String[] values, int[] frequencies )
	{
		int len = values.length;
		for ( int i = 0; i < len; i++ )
		{
			populateClassValueFrequencies( classMap.get( values[i] ), frequencies[i] );
		}
	}

	public static void populateClassValueFrequencies( int[] indexes, int[] frequencies )
	{
		int len = indexes.length;
		for ( int i = 0; i < len; i++ )
		{
			populateClassValueFrequencies( indexes[i], frequencies[i] );
		}
	}

	public static void populateClassValueFrequencies( String value, int frequency )
	{
		populateClassValueFrequencies( classMap.get( value ), frequency );
	}

	public static void populateClassValueFrequencies( int index, int frequency )
	{
		classValueFrequencies[index] = frequency;
	}

	public int getClassIndex( String value )
	{
		return ( int ) BasicFrequencyTable.classMap.get( value );
	}

	abstract int getAttributeIndex( String value );

	abstract double getProbabilty( String attributeValue, String classValue );

	abstract double getProbabilty( int attributeIndex, String classValue );

	abstract double getProbabilty( String attributeValue, int classIndex );

	abstract double getProbabilty( int attributeIndex, int classIndex );

}
