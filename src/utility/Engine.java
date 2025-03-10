package utility;

import commands.*;
import managers.CollectionManager;
import managers.CommandManager;
import models.Coordinates;
import models.Ticket;
import models.TicketType;
import org.w3c.dom.ls.LSOutput;


import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;

import java.util.NoSuchElementException;
import java.util.Scanner;


public class Engine {
    private static boolean flag = true;
    private static Scanner consoleRead = new Scanner(System.in);

    public static void finishProgramm() {
        flag = false;
    }

    public static void runProgramm() {
        Map<String, Ticket> COLLECTION = new HashMap<>();
        CollectionManager collectionManager = new CollectionManager(COLLECTION);
        // позже считать из файла

        Ticket.Builder builder = new Ticket.Builder();
        Coordinates.Builder builder1 = new Coordinates.Builder();
        Coordinates coordinates = builder1.x(15).y(Double.valueOf(24)).build();
        Ticket ticket = builder.price(1500).name("Билетик 1").coordinates(coordinates).discount(15).refundable(true).type(TicketType.CHEAP).build();
        collectionManager.addTicket("aboba1", ticket);

        coordinates = builder1.x(125).y(Double.valueOf(324)).build();
        ticket = builder.price(3500).name("Билетик 2").coordinates(coordinates).discount(25).refundable(false).type(TicketType.VIP).build();
        collectionManager.addTicket("aboba2", ticket);


        CommandManager.setUpCommand(new Help(collectionManager));
        CommandManager.setUpCommand(new Exit(collectionManager));
        CommandManager.setUpCommand(new Insert(2, collectionManager));
        CommandManager.setUpCommand(new Show(collectionManager));
        CommandManager.setUpCommand(new Clear(collectionManager));
        CommandManager.setUpCommand(new Info(collectionManager));
        CommandManager.setUpCommand(new RemoveKey(2, collectionManager));
        CommandManager.setUpCommand(new UpdateId(2, collectionManager));
        CommandManager.setUpCommand(new PrintAscending(collectionManager));
        CommandManager.setUpCommand(new MaxByCoordinates(collectionManager));
        CommandManager.setUpCommand(new ReplaceIfLowe(collectionManager));
        CommandManager.setUpCommand(new RemoveAnyByType(2, collectionManager));
        CommandManager.setUpCommand(new RemoveGreater(collectionManager));
        CommandManager.setUpCommand(new RemoveLower(collectionManager));




        do {
            try {
                CommandManager.setUserRequest(consoleRead.nextLine().trim().split(" "));
            } catch (NoSuchElementException e) {
                System.out.println("Ярослав Вадимович, не надо никаких ctrl+d, пожалуйста\nЯ закрою прогу, ибо нехуй всякую хуйню забивать в консоль");
                return;
            }
        } while (flag);
    }


}
