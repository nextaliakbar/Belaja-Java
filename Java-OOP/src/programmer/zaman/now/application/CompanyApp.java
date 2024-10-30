package programmer.zaman.now.application;

import programmer.zaman.now.data.Company;

public class CompanyApp {
    public static void main(String[] args) {
        Company company1 = new Company();
        company1.setName("GO-JEK");

        Company.Employee employee = company1.new Employee();
        employee.setName("Akbar");
        System.out.println(employee.getName());
        System.out.println(employee.getCompanyName());

        Company company2 = new Company();
        company2.setName("GRAB");

        Company.Employee employee2 = company2.new Employee();
        employee2.setName("Rafsanjani");
        System.out.println(employee2.getName());
        System.out.println(employee2.getCompanyName());
    }
}
