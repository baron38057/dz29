package classwork15042023;

public class CountingSortDz {
    public static void main(String[] args) {
        Product[] products = new Product[]{
                new Product("Product A", 12.99, 5),
                new Product("Product B", 9.99, 10),
                new Product("Product C", 12.99, 8),
                new Product("Product D", 7.99, 15),
                new Product("Product E", 9.99, 5),
                new Product("Product F", 9.99, 1)
        };
        Product[] result = bubbleSort(products);
        outputResult(result);
        //Product[] result2 = countSort(products);
        //outputResult(result2);
    }
    static Product[] bubbleSort(Product[] products){ 
        int size = products.length;
        for(int step = 0; step < size - 1; step++) {

            for (int i = 0; i < size - step - 1; i++) {
                if (products[i].price > products[i + 1].price) { 
                	String tempS = products[i].name;
                	double temp = products[i].price;
                	int tempQ = products[i].quantity;
                    products[i].price = products[i + 1].price;
                    products[i + 1].price = temp;
                    products[i].name = products[i + 1].name;
                    products[i + 1].name = tempS;
                    products[i].quantity = products[i + 1].quantity;
                    products[i + 1].quantity = tempQ;
                }
                 else if (products[i].price == products[i + 1].price) {
                	 if(products[i].quantity > products[i+1].quantity) {
                		 
                	 
                	 String tempS = products[i].name;
                 	 double temp = products[i].price;
                 	 int tempQ = products[i].quantity;
                	 
                	 products[i].price = products[i + 1].price;
                     products[i + 1].price = temp;
                     products[i].name = products[i + 1].name;
                     products[i + 1].name = tempS;
                     products[i].quantity = products[i + 1].quantity;
                     products[i + 1].quantity = tempQ;
                	 }
                } 
            }

        }
        return products;
    }
    
    //countSort работает только с int
    
   /* private static Product[] countSort(Product[] products) {
        int size = products.length;
        Product[] output = new Product[size];

        double max = products[0].quantity;
        for (int i = 1; i < size; i++) {
            if (products[i].quantity > max) {
                max = products[i].quantity;
            }
        }
        int[] count = new int[(int) (max + 1)];

        for (int i = 0; i < size; i++) {
            count[(int) products[i].quantity]++;
        }

        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }
        for (int i = size - 1; i >= 0; i--) {
            output[count[(int) products[i].quantity] - 1] = products[i];
            count[(int) products[i].quantity]--;
        }

        return output;

    } */
    

    static void outputResult(Product[] products) {
        for (int i = 0; i < products.length; i++) {
            System.out.println(products[i].name + " " + products[i].price + " " + products[i].quantity);
            
        }
    }
}


class Product {
    String name;
    double price;
    int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}
