package commands;

public interface Executable {
    default void execute(){
        System.out.println("Команда выполнена?");
    }
}
