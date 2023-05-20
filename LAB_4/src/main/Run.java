import org.junit.Assert;
import org.junit.Test;

public class Run {

    @Test
    public void testUniversityJsonSerialization() {
        // Створюємо oldUniversity
        University oldUniversity = createTypicalUniversity();

        // Записуємо oldUniversity у файл у форматі JSON
        JsonManager.writeUniversityToJson(oldUniversity, "university.json");

        // Зчитуємо університет з файлу у форматі JSON
        University newUniversity = JsonManager.readUniversityFromJson("university.json");

        // Порівнюємо newUniversity та oldUniversity за допомогою методу equals
        Assert.assertEquals(oldUniversity, newUniversity);
    }

    public static University createTypicalUniversity() {
        // Створюємо студентів
        Student student1 = new Student("John", "Doe", "Smith", Sex.MALE);
        Student student2 = new Student("Jane", "Doe", "Smith", Sex.FEMALE);

        // Створюємо групи
        Group group1 = new Group("Group A");
        group1.addStudent(student1);
        group1.addStudent(student2);

        Group group2 = new Group("Group B");
        group2.addStudent(new Student("Alice", "Johnson", "Brown", Sex.FEMALE));
        group2.addStudent(new Student("Bob", "Smith", "Davis", Sex.MALE));

        // Створюємо кафедри
        Department department1 = new Department("Department of Physics");
        department1.addGroup(group1);
        department1.addGroup(group2);

        Department department2 = new Department("Department of Chemistry");
        department2.addGroup(new Group("Group C"));
        department2.addGroup(new Group("Group D"));

        // Створюємо факультети
        Faculty faculty1 = new Faculty("Faculty of Science");
        faculty1.addDepartment(department1);
        faculty1.addDepartment(department2);

        Faculty faculty2 = new Faculty("Faculty of Arts");
        faculty2.addDepartment(new Department("Department of Literature"));
        faculty2.addDepartment(new Department("Department of History"));

        // Створюємо університет
        University university = new University("My University");
        university.addFaculty(faculty1);
        university.addFaculty(faculty2);

        return university;
    }

    public static void main(String[] args) {
        // Запуск JUnit тесту
        org.junit.runner.JUnitCore.main(Run.class.getName());
    }
}