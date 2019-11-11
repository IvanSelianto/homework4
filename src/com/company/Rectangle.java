package com.company;

public class Rectangle extends Figure {
    private double length;
    private double width;
    private String name = "Rectangle";

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public String setName(String name) {
        this.name = name;
        return name;

    }
    public String getName() {
        return name;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public String toString() {
        String s = "Name: %s; Length= %f; Width= %f %n", name, length, width ;
        return s;
    }


    public void speak() {
        System.out.printf("It's a %s, length = %f, width = %f, perimeter = %f, area = %f %n", name, length, width, perimeter(), area());
    }

    public void name() {
        System.out.println(name);

    }
    public double perimeter(){
        return 2*length+2*width;
    }
    public double area(){
        return length*width;
    }


}
