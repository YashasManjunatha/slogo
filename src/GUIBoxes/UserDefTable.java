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
	private final static int NAMECOLWIDTH = 65;
	private final static int VALCOLWIDTH = 133;
	private String tableType;
	
	public UserDefTable(Group root, double[] properties, String type) {
		this.root = root;
		tableType = type;
		table = new TableView<>();
		setupTableProperties(properties[0], properties[1], properties[2], properties[3]);
		setupTableColumns();
		root.getChildren().add(table);

	}
	
	
	private void setupTableColumns() {
		TableColumn nameCol = new TableColumn(tableType);
		nameCol.setCellValueFactory(new PropertyValueFactory<TableInsertion, String>("VarName"));
		nameCol.setMinWidth(NAMECOLWIDTH);
		nameCol.setMaxWidth(NAMECOLWIDTH);
		nameCol.setResizable(false);
		TableColumn valCol= new TableColumn("Value");
		valCol.setMinWidth(VALCOLWIDTH);
		valCol.setResizable(false);

		valCol.setCellValueFactory(new PropertyValueFactory<TableInsertion, String>("Value"));
		ObservableList<TableInsertion> data = FXCollections.observableArrayList(new TableInsertion("x", "90"));
		table.setItems(data);
		table.getColumns().addAll(nameCol, valCol);		
	}

	private void setupTableProperties(double xPos, double yPos, double width, double height) {
		table.setEditable(false);
		table.setLayoutX(xPos);
		table.setLayoutY(yPos);
		table.setMaxWidth(width);
		table.setMaxHeight(height);
	}

	
	public void updateBox() {
		root.getChildren().remove(table);
		root.getChildren().add(table);
	}

}
