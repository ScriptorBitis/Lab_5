package entity;

public class Event {
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private int ticketsCount; //Значение поля должно быть больше 0
    private String description; //Поле может быть null

    public Event(int id, String name, int ticketsCount, String description) {
        this.id = id;
        this.name = name;
        this.ticketsCount = ticketsCount;
        this.description = description;
    }
}
