package model;

public class Department {
    private String name;
    private Human head;

    // Конструктор, геттери та сеттери

    public Department(String name, Human head) {
        this.name = name;
        this.head = head;
    }

    public String getName() {
        return name;
    }

    public Human getHead() {
        return head;
    }
}
