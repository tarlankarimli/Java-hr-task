package az.hrmodule.controller;

import az.hrmodule.dao.RegionsDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegionsController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("loggeduser") != null) {
            if (req.getServletPath().equals("/regions")) {
                RegionsDao regionsDao = new RegionsDao();

                req.setAttribute("regionList", regionsDao.getList());
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/Regions/regionList.jsp");
                requestDispatcher.include(req, resp);
            }
        }
    }
}
