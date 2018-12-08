import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class MainController {
    public ImageView gradesButton;
    public ImageView registerButton;
    public ImageView statButton;
    public ImageView searchButton;

    @FXML
    public void initialize() {
        searchButton.setOnMouseClicked(event -> Main.changeScene("./search_section.fxml"));
        gradesButton.setOnMouseClicked(event -> Main.changeScene("./grades_section.fxml"));
        registerButton.setOnMouseClicked(event -> Main.changeScene("./registration_section.fxml"));
        statButton.setOnMouseClicked(event -> Main.changeScene("./statistics_section.fxml"));
    }

}
