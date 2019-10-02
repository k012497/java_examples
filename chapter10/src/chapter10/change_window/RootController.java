package chapter10.change_window;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class RootController implements Initializable {
	@FXML private Button btnLogin;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btnLogin.setOnAction((e)->{
			handleButtonLoginAction(e);
		});
	}
	
	//로그인 화면을 보여주는 이벤트 처리 함수 
	public void handleButtonLoginAction(ActionEvent e) {
		try {
			//root.fxml에 있는 최상위 루트 컨테이너 객체 값을 가져온다. 
			StackPane root = (StackPane) btnLogin.getScene().getRoot();
			//login.fxml을 로더하고 최상위 루트 컨테이너 객체 값을 가져온다.
			Parent login = FXMLLoader.load(getClass().getResource("login.fxml"));
			root.getChildren().add(login);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
