package com.restex.tutorial;

import com.restex.tutorial.model.Employee;
import com.restex.tutorial.model.Report;
import com.restex.tutorial.repository.EmployeeRepository;
import com.restex.tutorial.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Class for the insertion of test data
 */
@Component
public class DemoData {

    @Autowired
    private EmployeeRepository repoEmployee;

    @Autowired
    private ReportRepository repoReport;


    /**
     * @param event The application is ready Event
     */
    @EventListener
    public void appReady(ApplicationReadyEvent event) {

        repoReport.deleteAll();
        repoEmployee.deleteAll();
        Employee giorgos = new Employee();
        giorgos.setEmail("mail@mail.com");
        giorgos.setFirstName("giorgos");
        giorgos.setLastName("giorgopoulos");
        giorgos.setGender("maile");
        giorgos.setTitle("title");
        giorgos.setUsername("giorgos34");
        Report report = new Report();
        report.setDescription("Dummy report");
        report.setPriority("high");
        report.setTitle("a title");
        report.setEmployee(giorgos);

        repoEmployee.save(giorgos);
        repoReport.save(report);
    }
}