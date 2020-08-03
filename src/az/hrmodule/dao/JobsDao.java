package az.hrmodule.dao;

import az.hrmodule.config.DBConfig;
import az.hrmodule.domain.Departments;
import az.hrmodule.domain.Jobs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JobsDao extends Database{

    private String select_query = "select  * from jobs order by job_id asc";
    private String insert_query = "insert into jobs (job_id, job_title, min_salary,max_salary) values(?, ? ,?,?)";

    public List<Jobs> getList() {
        DBConfig dbConfig = new DBConfig();
        List<Jobs> jobs = new ArrayList<>();

        try {
            conn = dbConfig.getConnect();
            statement = conn.createStatement();
            resultSet = statement.executeQuery(select_query);

            while (resultSet.next()) {
                Jobs job = new Jobs();

                job.setJobId(resultSet.getString("job_id"));
                job.setJobTitle(resultSet.getString("job_title"));
                job.setMinSalary(resultSet.getInt("min_salary"));
                job.setMaxSalary(resultSet.getInt("max_salary"));

                jobs.add(job);
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jobs;
    }

    public int save(Jobs jobs) {
        DBConfig dbConfig = new DBConfig();

        int result = 0;
        try {
            conn = dbConfig.getConnect();
            preparedStatement = conn.prepareStatement(insert_query);
            preparedStatement.setString(1, jobs.getJobId());
            preparedStatement.setString(2, jobs.getJobTitle());
            preparedStatement.setInt(3, jobs.getMinSalary());
            preparedStatement.setInt(4, jobs.getMaxSalary());


            result = preparedStatement.executeUpdate();


            close();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return result;

    }
}
