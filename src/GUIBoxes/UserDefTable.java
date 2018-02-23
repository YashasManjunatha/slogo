package GUIBoxes;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class UserDefTable implements GUIBoxes{
	
	private TableView table;

	private static Group root;
	
	public UserDefTable(Group root) {
		this.root = root;
		table = new TableView<>();
		setupTable();
		root.getChildren().add(table);

	}
	


	private void setupTable() {
		table.setEditable(false);
		table.setLayoutX(700);
		table.setLayoutY(25);
		table.setMaxWidth(200);
		table.setMaxHeight(175);
		TableColumn nameCol = new TableColumn("Variable Name");
		nameCol.setCellValueFactory(new PropertyValueFactory<TableInsertion, String>("VarName"));
		nameCol.setMinWidth(75);
		nameCol.setMaxWidth(150);
		TableColumn  valCol= new TableColumn("Value");
		valCol.setMinWidth(75);
		valCol.setMaxWidth(200-nameCol.getWidth());
		valCol.setCellValueFactory(new PropertyValueFactory<TableInsertion, String>("Value"));
		ObservableList<TableInsertion> data = FXCollections.observableArrayList(new TableInsertion("x", "90"));
		table.setItems(data);
		table.getColumns().addAll(nameCol, valCol);
	}

	
	public void updateBox() {
		root.getChildren().remove(table);
		root.getChildren().add(table);
	}

}
