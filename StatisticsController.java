import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class StatisticsController {
    public Button backButton;

    @FXML
    public void initialize() {
        backButton.setOnMouseClicked(event -> Main.changeScene("./main_section.fxml"));
    }
}
