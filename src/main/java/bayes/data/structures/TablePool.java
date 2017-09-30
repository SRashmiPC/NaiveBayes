package bayes.data.structures;

import java.util.Map;

/**
 * Created by Rashmi on 9/30/2017.
 */
public class TablePool
{
	/**
	 * this class is a direct dependency of Naive Byes Algorithm
	 */
	Map<String, BasicFrequencyTable> attributeMap;

	public TablePool(String... attributeList)
	{

	}

	public void generateAtributeMap(String... attributeList){
		//TODO: generete map with relevant Frequency Tables
	}

	public BasicFrequencyTable getTable(String attribute){
		return attributeMap.get( attribute );
	}

	public double getProbability(String attribute, String attributeValue, String classValue){
		return getTable( attribute ).getProbabilty( attributeValue, classValue );
	}
}
