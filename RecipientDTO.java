
package transferobjects;

/*
Student Name:luyu chen 
Student Number: 040986748
Course & Section #: 23w_CST8200_012
Demonstration of Strategy design pattern
*/
/**
 * @author Luyu Chen
 * @see RecipientDTO 
 * @since IDE13
 */
public class RecipientDTO 
{
    private Integer awardID;
    private String name;
    private Integer year;
    private String city;
    private String category;

    /**
     * Get the ID of the award received by the recipient.
     * @return the award ID
     */
    public Integer getAwardID() {
        return awardID;
    }

    /**
     * Set the ID of the award received by the recipient.
     * @param awardID the award ID
     */
    public void setAwardID(Integer awardID) {
        this.awardID = awardID;
    }

    /**
     * Get the name of the recipient.
     * @return the recipient name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the recipient.
     * @param name the recipient name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the year the award was received by the recipient.
     * @return the award year
     */
    public Integer getYear() {
        return year;
    }

    /**
     * Set the year the award was received by the recipient.
     * @param year the award year
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     * Get the city where the award was received by the recipient.
     * @return the award city
     */
    public String getCity() {
        return city;
    }

    /**
     * Set the city where the award was received by the recipient.
     * @param city the award city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Get the category of the award received by the recipient.
     * @return the award category
     */
    public String getCategory() {
        return category;
    }

    /**
     * Set the category of the award received by the recipient.
     * @param category the award category
     */
    public void setCategory(String category) {
        this.category = category;
    }
}