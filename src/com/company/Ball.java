package com.company;

public class Ball extends Figure {
    private double radius;
    private String name = "Ball";

    public Ball(double radius) {
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

        return String.format("Name: %s; Radius = %f", name, radius);
    }


    public void speak() {
        System.out.printf("It's a %s, radius of ball %f, perimeter %f, area %f %n", name, radius, perimeter(), area());
    }

    public void name() {
        System.out.println(name);
    }


    public double perimeter() {
        return Double.POSITIVE_INFINITY;
    }


    public double area() {
        return 4 * Math.PI * Math.pow(radius, 2);
    }

}

