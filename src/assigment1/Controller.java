package assigment1;

import assigment1.entities.CurrentWeather;
import assigment1.services.WeatherServices;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public Text city;
    public Text temp;
    public ImageView icon;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        CurrentWeather cw = WeatherServices.getCurrentWeather();
        if (cw !=null){
            city.setText(cw.getName());
            temp.setText(cw.getMain().getTemp().toString());
            String ic = cw.getWeather().get(0).getIcon();
            Image img  = new Image("http://openweathermap.org/img/wn/"+ic+"@2x.png");
            icon.setImage(img);
        }
    }

    public void onToBook(ActionEvent actionEvent) throws Exception{
        Parent listBook = FXMLLoader.load(getClass().getResource("book/listbook/list.fxml"));
        Main.rootStage.setTitle("Books");
        Main.rootStage.setScene(new Scene(listBook,800,600));
    }



    public void onToStudent(ActionEvent actionEvent) throws Exception{
        Parent listBook = FXMLLoader.load(getClass().getResource("student/list/list.fxml"));
        Main.rootStage.setTitle("Books");
        Main.rootStage.setScene(new Scene(listBook,800,600));
    }

    public void ontoBookRent(ActionEvent actionEvent) throws Exception {
        Parent listRentBook = FXMLLoader.load(getClass().getResource("bookrent/list/list.fxml"));
        Main.rootStage.setTitle("Books");
        Main.rootStage.setScene(new Scene(listRentBook,800,600));
    }
}