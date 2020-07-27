package az.hrmodule.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConfig {

    private Connection conn=null;

    public void closeConn(){
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public Connection getConnect(){

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url="jdbc:oracle:thin:@192.168.109.73:1521/xe";
            String user="hr";
            String password="hr";
            Properties properties=new Properties();
            properties.setProperty("user",user);
            properties.setProperty("password",password);

            conn = DriverManager.getConnection(url, properties);

            ///   conn = DriverManager.getConnection(url, user,password);

            if(conn == null){
                System.out.println("Not connected");
            }else{
                System.out.println("Connected");
            }



        }catch (SQLException | ClassNotFoundException se){
            se.printStackTrace();
        }

        return conn;
    }


}
