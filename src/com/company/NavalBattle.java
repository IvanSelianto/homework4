package com.company;

import java.util.Random;

public class NavalBattle {
    private static final Random RANDOM = new Random();
    private int[][] shipField = createField();
    private int[] coordinatsForDeck = randomCoordinat();


    public static int[][] createField() {
        int[][] shipField = new int[11][11];
        for (int i = 0; i < shipField.length; i++) {
            for (int j = 0; j < shipField[i].length; j++) {
                shipField[i][j] = shipField[0][0];
            }
        }
        return shipField;

    }

    public void printField() {
        for (int i = 0; i < shipField.length-1; i++) {
            for (int j = 0; j < shipField[i].length-1; j++) {
                System.out.print(shipField[i][j] + " ");
            }
            System.out.println();
        }
    }

    private int[] randomCoordinat() {
        int[] xyCoordinats = new int[]{RANDOM.nextInt(10), RANDOM.nextInt(10)};
        return xyCoordinats;

    }

    private boolean checkFieldsForSingleDeck() {
        while (true) {
            try {
                if (shipField[coordinatsForDeck[0]][coordinatsForDeck[1]] != 0 ||
                        shipField[coordinatsForDeck[0] - 1][coordinatsForDeck[1]] != 0 ||
                        shipField[coordinatsForDeck[0] + 1][coordinatsForDeck[1]] != 0 ||
                        shipField[coordinatsForDeck[0]][coordinatsForDeck[1] - 1] != 0 ||
                        shipField[coordinatsForDeck[0]][coordinatsForDeck[1] + 1] != 0 ||
                        shipField[coordinatsForDeck[0] - 1][coordinatsForDeck[1] - 1] != 0 ||
                        shipField[coordinatsForDeck[0] - 1][coordinatsForDeck[1] + 1] != 0 ||
                        shipField[coordinatsForDeck[0] + 1][coordinatsForDeck[1] - 1] != 0 ||
                        shipField[coordinatsForDeck[0] + 1][coordinatsForDeck[1] + 1] != 0) {
                    return true;

                }
            } catch (ArrayIndexOutOfBoundsException e) {
                coordinatsForDeck = randomCoordinat();
                continue;


            }
            return false;

        }


    }

    private boolean checkFieldsForDoubleDeck(boolean axis) {
        while (true) {


            try {
                if (axis) {
                    if ((checkFieldsForSingleDeck() ||
                            shipField[coordinatsForDeck[0]][coordinatsForDeck[1] + 2] != 0 ||
                            shipField[coordinatsForDeck[0] + 1][coordinatsForDeck[1] + 2] != 0 ||
                            shipField[coordinatsForDeck[0] - 1][coordinatsForDeck[1] + 2] != 0)) {
                        return true;
                    }
                } else {
                    if (checkFieldsForSingleDeck() ||
                            shipField[coordinatsForDeck[0] - 2][coordinatsForDeck[1]] != 0 ||
                            shipField[coordinatsForDeck[0] - 2][coordinatsForDeck[1] - 1] != 0 ||
                            shipField[coordinatsForDeck[0] - 2][coordinatsForDeck[1] + 1] != 0) {
                        return true;
                    }

                }
            } catch (ArrayIndexOutOfBoundsException e) {
                coordinatsForDeck = randomCoordinat();
                continue;
            }
            return false;
        }


    }

    private boolean checkFieldsForTripleDeck(boolean axis) {
        while (true) {
            try {
                if (axis) {
                    if (checkFieldsForDoubleDeck(true) ||
                            shipField[coordinatsForDeck[0]][coordinatsForDeck[1] + 3] != 0 ||
                            shipField[coordinatsForDeck[0] + 1][coordinatsForDeck[1] + 3] != 0 ||
                            shipField[coordinatsForDeck[0] - 1][coordinatsForDeck[1] + 3] != 0) {
                        return true;
                    }

                } else {
                    if (checkFieldsForDoubleDeck(false) ||
                            shipField[coordinatsForDeck[0] - 3][coordinatsForDeck[1] - 1] != 0 ||
                            shipField[coordinatsForDeck[0] - 3][coordinatsForDeck[1] + 1] != 0 ||
                            shipField[coordinatsForDeck[0] - 3][coordinatsForDeck[1]] != 0) {
                        return true;
                    }

                }
            } catch (ArrayIndexOutOfBoundsException e) {
                coordinatsForDeck = randomCoordinat();
                continue;
            }
            return false;
        }
    }

