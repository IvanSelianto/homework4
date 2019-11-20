package com.company;

public abstract class Figure {
    private String name;


    public String getName() {
        return name;
    }

    public String setName(String name) {
        this.name = name;
        return name;

    }

    public abstract String toString();

    public abstract void speak();

    public void name() {
        System.out.println(name);

    }

    public abstract double perimeter();

    public abstract double area();


}
