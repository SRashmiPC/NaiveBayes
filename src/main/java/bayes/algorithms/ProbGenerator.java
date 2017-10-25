package bayes.algorithms;

import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;

/**
 * Created by Rashmi on 10/25/2017.
 */
public class ProbGenerator
{
	private double mean;
	private double standardDeviation;
	private double[] data;
	private boolean useApacheCommonMath;
	private NormalDistribution normalDistribution;

	public ProbGenerator( double[] data )
	{
		this.data = data;
		this.useApacheCommonMath = true;
	}

	public ProbGenerator( double[] data, boolean useApacheCommonMath )
	{
		this.data = data;
		this.useApacheCommonMath = useApacheCommonMath;
	}

	/**
	 * initialize mean and sd
	 */
	public void init(){
		if(useApacheCommonMath){
			initUsingApacheCommonMath();
		}else {
			initUsingBitSlices();
		}
	}

	public void initUsingApacheCommonMath(){
		Mean mean = new Mean(  );
		this.mean = mean.evaluate( this.data, 0, this.data.length );
		StandardDeviation standardDeviation = new StandardDeviation(  );
		this.standardDeviation = standardDeviation.evaluate( this.data );
		this.normalDistribution = new NormalDistribution( this.mean, this.standardDeviation );
	}

	public void initUsingBitSlices(){

	}

	/**
	 * calculate the probability of given val accoring to the distribution
	 * @param value value that seeking for probability
	 * @return probabilty of given value
	 */
	public double getProbability(double value){
		return this.normalDistribution.cumulativeProbability( value );
	}
}
