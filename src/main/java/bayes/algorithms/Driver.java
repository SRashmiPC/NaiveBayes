package bayes.algorithms;

/**
 * Created by Rashmi on 9/12/2017.
 */
public class Driver
{
	public static void main( String[] args )
	{
		WekaNaiveBayes wekaNaiveBayes = new WekaNaiveBayes( "E:\\SampleDataset\\ionosphere.arff", 34 );
		wekaNaiveBayes.startNaiveBayes();
	}
}
