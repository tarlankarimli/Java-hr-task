package az.hrmodule.controller;

import az.hrmodule.dao.CountryDao;
import az.hrmodule.dao.LocationDao;
import az.hrmodule.dao.RegionsDao;
import az.hrmodule.domain.Countries;
import az.hrmodule.domain.Locations;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LocationsController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("loggeduser") != null) {

            if (req.getServletPath().equals("/locations")) {
                LocationDao locationDao = new LocationDao();

                req.setAttribute("locationList", locationDao.getList());
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/Locations/locationList.jsp");
                requestDispatcher.include(req, resp);
            }

            if (req.getServletPath().equals("/newLocation")) {
                CountryDao countryDao = new CountryDao();

                req.setAttribute("countryList", countryDao.getList());
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/Locations/locationForm.jsp");
                requestDispatcher.include(req, resp);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getServletPath().equals("/saveLocation")){

            LocationDao locationDao=new LocationDao();
            Locations locations=new Locations();

            locations.setLocationId(Integer.parseInt(req.getParameter("location_id")));
            locations.setStreetAddress(req.getParameter("street_address"));
            locations.setPostalCode(req.getParameter("postal_code"));
            locations.setCity(req.getParameter("city"));
            locations.setStateProvince(req.getParameter("state_province"));
            locations.setCountryId(req.getParameter("country_id"));

            locationDao.save(locations);

            req.setAttribute("locationList",locationDao.getList());
            RequestDispatcher requestDispatcher=req.getRequestDispatcher("/views/Locations/locationList.jsp");
            requestDispatcher.include(req,resp);
        }
    }
}
