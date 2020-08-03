package az.hrmodule.controller;

import az.hrmodule.dao.*;
import az.hrmodule.domain.Countries;
import az.hrmodule.domain.Employee;
import az.hrmodule.domain.Locations;
import az.hrmodule.domain.Regions;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;

public class EmployeeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("loggeduser") != null) {
            if (req.getServletPath().equals("/employee/list")) {
                EmployeeDao employeeDao = new EmployeeDao();
                req.setAttribute("empList", employeeDao.getList());
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/employeeList.jsp");
                requestDispatcher.include(req, resp);
            }

            if (req.getServletPath().equals("/employee/newPerson")) {

                EmployeeDao employeeDao = new EmployeeDao();
                JobsDao jobsDao = new JobsDao();
                DepartmentDao departmentDao = new DepartmentDao();

            /*for(Employee e:employeeDao.getList()){
                System.out.println(e.getDepartmentId());
            }*/
                req.setAttribute("empList", employeeDao.getList());
                req.setAttribute("jobList", jobsDao.getList());
                req.setAttribute("deptList", departmentDao.getList());
                req.setAttribute("action", "saveEmployee");
                req.setAttribute("employee", new Employee());
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/employeeForm.jsp");
                requestDispatcher.include(req, resp);
            }

            if(req.getServletPath().equals("/employee/edit")) {
                String employeeId = req.getParameter("employeeId");
                EmployeeDao employeeDao = new EmployeeDao();
                JobsDao jobsDao = new JobsDao();
                DepartmentDao departmentDao = new DepartmentDao();
                Employee employee = employeeDao.getEmployee(employeeId);

                req.setAttribute("empList", employeeDao.getList());
                req.setAttribute("jobList", jobsDao.getList());
                req.setAttribute("deptList", departmentDao.getList());
                req.setAttribute("action", "updateEmployee");
                req.setAttribute("employee", employee);
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/employeeForm.jsp");
                requestDispatcher.include(req, resp);
            }


        }else {
            resp.sendRedirect(req.getContextPath() + "/login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      //  if (req.getSession().getAttribute("userlogged") != null) {
        if(req.getServletPath().equals("/employee/saveEmployee")){

            EmployeeDao employeeDao=new EmployeeDao();
            Employee employee=new Employee();

            employee.setManagerId(Integer.parseInt( req.getParameter("manager_id")));
            employee.setDepartmentId(Integer.parseInt( req.getParameter("department_id")));
            employee.setFirstName(req.getParameter("first_name"));
            employee.setLastName(req.getParameter("last_name"));
            employee.setEmail(req.getParameter("email"));
            employee.setPhoneNumber(req.getParameter("phone_number"));
            employee.setJobId(req.getParameter("job_id"));
            employee.setCommissionPct(Double.parseDouble(req.getParameter("commission_pct")));
            employee.setSalary(Double.parseDouble(req.getParameter("salary")));
            employeeDao.save(employee);

            req.setAttribute("empList",employeeDao.getList());
            RequestDispatcher requestDispatcher=req.getRequestDispatcher("/views/employeeList.jsp");
            requestDispatcher.include(req,resp);
        }

            if(req.getServletPath().equals("/employee/updateEmployee")){
                EmployeeDao employeeDao=new EmployeeDao();
                Employee employee=new Employee();

                employee.setManagerId(Integer.parseInt( req.getParameter("manager_id")));
                employee.setDepartmentId(Integer.parseInt( req.getParameter("department_id")));
                employee.setFirstName(req.getParameter("first_name"));
                employee.setLastName(req.getParameter("last_name"));
                employee.setEmail(req.getParameter("email"));
                employee.setPhoneNumber(req.getParameter("phone_number"));
                employee.setJobId(req.getParameter("job_id"));
                employee.setCommissionPct(Double.parseDouble(req.getParameter("commission_pct")));
                employee.setSalary(Double.parseDouble(req.getParameter("salary")));
                employee.setEmployeeId(Integer.parseInt( req.getParameter("id")));
                employeeDao.update(employee);

                req.setAttribute("empList",employeeDao.getList());
                RequestDispatcher requestDispatcher=req.getRequestDispatcher("/views/employeeList.jsp");
                requestDispatcher.include(req,resp);
            }

//        }else {
//            resp.sendRedirect(req.getContextPath() + "/login");
//
//        }
    }


}
