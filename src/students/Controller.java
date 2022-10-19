package students;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public TableView<Student> tbStudent;
    public TableColumn<Student,Integer> tdId;
    public TableColumn<Student,String> tdName;
    public TableColumn<Student,String> tdEmail;
    public TableColumn<Student,String> tdTel;



    public final static String connectionString = "jdbc:mysql://localhost:3306/java2";
    public final static String user = "root";
    public final static String password = "";// nếu là macbook thì là ="root";
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tdId.setCellValueFactory(new PropertyValueFactory<Student,Integer>("id"));
        tdName.setCellValueFactory(new PropertyValueFactory<Student,String>("name"));
        tdEmail.setCellValueFactory(new PropertyValueFactory<Student,String>("email"));
        tdTel.setCellValueFactory(new PropertyValueFactory<Student,String>("tel"));

        ObservableList<Student> ls = FXCollections.observableArrayList();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(connectionString,user,password);
            Statement statement = conn.createStatement();
            String sql_txt = "select * from Student";
            ResultSet rs = statement.executeQuery(sql_txt);
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String tel = rs.getString("tel");

                Student st = new Student(id,name,email,tel);
                ls.add(st);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            tbStudent.setItems(ls);
        }
    }

    public void onToBack(ActionEvent actionEvent) throws Exception {
        Parent addStudent = FXMLLoader.load(getClass().getResource("add/add.fxml"));
        Main.rootStage.setTitle("Students");
        Main.rootStage.setScene(new Scene(addStudent,800,600));
    }


}
