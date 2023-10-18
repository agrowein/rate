package ru.liga.aachebotarev.currency;

import ru.liga.aachebotarev.currency.utils.CommandName;

import java.text.ParseException;
import java.util.Scanner;

public class App
{
    public static void main( String[] args ) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                isRunning = false;
                System.out.println("Exiting the application.");
                continue;
            }

            String[] commandParts = input.split(" ");



        }
    }
}
