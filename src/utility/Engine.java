package utility;

import java.util.Scanner;


public class Engine {
    private static boolean flag = true;

    public static void finishProgramm (){
        flag=false;
    }

    public static void runProgramm() {
        do {
            Scanner in = new Scanner(System.in);
            CommandReader.setUserRequest(in.next());

        } while (flag);
    }
}
