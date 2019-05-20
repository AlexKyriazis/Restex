
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class DemoData {

    @Autowired
    private EmployeeRepository repoEmployee;

    @Autowired
    private ReportRepository repoReport;


    @EventListener
    public void appReady(ApplicationReadyEvent event) {

        Employee giorgos = new Employee();
        giorgos.setEmail("mail@mail.com");
        giorgos.setFirstName("giorgos");
        giorgos.setLastName("giorgopoulos");
        giorgos.setGender("maile");
        giorgos.setTitle("title");
        Report report = new Report();
        report.setDescription("Dummy report");
        report.setPriority(Priority.HIGH);
        report.setTitle("a title");
        report.setEmployee(giorgos);

        repoEmployee.save(giorgos);
        repoReport.save(report);
    }
}