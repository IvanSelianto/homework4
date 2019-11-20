package com.company;

public class Square extends Figure {
    private double side;
    private String name= "Square";

    public Square(double side) {
        this.side = side;


    }

    public String setName(String name) {
        this.name = name;
        return name;

    }

    public String getName() {
        return name;
    }


    public double setSide(double side) {
        this.side = side;
        return side;
    }

    public double getSide() {
        return side;
    }


    public String toString() {
        return String.format("Name: %s; Side of square= %f", name, side);
    }

    public void speak() {
        System.out.printf("It's a %s, Side of square = %f, perimeter = %f, perimeter = %f %n", name, side, perimeter(), area());
    }

    public void name() {
        System.out.println(name);

    }

    public double perimeter() {
        return side * 4;
    }


    public double area() {
        return Math.pow(side, 2);
    }


}
