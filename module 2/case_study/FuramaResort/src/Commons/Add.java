package Commons;

import Controllers.MainController;
import Models.Customer;
import Models.House;
import Models.Room;
import Models.Villa;

import java.io.IOException;
import java.util.Scanner;

public class Add {
    public static void addNewServices() throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        int serviceChoice;
        do {
            System.out.println("1. Add New Villa" + "\n" +
                    "2. Add New House" + "\n" +
                    "3. Add New Room" + "\n" +
                    "4. Back to menu" + "\n" +
                    "5. Exit");
            serviceChoice = scanner.nextInt();
            switch (serviceChoice) {
                case 1:
                    addVilla();
                    break;
                case 2:
                    addHouse();
                    break;
                case 3:
                    addRoom();
                    break;
                case 4:
                    MainController.displayMainMenu();
                    break;
                case 5:
                    return;
            }
        } while (serviceChoice < 1 || serviceChoice > 5);
    }

    public static void addVilla() throws IOException {
        String id = Validate.inputID("VL");
        String serviceType = Validate.inputServiceType();
        double usageArea = Validate.inputUsageArea();
        double poolArea = Validate.inputPoolArea();
        double rentCost = Validate.inputRentCost();
        int guestAmount = Validate.inputGuestAmount();
        String rentType = Validate.inputRentType();
        String roomStandard = Validate.inputRoomStandard();
        int floors = Validate.inputFloors();
        String exclusives = Validate.inputExclusives();

        Villa villa = new Villa(id, serviceType, usageArea, rentCost, guestAmount, rentType, poolArea, roomStandard, exclusives, floors);
        String[] array = villa.showInfo().split(SourcePath.COMMA);
        File.writeCSV(array, SourcePath.VILLA_CSV);


        Villa.arrVilla.add(villa);
        File.writeArray(Villa.arrVilla, SourcePath.ARR_VILLA_TXT);

    }

    public static void addHouse() throws IOException {
        String id = Validate.inputID("HO");
        String serviceType = Validate.inputServiceType();
        double usageArea = Validate.inputUsageArea();
        double rentCost = Validate.inputRentCost();
        int guestAmount = Validate.inputGuestAmount();
        String rentType = Validate.inputRentType();
        String roomStandard = Validate.inputRoomStandard();
        String exclusives = Validate.inputExclusives();
        int floors = Validate.inputFloors();

        House house = new House(id, serviceType, usageArea, rentCost, guestAmount, rentType, roomStandard, exclusives, floors);
        String[] array = house.showInfo().split(SourcePath.COMMA);
        File.writeCSV(array, SourcePath.HOUSE_CSV);

        House.arrHouse.add(house);
        File.writeArray(House.arrHouse, SourcePath.ARR_HOUSE_TXT);
    }

    public static void addRoom() throws IOException {
        String id = Validate.inputID("RO");
        String serviceType = Validate.inputServiceType();
        double usageArea = Validate.inputUsageArea();
        double rentCost = Validate.inputRentCost();
        int guestAmount = Validate.inputGuestAmount();
        String rentType = Validate.inputRentType();
        String freeService = Validate.inputFreeService();

        Room room = new Room(id, serviceType, usageArea, rentCost, guestAmount, rentType, freeService);
        String[] array = room.showInfo().split(SourcePath.COMMA);
        File.writeCSV(array, SourcePath.ROOM_CSV);

        Room.arrRoom.add(room);
        File.writeArray(Room.arrRoom, SourcePath.ARR_ROOM_TXT);
    }

    public static void addNewCustomer() throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        String name = Validate.inputName();
        String birthday = Validate.inputBirthday();
        String gender = Validate.inputGender();
        String idCard = Validate.inputIDCard();
        System.out.println("Input phone number");
        int phoneNum = scanner.nextInt();
        String email = Validate.inputEmail();
        System.out.println("Input address");
        String address = scanner.next();

        Customer customer = new Customer(name, birthday, gender, idCard, phoneNum, email, address);

        if (File.readArray(SourcePath.ARR_CUSTOMER_TXT) != null) Customer.arrCustomer = File.readArray(SourcePath.ARR_CUSTOMER_TXT);
        assert Customer.arrCustomer != null;
        Customer.arrCustomer.add(customer);

        File.writeArray(Customer.arrCustomer, SourcePath.ARR_CUSTOMER_TXT);

        String[] array = customer.showInfo().split(SourcePath.COMMA);
        File.writeCSV(array, SourcePath.CUSTOMER_CSV);
    }

    public static void addNewBooking() throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        Show.showInfoCustomerInOrder();
        System.out.println("Select customer to book");
        int customerChoice = scanner.nextInt() - 1;
        Customer.arrCustomer = File.readArray(SourcePath.ARR_CUSTOMER_TXT);
        Customer customer = Customer.arrCustomer.get(customerChoice);
        int choice;
        do {
            System.out.println("1. Booking Villa" + SourcePath.LINE_BREAKER +
                    "2. Booking House" + SourcePath.LINE_BREAKER +
                    "3. Booking Room");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    Show.showAllVilla();
                    Booking.bookService(SourcePath.ARR_VILLA_TXT, customer, "Villa");
                    break;
                case 2:
                    Show.showAllHouse();
                    Booking.bookService(SourcePath.ARR_HOUSE_TXT, customer, "House");
                    break;
                case 3:
                    Show.showAllRoom();
                    Booking.bookService(SourcePath.ARR_ROOM_TXT, customer, "Room");
                    break;
            }
        } while (choice < 1 || choice > 3);
    }
}
