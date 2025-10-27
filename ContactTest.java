import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    @Test
    public void testValidContactCreation() {
        Contact contact = new Contact("123", "Jane", "Doe", "1234567890", "123 Main St");
        assertEquals("123", contact.getContactId());
        assertEquals("Jane", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }

    @Test
    public void testInvalidContactId() {
        // Null ID
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "Jane", "Doe", "1234567890", "123 Main St");
        });
        // Too long ID
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "Jane", "Doe", "1234567890", "123 Main St");
        });
    }

    @Test
    public void testInvalidPhoneUpdate() {
        Contact contact = new Contact("123", "Jane", "Doe", "1234567890", "123 Main St");
        // Too short phone number
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhone("123");
        });
    }

    @Test
    public void testUpdateFirstName() {
        Contact contact = new Contact("123", "Jane", "Doe", "1234567890", "123 Main St");
        contact.setFirstName("Janet");
        assertEquals("Janet", contact.getFirstName());
    }
}
