/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlanetFood.Pojo;

/**
 *
 * @author ASUS
 */
public class Employees 
{  private String empId;
    private String ename;
    private double sal;
    private String job;

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setEmpno(String empno) {
        this.empId = empno;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public String getEmpno() {
        return empId;
    }

    public String getEname() {
        return ename;
    }

    public double getSal() {
        return sal;
    }
    
}

    

