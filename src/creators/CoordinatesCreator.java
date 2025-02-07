package creators;

import entity.Coordinates;

import java.util.Scanner;

public class CoordinatesCreator extends Creator {
    public static Coordinates createCoordinates() {

        Coordinates.Builder builder = new Coordinates.Builder();
        Scanner consoleRead = new Scanner(System.in);

        System.out.println("Инициализировано задание координат");

        System.out.println("Введите значение x");
        builder.x(consoleRead.nextInt());

        System.out.println("Введите значение y, учтите, что оно не должно превышать 484.");
        builder.y(consoleRead.nextDouble());



        Coordinates coordinates = builder.build();
        return coordinates;
    }
}
