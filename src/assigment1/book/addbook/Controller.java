package assigment1.book.addbook;

import assigment1.Main;
import assigment1.entities.Book;
import assigment1.dao.impls.BookRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

public class Controller {
    public TextField txtName;
    public TextField txtAuthor;
    public TextField txtQty;
    public void bttAdd(ActionEvent actionEvent) {
        try {
            String name = txtName.getText();
            String author = txtAuthor.getText();
            int qty = Integer.parseInt(txtQty.getText());
//            String sql_txt = "insert into books(name,author,qty) values(?,?,?)";
//
//            Connector conn = Connector.getInstance();
//            ArrayList arr = new ArrayList<>();
//            arr.add(name);
//            arr.add(author);
//            arr.add(qty);

//            String sql_txt2 = "select * from books where id = ?";tìm kiếm.. lọc where tham số
//            ArrayList pr = new ArrayList();
//            pr.add(1);
//            ResultSet bookwithid1 = conn.executeQuery(sql_txt2,pr);

            Book book = new Book(null,name,author,qty);
            BookRepository rp = new BookRepository();
            if (rp.create(book)){
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
