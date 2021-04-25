package com.company;

import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {
//        Test1();
        {
            Integer [] arr = {3, 5, 3, 1, 5, 321, 34, 5, 1};
            System.out.println(Arrays.toString(arr));
            heapSort(arr);
            System.out.println(Arrays.toString(arr));
        }
        {
            String [] arr = {"adf", "zealot", "alpha", "omega", "proto", "beta", "gamma"};
            System.out.println(Arrays.toString(arr));
            heapSort(arr, String::compareTo);
            System.out.println(Arrays.toString(arr));
        }

    }

    public static <E extends Comparable<E>> void heapSort(E[] list, Comparator<? super E> comparator) {
        Heap<E> heap = new Heap<E>(comparator);

        for (E o : list) heap.addComp(o);

        for (int i = list.length - 1; i >= 0; --i) list[i] = heap.removeComp();
    }


    public static <E extends Comparable<E>> void heapSort(E[] list) {
        Heap<E> heap = new Heap<>();

        for (E e : list) heap.add(e);

        for (int i = list.length - 1; i >= 0; i--) list[i] = heap.remove();
    }


    public static void Test1() throws CloneNotSupportedException {
        Integer[] arr = {2, 4, 5, 6, 2, 1};
        Heap<Integer> a = new Heap<>(arr);

        Heap<Integer> b = (Heap<Integer>) a.clone();

        System.out.println("Equals? " + a.equals(b));

        b.add(9999);
        a.add(2131);

        System.out.println("Equals? " + a.equals(b));

        System.out.print("a: ");
        while (a.getSize() > 0) {
            System.out.print(a.remove() + " ");
        }
        System.out.println();
        System.out.print("b: ");
        while (b.getSize() > 0) {
            System.out.print(b.remove() + " ");
        }
    }
}
