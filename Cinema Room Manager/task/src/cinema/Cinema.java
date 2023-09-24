package cinema;

import java.util.Scanner;

public class Cinema {
    static Scanner scanner = new Scanner(System.in);
    static int rows;
    static int seatsPerRow;
    static int totalSeats;
    static int seatRow;
    static int seatNumber;
    static int seatPrice;
    static int numOfBookedSeats;
    static int income;
    static boolean shouldBreak = false;
    static boolean[][] bookedSeats = new boolean[9][9];

    public static void main(String[] args) {
        // Write your code here
        setup();
        do {
            mainMenu();
        } while (!shouldBreak);
    }

    public static void setup() {
        System.out.println("Enter the number of rows:");
        rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        seatsPerRow = scanner.nextInt();
        totalSeats = rows * seatsPerRow;
        System.out.println();
    }

    public static void mainMenu() {
        String[] commands = {"1. Show the seats", "2. Buy a ticket", "3. Statistics", "0. Exit"};
        for (String s: commands) {
            System.out.println(s);
        }
        int commandChoice = scanner.nextInt();
        switch (commandChoice) {
            case 0:
                shouldBreak = true;
                break;
            case 1:
                System.out.println();
                printSeats();
                break;
            case 2:
                System.out.println();
                bookSeat();
                break;
            case 3:
                System.out.println();
                showStatistics();
                break;
            default:
                System.out.println("Invalid command");
                System.out.println();
        }
    }

    public static void printSeats() {
        System.out.println("Cinema:");
        System.out.print("  ");
        for (int i = 1; i <= seatsPerRow; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 1; i <= rows; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < seatsPerRow; j++) {
                if (bookedSeats[i-1][j]) {
                    System.out.print("B ");
                } else {
                    System.out.print("S ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void bookSeat() {
        while (true) {
            System.out.println("Enter a row number:");
            seatRow = scanner.nextInt();
            System.out.println("Enter a seat number in that row:");
            seatNumber = scanner.nextInt();
            System.out.println();
            if (seatRow > rows || seatRow < 1 || seatNumber > seatsPerRow || seatNumber < 1) {
                System.out.println("Wrong input!");
                System.out.println();
            } else if (bookedSeats[seatRow - 1][seatNumber - 1]) {
                System.out.println("That ticket has already been purchased!");
                System.out.println();
            } else {
                bookedSeats[seatRow - 1][seatNumber - 1] = true;
                numOfBookedSeats++;
                break;
            }
        }

        if (totalSeats >= 60) {
            if (seatRow <= rows / 2) {
                seatPrice = 10;
            } else {
                seatPrice = 8;
            }
        } else {
            seatPrice = 10;
        }
        income += seatPrice;

        System.out.printf("Ticket price: $%d", seatPrice);
        System.out.println();
        System.out.println();

        printSeats();
    }

    public static void showStatistics() {
        System.out.printf("Number of purchased tickets: %d", numOfBookedSeats);
        System.out.println();
        System.out.printf("Percentage: %.2f%%", (double) numOfBookedSeats / totalSeats * 100);
        System.out.println();
        System.out.printf("Current income: $%d", income);
        System.out.println();
        int totalIncome;
        if (totalSeats >= 60) {
            totalIncome = (rows / 2 * seatsPerRow * 10) + ((rows - (rows / 2)) * seatsPerRow * 8);
        } else {
            totalIncome = totalSeats * 10;
        }
        System.out.printf("Total income: $%d", totalIncome);
        System.out.println();
        System.out.println();
    }
    /*
    public static double trimDecimalPlaces(double num) {
        int temp;
        String string = Double.toString(num);
        for (int i = 0; i < Double.toString(num).length(); i++) {
            if ()
            if (Double.toString(num).charAt(i) == '.') {
                temp = i;
            }
        }
    }
     */
}