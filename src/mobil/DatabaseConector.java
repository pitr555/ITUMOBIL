import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class DatabaseConector
{
  public static ArrayList<String> getWords(String t9, String word) throws ClassNotFoundException
  {
	ArrayList<String> words = new ArrayList<String>();  
	  
    // nacita sa driver sqlite
    Class.forName("org.sqlite.JDBC");
    
    Connection connection = null;
    try
    {
      // vytvori sa pripojenie na db
      connection = DriverManager.getConnection("jdbc:sqlite:t9.db");
      Statement statement = connection.createStatement();
      statement.setQueryTimeout(30);  
      
      
      ResultSet rs;
      
      if (word == null)
      {
    	  rs = statement.executeQuery("select * from slovnik where t9=\'" + t9 + "\'");
      }
      else
      {
    	  rs = statement.executeQuery("select * from slovnik where t9 like \'" + t9 + "%\' and slovo like \'" + word + "%\'");
      }
    	  
      int length = t9.length();
    	  
      while(rs.next())
      {  
    	  String slovo = rs.getString("slovo").substring(0, length);
    	  if (! words.contains(slovo))
    	  {
    		  words.add(slovo);
    	  }
      }
      
      
    }
    catch(SQLException e)
    {
      System.err.println(e.getMessage());
      words = null;
    }
    finally
    {
    
      try
      {
        if(connection != null)
          connection.close();
       
        
      }
      catch(SQLException e)
      {
        System.err.println(e);
        words = null;
        
      }
    }
	return words;
  }
}