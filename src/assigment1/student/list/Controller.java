package assigment1.student.list;

import assigment1.Main;
import assigment1.entities.Student;
import assigment1.enums.RepoType;
import assigment1.factory.RepositoryFactory;
import dao.impls.StudentRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public TableColumn<Student ,Integer> txtID;
    public TableColumn<Student, String> txtName;
    public TableColumn<Student, String> txtEmail;
    public TableColumn<Student, String> txtTel;
    public TableView<Student> tbStudent;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        txtID.setCellValueFactory(new PropertyValueFactory<Student,Integer>("id"));
        txtName.setCellValueFactory(new PropertyValueFactory<Student,String>("name"));
        txtEmail.setCellValueFactory(new PropertyValueFactory<Student,String>("email"));
        txtTel.setCellValueFactory(new PropertyValueFactory<Student, String>("tel"));

        ObservableList<Student> ls = FXCollections.observableArrayList();
//        StudentRepository sp = new StudentRepository();
        StudentRepository sp = (StudentRepository) RepositoryFactory.createRepository(RepoType.STUDENT);
        ls.addAll(sp.all());
        tbStudent.setItems(ls);
    }

    public void bttBack(ActionEvent actionEvent) throws Exception{
        Parent listBook = FXMLLoader.load(getClass().getResource("../../home.fxml"));
        Main.rootStage.setTitle("Books");
        Main.rootStage.setScene(new Scene(listBook,800,600));
    }

    public void addStudent(ActionEvent actionEvent) throws Exception{
        Parent listBook = FXMLLoader.load(getClass().getResource("../add/add.fxml"));
        Main.rootStage.setTitle("Books");
        Main.rootStage.setScene(new Scene(listBook,800,600));
    }
}
