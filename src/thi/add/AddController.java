package thi.add;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import thi.Main;

public class AddController {
    public TextField txtID;
    public TextField txtNAME;
    public TextField txtADDRESS;
    public TextField txtPHONE;
    public static ObservableList<Student> listStudent  = FXCollections.observableArrayList();
    public Text error;

    public void addStudent(ActionEvent actionEvent) {

            try{
                error.setVisible(false);
                if(txtID.getText().isEmpty()||txtNAME.getText().isEmpty()||txtADDRESS.getText().isEmpty()||txtPHONE.getText().isEmpty()){
                    throw new Exception("Vui lòng nhập đầy đủ thông tin sinh viên");
                }
                Student st = new Student(txtID.getText(),txtNAME.getText(),txtADDRESS.getText(),txtPHONE.getText());
                listStudent.add(st);
                backToHome(null);
            }catch (Exception e){
                error.setVisible(true);
                error.setText(e.getMessage());
            }
        }


    public void backToHome(ActionEvent actionEvent) throws Exception {
        Parent listPage = FXMLLoader.load(getClass().getResource("../home.fxml"));
        Scene listScene = new Scene(listPage, 600, 400);
        Main.rootStage.setTitle("home");
        Main.rootStage.setScene(listScene);
    }
}
