package az.hrmodule.controller;

import az.hrmodule.dao.CountryDao;
import az.hrmodule.dao.RegionsDao;
import az.hrmodule.domain.Countries;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CountriesController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("loggeduser") != null) {

            if (req.getServletPath().equals("/countries")) {
                CountryDao countryDao = new CountryDao();

                req.setAttribute("countryList", countryDao.getList());
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/Countries/countryList.jsp");
                requestDispatcher.include(req, resp);
            }

            if (req.getServletPath().equals("/newCountry")) {
                RegionsDao regionsDao = new RegionsDao();

                req.setAttribute("regionList", regionsDao.getList());
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/Countries/countryForm.jsp");
                requestDispatcher.include(req, resp);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getServletPath().equals("/saveCountry")){

            CountryDao countryDao=new CountryDao();
            Countries countries=new Countries();

            countries.setCountryId(req.getParameter("country_id"));
            countries.setCountryName(req.getParameter("country_name"));
            countries.setRegionId(Integer.parseInt(req.getParameter("region_name")));

            countryDao.save(countries);

            req.setAttribute("countryList",countryDao.getList());
            RequestDispatcher requestDispatcher=req.getRequestDispatcher("/views/Countries/countryList.jsp");
            requestDispatcher.include(req,resp);
        }
    }
}
