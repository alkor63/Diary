package number5;

import java.util.Scanner;

public class LiveCoding {
    public static void main(String[] args) {
        double num = 1.0;
        Scanner in = new Scanner(System.in);
        System.out.println("При вводе double в качестве разделителя используйте запятую");
        while (num != 0) {
            System.out.print("Введите положительное число - сторону квадрата: ");
            num = in.nextDouble();
            if (num == 0) break;
            try {
                checkPositive(num);
                System.out.println(" площадь квадрата со стороной " + num + " = " + square(num));
            } catch (IllegalArgumentException e) {
                System.out.println("вы ввели " + num + e.getMessage());
            } finally {
                System.out.println("(для выхода из программы введите '0')");
            }
        }
        in.close();
    }

    public static double square(double x) {
        return x * x;
    } // вычислили квадрат аргумента

    public static void checkPositive(double d) throws IllegalArgumentException {
        if (d < 0.0) {
            throw new IllegalArgumentException(" - сторона квадрата не может быть отрицательной !");
        }
    }

}
