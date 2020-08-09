package ru.ayupov.task;

import java.util.*;

public class Person {
    private int age;
    private String surname;
    private String sex;

    public Person(int age, String surname, String sex) {
        this.age = age;
        this.surname = surname;
        this.sex = sex;
    }

    public static Map<String, Person> createMap() {
        Map<String, Person> book = new HashMap<>();
        Person person1 = new Person(29, "Петрова", "жен");
        Person person2 = new Person(34, "Сидорова", "жен");
        Person person3 = new Person(34, "Тихонова", "жен");
        Person person4 = new Person(35, "Петров", "муж");
        book.put("Key1", person1);
        book.put("Key2", person1);
        book.put("Key3", person2);
        book.put("Key4", person3);
        book.put("Key5", person4);
        book.put("Key6", person4);
        return book;
    }

    public static void printMap(Map<String, Person> map) {
        for (Map.Entry<String, Person> stringPersonEntry : map.entrySet()) {
            Map.Entry entry = (Map.Entry) stringPersonEntry;
            String key = (String) entry.getKey();
            Person value = (Person) entry.getValue();
            System.out.printf("%-2s|%s%n", key, value.toString());
        }
    }

    public static void removeItemFromMapByValue(Map<String, Person> map, Person value) {
        Map<String, Person> copy = new HashMap<>(map);
        for (Map.Entry<String, Person> pair : copy.entrySet()) {
            if (pair.getValue().equals(value)) {
                map.remove(pair.getKey());
                return;
            }
        }
    }

    public static void removeTheDuplicates(Map<String, Person> map) {
        Map<String, Person> copy = new HashMap<>(map);
        for (Map.Entry<String, Person> pair : copy.entrySet()) {
            int frequency = Collections.frequency(copy.values(), pair.getValue());
            if (frequency > 1) {
                removeItemFromMapByValue(map, pair.getValue());
                copy = map;
            }
        }
    }

    // Рещение через восстановление
    public static void removeItemFromMapByValueOriginal(Map<String, Person> map, Person value) {
        Map<String, Person> copy = new HashMap<>(map);
        for (Map.Entry<String, Person> pair : copy.entrySet()) {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void removeTheDuplicates2(Map<String, Person> map) {
        for (Map.Entry<String, Person> stringPersonEntry : map.entrySet()) {
            Map.Entry entry = (Map.Entry) stringPersonEntry;
            String key = (String) entry.getKey();
            Person value = (Person) entry.getValue();
            int frequency = Collections.frequency(map.values(), value);
            if (frequency > 1) {
                removeItemFromMapByValueOriginal(map, value);
            }
            map.put(key, value);
        }
    }

    @Override
    public String toString() {
        return String.format("  %-5d|%-9s|%-3s|", age, surname, sex);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(surname, person.surname) &&
                Objects.equals(sex, person.sex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, surname, sex);
    }
}
