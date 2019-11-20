package com.company;


import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class NavalBattle {
    private static final Random RANDOM = new Random();
    private int[][] shipField = createField();
    private int[] coordinatesForDeck = randomCoordinat();
    //   private int size;
    // private int shipSizeMultiplier;

    //  public NavalBattle(int size, int shipSizeMultiplier) {
    //    this.size = size;
    //  this.shipSizeMultiplier = shipSizeMultiplier;

    // }
    public int howMuch1() {
        int count = 0;
        for (int i = 0; i < shipField.length; i++) {
            for (int j = 0; j < shipField[i].length; j++) {
                if (shipField[i][j] == 1) {
                    count += 1;
                }

            }
        }
        return count;
    }

    private int[][] toOccupyAllShips(int[][] shipField) {


        for (int i = 1; i < shipField.length - 1; i++) {
            for (int j = 1; j < shipField[i].length - 1; j++) {

                if (shipField[i][j] == 1) {

                    if (shipField[i - 1][j] != 1) {
                        shipField[i - 1][j] = 2;
                    }

                    if (shipField[i + 1][j] != 1) {
                        shipField[i + 1][j] = 2;
                    }
                    if (shipField[i][j + 1] != 1) {
                        shipField[i][j + 1] = 2;
                    }
                    if (shipField[i][j - 1] != 1) {
                        shipField[i][j - 1] = 2;
                    }

                    shipField[i - 1][j - 1] = 2;
                    shipField[i - 1][j + 1] = 2;
                    shipField[i + 1][j - 1] = 2;
                    shipField[i + 1][j + 1] = 2;


                }

            }

        }

        return shipField;
    }

    public int[][] createField() {
        int[][] shipField = new int[10][10];


        for (int i = 0; i < shipField.length; i++) {
            for (int j = 0; j < shipField[i].length; j++) {
                shipField[i][j] = 0;
              /*  if (i == 0) {
                    shipField[i][j] = 2;
                }


                if (j == 0) {
                    shipField[i][j] = 2;
                }
                if (i == shipField.length - 1) {
                    shipField[i][j] = 2;
                }
                if (j == shipField[i].length - 1) {
                    shipField[i][j] = 2;
                }*/


            }

        }

        return shipField;

    }

    public void printField() {


      //  for (int i = 0; i < shipField.length; i++) {
        //    System.out.println(Arrays.toString(shipField[i]));


        //}
       // System.out.println("    ");
        for (int i = 0; i < shipField.length - 1; i++) {
            for (int j = 0; j < shipField[i].length - 1; j++) {
                if (shipField[i][j] == 2) {
                    System.out.print(0 + " ");
                } else {
                    System.out.print(shipField[i][j] + " ");

                }


            }
            System.out.println();
        }
    }


    private int[] randomCoordinat() {
        return new int[]{ThreadLocalRandom.current().nextInt(1, 11), ThreadLocalRandom.current().nextInt(1, 11)};

        //return new int[]{RANDOM.nextInt(10), RANDOM.nextInt(10)};

    }

    public boolean isFree(boolean axis, int length) {
        if (axis) {
            for (int i = 0; i < length + 1; i++) {
                if ((shipField[coordinatesForDeck[0]][coordinatesForDeck[1]] == 1 || shipField[coordinatesForDeck[0]][coordinatesForDeck[1]] == 2)
                        && (shipField[coordinatesForDeck[0]][coordinatesForDeck[1] + i] == 1 || shipField[coordinatesForDeck[0]][coordinatesForDeck[1]] == 2)) {
                    return false;
                }

            }

        } else {
            if (!axis) {
                for (int i = 0; i < length; i++) {
                    if ((shipField[coordinatesForDeck[0]][coordinatesForDeck[1]] == 1 || shipField[coordinatesForDeck[0]][coordinatesForDeck[1]] == 2)
                            && (shipField[coordinatesForDeck[0] - i][coordinatesForDeck[1]] == 1 || shipField[coordinatesForDeck[0] - i][coordinatesForDeck[1]] == 2)) {
                        return false;
                    }

                }

            }
        }


        return true;
    }


    public int[][] putSingleDeck() {
        while (true) {
            try {
                if (isFree(true, 1)) {
                    shipField[coordinatesForDeck[0]][coordinatesForDeck[1]] = 1;
                    toOccupyAllShips(shipField);

                    break;

                } else {
                    coordinatesForDeck = randomCoordinat();
                    continue;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                coordinatesForDeck = randomCoordinat();
                continue;


            }
        }
        return shipField;
    }

    public int[][] putDoubleDeck() {

        boolean oXOrOy = RANDOM.nextBoolean();
        if (oXOrOy) {
            while (true) {

                try {

                    if (isFree(true, 2)) {
                        shipField[coordinatesForDeck[0]][coordinatesForDeck[1]] = 1;
                        shipField[coordinatesForDeck[0]][coordinatesForDeck[1] + 1] = 1;
                        toOccupyAllShips(shipField);

                        break;
                    } else {
                        coordinatesForDeck = randomCoordinat();
                        continue;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    coordinatesForDeck = randomCoordinat();
                    continue;


                }
            }


        } else {
            while (true) {

                try {
                    if (isFree(false, 2)) {
                        shipField[coordinatesForDeck[0]][coordinatesForDeck[1]] = 1;
                        shipField[coordinatesForDeck[0] - 1][coordinatesForDeck[1]] = 1;
                        toOccupyAllShips(shipField);


                        break;

                    } else {
                        coordinatesForDeck = randomCoordinat();
                        continue;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    coordinatesForDeck = randomCoordinat();
                    continue;


                }
            }

        }
        return shipField;
    }

    public int[][] putTripleDeck() {

        boolean oXOrOy = RANDOM.nextBoolean();
        if (oXOrOy) {
            while (true) {

                try {
                    if (isFree(true, 3)) {
                        shipField[coordinatesForDeck[0]][coordinatesForDeck[1]] = 1;
                        shipField[coordinatesForDeck[0]][coordinatesForDeck[1] + 1] = 1;
                        shipField[coordinatesForDeck[0]][coordinatesForDeck[1] + 2] = 1;
                        toOccupyAllShips(shipField);


                        break;
                    } else {
                        coordinatesForDeck = randomCoordinat();
                        continue;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    coordinatesForDeck = randomCoordinat();
                    continue;


                }
            }


        } else {
            while (true) {

                try {
                    if (isFree(false, 3)) {
                        shipField[coordinatesForDeck[0]][coordinatesForDeck[1]] = 1;
                        shipField[coordinatesForDeck[0] - 1][coordinatesForDeck[1]] = 1;
                        shipField[coordinatesForDeck[0] - 2][coordinatesForDeck[1]] = 1;
                        toOccupyAllShips(shipField);

                        break;

                    } else {
                        coordinatesForDeck = randomCoordinat();
                        continue;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    coordinatesForDeck = randomCoordinat();
                    continue;


                }
            }

        }
        return shipField;
    }

    public int[][] putTetraDeck() {
        boolean oXOrOy = RANDOM.nextBoolean();
        if (oXOrOy) {
            while (true) {
                try {
                    if (isFree(true, 4)) {
                        shipField[coordinatesForDeck[0]][coordinatesForDeck[1]] = 1;
                        printField();
                        shipField[coordinatesForDeck[0]][coordinatesForDeck[1] + 1] = 1;
                        printField();
                        shipField[coordinatesForDeck[0]][coordinatesForDeck[1] + 2] = 1;
                        printField();
                        shipField[coordinatesForDeck[0]][coordinatesForDeck[1] + 3] = 1;
                        printField();
                        toOccupyAllShips(shipField);
                        printField();
                        break;
                    } else {
                        coordinatesForDeck = randomCoordinat();
                        continue;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    coordinatesForDeck = randomCoordinat();
                    continue;
                }
            }
        } else {
            while (true) {
                try {
                    if (isFree(false, 4)) {
                        shipField[coordinatesForDeck[0]][coordinatesForDeck[1]] = 1;
                        shipField[coordinatesForDeck[0] - 1][coordinatesForDeck[1]] = 1;
                        shipField[coordinatesForDeck[0] - 2][coordinatesForDeck[1]] = 1;
                        shipField[coordinatesForDeck[0] - 3][coordinatesForDeck[1]] = 1;
                        toOccupyAllShips(shipField);
                        break;
                    } else {
                        coordinatesForDeck = randomCoordinat();
                        continue;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    coordinatesForDeck = randomCoordinat();
                    continue;

                }
            }
        }
        return shipField;
    }
}




