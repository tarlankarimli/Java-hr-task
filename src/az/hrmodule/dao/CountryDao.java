package az.hrmodule.dao;

import az.hrmodule.config.DBConfig;
import az.hrmodule.domain.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CountryDao {

    private String select_query = "select  * from countries";
    private String insert_query = "insert into countries (country_id, country_name, region_id) values(?, ? ,?)";


    public List<Countries> getList() {
        DBConfig dbConfig = new DBConfig();
        List<Countries> countries = new ArrayList<>();

        try {
            Connection conn = dbConfig.getConnect();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(select_query);

            while (resultSet.next()) {
                Countries country = new Countries();

                country.setCountryId(resultSet.getString("country_id"));
                country.setCountryName(resultSet.getString("country_name"));
                country.setRegionId(resultSet.getInt("region_id"));

                countries.add(country);
            }


            conn.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return countries;

    }
    public int save(Countries countries) {
        DBConfig dbConfig = new DBConfig();

        int result = 0;
        try {
            Connection conn = dbConfig.getConnect();
            PreparedStatement ps = conn.prepareStatement(insert_query);
            ps.setString(1, countries.getCountryId());
            ps.setString(2, countries.getCountryName());
            ps.setInt(3, countries.getRegionId());
            System.out.println();

            result = ps.executeUpdate();


            conn.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return result;

    }
}
