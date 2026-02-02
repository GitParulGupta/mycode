package design.lowleveldesign.proxydesignpattern;

import design.lowleveldesign.proxydesignpattern.model.EmployeeDo;

public class Main {

    public static void main(String[] args) {
        EmployeeDao employeeDao = new EmployeeDaoProxy();
        employeeDao.create("ADMIN",new EmployeeDo());
        employeeDao.create("USER",new EmployeeDo());//this will throw runtime exception
    }
}
