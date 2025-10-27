/*
 * Mod 3 Assignment
 * CS 320
 * 
 * 7/20/25
 * 
 */
public class Contact {
    // Class variables
    private final String contactId;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    // Constructor
    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
        validateContactId(contactId);
        validateFirstName(firstName);
        validateLastName(lastName);
        validatePhone(phone);
        validateAddress(address);

        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    // Getters
    public String getContactId() {
        return contactId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    // Setters with validation
    public void setFirstName(String firstName) {
        validateFirstName(firstName);
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        validateLastName(lastName);
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        validatePhone(phone);
        this.phone = phone;
    }

    public void setAddress(String address) {
        validateAddress(address);
        this.address = address;
    }

    // ===== Validation Methods =====
    private void validateContactId(String contactId) {
        if (contactId == null || contactId.length() > 10) {
            throw new IllegalArgumentException("Contact ID is invalid");
        }
    }

    private void validateFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("First name is invalid");
        }
    }

    private void validateLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Last name is invalid");
        }
    }

    private void validatePhone(String phone) {
        if (phone == null || phone.length() != 10) {
            throw new IllegalArgumentException("Phone number is invalid");
        }
    }

    private void validateAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Address is invalid");
        }
    }
}
