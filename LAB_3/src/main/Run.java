package main;

import controller.*;
import model.*;


public class Run {
    public static void main(String[] args) {
        // Створення об'єктів голови, факультету, кафедри та групи
        Human rector = new Human("Jax", "Teller", "Richardson", Sex.MALE);
        Faculty faculty = new Faculty("Computer Science", rector);
        Department department = new Department("Software Engineering", rector);
        Group group = new Group("Group A", rector);

        // Додавання кафедри до факультету
        faculty.addDepartment(department);

        // Додавання факультету до університету
        University university = new University("New York University");
        university.addFaculty(faculty);

        // Виведення даних університету
        System.out.println("University Name: " + university.getName());
        System.out.println("Faculty Name: " + faculty.getName());
        System.out.println("Department Name: " + department.getName());
        System.out.println("Group Name: " + group.getName());
        System.out.println("Rector Name: " + rector.getFullName());
    }
}

