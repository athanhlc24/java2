package assigment1.bookrent.list;

import assigment1.Main;
import assigment1.entities.BookRent;
import assigment1.enums.RepoType;
import assigment1.factory.RepositoryFactory;
import assigment1.dao.impls.BookRentRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public TableView<BookRent> tbRents;
    public TableColumn<BookRent,Integer> tdId;
    public TableColumn<BookRent,String> tdBook;
    public TableColumn<BookRent,String> tdStudent;
    public TableColumn<BookRent, Date> tdRentDate;
    public TableColumn<BookRent,String> tdStatus;
    public TableColumn<BookRent,Date> tdExpired;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tdId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tdBook.setCellValueFactory(new PropertyValueFactory<>("bookName"));
        tdStudent.setCellValueFactory(new PropertyValueFactory<>("studentName"));
        tdRentDate.setCellValueFactory(new PropertyValueFactory<>("rentDate"));
        tdExpired.setCellValueFactory(new PropertyValueFactory<>("expiredDate"));
        tdStatus.setCellValueFactory(new PropertyValueFactory<>("statusLabel"));
        BookRentRepository brr = (BookRentRepository)RepositoryFactory.createRepository(RepoType.BOOKRENT);
        tbRents.getItems().addAll(brr.all());
    }


    public void onToBack(ActionEvent actionEvent) throws Exception{
        Parent listBook = FXMLLoader.load(getClass().getResource("../../home.fxml"));
        Main.rootStage.setTitle("Books");
        Main.rootStage.setScene(new Scene(listBook,800,600));
    }

    public void bttAdd(ActionEvent actionEvent)throws Exception {
        Parent listBook = FXMLLoader.load(getClass().getResource("../create/create.fxml"));
        Main.rootStage.setTitle("Books");
        Main.rootStage.setScene(new Scene(listBook,800,600));
    }
}
