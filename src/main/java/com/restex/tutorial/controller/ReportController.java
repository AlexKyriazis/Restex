
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
