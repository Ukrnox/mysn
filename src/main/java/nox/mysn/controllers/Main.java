package nox.mysn.controllers;

import org.yaml.snakeyaml.util.ArrayUtils;

import java.util.*;

public class Main {

//    public static boolean comp(int[] a, int[] b) {
//        boolean result;
//        if (a == null || b == null || a.length != b.length)
//            return false;
//        if (a.length == 0) {
//            return true;
//        }
//        int aLength = a.length;
//        for (int i = 0; i < aLength; i++) {
//            int temp = a[i];
//            temp *= temp;
//            result = false;
//            for (int j = 0; j < aLength - i; j++) {
//                if (b[j] == temp) {
//                    b[j] = b[aLength - i - 1];
//                    b[aLength - i - 1] = 0;
//                    result = true;
//                    break;
//                }
//            }
//            if (!result) {
//                return false;
//            }
//        }
//        return true;
//    }
//    public static boolean comp(int[] a, int[] b) {
//        boolean result = true;
//        if (a == null || b == null || a.length != b.length)
//            return false;
//        if (a.length == 0) {
//            return true;
//        }
//        int i = 0;
//        while (result) {
//            int temp = a[i] * a[i];
//            for (int j = 0; j < b.length; j++) {
//                if (b[j] == temp) {
//                    b[j] = 0;
//                    result = true;
//                    break;
//                }
//                else result = false;
//            }
//            i++;
//            if (i == a.length)
//                return result;
//        }
//        return result;
//    }

    public static boolean comp(int[] a, int[] b) {
        if (a == null || b == null || a.length != b.length)
            return false;
        if (a.length == 0) {
            return true;
        }
        LinkedList<Integer> integers = new LinkedList<>();
        for (int i : a) {
            integers.add(i*i);
        }
        for (int j : b) {
            if (!integers.contains(j)) {
                System.out.println(integers);
                return false;
            }
            else {
                integers.remove(Integer.valueOf(j));
            }
        }
        return true;
    }

//    public static boolean comp(int[] a, int[] b) {
//        System.out.println(Arrays.toString(a));
//        System.out.println(Arrays.toString(b));
//        boolean result = true;
//        if (a == null || b == null || a.length != b.length)
//            return false;
//        if (a.length == 0) {
//            return true;
//        }
//        int i = 0;
//        while (result) {
//            int temp = a[i] * a[i];
//            for (int j = 0; j < b.length; j++) {
//                if (b[j] == temp) {
//                    b[j] = 0;
//                    result = true;
//                    break;
//                }
//                else result = false;
//            }
//            i++;
//            if (i == a.length)
//                return result;
//        }
//        return result;
//    }

    public static void test() {
        try {
            throw new IndexOutOfBoundsException();
        } catch (IndexOutOfBoundsException e){
            System.out.println("1");
            System.out.println("2");
            throw e;
        }
        finally {
            System.out.println("3");
            System.out.println("4");
        }
        //return 3;
    }

    public static void main(String[] args) {
//        int[] a = new int[]{121, 144, 19, 161, 19, 144, 19, 11};
//        int[] b = new int[]{121, 14641, 20736, 361, 25921, 361, 20736, 361};
////        int[] a = new int[]{2, 2, 4};
////        int[] b = new int[]{4, 9, 9};
//        System.out.println(comp(a, b));

        test();
        System.out.println( );
    }

}
