package GUIBoxes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import commands.Command;
import commands.MakeUserInstruction;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 * Subclass of UserDefinedTable - this table stores all of the commands defined
 * by the user
 * 
 * @author Calvin Ma
 *
 */
public class CommandTable extends UserDefTable {

	private final static int NAMECOLWIDTH = 65;
	private final static int VALCOLWIDTH = 133;
	private final static String VARCOLUMNLABEL = "VarName";
	private final static String VALCOLUMNLABEL = "Value";

	/**
	 * Constructor for command table - check superclass for the paramters
	 * 
	 * @param pane
	 * @param properties
	 * @param type
	 */

	public CommandTable(Pane pane, double[] properties, String type) {
		super(pane, properties, type);

		setupTableColumns();

	}

	/**
	 * sets up the columns on this table including title and width
	 */
	private void setupTableColumns() {
		getTable().setEditable(true);
		TableColumn<TableInsertion, String> nameCol = new TableColumn(getTableType());
		nameCol.setCellValueFactory(new PropertyValueFactory(VARCOLUMNLABEL));
		nameCol.setMinWidth(NAMECOLWIDTH);
		nameCol.setMaxWidth(NAMECOLWIDTH);
		nameCol.setResizable(false);

		TableColumn<TableInsertion, String> valCol = new TableColumn(VALCOLUMNLABEL);
		valCol.setCellValueFactory(new PropertyValueFactory(VALCOLUMNLABEL));
		valCol.setMinWidth(VALCOLWIDTH);
		valCol.setResizable(false);
		valCol.setEditable(false);

		// ObservableList<TableInsertion> data1 = FXCollections.observableArrayList(new
		// TableInsertion("x", "90"), new TableInsertion("x", "180"));
		// table.setItems(data1);

		getTable().getColumns().addAll(nameCol, valCol);
	}

	/**
	 * sets up the properties of the table. values are read in from gui class that
	 * holds all gui objects
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
		setupAction();
	}

	private void setupAction() {
		
		getTable().setOnMousePressed(new EventHandler<MouseEvent>() {
			   @Override 
			   public void handle(MouseEvent ee) {
			      if (ee.isPrimaryButtonDown() && ee.getClickCount() == 2) {
			         System.out.println(getTable().getSelectionModel().getSelectedItem());                   
			      }
			   }
			});
		
	}

	/**
	 * when this function is called, the value column (the commands that variables
	 * are defined as) will update based on the commandMap that contains the
	 * variable with its corresponding command/commands
	 */


}
