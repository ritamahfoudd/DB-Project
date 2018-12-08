import javafx.scene.control.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class StudentRegController {

    /*Student Info*/
    public TextField studentFName;
    public TextField studentLName;
    public ChoiceBox studentGender;
    public DatePicker studentDOB;
    public TextField studentPOB;
    public TextField studentCurrCity;
    public TextField studentNationality;
    public TextField studentCity;
    public TextField studentCurrNeighborhood;
    public TextField studentDistrict;
    public TextField studentGovernorate;
    public TextField studentCRN;
    public TextField studentStatus;

    /*Mother Info*/
    public TextField motherFName;
    public TextField motherLName;
    public TextField motherPhoneNum;
    public CheckBox isMotherGuardian;

    /*Father Info*/
    public TextField fatherFName;
    public TextField fatherPhoneNum;
    public TextField fatherLName;
    public CheckBox isFatherGuardian;

    /*Guardian Info*/
    public TextField guardianFName;
    public TextField guardianLName;
    public TextField guardianPhoneNum;
    public ChoiceBox guardianGender;

    public Button addStudentButton;

    private static int studentCount;

    public void initialize() {
        addStudentButton.setOnMouseClicked(event -> addStudent());
        //studentCount = countStudents();
    }

    private boolean addStudent() {
        boolean result = false;
        String year = Integer.toString(Calendar.getInstance().get(Calendar.YEAR));
        String schoolID = "1234";
        String studentID = schoolID + year + studentCount;
        String query = "INSERT INTO STUDENT VALUES(" +
                "'" + studentID + "', " +
                "'" + studentFName.getText() + "', " +
                "'" + studentLName.getText() + "', " +
                "'2018-07-12', " +
                "'" + studentPOB.getText() + "', " +
                "'" + DateTimeFormatter.ofPattern("yyyy-MM-dd").format(studentDOB.getValue()) + "', " +
                "'M', " +
                "'" + studentNationality.getText() + "', " +
                "'" + studentGovernorate.getText() + "', " +
                "'" + studentDistrict.getText() + "', " +
                "'" + studentCity.getText() + "', " +
                "'" + studentCRN.getText() + "', " +
                "'" + studentCurrCity.getText() + "', " +
                "'" + studentCurrNeighborhood.getText() + "'" +
                ");";
        System.out.println(query);
        try {
            result = MySQL.getConn().createStatement().execute(query);
            studentCount++;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    private int countStudents() {
        String query = "SELECT COUNT(*) FROM STUDENT";
        int result = 0;
        try {
            ResultSet count = MySQL.getConn().createStatement().executeQuery(query);
            count.close();
            result = Integer.parseInt(count.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
