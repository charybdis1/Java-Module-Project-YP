import java.util.ArrayList;
import java.util.Iterator;

public class ProductPrinter {

    public void print(ArrayList<Product> list, double sum) {
        System.out.println("Добавленные товары:");
        Iterator<Product> iterator = list.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            System.out.println(product.name + " " + product.price);
        }
        System.out.println("Сумма на одного человека составляет: "
                + String.format("%.2f", sum) + " " + currencyFormat(sum));
    }

    public String currencyFormat(double price) {
        String ending;
        int intPrice = (int) (price);
        int remainderTen = (intPrice % 10);
        int remainderHundred = (intPrice % 100);

        if (remainderHundred >= 11 && remainderHundred <= 19) {
            ending = "рублей";
        } else {
            switch (remainderTen) {
                case 1:
                    ending = "рубль";
                    break;
                case 2, 3, 4:
                    ending = "рубля";
                    break;
                default:
                    ending = "рублей";
                    break;
            }
        }
        return ending;
    }


}
