package com.restex.tutorial.repository;

import com.restex.tutorial.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Report, Long> {


    //public List<Report> getReportsByPriorityAndUsername(Priority priority , String username);

}
