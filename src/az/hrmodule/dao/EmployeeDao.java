package az.hrmodule.dao;

import az.hrmodule.config.DBConfig;
import az.hrmodule.domain.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao extends Database {
    private String select_query = "select  * from employees order by employee_id asc";

    private String insert_query = "insert into employees (EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, PHONE_NUMBER, HIRE_DATE, JOB_ID, SALARY, COMMISSION_PCT, MANAGER_ID, DEPARTMENT_ID) values(employee_id_sq.nextval,?,?,?,?,sysdate,?,?,?,?,?)";
    private String update_query = "  UPDATE employees  set   FIRST_NAME=?, LAST_NAME=?, EMAIL=?,    PHONE_NUMBER=?, JOB_ID=?, SALARY=?, COMMISSION_PCT=?,     MANAGER_ID=?, DEPARTMENT_ID=?     WHERE employee_id=?";

    public List<Employee> getList() {
        DBConfig dbConfig = new DBConfig();
        List<Employee> employees = new ArrayList<>();

        try {
            conn = dbConfig.getConnect();
            statement = conn.createStatement();
            resultSet = statement.executeQuery(select_query);

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


            close();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return employees;

    }
    public Employee getEmployee(String employeeId) {
        DBConfig dbConfig = new DBConfig();
        Employee employee = new Employee();
        try {
            conn = dbConfig.getConnect();
            preparedStatement = conn.prepareStatement("select  * from employees where employee_id=?");
            preparedStatement.setString(1,employeeId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

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
            }
            close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employee;
    }


    public int save(Employee employee) {
        DBConfig dbConfig = new DBConfig();

        int result = 0;
        try {
            conn = dbConfig.getConnect();
            preparedStatement = conn.prepareStatement(insert_query);
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setString(3, employee.getEmail());
            preparedStatement.setString(4, employee.getPhoneNumber());
            preparedStatement.setString(5, employee.getJobId());
            preparedStatement.setDouble(6, employee.getSalary());
            preparedStatement.setDouble(7, employee.getCommissionPct());
            preparedStatement.setInt(8, employee.getManagerId());
            preparedStatement.setInt(9, employee.getDepartmentId());

            result = preparedStatement.executeUpdate();


            close();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return result;

    }

    public int update(Employee employee) {
        DBConfig dbConfig = new DBConfig();

        int result = 0;
        try {
            conn = dbConfig.getConnect();
            preparedStatement = conn.prepareStatement(update_query);
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setString(3, employee.getEmail());
            preparedStatement.setString(4, employee.getPhoneNumber());
           // ps.setDate(5, (Date) employee.getHireDate());
            preparedStatement.setString(5, employee.getJobId());
            preparedStatement.setDouble(6, employee.getSalary());
            preparedStatement.setDouble(7, employee.getCommissionPct());
            preparedStatement.setInt(8, employee.getManagerId());
            preparedStatement.setInt(9, employee.getDepartmentId());
            preparedStatement.setInt(10, employee.getEmployeeId());

            result = preparedStatement.executeUpdate();


            close();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return result;

    }
}
