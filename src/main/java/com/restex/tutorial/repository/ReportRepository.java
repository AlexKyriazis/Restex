package com.restex.tutorial.repository;

import com.restex.tutorial.model.Report;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Report, Long> {


   public Page<Report> getReportsByPriorityAndUsername(String username, String priority, Pageable pageable);

}
