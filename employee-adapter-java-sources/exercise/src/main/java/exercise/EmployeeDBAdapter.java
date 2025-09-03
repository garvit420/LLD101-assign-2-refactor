package exercise;

public class EmployeeDBAdapter implements Employee {
    private final EmployeeDB emp;

    public EmployeeDBAdapter(EmployeeDB e){
        this.emp = e;
    }

    @Override
    public String getId() {
        return Integer.toString(this.emp.getId());
    }

    @Override
    public String getFirstName() {
        return this.emp.getFirstName();
    }

    @Override
    public String getLastName() {
        return this.emp.getSurname();
    }

    @Override
    public String getEmail() {
        return this.emp.getEmailAddress();
    }
}
