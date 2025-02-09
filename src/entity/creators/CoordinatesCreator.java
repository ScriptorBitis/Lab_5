package entity.creators;

import entity.Coordinates;
import exeptions.WrongTypeInput;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CoordinatesCreator extends Creator  {

    private static Scanner consoleRead = new Scanner(System.in);

    public static Coordinates createCoordinates() throws WrongTypeInput {

        Coordinates.Builder builder = new Coordinates.Builder();


        System.out.println("Инициализировано задание координат");

        builder.x(askX());
        builder.y(askY());
        Coordinates coordinates=builder.build();
        return coordinates;
    }
    private static int askX() {
        System.out.println("Введите координату x");
        int x=0;
        boolean pass=true;
        do {
            try {


                x = Integer.valueOf(consoleRead.nextLine().trim());
                pass=false;
            }
            catch (NumberFormatException exception) {
                System.out.println("Ошибка ввода.Попробуйте снова");
            }
        }while (pass);
       return x;
    }



    private static Double askY() {
        System.out.println("Введите координату y. Учтите, что y не может быть больше 484");
        Double y=0.0;
        boolean pass=true;
        do {
            try {


                y = Double.valueOf(consoleRead.nextLine().trim());
                if (y>484){
                    throw new WrongTypeInput("y превышает максимальное значение");
                }
                pass=false;
            }catch (NumberFormatException |WrongTypeInput exception){
                System.out.println("Ошибка ввода.Попробуйте снова");

            }

        }while (pass);

        return y;
    }



}
