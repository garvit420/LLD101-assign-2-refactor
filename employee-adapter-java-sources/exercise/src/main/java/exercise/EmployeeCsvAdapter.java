package exercise;

public class EmployeeCsvAdapter implements Employee{
    private final String id;
    private final String firstName;
    private final String surname;
    private final String emailAddress;

    public EmployeeCsvAdapter(EmployeeCSV e){
        String[] token = e.tokens();
        this.id = token[0];
        this.firstName = token[1];
        this.surname = token[2];
        this.emailAddress = token[3];
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public String getLastName() {
        return this.surname;
    }

    @Override
    public String getEmail() {
        return this.emailAddress;
    }
}
