import entity.Coordinates;

public class Main {
    public static void main(String[] args) {
        Coordinates a=new Coordinates(12);
        System.out.println(a.getY());
        System.out.println(a.validate());
    }

}