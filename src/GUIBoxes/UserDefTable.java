package GUIBoxes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import commands.MakeUserInstruction;
import commands.Command;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.Pane;

public class UserDefTable implements GUIBoxes {

	private TableView table;

	private Pane thisPane;
	private final static int NAMECOLWIDTH = 65;
	private final static int VALCOLWIDTH = 133;
	private String tableType;
		
	public UserDefTable(Pane pane, double[] properties, String type) {
		thisPane = pane;
		setTableType(type);
		setTable(new TableView<>());
		setupTableProperties(properties[0], properties[1], properties[2], properties[3]);
		thisPane.getChildren().add(getTable());
	}

	

	private void setupTableProperties(double xPos, double yPos, double width, double height) {
		getTable().setEditable(false);
		getTable().setLayoutX(xPos);
		getTable().setLayoutY(yPos);
		getTable().setMaxWidth(width);
		getTable().setMaxHeight(height);
	}

	public void updateBox() {
//		root.getChildren().remove(table);
//		root.getChildren().add(table);
	}

	public void updateVars(Map<String, Double> variableMap) {
		List<TableInsertion> insertionList = new ArrayList<>();
		for (String key : variableMap.keySet()) {
			insertionList.add(new TableInsertion(key, variableMap.get(key) + ""));
		}
		ObservableList<TableInsertion> finalList = FXCollections.observableArrayList(insertionList);
		getTable().setItems(finalList);
		
	}
	
	private void setupTableColumns() {
		getTable().setEditable(true);
		TableColumn<TableInsertion, String> nameCol = new TableColumn(getTableType());
		nameCol.setCellValueFactory(new PropertyValueFactory("VarName"));
		nameCol.setMinWidth(NAMECOLWIDTH);
		nameCol.setMaxWidth(NAMECOLWIDTH);
		nameCol.setResizable(false);

		TableColumn<TableInsertion, String> valCol = new TableColumn("Value");
		valCol.setMinWidth(VALCOLWIDTH);
		valCol.setResizable(false);
		valCol.setEditable(true);

		valCol.setCellValueFactory(new PropertyValueFactory("Value"));

		

//		ObservableList<TableInsertion> data1 = FXCollections.observableArrayList(new TableInsertion("x", "90"), new TableInsertion("x", "180"));
//		table.setItems(data1);

		getTable().getColumns().addAll(nameCol, valCol);
	}

	public void updateFuncs(Map<String, Command> userCommandMap) {
		List<TableInsertion> insertionList = new ArrayList<>();
		for (String key : userCommandMap.keySet()) {
			MakeUserInstruction userCommand = (MakeUserInstruction) userCommandMap.get(key);
			System.out.println("ojipij" +  userCommand.toString());
			insertionList.add(new TableInsertion(key, userCommand.toString()));
		}
		ObservableList<TableInsertion> finalList = FXCollections.observableArrayList(insertionList);
		getTable().setItems(finalList);
		
	}

	public TableView getTable() {
		return table;
	}

	public void setTable(TableView table) {
		this.table = table;
	}

	public String getTableType() {
		return tableType;
	}

	public void setTableType(String tableType) {
		this.tableType = tableType;
	}

}
