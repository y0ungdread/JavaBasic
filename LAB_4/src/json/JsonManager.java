package json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Клас JsonManager для роботи з JSON
public class JsonManager {
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    // Запис університету у форматі JSON у файл
    public static void writeUniversityToJson(University university, String fileName) {
        try (Writer writer = new FileWriter(fileName)) {
            gson.toJson(university, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Зчитування університету з файлу у форматі JSON
    public static University readUniversityFromJson(String fileName) {
        try (Reader reader = new FileReader(fileName)) {
            return gson.fromJson(reader, University.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}