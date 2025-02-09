package commands;
import utility.Engine;

public class Exit extends Command implements Executable{

    @Override
    public void execute(String[] splitedRequest) {
        Engine.finishProgramm();
    }

    @Override
    public String toString() {
        return "exit";
    }


}
