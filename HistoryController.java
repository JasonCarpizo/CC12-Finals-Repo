package application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.List;
public class HistoryController {
   @FXML
   private TableView<Purchase> tableView;
   @FXML
   private TableColumn<Purchase, String> dateColumn;
   @FXML
   private TableColumn<Purchase, String> productColumn;
   @FXML
   private TableColumn<Purchase, Double> salePriceColumn;
   @FXML
   private Button backButton;
   private Stage dashboardStage;
   public void setDashboardStage(Stage dashboardStage) {
       this.dashboardStage = dashboardStage;
   }
   @FXML
   private void initialize() {
       dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
       productColumn.setCellValueFactory(new PropertyValueFactory<>("product"));
       salePriceColumn.setCellValueFactory(new PropertyValueFactory<>("salePrice"));
       // Load purchases data
       List<Purchase> purchases = Purchase.loadPurchases();
       if (purchases != null) {
           tableView.getItems().setAll(purchases);
       }
   }
   @FXML
   private void handleBackButtonAction(ActionEvent event) throws IOException {
       // Close the history scene
       Stage stage = (Stage) backButton.getScene().getWindow();
       stage.close();
      
       // Bring the dashboard scene back to front
       dashboardStage.toFront();
   }
}



