package bayes.algorithms;

/**
 * Created by Rashmi on 9/12/2017.
 */
public class Driver
{
	public static void main( String[] args )
	{
		BasicNaiveBayes basicNaiveBayes = new BasicNaiveBayes( "E:\\SampleDataset\\ionosphere.arff", 34 );
		basicNaiveBayes.startNaiveBayes();
	}
}
