package bayes.data.connector.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Rashmi on 11/11/2017.
 */
public class SQLConn
{
	private static SQLConn dbConn;

	private SQLConn()
	{
	}

	public static SQLConn getDBConn()
	{
		if ( dbConn != null )
		{
			return dbConn;
		}
		else
		{
			dbConn = new SQLConn();
			return dbConn;
		}
	}

	public Connection getConnection()
	{
		Connection con = null;
		try
		{
			Class.forName( "com.mysql.jdbc.Driver" );
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/epm", "root", "" );
		}
		catch ( ClassNotFoundException e )
		{
			e.printStackTrace();
		}
		catch ( SQLException e )
		{
			e.printStackTrace();
		}

		return con;
	}
}
