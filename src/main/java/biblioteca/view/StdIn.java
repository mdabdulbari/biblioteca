package biblioteca.view;

import java.util.Scanner;

public class StdIn {
    private Scanner scanner;

    public StdIn() {
        scanner = new Scanner(System.in);
    }

    public int takeInteger() {
        return Integer.parseInt(scanner.nextLine());
    }

    public String takeString() {
        return scanner.nextLine();
    }
}
