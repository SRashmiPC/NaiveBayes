package bayes.algorithms;

import bayes.data.builders.EPMSQLBuilder;
import bayes.data.builders.TestBuilder;

/**
 * Created by Rashmi on 9/12/2017.
 */
public class Driver
{
	public static void main( String[] args )
	{
		//		WekaNaiveBayes wekaNaiveBayes = new WekaNaiveBayes( "E:\\SampleDataset\\ionosphere.arff", 34 );
		//		wekaNaiveBayes.startNaiveBayes();

//		TestBuilder testBuilder = new TestBuilder();
//		testBuilder.buid();

		EPMSQLBuilder epmsqlBuilder = new EPMSQLBuilder();
		epmsqlBuilder.build();

	}
}
