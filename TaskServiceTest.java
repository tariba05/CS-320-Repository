
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskServiceTest {

    @Test
    public void testAddAndGetTask() {
        TaskService service = new TaskService();
        Task task = new Task("1", "Test", "Testing");
        service.addTask(task);
        assertEquals(task, service.getTask("1"));
    }

    @Test
    public void testDuplicateTaskId() {
        TaskService service = new TaskService();
        Task task1 = new Task("1", "First", "First Description");
        Task task2 = new Task("1", "Second", "Second Description");
        service.addTask(task1);
        assertThrows(IllegalArgumentException.class, () -> {
            service.addTask(task2);
        });
    }

    @Test
    public void testDeleteTask() {
        TaskService service = new TaskService();
        Task task = new Task("1", "Test", "Testing");
        service.addTask(task);
        service.deleteTask("1");
        assertNull(service.getTask("1"));
    }

    @Test
    public void testUpdateTaskName() {
        TaskService service = new TaskService();
        Task task = new Task("1", "OldName", "Desc");
        service.addTask(task);
        service.updateTaskName("1", "NewName");
        assertEquals("NewName", service.getTask("1").getName());
    }

    @Test
    public void testUpdateTaskDescription() {
        TaskService service = new TaskService();
        Task task = new Task("1", "Name", "OldDesc");
        service.addTask(task);
        service.updateTaskDescription("1", "NewDesc");
        assertEquals("NewDesc", service.getTask("1").getDescription());
    }

        @Test
    public void testUpdateNonExistentTask() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateName("999", "New Name");
        });
    }

    @Test
    public void testDeleteNonExistentTask() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteTask("999");
        });
    }

    @Test
    public void testUpdateDescriptionTooLong() {
        service.addTask(task);
        String tooLong = "This description is definitely way longer than fifty characters allowed";
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateDescription(task.getTaskId(), tooLong);
        });
    }


}
