package az.hrmodule.dao;

import az.hrmodule.config.DBConfig;
import az.hrmodule.domain.Departments;
import az.hrmodule.domain.Locations;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDao extends  Database{

    private String select_query = "select  * from departments order by department_id asc";
    private String insert_query = "insert into departments (department_id, department_name, manager_id,location_id) values(?, ? ,?,?)";


    public List<Departments> getList() {
        DBConfig dbConfig = new DBConfig();
        List<Departments> departments = new ArrayList<>();

        try {
            conn = dbConfig.getConnect();
            statement = conn.createStatement();
            resultSet = statement.executeQuery(select_query);

            while (resultSet.next()) {
                Departments department = new Departments();

                department.setDepartmentId(resultSet.getInt("department_id"));
                department.setDepartmentName(resultSet.getString("department_name"));
                department.setManagerId(resultSet.getInt("manager_id"));
                department.setLocationId(resultSet.getInt("location_id"));

                departments.add(department);
            }


            close();
        } catch (Exception e) {

            e.printStackTrace();
        }
        return departments;

    }

    public int save(Departments departments) {
        DBConfig dbConfig = new DBConfig();

        int result = 0;
        try {
            conn = dbConfig.getConnect();
            preparedStatement = conn.prepareStatement(insert_query);
            preparedStatement.setInt(1, departments.getDepartmentId());
            preparedStatement.setString(2, departments.getDepartmentName());
            preparedStatement.setInt(3, departments.getManagerId());
            preparedStatement.setInt(4, departments.getLocationId());


            result = preparedStatement.executeUpdate();


            close();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return result;

    }
}
