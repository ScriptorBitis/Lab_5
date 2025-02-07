package utility;

import java.util.Scanner;


public class Engine {
    private static boolean flag = true;

    public static void finishProgramm (){
        flag=false;
    }

    public static void runProgramm() {
        do {
            Scanner consoleRead = new Scanner(System.in);

            String[] splitedConsoleRead = consoleRead.nextLine().split(" ");
            CommandReader.setUserRequest(splitedConsoleRead[0],splitedConsoleRead);
        } while (flag);
    }
}
