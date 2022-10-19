package students.add;

import assigment1.database.Connector;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import students.Main;

import java.util.ArrayList;

public class Controller {
    public TextField txtName;
    public TextField txtEmail;
    public TextField txtTel;
    public void addStudent(ActionEvent actionEvent) {
        try {
            String name = txtName.getText();
            String email = txtEmail.getText();
            String tel = txtTel.getText();
            String sql = "insert into student(name,email,tel) values(?,?,?)";

            Connector conn = Connector.getInstance();
            ArrayList ar = new ArrayList();
            ar.add(name);
            ar.add(email);
            ar.add(tel);
            if (conn.excute(sql,ar)){
                bttBackHome();
            }else {
                System.out.println("ERROR");
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
    public void bttBackHome()  throws  Exception{
        Parent backHomeList = FXMLLoader.load(getClass().getResource("../list.fxml"));
        Main.rootStage.setTitle("Students");
        Main.rootStage.setScene(new Scene(backHomeList,800,600));
    }


}
