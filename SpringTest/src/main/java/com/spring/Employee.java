package com.spring;

public class Employee {
    String employeeName;
    public void setEmployeeName(String empName)
    {
        this.employeeName=empName;
    }
    public String getEmployeeName()
    {
        return employeeName;
    }
    public void printMessage()
    {
        System.out.println(employeeName+" Welcome to Spring");
    }
}
