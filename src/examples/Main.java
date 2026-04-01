package examples;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();

        userService.addUser(new SystemUser(1, "Ezequias Souza", "ezequias@email.com", "admin", true));
        userService.addUser(new SystemUser(2, "Ma", "maria@email.com", "manager", true));
        userService.addUser(new SystemUser(3, "Maria Silva", "ezequias@email.com", "manager", true));
        userService.addUser(new SystemUser(4, "Carlos Lima", "carlos@email.com", "support", false));

        System.out.println("----- USER LIST -----");
        userService.listUsers();

        System.out.println("Total users stored: " + userService.getTotalUsers());
    }
}