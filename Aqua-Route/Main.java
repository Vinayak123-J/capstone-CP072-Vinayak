import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        RouteManager manager = new RouteManager();

        int choice;

        System.out.println("\n================================");
        System.out.println("       WELCOME TO AQUA ROUTE");
        System.out.println(" Priority-Based Water Supply");
        System.out.println("================================");

        do {

            System.out.println("\n========== MAIN MENU ==========");
            System.out.println("1. Register Water Request");
            System.out.println("2. Register Water Tanker");
            System.out.println("3. View Water Requests");
            System.out.println("4. View Available Tankers");
            System.out.println("5. Schedule Water Supply");
            System.out.println("6. Generate Area-wise Report");
            System.out.println("0. Exit");
            System.out.println("===============================");

            System.out.print("Enter your choice: ");

            while (!sc.hasNextInt()) {
                System.out.println("Enter a valid number.");
                sc.nextLine();
            }

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter area name: ");
                    String area = sc.nextLine().trim();

                    if (area.isEmpty()) {
                        System.out.println("Area cannot be empty.");
                        break;
                    }

                    System.out.print("Enter required litres: ");

                    if (!sc.hasNextInt()) {
                        System.out.println("Invalid litres.");
                        sc.nextLine();
                        break;
                    }

                    int litres = sc.nextInt();
                    sc.nextLine();

                    if (litres <= 0) {
                        System.out.println("Litres must be positive.");
                        break;
                    }

                    System.out.println(
                        "Priority: Hospital / School / Residential"
                    );

                    System.out.print("Enter priority: ");
                    String priority = sc.nextLine().trim();

                    if (!priority.equalsIgnoreCase("Hospital")
                        && !priority.equalsIgnoreCase("School")
                        && !priority.equalsIgnoreCase("Residential")) {

                        System.out.println("Invalid priority.");
                        break;
                    }

                    manager.addRequest(area, litres, priority);
                    break;

                case 2:

                    System.out.print("Enter tanker name: ");
                    String name = sc.nextLine().trim();

                    if (name.isEmpty()) {
                        System.out.println("Name cannot be empty.");
                        break;
                    }

                    System.out.print("Enter tanker capacity: ");

                    if (!sc.hasNextInt()) {
                        System.out.println("Invalid capacity.");
                        sc.nextLine();
                        break;
                    }

                    int capacity = sc.nextInt();
                    sc.nextLine();

                    if (capacity <= 0) {
                        System.out.println("Capacity must be positive.");
                        break;
                    }

                    manager.addWaterSource(name, capacity);
                    break;

                case 3:

                    manager.displayRequests();
                    break;

                case 4:

                    manager.displaySources();
                    break;

                case 5:

                    manager.scheduleRoutes();
                    break;

                case 6:

                    manager.generateReport();
                    break;

                case 0:

                    System.out.println(
                        "Thank you for using Aqua Route!"
                    );
                    break;

                default:

                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);

        sc.close();
    }
}