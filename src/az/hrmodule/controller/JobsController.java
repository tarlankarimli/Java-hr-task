package az.hrmodule.controller;

import az.hrmodule.dao.*;
import az.hrmodule.domain.Countries;
import az.hrmodule.domain.Departments;
import az.hrmodule.domain.Jobs;
import az.hrmodule.domain.Locations;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JobsController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("loggeduser") != null) {

            if (req.getServletPath().equals("/jobs")) {
                JobsDao jobsDao = new JobsDao();
                req.setAttribute("jobList", jobsDao.getList());
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/Jobs/jobList.jsp");
                requestDispatcher.include(req, resp);
            }

            if (req.getServletPath().equals("/newJob")) {
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/Jobs/jobForm.jsp");
                requestDispatcher.include(req, resp);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getServletPath().equals("/saveJob")){

            JobsDao jobsDao=new JobsDao();
            Jobs jobs=new Jobs();

            jobs.setJobId(req.getParameter("job_id"));
            jobs.setJobTitle(req.getParameter("job_title"));

            jobsDao.save(jobs);

            req.setAttribute("jobList",jobsDao.getList());
            RequestDispatcher requestDispatcher=req.getRequestDispatcher("/views/Jobs/jobList.jsp");
            requestDispatcher.include(req,resp);
        }
    }
}
