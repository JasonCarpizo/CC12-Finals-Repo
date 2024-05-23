package application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.IOException;
public class DashboardController {
   @FXML
   private Label lblWelcome;
   @FXML
   private Button btn1;
   @FXML
   private Button btn2;
   @FXML
   private Button btn3;
   @FXML
   private Button btn4;
   private User user;
   private WithdrawDepositController withdrawDepositController; // Add reference to WithdrawDepositController
   public void setUser(User user) {
       this.user = user;
       lblWelcome.setText("Welcome, " + user.getUsername() + "!");
   }
   // Add a method to set the WithdrawDepositController
   public void setWithdrawDepositController(WithdrawDepositController withdrawDepositController) {
       this.withdrawDepositController = withdrawDepositController;
   }
   @FXML
   private void initialize() {
       // Add initialization logic if needed
   }
   @FXML
   private void handleWithdrawDeposit(ActionEvent event) {
       try {
           FXMLLoader loader = new FXMLLoader(getClass().getResource("WithdrawDepositView.fxml"));
           Parent root = loader.load();
           WithdrawDepositController controller = loader.getController();
           controller.setDashboardController(this);
           Stage stage = new Stage();
           stage.setScene(new Scene(root));
           stage.setTitle("Withdraw / Deposit");
           stage.show();
       } catch (IOException e) {
           e.printStackTrace();
           // Handle error loading the FXML file
       }
   }
   @FXML
   private void handleButton2Action() {
       // Handle Button 2 action
   }
   @FXML
   private void handleButton3Action(ActionEvent event) {
       try {
           FXMLLoader loader = new FXMLLoader(getClass().getResource("History.fxml"));
           Parent root = loader.load();
           // Create a new stage for the history scene
           Stage historyStage = new Stage();
           historyStage.setScene(new Scene(root));
           historyStage.setTitle("Transaction History");
           // Pass the dashboard stage to the history controller
           HistoryController historyController = loader.getController();
           historyController.setDashboardStage((Stage) ((Node) event.getSource()).getScene().getWindow());
           // Show the history scene
           historyStage.show();
       } catch (IOException e) {
           e.printStackTrace();
           // Handle error loading the FXML file
       }
   }
   @FXML
   private void handleButton4Action() {
       // Handle Button 4 action
   }
   public void withdraw(double amount) {
       if (user != null && user.getBalance() >= amount) {
           // Withdraw the amount
           user.setBalance(user.getBalance() - amount);
           System.out.println("Withdrawn: " + amount);
           System.out.println("New Balance: " + user.getBalance());
       } else {
           System.out.println("Insufficient funds.");
       }
   }
   // Method to deposit money
   public void deposit(double amount) {
       if (user != null) {
           // Deposit the amount
           user.setBalance(user.getBalance() + amount);
           System.out.println("Deposited: " + amount);
           System.out.println("New Balance: " + user.getBalance());
       }
   }
}




