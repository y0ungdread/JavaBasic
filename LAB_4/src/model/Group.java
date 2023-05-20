package model;
public class Group {
    private String name;
    private Human head;

    // Конструктор, геттери та сеттери

    public Group(String name, Human head) {
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