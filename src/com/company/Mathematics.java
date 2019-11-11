package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mathematics {

    public int add(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }

    public float add(float firstNumber, float secondNumber) {
        return firstNumber + secondNumber;
    }

    public double add(double firstNumber, double secondNumber) {
        return firstNumber + secondNumber;
    }

    public byte add(byte firstNumber, byte secondNumber) {
        return (byte) (firstNumber + secondNumber);
    }

    public short add(short firstNumber, short secondNumber) {
        return (short) (firstNumber + secondNumber);
    }

    public long add(long firstNumber, long secondNumber) {
        return firstNumber + secondNumber;
    }

    public String add(String firstPhrase, String secondPhrase) {
        return firstPhrase + secondPhrase;
    }

    public int[] add(int[] firstArray, int[] secondArray) {

        int[] resultArray = new int[firstArray.length + secondArray.length];
        for (int i = 0; i < firstArray.length; i++) {
            resultArray[i] = firstArray[i];


        }
        for (int j = 0, i = firstArray.length; i < resultArray.length; i++, j++) {
            resultArray[i] = secondArray[j];

        }
        return resultArray;

    }

    public List add(List firstList, List secondList) {
        List resultList = new ArrayList();
        resultList.addAll(firstList);
        resultList.addAll(secondList);

        return resultList;
    }

    public Map add(Map firstMap, Map secondMap) {
        Map resultMap = new HashMap();
        resultMap.putAll(firstMap);
        resultMap.putAll(secondMap);
        return resultMap;


    }
}



