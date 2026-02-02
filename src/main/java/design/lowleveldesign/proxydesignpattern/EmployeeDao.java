package design.lowleveldesign.proxydesignpattern;

import design.lowleveldesign.proxydesignpattern.model.EmployeeDo;

public interface EmployeeDao {
    void create(String cliendId, EmployeeDo employee);
    void update(String cliendId, EmployeeDo employee);
    void delete(String cliendId, EmployeeDo employee);
    void get(String cliendId, EmployeeDo employee);
}
