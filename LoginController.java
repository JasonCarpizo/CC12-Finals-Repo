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
public class LoginController {
   @FXML
   private TextField txtUsername;
   @FXML
   private PasswordField txtPassword;
   @FXML
   private Button btnLogin;
   @FXML
   private Button btnSignUp;
   @FXML
   private void handleLogin(ActionEvent event) throws IOException {
       String username = txtUsername.getText();
       String password = txtPassword.getText();
       User user = User.validateUser(username, password);
       if (user != null) {
           FXMLLoader loader = new FXMLLoader(getClass().getResource("DashboardView.fxml"));
           Parent root = loader.load();
           DashboardController controller = loader.getController();
           controller.setUser(user);
           Stage stage = (Stage) btnLogin.getScene().getWindow();
           Scene scene = new Scene(root);
           stage.setScene(scene);
           stage.setTitle("Banking System - Dashboard");
       } else {
           // Display an error message
           System.out.println("Invalid username or password");
       }
   }
   @FXML
   private void handleSignUp(ActionEvent event) throws IOException {
       Stage stage = (Stage) btnSignUp.getScene().getWindow();
       Parent root = FXMLLoader.load(getClass().getResource("SignUpView.fxml"));
       Scene scene = new Scene(root);
       stage.setScene(scene);
       stage.setTitle("Banking System - Sign Up");
   }
}
