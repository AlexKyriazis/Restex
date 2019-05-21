package com.restex.tutorial;

import com.restex.tutorial.model.Employee;
import com.restex.tutorial.model.Report;
import com.restex.tutorial.repository.EmployeeRepository;
import com.restex.tutorial.repository.ReportRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApplicationTests {


    @Autowired
    private EmployeeRepository repoEmployee;

    @Autowired
    private ReportRepository repoReport;


    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    private String getRootUrl() {
        return "http://localhost:" + port;
    }

	@Test
	public void contextLoads() {
	}

    @Before
    public void setTestData() {
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

    @Test
    public void testGetAllReports() {

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/api/reports/all",
                HttpMethod.GET, entity, String.class);

        Assert.assertNotNull(response.getBody());
        Assert.assertEquals(200, response.getStatusCode());
    }

}
