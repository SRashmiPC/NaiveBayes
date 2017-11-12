package bayes.data.builders;

import bayes.data.connector.DataService;
import bayes.data.connector.sql.SQLConn;
import bayes.data.connector.sql.SQLDataService;
import bayes.data.structures.ArrayFrequencyTable;
import bayes.data.structures.ClassAttribute;
import bayes.data.structures.TablePool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Rashmi on 11/11/2017.
 */
public class EPMSQLBuilder
{
	private final String database = "epm";
	private final String table = "main";
	private final String classAttributeName = "session";
	private final String studentIdAttribute = "student_id";
	private final String exerciseAttribute = "exercise";
	private final String activityAttribute = "activity";
	private final String timeAttribute = "time";
	private final String wheelAttribute = "mouse_wheel";
	private final String wheelClickAttribute = "wheel_click";
	private final String leftAttribute = "left_click";
	private final String rightAttribute = "right_click";
	private final String movementAttribute = "movement";
	private final String keysAttribute = "no_of_keys";

	private TablePool tablePool;

	public EPMSQLBuilder()
	{
	}

	public void build()
	{
		Connection connection = null;
		try
		{
			//establish sql connection
			SQLConn sqlConn = SQLConn.getDBConn();
			connection = sqlConn.getConnection();
			//create dataservice
			DataService dataService = new SQLDataService();

			//fetching data
			int classCardinality = dataService.getAttributeCardinality( classAttributeName, table, connection );
			String[] classValues = dataService.getDistinctValues( classAttributeName, table, connection );
			int[] classValueFrequencies = new int[classCardinality];

			for ( int i = 0; i < classCardinality; i++ )
			{
				classValueFrequencies[i] = dataService.getAttributeValueCount( classValues[i], classAttributeName, table, connection );
			}

			//For catogorical Feilds
			//get other attributes cardinality;
			int studentCardinality = dataService.getAttributeCardinality( studentIdAttribute, table, connection );
			int exerciseCardinality = dataService.getAttributeCardinality( exerciseAttribute, table, connection );
			int activityCardinality = dataService.getAttributeCardinality( activityAttribute, table, connection );

			//get othe data distinct value list
			String[] studentIds = dataService.getDistinctValues( studentIdAttribute, table, connection );
			String[] exercises = dataService.getDistinctValues( exerciseAttribute, table, connection );
			String[] activities = dataService.getDistinctValues( activityAttribute, table, connection );

			ArrayList<String[]> distinctLists = new ArrayList<String[]>();
			distinctLists.add( studentIds );
			distinctLists.add( exercises );
			distinctLists.add( activities );

			//fetch union frequenciesn
			int numberOfLists = distinctLists.size();
			for ( int i = 0; i < numberOfLists; i++ )
			{
				String[] distinctList = distinctLists.get( i );
			}
			//int studentunion = dataService.getTwoAttributesUnionCount(  )

			//For numerical feilds
			//keep list of integer arrays for each numeric fiesld
			ArrayList<int[]> timeIntegerLists = new ArrayList<int[]>( classCardinality );
			ArrayList<int[]> wheelIntegerLists = new ArrayList<int[]>( classCardinality );
			ArrayList<int[]> wheelClickIntegerLists = new ArrayList<int[]>( classCardinality );
			ArrayList<int[]> leftIntegerLists = new ArrayList<int[]>( classCardinality );
			ArrayList<int[]> rightIntegerLists = new ArrayList<int[]>( classCardinality );
			ArrayList<int[]> movementIntegerLists = new ArrayList<int[]>( classCardinality );
			ArrayList<int[]> keysIntegerLists = new ArrayList<int[]>( classCardinality );

			//now fetch alll numerical fields
			//we fetch all numerical feild value count fro each class attribute values;
			for ( int i = 0; i < classCardinality; i++ )
			{
				int[] timeValues = dataService.getIntegerValuesForClassValuesArray( timeAttribute, classValues[i], classAttributeName, classValueFrequencies[i], table, connection );
				int[] wheelValues = dataService.getIntegerValuesForClassValuesArray( wheelAttribute, classValues[i], classAttributeName, classValueFrequencies[i], table, connection );
				int[] wheelClickValues = dataService.getIntegerValuesForClassValuesArray( wheelClickAttribute, classValues[i], classAttributeName, classValueFrequencies[i], table, connection );
				int[] leftValues = dataService.getIntegerValuesForClassValuesArray( leftAttribute, classValues[i], classAttributeName, classValueFrequencies[i], table, connection );
				int[] rightValues = dataService.getIntegerValuesForClassValuesArray( rightAttribute, classValues[i], classAttributeName, classValueFrequencies[i], table, connection );
				int[] movementValues = dataService.getIntegerValuesForClassValuesArray( movementAttribute, classValues[i], classAttributeName, classValueFrequencies[i], table, connection );
				int[] keysValues = dataService.getIntegerValuesForClassValuesArray( keysAttribute, classValues[i], classAttributeName, classValueFrequencies[i], table, connection );

				// add each integer array to relevent list
				timeIntegerLists.add( timeValues );
				wheelIntegerLists.add( wheelValues );
				wheelClickIntegerLists.add( wheelClickValues );
				leftIntegerLists.add( leftValues );
				rightIntegerLists.add( rightValues );
				movementIntegerLists.add( movementValues );
				keysIntegerLists.add( keysValues );
			}

			//creating frequency tables
			//create class Attribute
			ClassAttribute classAttribute = new ClassAttribute( classValues.length );
			classAttribute.init( classValues, classValueFrequencies );

			//creating frequency Table for catogarical values
			ArrayFrequencyTable studentTable = new ArrayFrequencyTable( classAttribute, classValues, studentIdAttribute, studentIds );
			ArrayFrequencyTable exerciseTable = new ArrayFrequencyTable( classAttribute, classValues, exerciseAttribute, exercises );
			ArrayFrequencyTable activityTable = new ArrayFrequencyTable( classAttribute, classValues, activityAttribute, activities );

			//set probabilities for each attribute
			for ( int i = 0; i < classCardinality; i++ )
			{
				for ( int j = 0; j < studentCardinality; j++ )
				{
					double probability = dataService.getTwoAttributesUnionCount( studentIds[j], studentIdAttribute, classValues[i], classAttributeName, table, connection );
					probability /= classValueFrequencies[i];
					studentTable.setProbability( classValues[i], studentIds[j], probability );
				}

				for ( int j = 0; j < studentCardinality; j++ )
				{
					double probability = dataService.getTwoAttributesUnionCount( exercises[j], exerciseAttribute, classValues[i], classAttributeName, table, connection );
					probability /= classValueFrequencies[i];
					studentTable.setProbability( classValues[i], studentIds[j], probability );
				}

				for ( int j = 0; j < studentCardinality; j++ )
				{
					double probability = dataService.getTwoAttributesUnionCount( activities[j], activityAttribute, classValues[i], classAttributeName, table, connection );
					probability /= classValueFrequencies[i];
					studentTable.setProbability( classValues[i], studentIds[j], probability );
				}
			}

		}
		finally
		{
			if ( connection != null )
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
		}

	}
}
