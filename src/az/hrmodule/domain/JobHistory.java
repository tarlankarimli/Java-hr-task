package az.hrmodule.domain;

import java.util.Date;

public class JobHistory {
    private int employeeId;
    private Date startDate;
    private Date endDate;
    private String jobId;
    private int departmentId;

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public String getJobId() {
        return jobId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    @Override
    public String toString() {
        return "JobHistory{" +
                "employeeId=" + employeeId +
                ", departmentId=" + departmentId +
                ", jobId=" + jobId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
