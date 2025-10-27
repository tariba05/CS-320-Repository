import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

public class AppointmentTest {

    @Test
    public void testValidAppointment() {
        Date futureDate = new Date(System.currentTimeMillis() + 100000);
        Appointment appt = new Appointment("1234567890", futureDate, "Doctor appointment");
        assertEquals("1234567890", appt.getAppointmentId());
        assertEquals(futureDate, appt.getAppointmentDate());
        assertEquals("Doctor appointment", appt.getDescription());
    }

    @Test
    public void testInvalidId() {
        Date futureDate = new Date(System.currentTimeMillis() + 100000);
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(null, futureDate, "Checkup");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345678901", futureDate, "Checkup");
        });
    }

    @Test
    public void testInvalidDate() {
        Date pastDate = new Date(System.currentTimeMillis() - 100000);
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("123", pastDate, "Past appointment");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("123", null, "Null date");
        });
    }

    @Test
    public void testInvalidDescription() {
        Date futureDate = new Date(System.currentTimeMillis() + 100000);
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("123", futureDate, null);
        });

        String longDesc = "This description is way too long for the appointment field to accept!";
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("123", futureDate, longDesc);
        });
    }
}
