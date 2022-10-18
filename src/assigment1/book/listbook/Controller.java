package assigment1.book.listbook;
import assigment1.Main;
import assigment1.database.Connector;
import assigment1.entities.Book;
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
import java.sql.ResultSet;
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
//        ls.add(new Book(1,"Trí tuệ có vấn đề","ABC",10));
//        ls.add(new Book(2,"Trí tuệ tốt","XYZ",11));
//         tbBooks.setItems(ls);
        // lấy data từ database
        try {

            String sql_txt = "select * from books";
            Connector conn = Connector.getInstance();
            ResultSet rs = conn.query(sql_txt);
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String author = rs.getString("author");
                int qty = rs.getInt("qty");

                Book b = new Book(id,name,author,qty);
                ls.add(b);
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            tbBooks.setItems(ls);
        }

    }

    public void onToAdd(ActionEvent actionEvent) throws Exception{
        Parent addBook = FXMLLoader.load(getClass().getResource("../addbook/add.fxml"));
        Main.rootStage.setTitle("Books");
        Main.rootStage.setScene(new Scene(addBook,800,600));
    }

    public void onBackHome(ActionEvent actionEvent) throws Exception{
        Parent addBooks = FXMLLoader.load(getClass().getResource("../../home.fxml"));
        Main.rootStage.setTitle("Books");
        Main.rootStage.setScene(new Scene(addBooks,800,600));
    }
}