    private boolean checkFieldsForTetraDeck(boolean axis) {
        while (true) {
            try {
                if (axis) {
                    if (checkFieldsForTripleDeck(true) ||
                            shipField[coordinatsForDeck[0]][coordinatsForDeck[1] + 4] != 0 ||
                            shipField[coordinatsForDeck[0] + 1][coordinatsForDeck[1] + 4] != 0 ||
                            shipField[coordinatsForDeck[0] - 1][coordinatsForDeck[1] + 4] != 0) {
                        return true;
                    }

                } else {
                    if (checkFieldsForDoubleDeck(false) ||
                            shipField[coordinatsForDeck[0] - 4][coordinatsForDeck[1] - 1] != 0 ||
                            shipField[coordinatsForDeck[0] - 4][coordinatsForDeck[1] + 1] != 0 ||
                            shipField[coordinatsForDeck[0] - 4][coordinatsForDeck[1]] != 0) {
                        return true;
                    }

                }
            } catch (ArrayIndexOutOfBoundsException e) {
                coordinatsForDeck = randomCoordinat();
                continue;
            }
            return false;

        }
    }

    public int[][] putSingleDeck() {


        while (true) {

            if (checkFieldsForSingleDeck()) {
                coordinatsForDeck = randomCoordinat();
                continue;
            } else {
                break;

            }
        }


        shipField[coordinatsForDeck[0]][coordinatsForDeck[1]] = 1;
        return shipField;
    }


    public int[][] putDoubleDeck() {

        boolean oXOrOy = RANDOM.nextBoolean();
        if (oXOrOy) {
            while (true) {

                if (checkFieldsForDoubleDeck(true)) {
                    coordinatsForDeck = randomCoordinat();
                    continue;

                } else {
                    break;
                }


            }
            shipField[coordinatsForDeck[0]][coordinatsForDeck[1]] = 1;
            shipField[coordinatsForDeck[0]][coordinatsForDeck[1] + 1] = 1;

        } else {
            while (true) {

                if (checkFieldsForDoubleDeck(false)) {
                    coordinatsForDeck = randomCoordinat();
                    continue;

                } else {
                    break;
                }
            }
            shipField[coordinatsForDeck[0]][coordinatsForDeck[1]] = 1;
            shipField[coordinatsForDeck[0] - 1][coordinatsForDeck[1]] = 1;
        }
        return shipField;
    }

    public int[][] putTripleDeck() {

        boolean oXOrOy = RANDOM.nextBoolean();

        if (oXOrOy) {
            while (true) {

                if (checkFieldsForTripleDeck(true)) {
                    coordinatsForDeck = randomCoordinat();
                    continue;

                } else {
                    break;
                }


            }
            shipField[coordinatsForDeck[0]][coordinatsForDeck[1]] = 1;
            shipField[coordinatsForDeck[0]][coordinatsForDeck[1] + 1] = 1;
            shipField[coordinatsForDeck[0]][coordinatsForDeck[1] + 2] = 1;

        } else {
            while (true) {

                if (checkFieldsForTripleDeck(false)) {
                    coordinatsForDeck = randomCoordinat();
                    continue;

                } else {
                    break;
                }


            }
            shipField[coordinatsForDeck[0]][coordinatsForDeck[1]] = 1;
            shipField[coordinatsForDeck[0] - 1][coordinatsForDeck[1]] = 1;
            shipField[coordinatsForDeck[0] - 2][coordinatsForDeck[1]] = 1;
        }
        return shipField;
    }

    public int[][] putTetraDeck() {

        boolean oXOrOy = RANDOM.nextBoolean();

        if (oXOrOy) {
            while (true) {

                if (checkFieldsForTetraDeck(true)) {
                    coordinatsForDeck = randomCoordinat();
                    continue;
                } else {
                    break;
                }

            }
            shipField[coordinatsForDeck[0]][coordinatsForDeck[1]] = 1;
            shipField[coordinatsForDeck[0]][coordinatsForDeck[1] + 1] = 1;
            shipField[coordinatsForDeck[0]][coordinatsForDeck[1] + 2] = 1;
            shipField[coordinatsForDeck[0]][coordinatsForDeck[1] + 3] = 1;

        } else {
            while (true) {
                if (checkFieldsForTetraDeck(false)) {
                    coordinatsForDeck = randomCoordinat();
                    continue;
                } else {
                    break;
                }
            }
            shipField[coordinatsForDeck[0]][coordinatsForDeck[1]] = 1;
            shipField[coordinatsForDeck[0] - 1][coordinatsForDeck[1]] = 1;
            shipField[coordinatsForDeck[0] - 2][coordinatsForDeck[1]] = 1;
            shipField[coordinatsForDeck[0] - 3][coordinatsForDeck[1]] = 1;
        }
        return shipField;
    }
}




