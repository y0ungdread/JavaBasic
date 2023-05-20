package model;

public class Student extends Human {
    private Group group;

    // Конструктор, геттери та сеттери

    public Student(String name, String surname, String patronymic, Sex sex, Group group) {
        super(name, surname, patronymic, sex);
        this.group = group;
    }

    public Group getGroup() {
        return group;
    }
}
