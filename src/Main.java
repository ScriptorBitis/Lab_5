import commands.Executable;
import commands.Exit;
import commands.Help;
import commands.Insert;
import managers.CollectionManager;
import managers.CommandManager;
import utility.Engine;

public class Main {

    private static void setUpCommand(Executable command){
        CommandManager.addCommand(command.toString(),command);

    }
    public static void main(String[] args) {
        //Executable help = new Help();
        //Executable exit = new Exit();
        //int a=Integer.valueOf("ads");
        setUpCommand(new Help());
        setUpCommand(new Exit());
        setUpCommand(new Insert());
        //Event event= EventCreator.createEvent();
        //System.out.println(event.toString());
        Engine.runProgramm();
        System.out.println(CollectionManager.getCOLLECTION().toString());



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