package assigment1.book.listbook;

import assigment1.Main;
import assigment1.book.addbook.Book;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller  implements Initializable {
    public ListView<Book> lvBook;
    public static ObservableList<Book> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lvBook.setItems(list);
    }

    public void onToAdd(ActionEvent actionEvent)  throws Exception{
        Parent listPage = FXMLLoader.load(getClass().getResource("../book/addbook/add.fxml"));
        Scene listScene = new Scene(listPage,800,600);

       Main.rootStage.setScene(listScene);
    }
}