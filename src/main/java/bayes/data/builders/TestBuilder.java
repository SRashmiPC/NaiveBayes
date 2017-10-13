package bayes.data.builders;

import bayes.data.structures.ArrayFrequencyTable;
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
	private boolean[] prob = {};
	private String answer;

	private TablePool tablePool;

	public TestBuilder()
	{
		this.example = new int[][] { { 400, 350, 450, 500 }, { 0, 150, 300, 300 }, { 100, 150, 50, 200 }, { 500, 650, 800, 1000 } };
		this.prob = new boolean[] { true, true, true };
		this.answer = "Banana";
	}

	public void buid()
	{
		//define frequecy tables for three attributes
		ArrayFrequencyTable longTable;
		ArrayFrequencyTable sweetTable;
		ArrayFrequencyTable yellowTable;

		longTable = new ArrayFrequencyTable( className, attributes[0], classValues, attributesValues );
		sweetTable = new ArrayFrequencyTable( className, attributes[1], classValues, attributesValues );
		yellowTable = new ArrayFrequencyTable( className, attributes[2], classValues, attributesValues );

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

		longTable.printTable();
		sweetTable.printTable();
		yellowTable.printTable();

	}

}
