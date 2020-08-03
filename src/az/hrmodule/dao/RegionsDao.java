package az.hrmodule.dao;

import az.hrmodule.config.DBConfig;
import az.hrmodule.domain.Regions;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RegionsDao extends  Database{

    private String select_query = "select  * from regions";

    public List<Regions> getList() {
        DBConfig dbConfig = new DBConfig();
        List<Regions> regions = new ArrayList<>();

        try {
            conn = dbConfig.getConnect();
            statement = conn.createStatement();
            resultSet = statement.executeQuery(select_query);

            while (resultSet.next()) {
                Regions region = new Regions();

                region.setRegionName(resultSet.getString("region_name"));
                region.setRegionId(resultSet.getInt("region_id"));

                regions.add(region);
            }

            close();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return regions;

    }
}
