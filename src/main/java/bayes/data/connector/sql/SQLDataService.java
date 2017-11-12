package bayes.data.connector.sql;

import bayes.data.connector.DataService;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by Rashmi on 11/11/2017.
 */
public class SQLDataService extends DataService
{
	private SQLConn sqlConn;

	public SQLDataService()
	{
		this.sqlConn = SQLConn.getDBConn();
	}

	public int getAttributeCardinality( String attribute, String table )
	{
		int count = 0;
		Connection connection = null;
		try
		{
			connection = this.sqlConn.getConnection();
			String query = "SELECT COUNT(DISTINCT " + attribute + " ) FROM " + table;
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery( query );
		}
		catch ( SQLException e )
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				connection.close();
			}
			catch ( SQLException e )
			{
				e.printStackTrace();
			}
		}
		return count;
	}

	public int getAttributeValueCount( String value, String attribute, String table )
	{
		int count = 0;
		Connection connection = null;
		try
		{
			connection = this.sqlConn.getConnection();
			String query = "SELECT COUNT( " + attribute + " ) FROM " + table + " WHERE " + attribute + " = " + value;
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery( query );

			if ( resultSet.first() )
			{
				return resultSet.getInt( 1 );
			}
		}
		catch ( SQLException e )
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				connection.close();
			}
			catch ( SQLException e )
			{
				e.printStackTrace();
			}
		}
		return count;
	}

	public int getTwoAttributesUnionCount( String valueOne, String attributeOne, String valueTwo, String attributeTwo, String table )
	{
		int count = 0;
		Connection connection = null;
		try
		{
			connection = this.sqlConn.getConnection();
			String query = "SELECT COUNT( " + attributeOne + " ) FROM " + table + " WHERE " + attributeOne + " = " + valueOne + " and " + attributeTwo + " = " + valueTwo;
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery( query );

			if ( resultSet.first() )
			{
				return resultSet.getInt( 1 );
			}
		}
		catch ( SQLException e )
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				connection.close();
			}
			catch ( SQLException e )
			{
				e.printStackTrace();
			}
		}
		return count;
	}

	public int getAttributeCardinality( String attribute, String table, Connection connection )
	{
		int count = 0;
		if ( connection == null )
		{
			return getAttributeCardinality( attribute, table );
		}
		try
		{
			String query = "SELECT COUNT(DISTINCT " + attribute + " ) FROM " + table;
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery( query );
		}
		catch ( SQLException e )
		{
			e.printStackTrace();
		}
		return count;
	}

	public int getAttributeValueCount( String value, String attribute, String table, Connection connection )
	{
		int count = 0;
		if ( connection == null )
		{
			return getAttributeValueCount( value, attribute, table );
		}
		try
		{
			String query = "SELECT COUNT( " + attribute + " ) FROM " + table + " WHERE " + attribute + " = " + value;
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery( query );

			if ( resultSet.first() )
			{
				return resultSet.getInt( 1 );
			}
		}
		catch ( SQLException e )
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				connection.close();
			}
			catch ( SQLException e )
			{
				e.printStackTrace();
			}
		}
		return count;
	}

	public int getTwoAttributesUnionCount( String valueOne, String attributeOne, String valueTwo, String attributeTwo, String table, Connection connection )
	{
		int count = 0;
		if ( connection == null )
		{
			return getTwoAttributesUnionCount( valueOne, attributeOne, valueTwo, attributeTwo, table );
		}
		try
		{
			String query = "SELECT COUNT( " + attributeOne + " ) FROM " + table + " WHERE " + attributeOne + " = " + valueOne + " and " + attributeTwo + " = " + valueTwo;
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery( query );

			if ( resultSet.first() )
			{
				return resultSet.getInt( 1 );
			}
		}
		catch ( SQLException e )
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				connection.close();
			}
			catch ( SQLException e )
			{
				e.printStackTrace();
			}
		}
		return count;
	}

	public String[] getDistinctValues( String attribute, String table )
	{
		String[] distinctValues = null;
		Connection connection = null;
		try
		{
			connection = this.sqlConn.getConnection();
			String query = "SELECT DISTINCT " + attribute + " FROM " + table;
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery( query );
			String string = "";
			while ( resultSet.next() )
			{
				string += resultSet.getString( 1 ) + ",";
			}
			string = string.substring( 0, string.length() - 1 );
			distinctValues = string.split( "," );
		}
		catch ( SQLException e )
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				connection.close();
			}
			catch ( SQLException e )
			{
				e.printStackTrace();
			}
		}
		return distinctValues;
	}

	public String[] getDistinctValues( String attribute, String table, Connection connection )
	{
		String[] distinctValues = null;
		if ( connection == null )
		{
			return getDistinctValues( attribute, table );
		}
		try
		{
			String query = "SELECT DISTINCT " + attribute + " FROM " + table;
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery( query );
			String string = "";
			while ( resultSet.next() )
			{
				string += resultSet.getString( 1 ) + ",";
			}
			string = string.substring( 0, string.length() - 1 );
			distinctValues = string.split( "," );
		}
		catch ( SQLException e )
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				connection.close();
			}
			catch ( SQLException e )
			{
				e.printStackTrace();
			}
		}
		return distinctValues;
	}

	public ArrayList<Integer> getIntegerValuesForClassValue( String attribute, String classValue, String classAttribute, String table )
	{
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		Connection connection = null;
		try
		{
			connection = this.sqlConn.getConnection();
			Statement statement = connection.createStatement();
			String query = "SELECT " + attribute + " FROM " + table + " WHERE " + classAttribute + "=" + classValue;
			ResultSet resultSet = statement.executeQuery( query );
			while ( resultSet.next() )
			{
				arrayList.add( resultSet.getInt( 1 ) );
			}
			return arrayList;
		}
		catch ( SQLException e )
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				connection.close();
			}
			catch ( SQLException e )
			{
				e.printStackTrace();
			}
		}
		return arrayList;
	}

	public ArrayList<Integer> getIntegerValuesForClassValue( String attribute, String classValue, String classAttribute, String table, Connection connection )
	{
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		if ( connection == null )
		{
			return getIntegerValuesForClassValue( attribute, classValue, classAttribute, table );
		}
		try
		{
			Statement statement = connection.createStatement();
			String query = "SELECT " + attribute + " FROM " + table + " WHERE " + classAttribute + "=" + classValue;
			ResultSet resultSet = statement.executeQuery( query );
			while ( resultSet.next() )
			{
				arrayList.add( resultSet.getInt( 1 ) );
			}
			return arrayList;
		}
		catch ( SQLException e )
		{
			e.printStackTrace();
		}
		return arrayList;
	}

	public int[] getIntegerValuesForClassValuesArray( String attribute, String classValue, String classAttribute, int count, String table, Connection connection )
	{
		int[] arrayList = new int[count];
		if ( connection == null )
		{
			//return getIntegerValuesForClassValue( attribute, classValue, classAttribute, table );
		}
		try
		{

			Statement statement = connection.createStatement();
			String query = "SELECT " + attribute + " FROM " + table + " WHERE " + classAttribute + "=" + classValue;
			ResultSet resultSet = statement.executeQuery( query );

			int index = 0;
			while ( resultSet.next() )
			{
				arrayList[index] = resultSet.getInt( 1 );
			}
			return arrayList;
		}
		catch ( SQLException e )
		{
			e.printStackTrace();
		}
		return arrayList;
	}
}
