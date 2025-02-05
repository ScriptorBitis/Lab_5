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

    //Т.к. поле y- это Double (обертка), то придется изворачиваться в конструкторе
    public Coordinates(double x, double y) {
        this.x = x;
        this.y = new Double(y);
    }

    public Coordinates(double x) {
        this.x = x;
        this.y = null;
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
