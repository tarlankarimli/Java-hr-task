package az.hrmodule.dao;

import az.hrmodule.config.DBConfig;
import az.hrmodule.domain.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LocationDao extends Database {

    private String select_query = "select  * from locations order by location_id asc";
    private String insert_query = "insert into locations (location_id, street_address, postal_code,city,state_province,country_id) values(?, ? ,?,?,?,?)";


    public List<Locations> getList() {
        DBConfig dbConfig = new DBConfig();
        List<Locations> locations = new ArrayList<>();

        try {
            conn = dbConfig.getConnect();
            statement = conn.createStatement();
            resultSet = statement.executeQuery(select_query);

            while (resultSet.next()) {
                Locations location = new Locations();

                location.setLocationId(resultSet.getInt("location_id"));
                location.setStreetAddress(resultSet.getString("street_address"));
                location.setPostalCode(resultSet.getString("postal_code"));
                location.setCity(resultSet.getString("city"));
                location.setStateProvince(resultSet.getString("state_province"));
                location.setCountryId(resultSet.getString("country_id"));

                locations.add(location);
            }


            close();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return locations;

    }
    public int save(Locations locations) {
        DBConfig dbConfig = new DBConfig();

        int result = 0;
        try {
            conn = dbConfig.getConnect();
            preparedStatement = conn.prepareStatement(insert_query);
            preparedStatement.setInt(1, locations.getLocationId());
            preparedStatement.setString(2, locations.getStreetAddress());
            preparedStatement.setString(3, locations.getPostalCode());
            preparedStatement.setString(4, locations.getCity());
            preparedStatement.setString(5, locations.getStateProvince());
            preparedStatement.setString(6, locations.getCountryId());

            result = preparedStatement.executeUpdate();


            close();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return result;

    }
}
