package ru.ayupov.task;


import java.util.Map;

/**
 * Создать хешмап для класса Person (поля - возраст , фамилия,  пол) - переопределить equals(), hashСode(),
 * toString() для объектов класса Person.
 *
 * Добавить в мапу элементы так, что внутри мапы с разными ключами окажутся одинаковые Person
 *
 * Реализовать метод removeTheDuplicates по поиску дубликатов в исходной мапе, затем при нахождении дубликата
 * удалить его из исходной мапы используя метод
 * removeItemFromMapByValue(Map<String, Person> map, Person value)
 *  Вывести содержимое мапы в консоль.
 */

public class Main {
    public static void main(String[] args) {
        Map map = Person.createMap();
        System.out.printf("%-4s|%-7s|%-9s|%-3s|%n", "ключ", "возраст", "фамилия", "пол");
        Person.printMap(map);
        Person.removeTheDuplicates(map);

        System.out.println();
        System.out.println("Очистка дубликатов");

        System.out.printf("%-4s|%-7s|%-9s|%-3s|%n", "ключ", "возраст", "фамилия", "пол");
        Person.printMap(map);

        System.out.println();
        System.out.println("Вариант с удалением всех и добавлением");

        Map map2 = Person.createMap();
        System.out.printf("%-4s|%-7s|%-9s|%-3s|%n", "ключ", "возраст", "фамилия", "пол");
        Person.printMap(map2);
        Person.removeTheDuplicates(map2);

        System.out.println();
        System.out.println("Очистка дубликатов");

        System.out.printf("%-4s|%-7s|%-9s|%-3s|%n", "ключ", "возраст", "фамилия", "пол");
        Person.printMap(map);

    }
}
