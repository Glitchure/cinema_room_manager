import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        int target = scanner.nextInt();


        int counter = 0;
        for (int i = 0; i < size; i++) {
            if (array[i] == target) {
                counter++;
            }
        }
        System.out.println(counter);
    }
}