package az.hrmodule.controller;

import az.hrmodule.dao.*;
import az.hrmodule.domain.Countries;
import az.hrmodule.domain.Departments;
import az.hrmodule.domain.Locations;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DepartmentsController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("loggeduser") != null) {

            if (req.getServletPath().equals("/departments")) {
                DepartmentDao departmentDao = new DepartmentDao();

                req.setAttribute("departmentList", departmentDao.getList());
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/Departments/departmentList.jsp");
                requestDispatcher.include(req, resp);
            }

            if (req.getServletPath().equals("/newDepartment")) {
                LocationDao locationDao = new LocationDao();
                EmployeeDao employeeDao = new EmployeeDao();

                req.setAttribute("locationList", locationDao.getList());
                req.setAttribute("empList", employeeDao.getList());
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/Departments/departmentForm.jsp");
                requestDispatcher.include(req, resp);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getServletPath().equals("/saveDepartment")){

            DepartmentDao departmentDao=new DepartmentDao();
            Departments departments=new Departments();

            departments.setDepartmentId(Integer.parseInt(req.getParameter("department_id")));
            departments.setDepartmentName(req.getParameter("department_name"));
            departments.setManagerId(Integer.parseInt(req.getParameter("manager_id")));
            departments.setLocationId(Integer.parseInt(req.getParameter("location_id")));

            departmentDao.save(departments);

            req.setAttribute("departmentList",departmentDao.getList());
            RequestDispatcher requestDispatcher=req.getRequestDispatcher("/views/Departments/departmentList.jsp");
            requestDispatcher.include(req,resp);
        }
    }
}
