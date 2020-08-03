package az.hrmodule.dao;

import az.hrmodule.config.DBConfig;

import javax.xml.transform.Result;
import java.sql.*;

public class Database {
   Connection conn= null;
   PreparedStatement preparedStatement = null;
   ResultSet resultSet = null;
   Statement statement = null;

    public void close() {
        if(conn!=null) {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(preparedStatement!=null) {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(resultSet!=null) {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
