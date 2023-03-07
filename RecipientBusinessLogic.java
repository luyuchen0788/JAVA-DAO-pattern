/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package businesslayer;

import dataaccesslayer.RecipientDao;
import dataaccesslayer.RecipientDaoImpl;
import java.util.List;
import transferobjects.RecipientDTO;

/*
Student Name:luyu chen 
Student Number: 040986748
Course & Section #: 23w_CST8200_012
A class that provides business logic for handling Recipient data.
*/
/**
 * @author Luyu Chen
 * @see RecipientBusinessLogic
 * @since IDE13
 */


public class RecipientBusinessLogic
{
private static final int NAME_MAX_LENGTH = 40;
private static final int YEAR_MAX_LENGTH = 11;
private static final int CITY_MAX_LENGTH = 30;
private static final int CATEGORY_MAX_LENGTH = 40;

private RecipientDao reciDao = null;

/**

Creates a new RecipientBusinessLogic object and initializes its RecipientDao.
*/
public RecipientBusinessLogic()
{
reciDao = new RecipientDaoImpl();
}
/**

Returns a List of all RecipientDTOs from the RecipientDao.
@return a List of all RecipientDTOs
*/
public List<RecipientDTO> getAllRecipientDaos()
{
return reciDao.getAllRecipients();
}
/**

Adds the given RecipientDTO to the RecipientDao after cleaning and validating the data.
@param reci the RecipientDTO to add
@throws ValidationException if the RecipientDTO is invalid
*/
public void addRecipient(RecipientDTO reci) throws ValidationException
{
cleanRecipient(reci);
validateRecipient(reci);
reciDao.addRecipient(reci);
}
/**

Cleans the given RecipientDTO by trimming its name, city, and category fields.
@param reci the RecipientDTO to clean
*/
private void cleanRecipient(RecipientDTO reci)
{
if(reci.getName() != null){
reci.setName(reci.getName().trim());
}
if(reci.getCity() != null){
reci.setCity(reci.getCity().trim());
}
if(reci.getCategory() != null){
reci.setCategory(reci.getCategory().trim());
}
}
/**

Deletes the given RecipientDTO from the RecipientDao.
@param reci the RecipientDTO to delete
@throws ValidationException if the RecipientDTO is invalid
*/
public void deleteRecipient(RecipientDTO reci) throws ValidationException
{
reciDao.deleteRecipient(reci);
}
/**

Prints the metadata of the RecipientDao's ResultSet.
*/
public void printResultSetMetaData()
{
reciDao.printResultSetMetaData();
}
/**

Validates the given RecipientDTO by checking its name, city, and category fields.
@param reci the RecipientDTO to validate
@throws ValidationException if the RecipientDTO is invalid
*/
private void validateRecipient(RecipientDTO reci) throws ValidationException
{
validateString(reci.getName(), "Name", NAME_MAX_LENGTH, true);
validateString(reci.getCity(), "City", CITY_MAX_LENGTH, true);
validateString(reci.getCategory(), "Category", CATEGORY_MAX_LENGTH, true);
}
/**

Validates the given string by checking its length and nullability.
@param value the string to validate
@param fieldName the name of the field being validated
@param maxLength the maximum length of the field
@param isNullAllowed whether null values are allowed for the field
@throws ValidationException if the string is invalid
*/
private void validateString(String value, String fieldName, int maxLength, boolean isNullAllowed)
throws ValidationException{
if(value == null && isNullAllowed


){
                throw new ValidationException(String.format("%s cannot be null", 
                            fieldName));
            }
            else if(value.length() == 0){
                    throw new ValidationException(String.format("%s cannot be empty or only whitespace", 
                                    fieldName));
            }
            else if(value.length() > maxLength){
                    throw new ValidationException(String.format("%s cannot exceed %d characters", 
                                    fieldName, maxLength));
            }
    }
}
