package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Figure square = new Square(5);
        square.setName("square");
        System.out.println(square.getName());
        square.name();
        square.area();
        square.perimeter();
        square.speak();


        Figure circle = new Circle(11);
        circle.setName("circle");
        System.out.println(circle.getName());
        circle.name();
        circle.perimeter();
        circle.area();
        circle.speak();

        Figure rectangle = new Rectangle(4, 8);
        rectangle.setName("rectangle");
        System.out.println(rectangle.getName());
        rectangle.name();
        rectangle.perimeter();
        rectangle.area();
        rectangle.speak();

        Figure ball = new Ball(8);
        ball.setName("ball");
        System.out.println(ball.getName());
        ball.name();
        ball.perimeter();
        ball.area();
        ball.speak();

        Picture picture = new Picture();
        picture.add(square);
        picture.add(rectangle);
        picture.add(square);
        picture.add(rectangle);
        picture.add(rectangle);
        picture.add(rectangle);
        picture.add(circle);
        picture.add(ball);


        System.out.println(picture.allNames());
        System.out.println(picture.totalPerimeter());
        System.out.println(picture.totalArea());
        System.out.println(picture.mapOfFigures());


        Mathematics mathematics = new Mathematics();
        int[] firstArray = new int[]{1, 2, 3, 4};
        int[] secondArray = new int[]{5, 6, 7, 8};
        System.out.println(Arrays.toString(mathematics.add(firstArray, secondArray)));

        List<String> list1 = new ArrayList<>();
        list1.add("Одна");
        list1.add("Две");
        list1.add("Три");
        List<Integer> list2 = new ArrayList<>();
        list2.add(4);
        list2.add(5);
        System.out.println(mathematics.add(list1, list2));

        Map<String, Integer> map1 = new HashMap<>();
        map1.put("Ваня", 0);
        map1.put("Дима", 2);

        Map<Integer, String> map2 = new HashMap<>();
        map2.put(3, "Виталя");

        System.out.println(mathematics.add(map1, map2));

        System.out.println(circle.toString());
        circle.name();


        NavalBattle ships = new NavalBattle();

        ships.createField();
        ships.printField();
        System.out.println("   ");
        ships.putTetraDeck();
        ships.printField();
        System.out.println("         ");
        ships.putTripleDeck();
        ships.putTripleDeck();

        ships.printField();
        System.out.println("         ");
        ships.putDoubleDeck();
        ships.putDoubleDeck();
        ships.putDoubleDeck();

        ships.printField();
        System.out.println("         ");

        ships.putSingleDeck();
        ships.putSingleDeck();
        ships.putSingleDeck();
        ships.putSingleDeck();

        ships.printField();
        System.out.println("         ");
        System.out.println(ships.howMuch1());





        



    }


}

