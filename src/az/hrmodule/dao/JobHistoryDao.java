package az.hrmodule.dao;

import az.hrmodule.config.DBConfig;
import az.hrmodule.domain.JobHistory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JobHistoryDao extends  Database {

    private String select_query = "select  * from job_history";

    public List<JobHistory> getList() {
        DBConfig dbConfig = new DBConfig();
        List<JobHistory> jobsHistory = new ArrayList<>();

        try {
            conn = dbConfig.getConnect();
            statement = conn.createStatement();
            resultSet = statement.executeQuery(select_query);

            while (resultSet.next()) {
                JobHistory jobHistory = new JobHistory();
                jobHistory.setEmployeeId(resultSet.getInt("employee_id"));
                jobHistory.setStartDate(resultSet.getDate("start_date"));
                jobHistory.setEndDate(resultSet.getDate("end_date"));
                jobHistory.setJobId(resultSet.getString("job_id"));
                jobHistory.setDepartmentId(resultSet.getInt("department_id"));

                jobsHistory.add(jobHistory);
            }


            close();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return jobsHistory;

    }
}
