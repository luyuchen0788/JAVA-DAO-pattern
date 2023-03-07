
import businesslayer.RecipientBusinessLogic;
import businesslayer.ValidationException;
import dataaccesslayer.RecipientDao;
import java.util.List;
import transferobjects.RecipientDTO;

/*
Student Name:luyu chen 
Student Number: 040986748
Course & Section #: 23w_CST8200_012
Demonstration of Strategy design pattern
*/
/**
 * @author Luyu Chen
 * @see SimpleDemo
 * @since IDE13
 */

/**This class represents a Java application that interacts with a recipient database using the+
 * RecipientBusinessLogic class.

It includes a main method that performs the following actions:

Prints the metadata of the database using the RecipientBusinessLogic method printResultSetMetaData.
Retrieves all recipients from the database using the RecipientBusinessLogic method getAllRecipientDaos and prints them using the method printRecipients.
Inserts a new recipient into the database using the RecipientBusinessLogic method addRecipient and prints the updated list of recipients using the method printRecipients.
Deletes the last recipient in the database using the RecipientBusinessLogic method deleteRecipient and prints the updated list of recipients using the method printRecipients.
The class also includes two private methods: printRecipient and printRecipients, which are used to print individual recipients and lists of recipients, respectively.
*/
public class SimpleDemo{

 
	public void demo()
  
        {
        try
        {
                RecipientBusinessLogic logic = new RecipientBusinessLogic();
                List<RecipientDTO> list = null;
                RecipientDTO reci = null;
                
                System.out.println("Printing Metadata");
                logic.printResultSetMetaData();
                System.out.println();

                System.out.println("Printing Recipients First");
                list = logic.getAllRecipientDaos();
                printRecipients(list);
     
                System.out.println("Inserting One Recipient");
                reci = new RecipientDTO();
                reci.setName("luyu Chen");
                reci.setCity("Ottawa");
                reci.setYear(2000);
                reci.setCategory("Education");       
                logic.addRecipient(reci);
                //list = logic.getAllRecipientDaos();

                System.out.println("Printing Recipients");
                list = logic.getAllRecipientDaos();
                printRecipients(list);
                
                System.out.println("Deleting last recipient");
                list = logic.getAllRecipientDaos();
                reci = list.get(list.size() - 1);
                logic.deleteRecipient(reci);
                list = logic.getAllRecipientDaos();
                printRecipients(list);
                                
	}
        catch(ValidationException e)
        {
                System.err.println(e.getMessage());
        }
    }
    /**A private method that takes a RecipientDTO object and prints its properties.
      *@param reci the RecipientDTO object to be printed
      */
    
private static void printRecipient(RecipientDTO reci) {
    String output = String.format("%-10s%-40s%-10s%-20s%-15s",
            reci.getAwardID().toString(),
            reci.getName(),
            reci.getYear(),
            reci.getCity(),
            reci.getCategory());
    System.out.println(output);
}

private static void printRecipients(List<RecipientDTO> dtos) {
    System.out.printf("%-10s%-40s%-10s%-20s%-15s%n", "Award ID",
            "Name", "Year", "City", "Category");
    for (RecipientDTO dto : dtos) {
        printRecipient(dto);
    }
    System.out.println();
}

}
