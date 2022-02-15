package org.example;

public class Student implements PersonChecker{
    private String name;
    private int age;
    private int cheatNumber;
    private float average;

    public static final float GOOD_AVERAGE_MINIMUM = 4.0f;

    public Student(String name, int age, int cheatNumber, float average) {
        this.name = name;
        this.age = age;
        this.cheatNumber = cheatNumber;
        this.average = average;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", cheatNumber=" + cheatNumber +
                ", average=" + average +
                '}';
    }

    @Override
    public boolean isOk() {
        return average > GOOD_AVERAGE_MINIMUM && cheatNumber == 0;
    }
}
