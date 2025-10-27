import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

public class AppointmentServiceTest {
    private AppointmentService service;
    private Appointment appointment;

    @BeforeEach
    public void setUp() {
        service = new AppointmentService();
        Date futureDate = new Date(System.currentTimeMillis() + 100000);
        appointment = new Appointment("001", futureDate, "Meeting");
    }

    @Test
    public void testAddAppointment() {
        service.addAppointment(appointment);
        assertEquals(appointment, service.getAppointment("001"));
    }

    @Test
    public void testAddDuplicateAppointment() {
        service.addAppointment(appointment);
        assertThrows(IllegalArgumentException.class, () -> {
            service.addAppointment(appointment);
        });
    }

    @Test
    public void testDeleteAppointment() {
        service.addAppointment(appointment);
        service.deleteAppointment("001");
        assertNull(service.getAppointment("001"));
    }

    @Test
    public void testDeleteNonexistentAppointment() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteAppointment("999");
        });
    }
}
