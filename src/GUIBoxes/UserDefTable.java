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

/**
 * superclass for user defined tables - these tables hold the variables and
 * commands that are defined by the users
 * 
 * @author Calvin
 *
 */
public class UserDefTable {

	private TableView table;

	private Pane thisPane;
	private final static int NAMECOLWIDTH = 65;
	private final static int VALCOLWIDTH = 133;
	private String tableType;

	/**
	 * Constructor for userdefinedtable
	 * 
	 * @param pane
	 *            - needs pane because once tableview is initialized, it is added to
	 *            pane
	 * @param properties
	 *            - properties for setting up tableview
	 * @param type
	 *            - String that represents type of tableview - in this case, either
	 *            variable or command
	 */
	public UserDefTable(Pane pane, double[] properties, String type) {
		thisPane = pane;
		setTableType(type);
		setTable(new TableView<>());
		setupTableProperties(properties[0], properties[1], properties[2], properties[3]);
		thisPane.getChildren().add(getTable());
	}

	/**
	 * sets up properties of table
	 * 
	 * @param xPos
	 *            - x position of table
	 * @param yPos
	 *            - y position of table
	 * @param width
	 *            - width of table
	 * @param height
	 *            - height of table
	 */
	private void setupTableProperties(double xPos, double yPos, double width, double height) {
		getTable().setEditable(false);
		getTable().setLayoutX(xPos);
		getTable().setLayoutY(yPos);
		getTable().setMaxWidth(width);
		getTable().setMaxHeight(height);
	}


	/**
	 * function that updates the table based on a variablemap
	 * 
	 * @param variableMap
	 *            - map that contains the variables and associated values
	 */
	public void updateVars(Map<String, Double> variableMap) {
		List<TableInsertion> insertionList = new ArrayList<>();
		for (String key : variableMap.keySet()) {
			insertionList.add(new TableInsertion(key, variableMap.get(key) + ""));
		}
		ObservableList<TableInsertion> finalList = FXCollections.observableArrayList(insertionList);
		getTable().setItems(finalList);

	}

	/**
	 * updates the table based on usercommandmap
	 * 
	 * @param userCommandMap
	 *            - map that maps a user defined command with its function
	 */
	

	public void updateStringFuncs(Map<String, String> userCommandMap) {
		List<TableInsertion> insertionList = new ArrayList<>();
		for (String key : userCommandMap.keySet()) {
			insertionList.add(new TableInsertion(key, userCommandMap.get(key)));
		}
		ObservableList<TableInsertion> finalList = FXCollections.observableArrayList(insertionList);
		getTable().setItems(finalList);

	}
	
	public void updateCommandFuncs(Map<String, Command> userCommandMap) {
		List<TableInsertion> insertionList = new ArrayList<>();
		for (String key : userCommandMap.keySet()) {
			MakeUserInstruction userCommand = (MakeUserInstruction) userCommandMap.get(key);
			insertionList.add(new TableInsertion(key, userCommand.toString()));
		}
		ObservableList<TableInsertion> finalList = FXCollections.observableArrayList(insertionList);
		getTable().setItems(finalList);

	}

	/**
	 * protected method that allow subclasses to access the table
	 * 
	 * @return tableview table
	 */
	protected TableView getTable() {
		return table;
	}

	/**
	 * protected method that allows subclasses to edit and set the table
	 * 
	 * @param table
	 *            - new table that will be set
	 */
	protected void setTable(TableView table) {
		this.table = table;
	}

	/**
	 * protected method that allows subclasses to get table type string
	 * 
	 * @return string that represents type of table
	 */
	protected String getTableType() {
		return tableType;
	}

	/**
	 * protected method that allows subclasses to set the table string
	 * @param tableType
	 */
	protected void setTableType(String tableType) {
		this.tableType = tableType;
	}

}
