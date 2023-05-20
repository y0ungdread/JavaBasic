package model;

public class Human {
    private String name;
    private String surname;
    private String patronymic;
    private Sex sex;

    public Human(String name, String surname, String patronymic, Sex sex) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.sex = sex;
    }
    // Конструктор, геттери та сеттери

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public Sex getSex() {
        return sex;
    }

    public String getFullName() {
        if (surname != null && !surname.isEmpty()) {
            return name + " " + surname + " " + patronymic;
        } else {
            return name + " " + name;
        }
    }
}