package application;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
public class SignupController {
   @FXML
   private TextField txtNewUsername;
   @FXML
   private PasswordField txtNewPassword;
   @FXML
   private Button btnCreateAccount;
   @FXML
   private void handleCreateAccount(ActionEvent event) throws IOException {
       String username = txtNewUsername.getText();
       String password = txtNewPassword.getText();
       User user = new User(username, password);
       User.addUser(user);
       // Display a success message
       System.out.println("Account created successfully");
       // Redirect back to the login scene
       Stage stage = (Stage) btnCreateAccount.getScene().getWindow();
       Parent root = FXMLLoader.load(getClass().getResource("LoginView.fxml"));
       Scene scene = new Scene(root);
       stage.setScene(scene);
       stage.setTitle("Banking System - Login");
   }
}
