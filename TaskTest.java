
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {

    @Test
    public void testValidTaskCreation() {
        Task task = new Task("123", "Name", "Description");
        assertEquals("123", task.getTaskId());
        assertEquals("Name", task.getName());
        assertEquals("Description", task.getDescription());
    }

    @Test
    public void testInvalidTaskId() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task(null, "Name", "Description");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345678901", "Name", "Description");
        });
    }

    @Test
    public void testInvalidName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("123", null, "Description");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("123", "This name is way too long for the field", "Description");
        });
    }

    @Test
    public void testInvalidDescription() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("123", "Name", null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("123", "Name", "This description is way too long and definitely more than fifty characters.");
        });
    }

    @Test
    public void testSetters() {
        Task task = new Task("123", "Name", "Description");
        task.setName("NewName");
        task.setDescription("NewDescription");
        assertEquals("NewName", task.getName());
        assertEquals("NewDescription", task.getDescription());
    }
}
