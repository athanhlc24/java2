package thi.list;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import thi.Main;
import thi.add.AddController;
import thi.add.Student;

import java.net.URL;
import java.util.ResourceBundle;

public class ListController implements Initializable {
    public TableView<Student> tbSTUDENT;

    public TableColumn tbID;
    public TableColumn tbNAME;
    public TableColumn tbADDRESS;
    public TableColumn tbPHONE;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tbID.setCellValueFactory(new PropertyValueFactory<>("id"));
        tbNAME.setCellValueFactory(new PropertyValueFactory<>("name"));
        tbADDRESS.setCellValueFactory(new PropertyValueFactory<>("address"));
        tbPHONE.setCellValueFactory(new PropertyValueFactory<>("phone"));
        tbSTUDENT.setItems(AddController.listStudent);
    }

    public void back(ActionEvent actionEvent) throws Exception {
        Parent listPage = FXMLLoader.load(getClass().getResource("../home.fxml"));
        Scene listScene = new Scene(listPage, 600, 400);
        Main.rootStage.setTitle("add");
        Main.rootStage.setScene(listScene);
    }
}
