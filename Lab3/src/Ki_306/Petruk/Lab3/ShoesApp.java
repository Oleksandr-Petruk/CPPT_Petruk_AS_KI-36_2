package Ki_306.Petruk.Lab3;

import java.util.Scanner;

/**
 * Головний клас Main для запуску програми, що керує кросівками.
 */
public class ShoesApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Sneakers sneakers = new Sneakers("Nike", 42.5, "Білий");

        while (true) {
            System.out.println("Оберіть дію:");

            if (!sneakers.isWorn()) {
                System.out.println("1. Одягнути взуття");
            } else {
                System.out.println("1. Зняти взуття");
            }
            if (!sneakers.isLaced()) {
                System.out.println("2. Зав'язати шнурки");
            } else {
                System.out.println("2. Розв'язати шнурки");
            }
            System.out.println("3. Очистити взуття");
            System.out.println("4. Відремонтувати взуття");
            System.out.println("5. Відполірувати взуття");
            System.out.println("6. Перевірити стан взуття");
            System.out.println("7. Пробігти");
            System.out.println("8. Вийти");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    if (!sneakers.isWorn()) {
                        sneakers.wear();
                    } else {
                        sneakers.remove();
                    }
                }
                case 2 -> {
                    if (!sneakers.isLaced()) {
                        sneakers.laceUp();
                    } else {
                        sneakers.unlace();
                    }
                }
                case 3 -> sneakers.clean();
                case 4 -> sneakers.repair();
                case 5 -> sneakers.polish();
                case 6 -> sneakers.checkStatus();
                case 7 -> {
                    if (sneakers.isWorn()) {
                        System.out.print("Введіть дистанцію для пробігу (в км): ");
                        double distance = scanner.nextDouble();
                        sneakers.run(distance);
                    } else {
                        System.out.println("Спочатку одягніть кросівки, щоб пробігти.");
                    }
                }
                case 8 -> {
                    System.out.println("Вихід з програми.");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Невірний вибір, спробуйте ще раз.");
            }
        }
    }
}
