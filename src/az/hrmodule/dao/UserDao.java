package az.hrmodule.dao;

import az.hrmodule.config.DBConfig;

import java.sql.SQLException;

public class UserDao extends Database{

    public boolean login(String email, String password) {
        DBConfig dbConfig = new DBConfig();
        conn = dbConfig.getConnect();
        String user_query = "select * from users t where t.email=? and t.password=? and t.isActive=1";
        try {
            preparedStatement = conn.prepareStatement(user_query);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                close();
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return  false;
        } finally {
            close();
        }
        return false;
    }
}
