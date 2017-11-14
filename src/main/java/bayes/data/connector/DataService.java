package bayes.data.connector;

import java.sql.Connection;
import java.util.ArrayList;

/**
 * Created by Rashmi on 11/11/2017.
 */
public abstract class DataService
{
	public abstract int getAttributeCardinality( String attribute, String table );

	public abstract int getAttributeValueCount( String value, String attribute, String table );

	public abstract int getTwoAttributesUnionCount( String valueOne, String attributeOne, String valueTwo, String attributeTwo, String table );

	public abstract int getAttributeCardinality( String attribute, String table, Connection connection );

	public abstract int getAttributeValueCount( String value, String attribute, String table, Connection connection );

	public abstract int getTwoAttributesUnionCount( String valueOne, String attributeOne, String valueTwo, String attributeTwo, String table, Connection connection );

	public abstract String[] getDistinctValues( String attribute, String table );

	public abstract String[] getDistinctValues( String attribute, String table, Connection connection );

	public abstract ArrayList<Integer> getIntegerValuesForClassValue( String attribute, String classValue, String classAttribute, String table );

	public abstract ArrayList<Integer> getIntegerValuesForClassValue( String attribute, String classValue, String classAttribute, String table, Connection connection );

	public abstract double[] getIntegerValuesForClassValuesArray( String attribute, String classValue, String classAttribute, int count, String table, Connection connection );

}
