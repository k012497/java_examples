package chapter10.view_control_test;

import java.net.URL;
import java.util.ResourceBundle;

import chapter10.view_control.Phone;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class RootController implements Initializable {
	@FXML private ListView<String> listView;
	@FXML private TableView<Phone> tableView;
	@FXML private ImageView imageView;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		insertTableViewItemAndEventProcess();
		insertListViewItemAndEventProcess();
	}

	private void insertTableViewItemAndEventProcess() {
		ObservableList<Phone> tableViewData = FXCollections.observableArrayList();
		tableViewData.add(new Phone("phone01", "phone01.png"));
		tableViewData.add(new Phone("phone02", "phone02.png"));
		tableViewData.add(new Phone("phone03", "phone03.png"));
		tableViewData.add(new Phone("phone04", "phone04.png"));
		tableViewData.add(new Phone("phone05", "phone05.png"));
		tableViewData.add(new Phone("phone06", "phone06.png"));
		tableViewData.add(new Phone("phone07", "phone07.png"));
		
		TableColumn tcSmartPhone = tableView.getColumns().get(0);
		tcSmartPhone.setCellValueFactory(new PropertyValueFactory("smartPhone"));
		TableColumn tcImage = tableView.getColumns().get(1);
		tcImage.setCellValueFactory(new PropertyValueFactory("image"));
		
		tableView.setItems(tableViewData);
		
		tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Phone>() {

			@Override
			public void changed(ObservableValue<? extends Phone> observable, Phone oldValue, Phone phone) {
				imageView.setImage(new Image(getClass().getResource("images/" + phone.getImage()).toString()));
			}
		});
		
	}

	private void insertListViewItemAndEventProcess() {
		ObservableList<String> listViewData = FXCollections.observableArrayList();
		listViewData.add("phone01");
		listViewData.add("phone02");
		listViewData.add("phone03");
		listViewData.add("phone04");
		listViewData.add("phone05");
		listViewData.add("phone06");
		listViewData.add("phone07");
		
		listView.setItems(listViewData);
		
		listView.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				tableView.getSelectionModel().select(newValue.intValue());
				tableView.scrollTo(newValue.intValue());
			}
		});
		
	}
	
	public void handlerButtonOkAction() {
		System.out.println(listView.getSelectionModel().getSelectedItem());
		System.out.println(tableView.getSelectionModel().getSelectedItem());
	}
	public void handlerButtonExitAction() {
		Platform.exit();
	}
	
}
