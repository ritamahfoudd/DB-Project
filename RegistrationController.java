import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class RegistrationController {
    public Button backButton;
    public Button studentButton;

    @FXML
    public void initialize() {
        backButton.setOnMouseClicked(event -> Main.changeScene("./main_section.fxml"));
        studentButton.setOnMouseClicked(event -> Main.changeScene("./student_registration.fxml"));
    }
}
