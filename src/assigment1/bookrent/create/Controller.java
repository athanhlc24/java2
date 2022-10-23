package assigment1.bookrent.create;

import assigment1.Main;
import assigment1.entities.Book;
import assigment1.entities.Student;
import assigment1.enums.RepoType;
import assigment1.factory.RepositoryFactory;
import assigment1.dao.impls.BookRepository;
import assigment1.dao.impls.StudentRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public ComboBox<Book> cbBook;
    public ComboBox<Student> cbStudent;
    public DatePicker dpExpired;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        BookRepository rp = new BookRepository();
        ObservableList<Book> ls = FXCollections.observableArrayList();
        BookRepository rp = (BookRepository) RepositoryFactory.createRepository(RepoType.BOOK);
        ls.addAll(rp.all());
        cbBook.setItems(ls);
//        StudentRepository rp2 = new StudentRepository();
        ObservableList<Student> lsStudent = FXCollections.observableArrayList();
        StudentRepository rp2 = (StudentRepository)RepositoryFactory.createRepository(RepoType.STUDENT);
        lsStudent.addAll(rp2.all());
        cbStudent.setItems(lsStudent);
    }

    public void Submit(ActionEvent actionEvent) {
        Book selected = cbBook.getSelectionModel().getSelectedItem();
        LocalDate dp = dpExpired.getValue();
        Student selectedStudent = cbStudent.getSelectionModel().getSelectedItem();

        

        System.out.println(selected);
        System.out.println(dp);
        System.out.println(selectedStudent);

    }

    public void ontoBack(ActionEvent actionEvent) throws Exception{
        Parent listBook = FXMLLoader.load(getClass().getResource("../list/list.fxml"));
        Main.rootStage.setTitle("Books");
        Main.rootStage.setScene(new Scene(listBook,800,600));
    }
}
