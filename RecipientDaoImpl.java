
package dataaccesslayer;
/*
Student Name:luyu chen 
Student Number: 040986748
Course & Section #: 23w_CST8200_012

*/
/**
 * @author Luyu Chen
 * @see RecipientDaoImpl
 * @since IDE13
 */
import java.sql.ResultSetMetaData;
import java.util.List;
import transferobjects.RecipientDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author luyu chen
 */
public class RecipientDaoImpl implements RecipientDao 
{
    
        @Override
        public void printResultSetMetaData()
        {
            Connection con = null;
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            try
            {
                DataSource ds = new DataSource();
                con = ds.createConnection();
                pstmt = con.prepareCall("SELECT AwardID, Name, Year, City, Category from Recipients");
                rs = pstmt.executeQuery();
                ResultSetMetaData rsmd = rs.getMetaData();  
                
                            //Result set meta data
                System.out.println("Total cols: " + rsmd.getColumnCount());
                
                for(Integer i = 1; i <= rsmd.getColumnCount(); i++)
                {
                            System.out.println("Column name: " 
                                            + rsmd.getColumnName(i));
                            System.out.println("Column type: " 
                                        + rsmd.getColumnTypeName(i));    
                            
                            System.out.println("Java class: " 
                                    + rsmd.getColumnClassName(i));
                }
                            
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
            finally
            {
                try
                {
                    if(rs != null)
                    {
                        rs.close();
                    }
                }
                catch(SQLException ex)
                {
                    System.out.println(ex.getMessage());
                }
                
                try
                {
                    if(pstmt != null)
                    {
                        pstmt.close();
                    }
                }
                catch(SQLException ex)
                {
                    System.out.println(ex.getMessage());
                }
                
                try
                {
                    if(con != null)
                    {
                        con.close();
                    }
                }
                catch(SQLException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
        }
    
    	@Override
	public List<RecipientDTO> getAllRecipients() 
        {
            Connection con = null;
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            ArrayList<RecipientDTO> recipients = null;
            
            try
            {
                DataSource ds = new DataSource();
                con = ds.createConnection();
                pstmt = con.prepareCall("SELECT AwardID, Name, Year, City, Category from Recipients");
                rs = pstmt.executeQuery();
                recipients = new ArrayList<RecipientDTO>();
                while(rs.next())
                {
                    RecipientDTO r = new RecipientDTO();
                    r.setAwardID(rs.getInt("AwardID"));
                    r.setName(rs.getString("Name"));
                    r.setYear(rs.getInt("Year"));
                    r.setCity(rs.getString("City"));
                    r.setCategory(rs.getString("Category"));
                    recipients.add(r);
                }
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
            finally
            {
                try
                {
                    if(rs != null)
                    {
                        rs.close();
                    }
                }
                catch(SQLException ex)
                {
                    System.out.println(ex.getMessage());
                }
                
                try
                {
                    if(pstmt != null)
                    {
                        pstmt.close();
                    }
                }
                catch(SQLException ex)
                {
                    System.out.println(ex.getMessage());
                }
                
                try
                {
                    if(con != null)
                    {
                        con.close();
                    }
                }
                catch(SQLException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
            return recipients;
        }
        @Override
        public void addRecipient(RecipientDTO reci)
        {
		Connection con = null;
		PreparedStatement pstmt = null;
		try
                {
			DataSource ds = new DataSource();
			con = ds.createConnection();
			// do not insert AuthorID, it is generated by Database
			pstmt = con.prepareStatement(
					"INSERT INTO Recipients (Name, Year, City, Category) " +
			        "VALUES(?, ?, ?, ?)");
			pstmt.setString(1, reci.getName());
			pstmt.setInt(2, reci.getYear());
                        pstmt.setString(3, reci.getCity());
			pstmt.setString(4, reci.getCategory());
			pstmt.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			try{ if(pstmt != null){ pstmt.close(); }}
			catch(SQLException ex){System.out.println(ex.getMessage());}
			try{ if(con != null){ con.close(); }}
			catch(SQLException ex){System.out.println(ex.getMessage());}
		}
        }
        
        @Override
        public void deleteRecipient(RecipientDTO reci)
        {
                Connection con = null;
		PreparedStatement pstmt = null;
		try{
			DataSource ds = new DataSource();
			con = ds.createConnection();
			pstmt = con.prepareStatement(
					"DELETE FROM Recipients WHERE AwardID = ?");	
			pstmt.setInt(1, reci.getAwardID().intValue());
			pstmt.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			try{ if(pstmt != null){ pstmt.close(); }}
			catch(SQLException ex){System.out.println(ex.getMessage());}
			try{ if(con != null){ con.close(); }}
			catch(SQLException ex){System.out.println(ex.getMessage());}
		}
        }
                
        
        @Override
	public RecipientDTO getRecipientByRecipientId(Integer reciId)
        {
            return null;
        }
        
}
