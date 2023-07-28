import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Controller implements Initializable{
    @FXML
    private ImageView myImageView;

    @FXML
    private Button rightBtn, leftBtn, proceedBtn;

    @FXML
    private Circle circle1, circle2, circle3, circle4;

    //Global variables
    //regular vars
    int cnt = 0;
    private Circle[] circles;
    private String[] imageAddresses = {"/Images/bank1.jpg", "/Images/bank2.jpg", "/Images/bank3.jpg", "/Images/bank4.jpg"};

    //fx vars
    private Parent root;
    private Scene scene;
    private Stage stage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        myImageView.setImage(new Image(getClass().getResourceAsStream(imageAddresses[0])));
        circles = new Circle[]{circle1, circle2, circle3, circle4};
        if(cnt == 0){
            leftBtn.setStyle("-fx-opacity: 0;");
        }
    }

    public void changeScene(ActionEvent ae){
        System.out.println("Scene Changed");
    }

    public void nextImg(ActionEvent ae){
            try {
                if(cnt < imageAddresses.length){
                    cnt++;
                    leftBtn.setStyle("-fx-opacity: 2; -fx-background-color:  linear-gradient(to top left, #298a4c, #bcaf1e); -fx-background-radius: 0; -fx-background-radius: bold");
                    myImageView.setImage(new Image(getClass().getResourceAsStream(imageAddresses[cnt])));
                    circles[cnt].setStyle("-fx-fill: #f0f8ff; -fx-stroke-width: 1;");
                    circles[cnt-1].setStyle("-fx-fill: #550db4; -fx-stroke-width: 0;");
                }
            }
            catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Error: "+e+":Array Size Overflow!");
                cnt = 3;
                myImageView.setImage(new Image(getClass().getResourceAsStream(imageAddresses[cnt])));
                circles[cnt].setStyle("-fx-fill: #f0f8ff; -fx-stroke-width: 1;");
            }
            
    }

    public void prevImg(ActionEvent ae){
        try {
            if(cnt >= 0){
                // if(cnt == 3){
                //     rightBtn.setStyle("-fx-opacity: 0;");
                // }
                cnt--;
                // rightBtn.setStyle("-fx-opacity: 1; -fx-background-color:  linear-gradient(to top left, #298a4c, #bcaf1e); -fx-background-radius: 0; -fx-background-radius: bold");
                myImageView.setImage(new Image(getClass().getResourceAsStream(imageAddresses[cnt])));
                circles[cnt].setStyle("-fx-fill: #f0f8ff; -fx-stroke-width: 1;");
                circles[cnt+1].setStyle("-fx-fill: #550db4; -fx-stroke-width: 0;");         
            }    
        } catch (Exception e) {
            System.out.println("Error: "+e+":Array Size Underflow!");
            cnt = 0;
            myImageView.setImage(new Image(getClass().getResourceAsStream(imageAddresses[cnt])));
            circles[cnt].setStyle("-fx-fill: #f0f8ff; -fx-stroke-width: 1;");
        }
        
    }

}
