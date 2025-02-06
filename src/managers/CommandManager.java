package managers;

import commands.*;



import java.util.HashMap;
import java.util.Map;


public class CommandManager {
    private static final Map<String,Executable> COMMAND_MAP = new HashMap<>();


    public static  final void addCommand(String name, Executable command){
        COMMAND_MAP.put(name, command);
    }

    public static final Map<String,Executable> getCommands(){
        return COMMAND_MAP;
    }





}
