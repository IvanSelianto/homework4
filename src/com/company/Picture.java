package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Picture {

    private int intCounter = 0;
    private List<Figure> picture = new ArrayList<>();
    private Map<String, Integer> mapOfFigures = new HashMap<>();


    public void add(Figure figure) {
        picture.add(figure);


    }

    public double totalArea() {
        double totalArea = 0;

        for (int i = 0; i < picture.size(); i++) {
            totalArea += picture.get(i).area();

        }
        return totalArea;
    }

    public double totalPerimeter() {
        double totalPerimeter = 0;

        for (int i = 0; i < picture.size(); i++) {
            totalPerimeter += picture.get(i).perimeter();

        }
        return totalPerimeter;

    }

    public String allNames() {
        String allNames = "";

        for (int i = 0; i < picture.size(); i++) {
            allNames += picture.get(i).getName() + " ";

        }
        return allNames;
    }

    public Map mapOfFigures() {
        for (int i = 0; i < picture.size(); i++) {
            for (int j = 0; j < picture.size(); j++) {
                if (picture.get(i).getName().equals(picture.get(j).getName())) {
                    intCounter++;
                }
            }
            mapOfFigures.put(picture.get(i).getName(), intCounter);
            intCounter = 0;
        }
        return mapOfFigures;
    }
}
