package bayes.data.structures;

import java.util.Map;

/**
 * Created by Rashmi on 9/30/2017.
 */
public class Class
{
	private String className;
	private int classCardinality;
	private Map<String, Integer> classMap;//maps classAttribute's values to indexes
	private int[] classValueFrequencies;
	private boolean allocated = false;

	public String getClassName()
	{
		return className;
	}

	public void setClassName( String className )
	{
		this.className = className;
	}

	public int getClassCardinality()
	{
		return classCardinality;
	}

	public void setClassCardinality( int classCardinality )
	{
		this.classCardinality = classCardinality;
	}

	public Map<String, Integer> getClassMap()
	{
		return classMap;
	}

	public void setClassMap( Map<String, Integer> classMap )
	{
		this.classMap = classMap;
	}

	public int[] getClassValueFrequencies()
	{
		return classValueFrequencies;
	}

	public void setClassValueFrequencies( int[] classValueFrequencies )
	{
		this.classValueFrequencies = classValueFrequencies;
	}
}
