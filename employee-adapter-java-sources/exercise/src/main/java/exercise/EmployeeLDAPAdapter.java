package exercise;

public class EmployeeLDAPAdapter implements Employee {
    private final String id;
    private final String firstName;
    private final String surname;
    private final String emailAddress;

    public EmployeeLDAPAdapter(EmployeeLDAP e){
        this.id = e.get("id");
        this.firstName = e.get("firstName");
        this.surname = e.get("surname");
        this.emailAddress = e.get("emailAddress");
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

