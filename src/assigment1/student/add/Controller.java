package assigment1.student.add;

import assigment1.Main;
import assigment1.entities.Student;
import assigment1.dao.impls.StudentRepository;
import assigment1.enums.RepoType;
import assigment1.factory.RepositoryFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

public class Controller {
    public TextField txtId;
    public TextField txtName;
    public TextField txtEmail;
    public TextField txtTel;

    public void bttBackToList() throws Exception{

        Parent listBook = FXMLLoader.load(getClass().getResource("../list/list.fxml"));
        Main.rootStage.setTitle("Books");
        Main.rootStage.setScene(new Scene(listBook,800,600));
    }

    public void bttAddStudent(ActionEvent actionEvent) {
        try {
            String name = txtName.getText();
            String email = txtEmail.getText();
            String tel = txtTel.getText();
            Student student = new Student(null,name,email,tel);
            StudentRepository rp = (StudentRepository) RepositoryFactory.createRepository(RepoType.STUDENT);
            if (rp.create(student)){
                bttBackToList();

            }else {
                System.out.println("Error");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
