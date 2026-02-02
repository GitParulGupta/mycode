package design.lowleveldesign.proxydesignpattern;

import design.lowleveldesign.proxydesignpattern.model.EmployeeDo;

public class EmployeeDaoImpl implements EmployeeDao {


    @Override
    public void create(String cliendId, EmployeeDo employee) {
        System.out.println("Create Employee...");
    }

    @Override
    public void update(String cliendId, EmployeeDo employee) {
        System.out.println("Update Employee...");
    }

    @Override
    public void delete(String cliendId, EmployeeDo employee) {
        System.out.println("Delete Employee...");
    }

    @Override
    public void get(String cliendId, EmployeeDo employee) {
        System.out.println("Fetched Employee...");
    }
}
