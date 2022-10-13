package assigment1.book.listbook;

import assigment1.Main;
import assigment1.entities.Book;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;
public class Controller implements Initializable{
    public TableView<Book> tbBooks;
    public TableColumn<Book,Integer> tdId;
    public TableColumn<Book,String> tdName;
    public TableColumn<Book,String> tdAuthor;
    public TableColumn<Book,Integer> tdQty;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tdId.setCellValueFactory(new PropertyValueFactory<Book,Integer>("id"));
        tdName.setCellValueFactory(new PropertyValueFactory<Book,String>("name"));
        tdAuthor.setCellValueFactory(new PropertyValueFactory<Book,String>("author"));
        tdQty.setCellValueFactory(new PropertyValueFactory<Book,Integer>("qty"));

        ObservableList<assigment1.entities.Book> ls = FXCollections.observableArrayList();
        ls.add(new Book(1,"Trí tuệ có vấn đề","ABC",10));
        ls.add(new Book(2,"Trí tuệ tốt","XYZ",11));
        tbBooks.setItems(ls);
    }

    public void onToAdd(ActionEvent actionEvent) {
    }
}