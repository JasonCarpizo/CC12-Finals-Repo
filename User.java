package application;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
public class User implements Serializable {
   private static final long serialVersionUID = 1L;
   private String username;
   private String password;
   private double balance; // New attribute for balance
   private static Map<String, User> users = new HashMap<>();
   private static final String DIRECTORY_PATH = "C:\\Users\\User\\Desktop\\Tracker Accounts";
   public User(String username, String password) {
       this.username = username;
       this.password = password;
       this.balance = balance; // Initial balance set to 0
   }
   public String getUsername() {
       return username;
   }
   public String getPassword() {
       return password;
   }
   public double getBalance() {
       return balance;
   }
   public void setBalance(double balance) {
       this.balance = balance;
   }
   public static void addUser(User user) {
       users.put(user.getUsername(), user);
       saveUserToFile(user);
   }
   public static User validateUser(String username, String password) {
       User user = loadUserFromFile(username);
       if (user != null && user.getPassword().equals(password)) {
           return user;
       }
       return null;
   }
   private static void saveUserToFile(User user) {
       try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(getUserFilePath(user.getUsername())))) {
           oos.writeObject(user);
       } catch (IOException e) {
           e.printStackTrace();
       }
   }
   private static User loadUserFromFile(String username) {
       try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(getUserFilePath(username)))) {
           return (User) ois.readObject();
       } catch (FileNotFoundException e) {
           // if file not found, it means no user with this username has been saved yet
           return null;
       } catch (IOException | ClassNotFoundException e) {
           e.printStackTrace();
           return null;
       }
   }
   private static String getUserFilePath(String username) {
       return DIRECTORY_PATH + File.separator + username + ".dat";
   }
   // Ensure the directory exists
   static {
       File directory = new File(DIRECTORY_PATH);
       if (!directory.exists()) {
           directory.mkdirs();
       }
   }
}


