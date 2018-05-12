package am.ak.bean.wrapper;

/**
 * Created by karlen on 5/27/17.
 */
public class Company {

    private String name;

    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
