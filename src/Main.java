import commands.Executable;
import commands.Exit;
import commands.Help;
import entity.Coordinates;
import entity.Event;
import entity.Ticket;
import entity.TicketType;
import managers.CommandManager;
import utility.CommandReader;
import utility.Engine;

import java.util.Scanner;
import static managers.CommandManager.*;

public class Main {
    public static void main(String[] args) {
        Executable help = new Help();
        Executable exit = new Exit();

        CommandManager.addCommand("\\help",help);
        CommandManager.addCommand("\\exit",exit);
        Engine.runProgramm();


        //System.out.println(CommandManager.getCommands().toString());


        //System.out.println();

        //System.out.println();

        //Coordinates a=new Coordinates(12);
        //System.out.println(a.getY());
        //System.out.println(a.validate());

        //Event event = new Event.Builder().description("Artom (Артем)  pokupaet zajigalku").ticketsCount(12).build();
        //System.out.println(event.toString());
        //System.out.println(event.validate());

        //Ticket ticket=new Ticket.Builder().event(event).name("Prikol").coordinates(new Coordinates(12,13)).discount(15).price(-1).type(TicketType.VIP).build();
        //System.out.println(ticket.toString());
        //System.out.println(ticket.validate());

    }

}