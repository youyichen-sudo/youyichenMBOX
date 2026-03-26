package Exercise7;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class AdminPanel {

    List<RegisteredUsers> registeredUsers = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void userManagementOptions() {
        while (true) {
            System.out.println("\nWelcome to E-Ryder Administrator Panel.");
            System.out.println("What do you want to do?");
            System.out.println("1. Add New Users");
            System.out.println("2. View Registered Users");
            System.out.println("3. Remove Registered Users");
            System.out.println("4. Update Registered Users");
            System.out.println("5. EXIT");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                addNewUsers();
            } else if (choice == 2) {
                viewRegisteredUsers();
            } else if (choice == 3) {
                removeRegisteredUsers();
            } else if (choice == 4) {
                updateRegisteredUsers();
            } else if (choice == 5) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid choice. Please try again");
            }
        }
    }

    private void addNewUsers() {
        System.out.print("How many users do you want to add: ");
        int count = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < count; i++) {
            System.out.println("\nEnter details for user " + (i + 1));

            System.out.print("Full Name: ");
            String name = sc.nextLine();

            System.out.print("Email: ");
            String email = sc.nextLine();

            System.out.print("Date of Birth: ");
            String dob = sc.nextLine();

            System.out.print("Card Number: ");
            String card = sc.nextLine();

            System.out.print("Card Expiry Date: ");
            String exp = sc.nextLine();

            System.out.print("Card Provider: ");
            String provider = sc.nextLine();

            System.out.print("CVV: ");
            String cvv = sc.nextLine();

            System.out.print("User Type: ");
            String type = sc.nextLine();

            String[] trips = new String[3];
            for (int j = 0; j < 3; j++) {
                System.out.println("\nEnter Trip " + (j + 1) + " Details");

                System.out.print("Trip Date (YYYY-MM-DD): ");
                String date = sc.nextLine();

                System.out.print("Source: ");
                String src = sc.nextLine();

                System.out.print("Destination: ");
                String dest = sc.nextLine();

                System.out.print("Fare: ");
                String fare = sc.nextLine();

                System.out.print("Feedback: ");
                String feedback = sc.nextLine();

                StringBuilder sb = new StringBuilder();
                sb.append("Date: ").append(date)
                        .append(", Source: ").append(src)
                        .append(", Destination: ").append(dest)
                        .append(", Fare (€): ").append(fare)
                        .append(", Feedback: ").append(feedback);

                trips[j] = sb.toString();
            }

            RegisteredUsers user = new RegisteredUsers(name, email, dob, card, exp, provider, cvv, type, trips);
            registeredUsers.add(user);
            System.out.println("User added successfully!");
        }
    }

    private void viewRegisteredUsers() {
        if (registeredUsers.isEmpty()) {
            System.out.println("No registered users to display");
            return;
        }

        for (RegisteredUsers user : registeredUsers) {
            System.out.println("------------------------------");
            System.out.println(user);
            System.out.println("------------------------------");
        }
    }

    private void removeRegisteredUsers() {
        if (registeredUsers.isEmpty()) {
            System.out.println("No registered users to remove");
            return;
        }

        System.out.print("Enter email to remove: ");
        String email = sc.nextLine();
        boolean found = false;

        Iterator<RegisteredUsers> it = registeredUsers.iterator();
        while (it.hasNext()) {
            RegisteredUsers u = it.next();
            if (u.getEmailAddress().equals(email)) {
                it.remove();
                found = true;
                System.out.println("User removed successfully");
            }
        }

        if (!found) {
            System.out.println("No user found with this email address");
        }
    }

    private void updateRegisteredUsers() {
        if (registeredUsers.isEmpty()) {
            System.out.println("No registered users to update");
            return;
        }

        System.out.print("Enter email to update: ");
        String email = sc.nextLine();
        RegisteredUsers target = null;

        for (RegisteredUsers u : registeredUsers) {
            if (u.getEmailAddress().equals(email)) {
                target = u;
                break;
            }
        }

        if (target == null) {
            System.out.println("No user found");
            return;
        }

        System.out.println("Press Enter to keep old value");

        System.out.print("New Full Name: ");
        String name = sc.nextLine();
        if (!name.isEmpty()) {
            target.setFullName(name);
        }

        System.out.print("New DOB: ");
        String dob = sc.nextLine();
        if (!dob.isEmpty()) {
            target.setDateOfBirth(dob);
        }

        System.out.print("New Card Number (0 for no change): ");
        String card = sc.nextLine();
        if (!card.equals("0")) {
            target.setCardNumber(card);
        }

        System.out.print("New Expiry Date: ");
        String exp = sc.nextLine();
        if (!exp.isEmpty()) {
            target.setCardExpiryDate(exp);
        }

        System.out.print("New Provider: ");
        String provider = sc.nextLine();
        if (!provider.isEmpty()) {
            target.setCardProvider(provider);
        }

        System.out.print("New CVV: ");
        String cvv = sc.nextLine();
        if (!cvv.isEmpty()) {
            target.setCvv(cvv);
        }

        System.out.print("New User Type: ");
        String type = sc.nextLine();
        if (!type.isEmpty()) {
            target.setUserType(type);
        }

        System.out.println("User updated successfully!");
    }
}