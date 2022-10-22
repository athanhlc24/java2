package assigment1.bookrent.create;

import assigment1.entities.Book;
import assigment1.entities.Student;
import dao.impls.BookRepository;
import dao.impls.StudentRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
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
        BookRepository rp = new BookRepository();
        ObservableList<Book> ls = FXCollections.observableArrayList();
        ls.addAll(rp.all());
        cbBook.setItems(ls);
        StudentRepository rp2 = new StudentRepository();
        ObservableList<Student> lsStudent = FXCollections.observableArrayList();
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
}
