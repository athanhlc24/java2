package thi;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class HomeController {
    public void addStudent(ActionEvent actionEvent) throws Exception{
        Parent listPage = FXMLLoader.load(getClass().getResource("./add/add.fxml"));
        Scene listScene = new Scene(listPage, 600, 400);
        Main.rootStage.setTitle("add");
        Main.rootStage.setScene(listScene);
    }

    public void listStudent(ActionEvent actionEvent) throws Exception{
        Parent listPage = FXMLLoader.load(getClass().getResource("./list/list.fxml"));
        Scene listScene = new Scene(listPage, 600, 400);
        Main.rootStage.setTitle("add");
        Main.rootStage.setScene(listScene);
    }
}
