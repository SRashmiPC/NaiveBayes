package bayes.algorithms;

import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.core.Instances;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

/**
 * Created by Rashmi on 9/12/2017.
 */
public class WekaNaiveBayes
{
	private String filePath;
	private int classIndex;

	public WekaNaiveBayes( String filePath, int classIndex )
	{
		this.filePath = filePath;
		this.classIndex = classIndex;
	}

	public WekaNaiveBayes()
	{
	}

	public String getFilePath()
	{
		return filePath;
	}

	public void setFilePath( String filePath )
	{
		this.filePath = filePath;
	}

	public Instances getInstance()
	{
		try
		{
			BufferedReader bufferedReader = new BufferedReader( new FileReader( this.filePath ) );
			Instances instances = new Instances( bufferedReader ); //generate instance using data file
			instances.setClassIndex( this.classIndex ); // set the class attribute in the instance
			bufferedReader.close(); // close buffer reader
			return instances;
		}
		catch ( FileNotFoundException e )
		{
			e.printStackTrace();
		}
		catch ( IOException e )
		{
			e.printStackTrace();
		}
		return null;
	}

	public Instances getInstance( String filepath, int classIndex )
	{
		try
		{
			BufferedReader bufferedReader = new BufferedReader( new FileReader( filePath ) );
			Instances instances = new Instances( bufferedReader ); //generate instance using data file
			instances.setClassIndex( classIndex ); // set the class attribute in the instance
			bufferedReader.close(); // close buffer reader
			return instances;
		}
		catch ( FileNotFoundException e )
		{
			e.printStackTrace();
		}
		catch ( IOException e )
		{
			e.printStackTrace();
		}
		return null;
	}

	public void startNaiveBayes()
	{
		Instances instances = getInstance();
		try
		{
			NaiveBayes naiveBayes = new NaiveBayes();
			naiveBayes.buildClassifier( instances ); // build classifiere
			Evaluation evaluation = new Evaluation( instances );
			//cross validate using 10 folds
			evaluation.crossValidateModel( naiveBayes, instances, 10, new Random( 1 ) );
			System.out.println( evaluation.toSummaryString( "\nResults\n*****\n", true ) );
			System.out.println( "Precision: " + evaluation.precision( 1 ) + " Recall: " + evaluation.recall( 1 ) );

		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
	}
}
