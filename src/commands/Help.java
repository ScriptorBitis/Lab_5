package commands;

public class Help extends Command implements Executable{
    private static final  String helpMessage="info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)\n" +
            "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении\n" +
            "insert null {element} : добавить новый элемент с заданным ключом\n" +
            "update id {element} : обновить значение элемента коллекции, id которого равен заданному\n" +
            "remove_key null : удалить элемент из коллекции по его ключу\n" +
            "clear : очистить коллекцию\n" +
            "save : сохранить коллекцию в файл\n" +
            "execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.\n" +
            "exit : завершить программу (без сохранения в файл)\n" +
            "remove_greater {element} : удалить из коллекции все элементы, превышающие заданный\n" +
            "remove_lower {element} : удалить из коллекции все элементы, меньшие, чем заданный\n" +
            "replace_if_lowe null {element} : заменить значение по ключу, если новое значение меньше старого\n" +
            "remove_any_by_type type : удалить из коллекции один элемент, значение поля type которого эквивалентно заданному\n" +
            "max_by_coordinates : вывести любой объект из коллекции, значение поля coordinates которого является максимальным\n" +
            "print_ascending : вывести элементы коллекции в порядке возрастания";

    @Override
    public void execute(String[] splitedRequest) {
        System.out.println(helpMessage);
    }

    @Override
    public String toString() {
        return "help";
    }
}
