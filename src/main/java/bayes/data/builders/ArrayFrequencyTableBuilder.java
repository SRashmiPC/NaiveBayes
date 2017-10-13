package bayes.data.builders;

import bayes.data.structures.ArrayFrequencyTable;

/**
 * Created by Rashmi on 9/29/2017.
 */
public class ArrayFrequencyTableBuilder
{
	ArrayFrequencyTable arrayFrequencyTable;

	public ArrayFrequencyTableBuilder( String className, String attributeName, String[] classValues, String[] attributeValues )
	{
		this.arrayFrequencyTable = new ArrayFrequencyTable( className, attributeName, classValues, attributeValues );
	}

	public ArrayFrequencyTable getArrayFrequencyTable()
	{
		return arrayFrequencyTable;
	}

}
