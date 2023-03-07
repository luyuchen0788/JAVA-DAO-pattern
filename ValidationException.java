/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package businesslayer;
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



public class ValidationException extends Exception {

/**

Constructs a new ValidationException with a default message "Data not in valid format".
*/
public ValidationException() {
super("Data not in valid format");
}
/**

Constructs a new ValidationException with the specified message.
@param message the detail message
*/
public ValidationException(String message) {
super(message);
}
/**

Constructs a new ValidationException with the specified detail message and cause.
@param message the detail message
@param cause the cause (which is saved for later retrieval by the getCause() method)
*/
public ValidationException(String message, Throwable cause) {
super(message, cause);
}
/**

Constructs a new ValidationException with the specified cause and a default message "Data not in valid format".
@param cause the cause (which is saved for later retrieval by the getCause() method)
*/
public ValidationException(Throwable cause) {
super("Data not in valid format", cause);
}
}


