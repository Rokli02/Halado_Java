package org.example;

public class App 
{
    public static void printUniversityCitizens(PersonChecker[] citizens) {
        for (PersonChecker citizen : citizens) {
            if(citizen.isOk()) {
                System.out.println(citizen);
            }
        }
    }

    public static void main( String[] args )
    {
        PersonChecker[] citizens = new PersonChecker[6];

        citizens[0] = new Student("Student1", 21, 2, 3.4f);
        citizens[1] = new Teacher("Teacher1", 62, 120);
        citizens[2] = new Student("Student2", 21, 0, 4.5f);
        citizens[3] = new Student("Student3", 21, 1, 5f);
        citizens[4] = new Teacher("Teacher2", 62, 20);
        citizens[5] = new Student("Student4", 21, 2, 3.4f);

        printUniversityCitizens(citizens);
    }
}
