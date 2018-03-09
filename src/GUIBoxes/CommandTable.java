package GUIBoxes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import commands.Command;
import commands.MakeUserInstruction;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

public class CommandTable extends UserDefTable {

	private final static int NAMECOLWIDTH = 65;
	private final static int VALCOLWIDTH = 133;
	
	public CommandTable(Pane pane, double[] properties, String type) {
		super(pane, properties, type);
		
		setupTableColumns();
		
		
		
	}
	
	private void setupTableColumns() {
		getTable().setEditable(true);
		TableColumn<TableInsertion, String> nameCol = new TableColumn(getTableType());
		nameCol.setCellValueFactory(new PropertyValueFactory("VarName"));
		nameCol.setMinWidth(NAMECOLWIDTH);
		nameCol.setMaxWidth(NAMECOLWIDTH);
		nameCol.setResizable(false);

		TableColumn<TableInsertion, String> valCol = new TableColumn("Value");
		valCol.setCellValueFactory(new PropertyValueFactory("Value"));
		valCol.setMinWidth(VALCOLWIDTH);
		valCol.setResizable(false);
		valCol.setEditable(false);
		

//		ObservableList<TableInsertion> data1 = FXCollections.observableArrayList(new TableInsertion("x", "90"), new TableInsertion("x", "180"));
//		table.setItems(data1);

		getTable().getColumns().addAll(nameCol, valCol);
	}
	
	private void setupTableProperties(double xPos, double yPos, double width, double height) {
		getTable().setEditable(false);
		getTable().setLayoutX(xPos);
		getTable().setLayoutY(yPos);
		getTable().setMaxWidth(width);
		getTable().setMaxHeight(height);
	}

	public void updateFuncs(Map<String, Command> userCommandMap) {
		List<TableInsertion> insertionList = new ArrayList<>();
		System.out.println("ASDFOAUSHOFIASHDOIH");
		for (String key : userCommandMap.keySet()) {
			MakeUserInstruction userCommand = (MakeUserInstruction) userCommandMap.get(key);
			System.out.println("ojipij" +  userCommand.toString());
			insertionList.add(new TableInsertion(key, userCommand.toString()));
		}
		ObservableList<TableInsertion> finalList = FXCollections.observableArrayList(insertionList);
		getTable().setItems(finalList);
		
	}
	

}
