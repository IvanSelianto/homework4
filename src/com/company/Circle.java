package com.company;

public class Circle extends Figure {
    private double radius;
    private String name ="Circle";

    public Circle(double radius) {
        this.radius = radius;


    }
    public String setName(String name) {
        this.name = name;
        return name;

    }

    public String getName() {
        return name;
    }



    public String toString() {
        String s = "Name: %s; Radius = %f", name, radius;
        return s;
    }


    public void speak() {
        System.out.printf("It's a %s, radius of circle %f, perimeter %f, area %f %n", name, radius, perimeter(), area());
    }

    public void name() {
        System.out.println(name);

    }

    public double perimeter() {
        return 2 * Math.PI * radius;
    }


    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }

}
