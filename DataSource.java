
package dataaccesslayer;

import java.sql.Connection;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
/*
Student Name:luyu chen 
Student Number: 040986748
Course & Section #: 23w_CST8200_012
A custom exception for cases when data is not in valid format.
*/
/**
 * @author Luyu Chen
 * @see ValidationException
 * @since IDE13
 */


/**

This class represents a data source that provides connections to a database.

It uses a properties file to retrieve the database connection information such as url, username, and password.

It can create and return a new connection if one does not exist, or return the existing connection if one already exists.
*/
public class DataSource {

private Connection connection;

/**

Creates a new instance of the DataSource class.
*/
public DataSource() {
}
/**

Retrieves the connection to the database by loading connection information from a properties file and creating a new connection,

or returning an existing connection if one already exists.

@return the Connection object representing the database connection
*/
public Connection createConnection() {
Properties props = new Properties();

try(InputStream in = Files.newInputStream(Paths.get("src/database.properties"));)
{
props.load(in);
}
catch(IOException e)
{
e.printStackTrace();
}

String url = props.getProperty("jdbc.url");
String username = props.getProperty("jdbc.username");
String password = props.getProperty("jdbc.password");

try
{
if(connection != null)
{
System.out.println("Cannot create new connection, one exists already");
}
else
{
connection = DriverManager.getConnection(url, username, password);
}
}
catch(SQLException ex)
{
ex.printStackTrace();
}

return connection;
}
}