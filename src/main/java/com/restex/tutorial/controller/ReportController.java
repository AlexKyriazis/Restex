package com.restex.tutorial.controller;

import com.restex.tutorial.exception.ResourceNotFoundException;
import com.restex.tutorial.model.Priority;
import com.restex.tutorial.model.Report;
import com.restex.tutorial.repository.EmployeeRepository;
import com.restex.tutorial.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The basic controller of the application.
 */
@RestController
@RequestMapping("/api/reports")
public class ReportController {
    private final int PAGE_SIZE = 10;
    @Autowired
    private EmployeeRepository repoEmployee;

    @Autowired
    private ReportRepository repoReports;

    @GetMapping("/all")
    public List<Report> getAllReports(){
        return repoReports.findAll();
    }

    @GetMapping("/userNamePriority/")
    public Page<Report> getReportsByUsernameAndPriority(@RequestParam String username, @RequestParam String priority, @RequestParam int pageNumber) throws ResourceNotFoundException {
        System.out.println(priority);
        Pageable pageable = PageRequest.of(pageNumber, PAGE_SIZE);
        if (Priority.fromString(priority) != null) {

            return repoReports.getReportsByPriorityAndUsername(username, priority, pageable);
        }
        throw new ResourceNotFoundException("priority must be one of two values: high, low ");
    }
}
