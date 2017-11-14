package bayes.data.structures;

import bayes.algorithms.ProbGenerator;

import java.util.ArrayList;

/**
 * Created by Rashmi on 11/13/2017.
 */
public class NumericalTable extends BasicFrequencyTable
{
	boolean useApacheCommonMath;
	private ProbGenerator[] probGenerators;
	ArrayList<double[]> attributeValueList;

	public NumericalTable( ClassAttribute classAttribute, String attributeName, ArrayList<double[]> attributeValueList )
	{
		super( classAttribute, attributeName, Integer.MAX_VALUE);
		this.attributeValueList = attributeValueList;
		this.probGenerators = new ProbGenerator[classAttribute.getClassCardinality()];
		useApacheCommonMath = true;
	}

	public NumericalTable( ClassAttribute classAttribute, String attributeName, ArrayList<double[]> attributeValueList, boolean useApaceCommanMath )
	{
		super( classAttribute, attributeName, Integer.MAX_VALUE );
		this.probGenerators = new ProbGenerator[classAttribute.getClassCardinality()];
		this.useApacheCommonMath = useApaceCommanMath;
	}

	public void init(){
		int length = this.attributeValueList.size();
		for(int i=0; i< length ;i++){
			probGenerators[i] = new ProbGenerator( attributeValueList.get( i ), useApacheCommonMath );
			probGenerators[i].init();
		}
	}

	public NumericalTable( ClassAttribute classAttribute, String attributeName, int[] attributeValues )
	{
		super( classAttribute, attributeName, attributeValues.length );
	}

	public double getProbabilty( String attributeValue, String classValue )
	{
		return getProbabilty( new Double( attributeValue ), classValue );
	}


	public double getProbabilty( double attributeValue, String classValue )
	{
		return this.probGenerators[super.getClassIndex( classValue )].getProbability( attributeValue );
	}

	public double getProbabilty( String attributeValue, int classIndex )
	{
		return getProbabilty( new Double( attributeValue ), classIndex );
	}

	public double getProbabilty( double attributeValue, int classIndex )
	{
		return this.probGenerators[classIndex].getProbability( attributeValue );
	}

	//Atrinute has no index here. Thus those mrthods which seeking for an attribute index remain abstract.
	public int getAttributeIndex( String value )
	{
		return 0;
	}

	public double getProbabilty( int attributeIndex, String classValue )
	{
		return 0;
	}

	public double getProbabilty( int attributeIndex, int classIndex )
	{
		return 0;
	}
}
