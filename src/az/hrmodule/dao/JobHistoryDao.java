package az.hrmodule.dao;

import az.hrmodule.config.DBConfig;
import az.hrmodule.domain.Department;
import az.hrmodule.domain.Job;
import az.hrmodule.domain.JobHistory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JobHistoryDao {

    private String select_query = "select  * from job_history";

    public List<JobHistory> getList() {
        DBConfig dbConfig = new DBConfig();
        List<JobHistory> jobsHistory = new ArrayList<>();

        try {
            Connection conn = dbConfig.getConnect();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(select_query);

            while (resultSet.next()) {
                JobHistory jobHistory = new JobHistory();

                jobHistory.setEmployeeId(resultSet.getInt("employee_id"));
                jobHistory.setDepartmentId(resultSet.getInt("department_id"));
                jobHistory.setJobId(resultSet.getInt("job_id"));
                jobHistory.setStartDate(resultSet.getDate("start_date"));
                jobHistory.setEndDate(resultSet.getDate("end_date"));

                jobsHistory.add(jobHistory);
            }


            conn.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return jobsHistory;

    }
}
