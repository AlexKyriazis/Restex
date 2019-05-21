package com.restex.tutorial.controller;

import com.restex.tutorial.model.Report;
import com.restex.tutorial.repository.EmployeeRepository;
import com.restex.tutorial.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class ReportController {
    @Autowired
    private EmployeeRepository repoEmployee;

    @Autowired
    private ReportRepository repoReports;

    @GetMapping("/all")
    public List<Report> getAllReports(){
        return repoReports.findAll();
    }

//    @GetMapping("/userNamePriority/")
//    public List<Report> getReportsByUsernameAndPriority(@RequestParam String username, @RequestParam Priority priority){
//        return repoReports.getReportsByPriorityAndUsername(priority, username);
//    }
}
