package assigment1;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Controller {
    public void onToBook(ActionEvent actionEvent) throws Exception{
        Parent listBook = FXMLLoader.load(getClass().getResource("book/listbook/list.fxml"));
        Main.rootStage.setTitle("Books");
        Main.rootStage.setScene(new Scene(listBook,800,600));
    }

    public void bookRent(ActionEvent actionEvent)throws Exception {
        Parent listBook = FXMLLoader.load(getClass().getResource("bookrent/create/create.fxml"));
        Main.rootStage.setTitle("Books");
        Main.rootStage.setScene(new Scene(listBook,800,600));
    }

    public void onToStudent(ActionEvent actionEvent) throws Exception{
        Parent listBook = FXMLLoader.load(getClass().getResource("student/list/list.fxml"));
        Main.rootStage.setTitle("Books");
        Main.rootStage.setScene(new Scene(listBook,800,600));
    }
}