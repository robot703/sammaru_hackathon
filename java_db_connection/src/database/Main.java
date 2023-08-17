package database;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        DBConnection connection = new DBConnection();
        Thread printThread = new Thread(connection::printAdminDataAbove80);

        printThread.start(); // 추가 스레드를 백그라운드에서 실행

        Scanner scanner = new Scanner(System.in);
        System.out.println("Press 1 to exit.");
        int userInput = scanner.nextInt();

        if (userInput == 1) {
            // 사용자가 1을 입력하면 프로그램 종료
            System.out.println("Exiting the program.");
            System.exit(0);
        }
    }
}
