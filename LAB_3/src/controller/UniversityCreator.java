package controller;

import model.*;
public class UniversityCreator {
    public University createTypicalUniversity() {
        University university = new University("New York University");

        FacultyCreator facultyCreator = new FacultyCreator();
        DepartmentCreator departmentCreator = new DepartmentCreator();

        // Створення факультетів
        Faculty faculty1 = facultyCreator.createFaculty("Social sciences", null);
        Faculty faculty2 = facultyCreator.createFaculty("Economy", null);

        // Створення відділів
        Department department1 = departmentCreator.createDepartment("Art History", null);
        Department department2 = departmentCreator.createDepartment("Accounting Division", null);

        // Додавання відділів до факультетів
        faculty1.addDepartment(department1);
        faculty2.addDepartment(department2);

        // Додавання факультетів до університету
        university.addFaculty(faculty1);
        university.addFaculty(faculty2);

        return university;
    }
}
