package thi;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import thi.add.AddController;

import java.io.FileWriter;

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

    public void exit(ActionEvent actionEvent) {
        System.exit(0);
        
    }

    public void save(ActionEvent actionEvent) {
        try {
            FileWriter f = new FileWriter("student.txt");
            f.write(AddController.listStudent.toString());
            f.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Success...");
    }
}
