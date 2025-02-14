package commands;

import models.Ticket;
import managers.CollectionManager;

public class MaxByCoordinates extends Command implements Executable {


    @Override
    public void execute(String[] splitedConsoleRead) {
        Ticket ticket=null;
        double coordinatesSum=Double.MIN_VALUE;
        for (Ticket ticket1:CollectionManager.getCOLLECTION().values()){
            if (Math.pow(ticket1.getCoordinates().getX(),2)+Math.pow(ticket1.getCoordinates().getY(),2)>coordinatesSum){
                coordinatesSum=Math.pow(ticket1.getCoordinates().getX(),2)+Math.pow(ticket1.getCoordinates().getY(),2);
                ticket=ticket1;
            }
        }
        System.out.println(ticket.toString());
    }

    @Override
    public String toString() {
        return "max_by_coordinates";
    }
}
