package exercise;

public class EmployeeLDAPAdapter implements Employee {
    private final String id;
    private final String firstName;
    private final String surname;
    private final String emailAddress;

    public EmployeeLDAPAdapter(EmployeeLDAP e){
        this.id = e.get("uid");
        this.firstName = e.get("givenName");
        this.surname = e.get("sn");
        this.emailAddress = e.get("mail");
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

