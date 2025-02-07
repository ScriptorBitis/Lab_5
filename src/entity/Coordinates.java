package entity;

import java.lang.Double;

import utility.Validatable;

public class Coordinates implements Validatable {
    private double x;
    private Double y; //Максимальное значение поля: 484, Поле не может быть null

    // я хз, как можно ввести только параметр для y, но пусть
    public Double getY() {
        return y;
    }

    public double getX() {
        return x;
    }

    public static class Builder {
        private double x=0;
        private Double y=null;

        public Double getY() {
            return y;
        }

        public Builder x(int x) {
            this.x = x;
            return this;
        }

        public Builder y(Double integer) {
            this.y = integer;
            return this;
        }


        public Coordinates build() {
            Coordinates coordinates=new Coordinates();
            coordinates.y=this.y;
            coordinates.x=this.x;

            return coordinates;
        }

    }

    //Проверка на правильность поля y
    @Override
    public boolean validate() {
        if (y == null) {
            return false;
        }
        if (y > 484) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
