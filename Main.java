package application;

import javafx.application.Application;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main extends Application {
	@Override
	public void start(Stage stage) throws IOException {
		LL Gazall = new LL();
		BufferedReader br = null;
		String line = "";
		String sp = ",";
		LL westBankll = new LL();

		try {
			br = new BufferedReader(new FileReader("C:\\Users\\tabak\\Downloads\\gaza22final.txt"));
			while ((line = br.readLine()) != null) {
				// use comma as separator
				String[] student = line.split(sp);
				Nodee nodee = new Nodee(Integer.parseInt(student[0]), student[1], Double.parseDouble(student[2]));
				Gazall.insert(nodee);
			}
			// print ll
			Gazall.sort();

			br = new BufferedReader(new FileReader("C:\\Users\\tabak\\Downloads\\westbank22final.txt"));
			while ((line = br.readLine()) != null) {
				// use comma as separator
				String[] student = line.split(sp);
				Nodee nodee = new Nodee(Integer.parseInt(student[0]), student[1], Double.parseDouble(student[2]));
				westBankll.insert(nodee);
			}
			// print ll
			westBankll.sort();

		} catch (IOException e) {

		}

		Pane root = new Pane();

		TabPane tabPane = new TabPane();
		tabPane.setTabMinWidth(500);
		Tab tab1 = new Tab("Gaza");
		Tab tab2 = new Tab("Westbank");

		tabPane.getTabs().add(tab1);
		tabPane.getTabs().add(tab2);
		// adding a choice box in type String
		ChoiceBox<String> choiceBox = new ChoiceBox<>();
		choiceBox.getItems().add("Scientific");
		choiceBox.getItems().add("Literary");

		choiceBox.setLayoutX(10);
		choiceBox.setLayoutY(10);
		choiceBox.setPrefWidth(100);
		choiceBox.setPrefHeight(30);

		// insert a button in tab

		// create a form in tab1 to add new student
		GridPane grid = new GridPane();
		// adding the space between the textfield and the label
		grid.setHgap(10);
		grid.setVgap(10);

		// creating the text fields and labels for the add student field
		grid.setPadding(new Insets(100, 100, 100, 100));
		Text scenetitle = new Text("Add new student");
		grid.add(scenetitle, 0, 0, 2, 1);
		Label seatnumber = new Label("Seatnumber:");
		grid.add(seatnumber, 0, 1);
		TextField seatnumberTextField = new TextField();
		grid.add(seatnumberTextField, 1, 1);
		Label choiceboxlabel = new Label("select the branch you want to search for");
		Label branch = new Label("Branch:");
		grid.add(branch, 0, 2);
		TextField branchTextField = new TextField();
		grid.add(branchTextField, 1, 2);
		Label average = new Label("Average:");
		grid.add(average, 0, 3);
		TextField averageTextField = new TextField();
		grid.add(averageTextField, 1, 3);
		// adding the button add
		Button btn1 = new Button("Add");
		HBox hbBtn = new HBox(10);
		btn1.setLayoutX(400);
		btn1.setLayoutY(300);

		hbBtn.getChildren().add(btn1);
		grid.add(hbBtn, 1, 4);
		tab1.setContent(grid);
		// inserting the choice box for the branch
		grid.add(choiceBox, 1, 4);

		// create a button in tab1 to show mean
		Button btn2 = new Button("Show mean");
		HBox hbBtn2 = new HBox(10);
		hbBtn2.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn2.getChildren().add(btn2);
		grid.add(hbBtn2, 1, 5);
		tab1.setContent(grid);
		// create a button in tab1 to show mode
		Button btn3 = new Button("Show mode");
		HBox hbBtn3 = new HBox(10);
		hbBtn3.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn3.getChildren().add(btn3);
		grid.add(hbBtn3, 1, 6);
		tab1.setContent(grid);
		// create label to show result
		Label result = new Label();
		result.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
		grid.add(result, 1, 2);
		tab1.setContent(grid);
		// create a delete button with textfield to delete student
		Button btn4 = new Button("Delete");
		HBox hbBtn4 = new HBox(10);
		hbBtn4.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn4.getChildren().add(btn4);
		grid.add(hbBtn4, 1, 8);
		tab1.setContent(grid);
		TextField deleteTextField = new TextField();
		grid.add(deleteTextField, 1, 9);
		tab1.setContent(grid);
		// create a search button with textfield to search student
		Button btn5 = new Button("Search");
		HBox hbBtn5 = new HBox(10);
		hbBtn5.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn5.getChildren().add(btn5);
		grid.add(hbBtn5, 1, 10);
		tab1.setContent(grid);
		TextField searchTextField = new TextField();
		grid.add(searchTextField, 1, 11);
		tab1.setContent(grid);
		// create a search button with textfield to show result of above method
		Button btn6 = new Button("Above");
		HBox hbBtn6 = new HBox(10);
		hbBtn6.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn6.getChildren().add(btn6);
		grid.add(hbBtn6, 1, 12);
		tab1.setContent(grid);
		TextField aboveTextField = new TextField();
		grid.add(aboveTextField, 1, 13);
		tab1.setContent(grid);
		// create a button to show top ten
		Button btn7 = new Button("Top ten");
		HBox hbBtn7 = new HBox(10);
		hbBtn7.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn7.getChildren().add(btn7);

		grid.add(hbBtn7, 1, 15);
		VBox first = new VBox(scenetitle, seatnumber, seatnumberTextField, branch, branchTextField, average,
				averageTextField, btn1, choiceboxlabel, choiceBox, deleteTextField, btn4, searchTextField, btn5,
				aboveTextField, btn6, btn7, btn2, btn3);
		first.setAlignment(Pos.TOP_LEFT);
		first.setSpacing(10);
		grid.add(first, 0, 0);

		tab1.setContent(grid);

		// creating a new tab with the same content for west bank in tab2
		// creating a choice box with type string
		ChoiceBox<String> choiceBox2 = new ChoiceBox<>();
		choiceBox2.getItems().add("Scientific");
		choiceBox2.getItems().add("Literary");

		choiceBox2.setLayoutX(10);
		choiceBox2.setLayoutY(10);
		choiceBox2.setPrefWidth(100);
		choiceBox2.setPrefHeight(30);

		// adding the choice box in tab2
		tab2.setContent(choiceBox2);
		GridPane grid2 = new GridPane();
		grid2.setHgap(10);
		grid2.setVgap(10);
		// adding the new Student fileds
		grid2.setPadding(new Insets(25, 25, 25, 25));
		Text scenetitle2 = new Text("Add new student");
		grid2.add(scenetitle2, 0, 0, 2, 1);
		// adding the seat number label and textfield
		Label seatnumber2 = new Label("Seatnumber:");
		grid2.add(seatnumber2, 0, 1);
		TextField seatnumberTextField2 = new TextField();
		grid2.add(seatnumberTextField2, 1, 1);
		// adding the branch label and textfield
		Label choiceboxlabel2 = new Label("select the branch");
		Label branch2 = new Label("Branch:");
		grid2.add(branch2, 0, 2);
		TextField branchTextField2 = new TextField();
		grid2.add(branchTextField2, 1, 2);
		// adding the average label and textfield
		Label average2 = new Label("Average:");
		grid2.add(average2, 0, 3);
		TextField averageTextField2 = new TextField();
		grid2.add(averageTextField2, 1, 3);
		// adding the add button
		Button btn8 = new Button("Add");
		HBox hbBtn8 = new HBox(10);
		hbBtn8.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn8.getChildren().add(btn8);
		grid2.add(hbBtn8, 1, 4);
		tab2.setContent(grid2);
		grid2.add(choiceBox2, 1, 4);

		// create a button in tab2 to show mean
		Button btn9 = new Button("Show mean");
		HBox hbBtn9 = new HBox(10);
		hbBtn9.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn9.getChildren().add(btn9);
		grid2.add(hbBtn9, 1, 5);
		tab2.setContent(grid2);
		// create a button in tab2 to show mode
		Button btn10 = new Button("Show mode");
		HBox hbBtn10 = new HBox(10);
		hbBtn10.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn10.getChildren().add(btn10);
		grid2.add(hbBtn10, 1, 6);
		tab2.setContent(grid2);
		// create label to show result
		Label result2 = new Label();
		result2.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

		grid2.add(result2, 1, 5);
		tab2.setContent(grid2);
		// create a delete button with textfield to delete student
		Button btn11 = new Button("Delete");
		HBox hbBtn11 = new HBox(10);
		hbBtn11.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn11.getChildren().add(btn11);
		grid2.add(hbBtn11, 1, 8);
		tab2.setContent(grid2);
		TextField deleteTextField2 = new TextField();
		grid2.add(deleteTextField2, 1, 9);
		tab2.setContent(grid2);
		// create a search button with textfield to search student
		Button btn12 = new Button("Search");
		HBox hbBtn12 = new HBox(10);
		hbBtn12.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn12.getChildren().add(btn12);
		grid2.add(hbBtn12, 1, 10);
		tab2.setContent(grid2);
		TextField searchTextField2 = new TextField();
		grid2.add(searchTextField2, 1, 11);
		tab2.setContent(grid2);
		// create a search button with textfield to show result of above method
		Button btn13 = new Button("Above");
		HBox hbBtn13 = new HBox(10);
		hbBtn13.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn13.getChildren().add(btn13);
		grid2.add(hbBtn13, 1, 12);
		tab2.setContent(grid2);
		TextField aboveTextField2 = new TextField();
		grid2.add(aboveTextField2, 1, 13);
		tab2.setContent(grid2);
		// create a button to show top ten
		Button btn14 = new Button("Top ten");
		HBox hbBtn14 = new HBox(10);
		hbBtn14.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn14.getChildren().add(btn14);
		grid2.add(hbBtn14, 1, 15);
		tab2.setContent(grid2);
		VBox second = new VBox(scenetitle2, seatnumber2, seatnumberTextField2, branch2, branchTextField2, average2,
				averageTextField2, btn8, choiceboxlabel2, choiceBox2, deleteTextField2, btn11, searchTextField2, btn12,
				aboveTextField2, btn13, btn14, btn9, btn10);
		second.setAlignment(Pos.TOP_LEFT);
		second.setSpacing(10);
		grid2.add(second, 0, 0);
		root.getChildren().add(tabPane);
		tab2.setContent(grid2);

		Scene scene = new Scene(root, 1000, 1000);

		stage.setScene(scene);
		stage.show();

		btn1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				int seatnumber = Integer.parseInt(seatnumberTextField.getText());
				String branch = branchTextField.getText();
				double average = Double.parseDouble(averageTextField.getText());
				Gazall.insert(new Nodee(seatnumber, branch, average));
				result.setText("Student added successfully");
				Gazall.sort();
			}
		});

		btn2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

				double mean = Gazall.mean();
				result.setText(String.valueOf(mean));
			}
		});
		btn3.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				String branch = choiceBox.getValue();
				double mod = Gazall.mode();
				result.setText(String.valueOf(mod));
			}
		});

		btn4.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				int seatnumber = Integer.parseInt(deleteTextField.getText());
				if (Gazall.search(seatnumber) != null) {
					Gazall.delete(seatnumber);
					result.setText("Student deleted successfully");
				} else {
					result.setText("Student not found");
				}
			}

		});

		btn5.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				int seatnumber = Integer.parseInt(searchTextField.getText());
				if (Gazall.search(seatnumber) != null) {
					Nodee Nodee = Gazall.search(seatnumber);
					result.setText(Nodee.getSeatnumber() + " " + Nodee.getBranch() + " " + Nodee.getAverage());
				} else {
					result.setText("Student not found");
				}

			}
		});

		btn6.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				String branch = choiceBox.getSelectionModel().getSelectedItem();
				double average = Double.parseDouble(aboveTextField.getText());
				Gazall.above(average, branch);
				result.setText(Gazall.above(average, branch));
			}
		});

		btn7.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// serialize the linked list
				String branch = choiceBox.getSelectionModel().getSelectedItem();
				LL topTen = Gazall.topTen(branch);
				Nodee topHead = topTen.getHead();
				String topTenString = "";
				while (topHead != null) {
					topTenString = topTenString + topHead.getSeatnumber() + " " + topHead.getBranch() + " "
							+ topHead.getAverage() + '\n';
					topHead = topHead.next;
				}
				result.setMinHeight(200);
				result.setText(topTenString);

			}
		});

		btn8.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				int seatnumber = Integer.parseInt(seatnumberTextField2.getText());
				String branch = branchTextField2.getText();
				double average = Double.parseDouble(averageTextField2.getText());
				westBankll.insert(new Nodee(seatnumber, branch, average));
				result2.setText("Student added successfully");
				westBankll.sort();
			}
		});

		btn9.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				double mean = westBankll.mean();
				result2.setText(String.valueOf(mean));
			}
		});

		btn10.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				double mod = westBankll.mode();
				result2.setText(String.valueOf(mod));
			}
		});
		btn11.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				int seatnumber = Integer.parseInt(deleteTextField2.getText());
				if (westBankll.search(seatnumber) != null) {
					westBankll.delete(seatnumber);
					result2.setText("Student deleted successfully");
				} else {
					result2.setText("Student not found");
				}
			}

		});

		btn12.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				int seatnumber = Integer.parseInt(searchTextField2.getText());
				if (westBankll.search(seatnumber) != null) {
					Nodee Nodee = westBankll.search(seatnumber);
					result2.setText(Nodee.getSeatnumber() + " " + Nodee.getBranch() + " " + Nodee.getAverage());
				} else {
					result2.setText("Student not found");
				}

			}
		});
		btn13.setOnAction(new EventHandler<ActionEvent>() {
			@Override
				public void handle(ActionEvent event) {
					String branch = choiceBox2.getSelectionModel().getSelectedItem();
					double average = Double.parseDouble(aboveTextField2.getText());
					westBankll.above(average, branch);
					result2.setText(westBankll.above(average, branch));
				}
			});


		
		btn14.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// serialize the linked list
				String branch = choiceBox2.getSelectionModel().getSelectedItem();
//                branch = "Scientific";
				LL topTen = westBankll.topTen(branch);
				Nodee topHead = topTen.getHead();
				String topTenString = "";
				while (topHead != null) {
					topTenString = topTenString + topHead.getSeatnumber() + " " + topHead.getBranch() + " "
							+ topHead.getAverage() + '\n';
					topHead = topHead.next;
				}
				result2.setMinHeight(200);
				result2.setText(topTenString);

			}
		});
	}

	public static void main(String[] args) {

		launch();
	}
}
