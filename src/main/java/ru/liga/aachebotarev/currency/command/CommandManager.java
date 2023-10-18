package ru.liga.aachebotarev.currency.command;

import ru.liga.aachebotarev.currency.utils.CommandName;

import java.util.Scanner;

public class CommandManager {
    private final Scanner scanner;

    public CommandManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public void applyCommand(String[] args) {
        String command = args[0];

        if (!command.equalsIgnoreCase(CommandName.COMMAND)) {
            System.out.println("Unknown command. Please use 'rate [USD | EUR | TRY] [week | tomorrow]'");
        }
    }

}
