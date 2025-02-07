package commands;

import utility.Creator;

public class Insert extends Command implements Executable{

    @Override
    public void execute(String[] splitedConsoleRead) {
        Creator.createElement();
    }

    @Override
    public String toString() {
        return "insert";
    }
}
