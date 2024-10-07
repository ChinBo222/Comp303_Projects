package org.spring;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PhoneTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        PhoneCatalog catalog = context.getBean("phoneCatalog", PhoneCatalog.class);
        catalog.showProduct();
    }
}
