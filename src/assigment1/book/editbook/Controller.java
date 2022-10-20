package assigment1.book.editbook;

import assigment1.Main;
import assigment1.entities.Book;
import dao.impls.BookRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public TextField txtName;
    public TextField txtAuthor;
    public TextField txtQty;
    public static Book editedBook;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (editedBook !=null){
            txtName.setText(editedBook.getName());
            txtAuthor.setText(editedBook.getAuthor());
            txtQty.setText(editedBook.getQty().toString());
        }
    }

    public void bttEdit(ActionEvent actionEvent) {
        try {
            String name = txtName.getText();
            String author = txtAuthor.getText();
            int qty = Integer.parseInt(txtQty.getText());
            editedBook.setName(name);
            editedBook.setAuthor(author);
            editedBook.setQty(qty);
            BookRepository rp = new BookRepository();
            if (rp.update(editedBook)){
                bttBack(null);
            }else {
                System.out.println("Error");
            }

        }catch (Exception e){

            System.out.println(e.getMessage());
        }

    }

    public void bttBack(ActionEvent actionEvent)throws Exception {
        Parent listBook = FXMLLoader.load(getClass().getResource("../listbook/list.fxml"));
        Main.rootStage.setTitle("Books");
        Main.rootStage.setScene(new Scene(listBook,800,600));
    }

    public void delete(ActionEvent actionEvent) {
        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Delete Book?");
            alert.setHeaderText("Are you sure delete book: "+editedBook.getName());
            Optional<ButtonType> option = alert.showAndWait();

            if (option.get()==ButtonType.OK) {
                BookRepository rp = new BookRepository();
                if (rp.delete(editedBook)) {
                    bttBack(null);
                } else {
                    System.out.println("Error");
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
