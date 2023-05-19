import java.util.Scanner;
import java.util.Random;

    class MatrixOperations {
    private static final int MAX_SIZE = 20;
    private static final int RANDOM_MIN = 1;
    private static final int RANDOM_MAX = 100;

    private int[][] matrix;
    private int width;
    private int height;

    public static void main(String[] args) {
        MatrixOperations program = new MatrixOperations();
        program.run();
    }

    public void run() {
        createMatrix();
        printMatrix();
        findMinMax();
        calculateAverage();
    }

    public void createMatrix() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть ширину матриці (не більше 20): ");
        width = scanner.nextInt();

        System.out.print("Введіть висоту матриці (не більше 20): ");
        height = scanner.nextInt();

        if (width > MAX_SIZE || height > MAX_SIZE) {
            System.out.println("Розміри матриці не можуть перевищувати 20.");
            System.exit(0);
        }

        matrix = new int[height][width];

        System.out.println("Оберіть спосіб заповнення матриці:");
        System.out.println("1. Ввести з клавіатури");
        System.out.println("2. Заповнити випадково");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                fillMatrixFromInput(scanner);
                break;
            case 2:
                fillMatrixRandomly();
                break;
            default:
                System.out.println("Некоректна відповідь.");
                System.exit(0);
        }
    }

    private void fillMatrixFromInput(Scanner scanner) {
        System.out.println("Введіть елементи матриці:");
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print("Елемент [" + i + "][" + j + "]: ");
                matrix[i][j] = scanner.nextInt();
            }
        }
    }

    private void fillMatrixRandomly() {
        Random random = new Random();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                matrix[i][j] = random.nextInt(RANDOM_MAX - RANDOM_MIN + 1) + RANDOM_MIN;
            }
        }
    }

    public void printMatrix() {
        System.out.println("Матриця:");
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public void findMinMax() {
        int min = matrix[0][0];
        int max = matrix[0][0];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                }

                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }
            }
        }

        System.out.println("Мінімальний елемент: " + min);
        System.out.println("Максимальний елемент: " + max);
    }

    public void calculateAverage() {
        int sum = 0;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                sum += matrix[i][j];
            }
        }

        double average = (double) sum / (width * height);
        System.out.println("Середнє арифметичне: " + average);
    }

}