import java.util.ArrayList;

public class Calculator {
    int numberOfPersons = 0;
    Double sum = 0.0;
    ArrayList<Product> productsList = new ArrayList<>();

    public void add(Product product) {
        productsList.add(product);

        sum = sum + product.price;
    }
    public double getSumPerPerson() {
        return sum/numberOfPersons;
    }
}
