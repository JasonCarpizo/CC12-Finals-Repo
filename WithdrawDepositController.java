package application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class WithdrawDepositController {
   @FXML
   private TextField amountField;
   @FXML
   private Label totalMoneyLabel; // Label to display total money
   @FXML
   private ListView<String> historyListView;
   private DashboardController dashboardController;
   private ObservableList<String> transactionHistory;
   private double totalMoney = 0; // Variable to store total money
   public void setDashboardController(DashboardController dashboardController) {
       this.dashboardController = dashboardController;
   }
   @FXML
   private void initialize() {
       transactionHistory = FXCollections.observableArrayList();
       historyListView.setItems(transactionHistory);
       updateTotalMoneyLabel();
   }
   @FXML
   private void handleWithdraw(ActionEvent event) {
       double amount = Double.parseDouble(amountField.getText());
       dashboardController.withdraw(amount);
       totalMoney -= amount; // Subtract withdrawn amount from total money
       updateTotalMoneyLabel();
       updateTransactionHistory("Withdraw", amount);
       amountField.clear();
   }
   @FXML
   private void handleDeposit(ActionEvent event) {
       double amount = Double.parseDouble(amountField.getText());
       dashboardController.deposit(amount);
       totalMoney += amount; // Add deposited amount to total money
       updateTotalMoneyLabel();
       updateTransactionHistory("Deposit", amount);
       amountField.clear();
   }
   @FXML
   private void handleBack(ActionEvent event) {
       amountField.getScene().getWindow().hide();
   }
   private void updateTransactionHistory(String action, double amount) {
       LocalDateTime dateTime = LocalDateTime.now();
       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
       String formattedDateTime = dateTime.format(formatter);
       String transaction = String.format("[%s] %s: $%.2f", formattedDateTime, action, amount);
       transactionHistory.add(transaction);
   }
   private void updateTotalMoneyLabel() {
       totalMoneyLabel.setText(String.format("Total Money: $%.2f", totalMoney));
   }
}
