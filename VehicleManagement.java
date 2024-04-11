import java.util.Scanner;
import java.util.ArrayList;

public class VehicleManagement {
    private ArrayList<Vehicle> vehicleList = new ArrayList<>();
    private Scanner scc = new Scanner(System.in);

    public static void main(String[] args) {
        VehicleManagement vehicleManagement = new VehicleManagement();
        vehicleManagement.runMenu();
    }

    public void runMenu() {
        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Add a vehicle");
            System.out.println("2. Display a list of vehicle details");
            System.out.println("3. Delete a vehicle");
            System.out.println("4. Sort vehicle list by age");
            System.out.println("5. Quit");
            System.out.print("\nEnter your choice: ");
            choice = scc.nextInt();
            scc.nextLine();

            switch (choice) {
                case 1:
                    addVehicle();
                    break;
                case 2:
                    displayVehicleList();
                    break;
                case 3:
                    deleteVehicle();
                    break;
                case 4:
                    sortVehicleListByAge();
                    displaySortMenu();
                    break;
                case 5:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }

    public void addVehicle() {
        System.out.print("\nEnter registration number: ");
        String regNo = scc.nextLine();
        System.out.print("Enter make: ");
        String make = scc.nextLine();
        System.out.print("Enter year of manufacture: ");
        int yearOfManufacture = scc.nextInt();
        System.out.print("Enter value: ");
        double value = scc.nextDouble();
        scc.nextLine();

        Vehicle vehicle = new Vehicle(regNo, make, yearOfManufacture, value);
        vehicleList.add(vehicle);

        System.out.print("\nVehicle added successfully!\n");
    }

    public void displayVehicleList() {
        System.out.println("List of Vehicle details: ");
        if (vehicleList.isEmpty()) {
            System.out.println("No vehicles added.");
        } else {
            for (Vehicle vehicle : vehicleList) {
                System.out.println(vehicle);
            }
        }
    }

    public void deleteVehicle() {
        System.out.print("Enter the index of the vehicle to delete: ");
        int indexDelete = scc.nextInt();
        scc.nextLine();

        if (indexDelete >= 0 && indexDelete < vehicleList.size()) {
            vehicleList.remove(indexDelete);
            System.out.println("\nVehicle deleted successfully!\n");
        } else {
            System.out.println("\nInvalid index!\n");
        }
    }

    public void sortVehicleListByAge() {
        vehicleList.sort((v1, v2) -> Integer.compare(v1.getYearOfManufacture(), v2.getYearOfManufacture()));
    }

    public void displaySortMenu() {
        int sortChoice;
        do {
            System.out.println("\nSort Menu:");
            System.out.println("1. Sort by age (ascending)");
            System.out.println("2. Sort by age (descending)");
            System.out.println("3. Back to main menu");
            System.out.print("Enter your choice: ");
            sortChoice = scc.nextInt();
            scc.nextLine();

            switch (sortChoice) {
                case 1:
                    sortVehicleListByAge();
                    System.out.println("List of vehicle details sorted by age (ascending):");
                    displayVehicleList();
                    break;
                case 2:
                    sortVehicleListByAge();
                    vehicleList.sort((v1, v2) -> Integer.compare(v2.getYearOfManufacture(), v1.getYearOfManufacture()));
                    System.out.println("List of vehicle details sorted by age (descending):");
                    displayVehicleList();
                    break;
                case 3:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (sortChoice != 3);
    }
}
