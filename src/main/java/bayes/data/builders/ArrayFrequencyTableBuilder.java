package bayes.data.builders;

import bayes.data.structures.ArrayFrequencyTable;
import bayes.data.structures.ClassAttribute;

/**
 * Created by Rashmi on 9/29/2017.
 */
public class ArrayFrequencyTableBuilder
{
	ArrayFrequencyTable arrayFrequencyTable;

	public ArrayFrequencyTableBuilder( ClassAttribute classAttribute, String attributeName, String[] classValues, String[] attributeValues )
	{
		this.arrayFrequencyTable = new ArrayFrequencyTable( classAttribute, classValues, attributeName, attributeValues );
	}

	public ArrayFrequencyTable getArrayFrequencyTable()
	{
		return arrayFrequencyTable;
	}

}
