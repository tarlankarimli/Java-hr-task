package az.hrmodule.dao;

import az.hrmodule.config.DBConfig;
import az.hrmodule.domain.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
    private String select_query = "select  * from employees";

    private String insert_query = "insert into employees (EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, PHONE_NUMBER, HIRE_DATE, JOB_ID, SALARY, COMMISSION_PCT, MANAGER_ID, DEPARTMENT_ID) values(employee_id_sq.nextval,?,?,?,?,sysdate,?,?,?,?,?)";

    public List<Employee> getList() {
        DBConfig dbConfig = new DBConfig();
        List<Employee> employees = new ArrayList<>();

        try {
            Connection conn = dbConfig.getConnect();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(select_query);

            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setEmployeeId(resultSet.getInt(1));
                employee.setManagerId(resultSet.getInt("manager_id"));
                employee.setDepartmentId(resultSet.getInt("department_id"));
                employee.setFirstName(resultSet.getString("first_name"));
                employee.setLastName(resultSet.getString("last_name"));
                employee.setEmail(resultSet.getString("email"));
                employee.setPhoneNumber(resultSet.getString("phone_number"));
                employee.setJobId(resultSet.getString("job_id"));
                employee.setCommissionPct(resultSet.getDouble("commission_pct"));
                employee.setSalary(resultSet.getDouble("salary"));
                employee.setHireDate(resultSet.getDate("hire_date"));

                employees.add(employee);
            }


            conn.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return employees;

    }


    public int save(Employee employee) {
        DBConfig dbConfig = new DBConfig();

        int result = 0;
        try {
            Connection conn = dbConfig.getConnect();
            PreparedStatement ps = conn.prepareStatement(insert_query);
            ps.setString(1, employee.getFirstName());
            ps.setString(2, employee.getLastName());
            ps.setString(3, employee.getEmail());
            ps.setString(4, employee.getPhoneNumber());
            ps.setString(5, employee.getJobId());
            ps.setDouble(6, employee.getSalary());
            ps.setDouble(7, employee.getCommissionPct());
            ps.setInt(8, employee.getManagerId());
            ps.setInt(9, employee.getDepartmentId());

            result = ps.executeUpdate();


            conn.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return result;

    }
}
