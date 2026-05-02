import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //adding test users
        Employee testEmployee = new Employee(1, "Mary", "Tester", true, LocalDate.of(1999, 01, 01));
        Employee inactiveEmployee = new Employee(2, "James", "Terminated", false, LocalDate.of(1985, 05, 26));
        String adminHashPassword = SecurityUtil.hashMD5("Adm1n!");
        User adminUser = new User("HR0001", adminHashPassword, Role.ADMIN, -1, true);
        AuthenticationManager.addUser("HR0001", adminUser);
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("***TESTING: Successful Emoplyee Login***");
        System.out.println("Enter your username");
        String inputUsername = scanner.nextLine();
        System.out.println("Enter your password");
        String inputPassword = scanner.nextLine();
        User authenticatedUser = AuthenticationManager.authenticateEmployee(inputUsername, inputPassword);
        if(authenticatedUser == null) {
            System.out.println("Unable to authenticate");
        }
        else {
            System.out.println("Authentication successful for following user:");
            authenticatedUser.printUser();
        }

        System.out.println("***TESTING: Successful Admin Login***");
        System.out.println("Enter your username");
        inputUsername = scanner.nextLine();
        System.out.println("Enter your password");
        inputPassword = scanner.nextLine();
        authenticatedUser = AuthenticationManager.authenticateAdmin(inputUsername, inputPassword);
        if(authenticatedUser == null) {
            System.out.println("Unable to authenticate");
        }
        else {
            System.out.println("Authentication successful for following user:");
            authenticatedUser.printUser();
        }
        
        System.out.println("***TESTING: Incorrect username or password***");
        System.out.println("Enter your username");
        inputUsername = scanner.nextLine();
        System.out.println("Enter your password");
        inputPassword = scanner.nextLine();
        authenticatedUser = AuthenticationManager.authenticateEmployee(inputUsername, inputPassword);
        if(authenticatedUser == null) {
            System.out.println("Unable to authenticate");
        }
        else {
            System.out.println("Authentication successful for following user:");
            authenticatedUser.printUser();
        }

        System.out.println("***TESTING: Inactive Employee***");
        System.out.println("Enter your username");
        inputUsername = scanner.nextLine();
        System.out.println("Enter your password");
        inputPassword = scanner.nextLine();
        authenticatedUser = AuthenticationManager.authenticateEmployee(inputUsername, inputPassword);
        if(authenticatedUser == null) {
            System.out.println("Unable to authenticate");
        }
        else {
            System.out.println("Authentication successful for following user:");
            authenticatedUser.printUser();
        }

        scanner.close();

    }
}
