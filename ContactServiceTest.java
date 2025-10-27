import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {

    @Test
    public void testAddContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("123", "Jane", "Doe", "1234567890", "123 Main St");

        service.addContact(contact);
        assertEquals("Jane", service.getContact("123").getFirstName());
    }

    @Test
    public void testDeleteContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("123", "Jane", "Doe", "1234567890", "123 Main St");

        service.addContact(contact);
        service.deleteContact("123");
        assertNull(service.getContact("123"));
    }

    @Test
    public void testUpdateFirstName() {
        ContactService service = new ContactService();
        Contact contact = new Contact("123", "Jane", "Doe", "1234567890", "123 Main St");

        service.addContact(contact);
        service.updateFirstName("123", "Janet");
        assertEquals("Janet", service.getContact("123").getFirstName());
    }

    @Test
    public void testDuplicateIdThrowsError() {
        ContactService service = new ContactService();
        Contact contact1 = new Contact("123", "Jane", "Doe", "1234567890", "123 Main St");
        Contact contact2 = new Contact("123", "John", "Smith", "0987654321", "456 Elm St");

        service.addContact(contact1);
        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(contact2);
        });
    }
}
