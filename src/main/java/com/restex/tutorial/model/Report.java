package com.restex.tutorial.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 *
 */
@Entity
@Table(name = "report")
@EntityListeners(AuditingEntityListener.class)
@NamedQuery(name = "Report.getReportsByPriorityAndUsername",
        query = "SELECT r FROM Report r , Employee e WHERE e.username = ?1 AND r.priority = ?2 "
)

public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "title", nullable = false)
    private String title;

    //@Enumerated
    @Column(name = "priority", nullable = false)
    private String priority;

    @ManyToOne( optional = false)
    private Employee employee;

    public long getId() {
        return id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "description", nullable = false)
    private String description;
}
