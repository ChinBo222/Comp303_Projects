package com.spring;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class EmployeeTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Employee emp = context.getBean("employeeInfo", Employee.class);
        emp.printMessage();
    }
}