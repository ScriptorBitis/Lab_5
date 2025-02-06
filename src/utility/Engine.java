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
            CommandReader.setUserRequest(consoleRead.next());

        } while (flag);
    }
}
