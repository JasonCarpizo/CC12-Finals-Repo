package application;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
public class Purchase implements Serializable {
   private static final long serialVersionUID = 1L;
   private String date;
   private String product;
   private double salePrice;
   public Purchase(String date, String product, double salePrice) {
       this.date = date;
       this.product = product;
       this.salePrice = salePrice;
   }
   public String getDate() {
       return date;
   }
   public String getProduct() {
       return product;
   }
   public double getSalePrice() {
       return salePrice;
   }
   // Method to load purchases
   public static List<Purchase> loadPurchases() {
       // Implement the logic to load purchases from a file or database
       List<Purchase> purchases = new ArrayList<>();
       // Example data
       purchases.add(new Purchase("21 May 21", "Ice Cream Making for Beginners", 10.00));
       return purchases;
   }
}


