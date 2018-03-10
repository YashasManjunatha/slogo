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

public class UserDefTable {

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

	public void updateVars(Map<String, Double> variableMap) {
		List<TableInsertion> insertionList = new ArrayList<>();
		for (String key : variableMap.keySet()) {
			insertionList.add(new TableInsertion(key, variableMap.get(key) + ""));
		}
		ObservableList<TableInsertion> finalList = FXCollections.observableArrayList(insertionList);
		getTable().setItems(finalList);
		
	}
	

	public void updateFuncs(Map<String, Command> userCommandMap) {
		List<TableInsertion> insertionList = new ArrayList<>();
		for (String key : userCommandMap.keySet()) {
			MakeUserInstruction userCommand = (MakeUserInstruction) userCommandMap.get(key);
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
