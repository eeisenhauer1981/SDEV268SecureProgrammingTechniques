import java.time.LocalDate;

class Employee {
    private int employeeID;
    private String firstName;
    private String lastName; 
    private boolean active;
    private LocalDate dateOfBirth;
    private Role role;
    private String emailAddress;   
    
    //default constructor
    public Employee() {
        this.employeeID = 0;
        this.firstName = "";
        this.lastName = "";            
        this.active = false;
        this.dateOfBirth = null;
        this.role = Role.EMPLOYEE;  
    }

    //constructor with parameters
    public Employee(
        int employeeCount,
        String newFirstName,
        String newLastName,
        boolean newActive,
        LocalDate newBirthDate
    ) {
            this.employeeID = employeeCount;
            this.firstName = newFirstName;
            this.lastName = newLastName;
            this.active = newActive;
            this.dateOfBirth = newBirthDate;
            this.emailAddress = firstName + lastName + employeeID + "@company.com";
            this.role = Role.EMPLOYEE;
            AuthenticationManager.newUser(this.getEmailAddress(), this.getDateOfBirth(), this.getRole(), this.getEmployeeID(), this.getActive());
    }

    //getter functions 
    public int getEmployeeID() {return employeeID;}
    
    public String getFirstName() {return this.firstName;}

    public String getLastName() {return this.lastName;}

    public boolean getActive() {return this.active;}
    
    public LocalDate getDateOfBirth() {return this.dateOfBirth;}

    public String getEmailAddress() {return this.emailAddress;}

    public Role getRole() {return this.role;}

}