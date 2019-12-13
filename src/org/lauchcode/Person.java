package org.lauchcode;

public class Person {
    private String name;
    private String surname;
    private String middle_name;

    public Person() {}

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, String surname, String middle_name) {
        this.name = name;
        this.surname = surname;
        this.middle_name = middle_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", middle_name='" + middle_name + '\'' +
                '}';
    }
}
