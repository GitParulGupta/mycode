package design.lowleveldesign.proxydesignpattern;

import design.lowleveldesign.proxydesignpattern.model.EmployeeDo;

public class EmployeeDaoProxy implements EmployeeDao {

    EmployeeDao employeeDao;

    public EmployeeDaoProxy() {
        this.employeeDao = new EmployeeDaoImpl();
    }


    @Override
    public void create(String cliendId, EmployeeDo employee) {
        if("ADMIN".equals(cliendId)){
            employeeDao.create(cliendId,employee);
        }else{
            throw new RuntimeException("Access Denied");
        }
    }

    @Override
    public void update(String cliendId, EmployeeDo employee) {
        if("ADMIN".equals(cliendId) || "USER".equals(cliendId)){
            employeeDao.update(cliendId,employee);
        }else{
            throw new RuntimeException("Access Denied");
        }
    }

    @Override
    public void delete(String cliendId, EmployeeDo employee) {
        if("ADMIN".equals(cliendId)){
            employeeDao.delete(cliendId,employee);
        }else{
            throw new RuntimeException("Access Denied");
        }
    }

    @Override
    public void get(String cliendId, EmployeeDo employee) {
        if("ADMIN".equals(cliendId) || "USER".equals(cliendId)){
            employeeDao.get(cliendId,employee);
        }else{
            throw new RuntimeException("Access Denied");
        }
    }
}
