package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try {
            // Підключення до бази даних
            String url = "jdbc:mysql://localhost:3306/students";
            String username = "your_username";
            String password = "your_password";
            Connection connection = DriverManager.getConnection(url, username, password);

            // Введення місяця користувачем
            String month = "June";

            // SQL-запит для отримання студентів, народжених у вказаному місяці
            String sql = "SELECT * FROM students WHERE MONTH(birth_date) = MONTH(STR_TO_DATE('" + month + "', '%M'))";

            // Виконання запиту і отримання результатів
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            // Виведення інформації про студентів
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String lastName = resultSet.getString("last_name");
                String firstName = resultSet.getString("first_name");
                String middleName = resultSet.getString("middle_name");
                Date birthDate = resultSet.getDate("birth_date");
                String studentId = resultSet.getString("student_id");

                System.out.println("ID: " + id);
                System.out.println("Last Name: " + lastName);
                System.out.println("First Name: " + firstName);
                System.out.println("Middle Name: " + middleName);
                System.out.println("Birth Date: " + birthDate);
                System.out.println("Student ID: " + studentId);
                System.out.println();
            }

            // Закриття з'єднання з базою даних
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}