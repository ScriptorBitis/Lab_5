import entity.Coordinates;
import entity.Event;
import entity.Ticket;
import entity.TicketType;

public class Main {
    public static void main(String[] args) {
        Coordinates a=new Coordinates(12);
        System.out.println(a.getY());
        System.out.println(a.validate());


        Event event = new Event.Builder().description("Artom (Артем) (Ебаный мудак)  pokupaet zajigalku").ticketsCount(12).build();
        System.out.println(event.toString());
        System.out.println(event.validate());

        Ticket ticket=new Ticket.Builder().event(event).name("Chlen").coordinates(new Coordinates(12,13)).discount(15).price(15).type(TicketType.VIP).build();
        System.out.println(ticket.toString());
    }

}