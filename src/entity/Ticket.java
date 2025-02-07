package entity;

import utility.Validatable;

import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class Ticket implements Validatable {
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Integer price; //Поле может быть null, Значение поля должно быть больше 0
    private float discount; //Значение поля должно быть больше 0, Максимальное значение поля: 100
    private Boolean refundable; //Поле может быть null
    private Coordinates coordinates; //Поле не может быть null
    private TicketType type; //Поле может быть null
    private Event event; //Поле может быть null

    public Ticket() {
        this.id = this.hashCode();
        this.creationDate = LocalDateTime.now().withNano(0);
    }

    public int getId() {
        return id;
    }

    public static class Builder {
        private String name = null;

        private Integer price = null;
        private float discount = 0;
        private Boolean refundable = null;
        private Coordinates coordinates = null;
        private TicketType type = null;
        private Event event = null;

        public Builder name(String name) {
            this.name = name;
            return this;
        }



        public Builder price(Integer price) {
            this.price = price;
            return this;
        }

        public Builder discount(float discount) {
            this.discount = discount;
            return this;
        }

        public Builder refundable(Boolean refundable) {
            this.refundable = refundable;
            return this;
        }

        public Builder coordinates(Coordinates coordinates) {
            this.coordinates = coordinates;
            return this;
        }

        public Builder type(TicketType type) {
            this.type = type;
            return this;
        }

        public Builder event(Event event) {
            this.event = event;
            return this;
        }

        public Ticket  build() {
            Ticket ticket= new Ticket();
            ticket.name=this.name;

            ticket.price=this.price;
            ticket.discount=this.discount;
            ticket.refundable=this.refundable;
            ticket.coordinates=this.coordinates;
            ticket.type=this.type;
            ticket.event=this.event;

            return ticket;
        }
    }

    @Override
    public boolean validate() {
        if (id <= 0) {
            return false;
        }

        if ( creationDate == null) {
            return false;
        }
        if ( price != null) {
            if (price <=0){
                return false;
            }
        }
        if ( discount <=0) {
            return false;
        }
        if ( coordinates == null) {
            return false;
        }
        if ( name == null) {
            return false;
        }
        if (name.isEmpty()){
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", creationDate=" + creationDate +
                ", price=" + price +
                ", discount=" + discount +
                ", refundable=" + refundable +
                ", coordinates=" + coordinates +
                ", type=" + type +
                ", event=" + event +
                '}';
    }
}
