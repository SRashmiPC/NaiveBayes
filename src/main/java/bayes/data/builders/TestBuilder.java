package bayes.data.builders;

import bayes.algorithms.MyNaiveBayes;
import bayes.data.structures.ArrayFrequencyTable;
import bayes.data.structures.ClassAttribute;
import bayes.data.structures.TablePool;

/**
 * Created by Rashmi on 10/6/2017.
 */
public class TestBuilder
{
	/**
	 * this example/ testing builder created using
	 * http://blog.aylien.com/naive-bayes-for-dummies-a-simple-explanation/
	 * as a reference.
	 */
	private final String className = "Fruit";
	private final String[] classValues = { "Banana", "Orange", "Other" };
	private final String[] attributes = { "long", "sweet", "yellow" };
	// allthree attributes have true or false as values
	private final String[] attributesValues = { "t", "f" };

	private int[][] example;
	private String[] prob;
	private String answer;

	private TablePool tablePool;

	public TestBuilder()
	{
		this.example = new int[][] { { 400, 350, 450, 500 }, { 0, 150, 300, 300 }, { 100, 150, 50, 200 }, { 500, 650, 800, 1000 } };
		this.prob = new String[] { "t", "t", "t" };
		this.answer = "Banana";
	}

	public TablePool getTablePool()
	{
		return tablePool;
	}

	public void buid()
	{
		//define frequecy tables for three attributes
		ArrayFrequencyTable longTable;
		ArrayFrequencyTable sweetTable;
		ArrayFrequencyTable yellowTable;

		//create class attribute object
		double[] classFrequencies = new double[] { example[0][3], example[1][3], example[2][3] };
		ClassAttribute classAttribute = new ClassAttribute( classValues.length );
		classAttribute.init( classValues, classFrequencies );

		longTable = new ArrayFrequencyTable( classAttribute, classValues, attributes[0], attributesValues );
		sweetTable = new ArrayFrequencyTable( classAttribute, classValues, attributes[1], attributesValues );
		yellowTable = new ArrayFrequencyTable( classAttribute, classValues, attributes[2], attributesValues );

		//buildingLongTable
		for ( int i = 0; i < classValues.length; i++ )
		{
			double total = example[i][3];
			longTable.setProbability( classValues[i], attributesValues[0], example[i][0] / total );
			longTable.setProbability( classValues[i], attributesValues[1], ( total - example[i][0] ) / total );
		}

		//buildingSweetTable
		for ( int i = 0; i < classValues.length; i++ )
		{
			double total = example[i][3];
			sweetTable.setProbability( classValues[i], attributesValues[0], example[i][1] / total );
			sweetTable.setProbability( classValues[i], attributesValues[1], ( total - example[i][1] ) / total );
		}

		//buildingYellowTable
		for ( int i = 0; i < classValues.length; i++ )
		{
			double total = example[i][3];
			yellowTable.setProbability( classValues[i], attributesValues[0], example[i][2] / total );
			yellowTable.setProbability( classValues[i], attributesValues[1], ( total - example[i][2] ) / total );
		}
		tablePool = new TablePool( classAttribute, attributes );
		longTable.printTable();
		sweetTable.printTable();
		yellowTable.printTable();
		//add frequency Tables to the pool
		tablePool.add( attributes[0], longTable );
		tablePool.add( attributes[1], sweetTable );
		tablePool.add( attributes[2], yellowTable );

		//start posterior probabilities calculation
		MyNaiveBayes myNaiveBayes = new MyNaiveBayes( this.tablePool );
		myNaiveBayes.startCalculation( this.prob );
		myNaiveBayes.printProbabilities();

	}

}
