package dataaccesslayer;
/*
Student Name:luyu chen 
Student Number: 040986748
Course & Section #: 23w_CST8200_012

*/
/**
 * @author Luyu Chen
 * @see  RecipientDao 
 * @since IDE13
 */

import transferobjects.RecipientDTO;
import java.util.List;

/**
 * This interface defines the methods that a Recipient DAO should implement.
 * The Recipient DAO is responsible for accessing and manipulating recipient data
 * in the application's data store.
 * 
 * The DAO pattern helps to separate the business logic from the persistence
 * logic of an application, making it easier to maintain and update each component.
 * 
 * 
 */
public interface RecipientDao 
{
    /**
     * Retrieves a list of all recipients from the data store.
     *
     * @return a List of RecipientDTO objects representing all recipients.
     */
    List<RecipientDTO> getAllRecipients();
    
    /**
     * Retrieves a recipient from the data store by their recipient ID.
     *
     * @param reciId the ID of the recipient to retrieve.
     * @return a RecipientDTO object representing the recipient with the specified ID.
     */
    RecipientDTO getRecipientByRecipientId(Integer reciId);
    
    /**
     * Adds a new recipient to the data store.
     *
     * @param reci the RecipientDTO object representing the recipient to add.
     */
    void addRecipient(RecipientDTO reci);
    
    /**
     * Deletes a recipient from the data store.
     *
     * @param reci the RecipientDTO object representing the recipient to delete.
     */
    void deleteRecipient(RecipientDTO reci);
    
    /**
     * Prints the metadata of the ResultSet object returned by a database query.
     * This method is useful for debugging and testing purposes.
     */
    void printResultSetMetaData();
    
}
