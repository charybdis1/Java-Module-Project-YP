import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("На скольких человек нужно разделить счет?");

        int number;
        while (true) {
            if (scanner.hasNextInt()) {

                number = scanner.nextInt();
                if (number <= 1) {
                    System.out.println("Число должно быть больше одного. Введите корректное число");
                } else {
                    // Пропускаем перевод строки после числа
                    scanner.nextLine();
                    break;
                }

            } else {
                System.out.println("Введен неверный формат числа. Пример: '2' , '5' и т.д.");
            }

            // Пропускаем перевод строки после числа
            scanner.nextLine();
        }

        Calculator calculator = new Calculator();
        calculator.numberOfPersons = number;
        while (true) {

            System.out.println("Введите название товара:");

            String name = scanner.nextLine();
            if (!name.isBlank()) {
                while (true) {

                    System.out.println("Введите стоимость в формате 'рубли,копейки':");

                    if (scanner.hasNextDouble()) {
                        double price = scanner.nextDouble();
                        if (price <= 0) {
                            System.out.println("Стоимость товара должна быть больше нуля");
                            // Пропускаем перевод строки после числа
                            scanner.nextLine();
                        } else {
                            Product product = new Product(name, price);

                            calculator.add(product);

                            System.out.println("Товар успешно добавлен");
                            // Пропускаем перевод строки после числа
                            scanner.nextLine();
                            break;
                        }
                    } else {
                        System.out.println("Неверный формат стоимости");
                        // Пропускаем перевод строки после числа
                        scanner.nextLine();
                    }
                }
            } else {
                System.out.println("Неверное название товара:");
            }

            System.out.println("Добавить еще товар? \n" +
                    "После добавления всех товаров введите команду 'завершить'");
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("завершить")) {
                new ProductPrinter().print(calculator.productsList, calculator.getSumPerPerson());
                break;
            }
        }
    }
}