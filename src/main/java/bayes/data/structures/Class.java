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
	private double[] classValueProbabilities;
	private boolean allocated = false;

	public Class( int classCardinality )
	{
		this.classCardinality = classCardinality;
	}

	public void init( double[] classValueFrequencies )
	{
		generateClassValueProb( classValueFrequencies );
	}

	public void generateClassValueProb( double[] classValueFrequencies )
	{
		int sum = 0;
		for ( int i = 0; i < classCardinality; i++ )
		{
			sum += classValueFrequencies[i];
		}

		for ( int i = 0; i < classCardinality; i++ )
		{
			classValueFrequencies[i] += classValueFrequencies[i] / sum;
		}

		this.classValueProbabilities = classValueFrequencies;
	}

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

	public double[] getClassValueProbabilities()
	{
		return classValueProbabilities;
	}

	public void setClassValueProbabilities( double[] classValueProbabilities )
	{
		this.classValueProbabilities = classValueProbabilities;
	}
}
