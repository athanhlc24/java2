package assigment1.bookrent.create;

import assigment1.Main;
import assigment1.dao.impls.BookRentRepository;
import assigment1.entities.Book;
import assigment1.entities.BookRent;
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
import java.util.ArrayList;
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
        try {
            Book selected = cbBook.getSelectionModel().getSelectedItem();
            Student selectedStudent = cbStudent.getSelectionModel().getSelectedItem();
            BookRentRepository br = new BookRentRepository();
            ArrayList<BookRent> ls = new ArrayList<>();
            ls.addAll(br.all());
            BookRent br1  = new BookRent(selected.getId(), selectedStudent.getId());
            if (br.create(br1)){
                ontoBack();
            }else {
                System.out.println("loi roi");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public void ontoBack() throws Exception{
        Parent listBook = FXMLLoader.load(getClass().getResource("../list/list.fxml"));
        Main.rootStage.setTitle("Books");
        Main.rootStage.setScene(new Scene(listBook,800,600));
    }
}
