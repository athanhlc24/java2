package assigment1.book.addbook;

import assigment1.Main;
import assigment1.database.Connector;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

import java.sql.PreparedStatement;
import java.util.ArrayList;

public class Controller {
    public TextField txtName;
    public TextField txtAuthor;
    public TextField txtQty;
    public void bttAdd(ActionEvent actionEvent) {
        try {
            String name = txtName.getText();
            String author = txtAuthor.getText();
            int qty = Integer.parseInt(txtQty.getText());
            String sql_txt = "insert into books(name,author,qty) values(?,?,?)";

            Connector conn = new Connector();
            ArrayList arr = new ArrayList<>();
            arr.add(name);
            arr.add(author);
            arr.add(qty);


            if (conn.excute(sql_txt,arr)){
                bttBack();
            }else {
                System.out.println("Error");
            }

        }catch (Exception e){

            System.out.println(e.getMessage());
        }

    }

    public void bttBack() throws Exception{
        Parent listBook = FXMLLoader.load(getClass().getResource("../listbook/list.fxml"));
        Main.rootStage.setTitle("Books");
        Main.rootStage.setScene(new Scene(listBook,800,600));
    }
}
