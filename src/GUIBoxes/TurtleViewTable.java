package GUIBoxes;

import java.util.ArrayList;
import java.util.List;

import Turtle.Turtle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.Pane;

/**
 * Displays Table of Turtles in GUI
 *
 */
public class TurtleViewTable extends TableView implements GUIBoxes{
	private TableView table;
	
	private Pane thisPane;
	private final static int ACTIVECOLWIDTH = 50;
	private final static int IDCOLWIDTH = 25;
	private final static int POSCOLWIDTH = 50;
	private final static int HEADINGCOLWIDTH = 75;
	private final static int PENCOLWIDTH = 65;
	private List<Turtle> turtles;
	
	public TurtleViewTable(Pane pane, double[] properties, List<Turtle> turtles) {
		thisPane = pane;
		this.turtles = turtles;
		table = new TableView<>();
		setupTableProperties(properties[0], properties[1], properties[2], properties[3]);
		setupTableColumns();
		thisPane.getChildren().add(table);
	}
	
	private void setupStringColumn(TableColumn<TurtleListInsertion, String> col, double width) {
		col.setMinWidth(width);
		col.setMaxWidth(width);
		col.setResizable(false);
	}
	
	private void setupBooleanColumn(TableColumn<TurtleListInsertion, Boolean> col, double width) {
		col.setMinWidth(width);
		col.setMaxWidth(width);
		col.setResizable(false);
	}
	
	private void setupTableColumns() {
		table.setEditable(true);
		
		TableColumn<TurtleListInsertion, Boolean> activeCol = new TableColumn("Active");
		activeCol.setCellValueFactory(f -> f.getValue().isActive());
		activeCol.setCellFactory(tc -> new CheckBoxTableCell<>());
		setupBooleanColumn(activeCol, ACTIVECOLWIDTH);
		activeCol.setEditable(true);
		activeCol.setOnEditCommit((CellEditEvent<TurtleListInsertion, Boolean> t) -> {
			((TurtleListInsertion) t.getTableView().getItems().get(t.getTablePosition().getRow())).setActive(t.getNewValue());
		});
		
		TableColumn<TurtleListInsertion, String> idCol = new TableColumn("ID");
		idCol.setCellValueFactory(f -> f.getValue().getId());
		setupStringColumn(idCol, IDCOLWIDTH);
		
		TableColumn<TurtleListInsertion, String> xposCol = new TableColumn("X");
		xposCol.setCellValueFactory(f -> f.getValue().getXpos());
		setupStringColumn(xposCol, POSCOLWIDTH);
		xposCol.setEditable(true);
		xposCol.setCellFactory(TextFieldTableCell.<TurtleListInsertion>forTableColumn());
		xposCol.setOnEditCommit((CellEditEvent<TurtleListInsertion, String> t) -> {
			((TurtleListInsertion) t.getTableView().getItems().get(t.getTablePosition().getRow())).setXpos(Double.parseDouble(t.getNewValue()));
		});
		
		TableColumn<TurtleListInsertion, String> yposCol = new TableColumn("Y");
		yposCol.setCellValueFactory(f -> f.getValue().getYpos());
		setupStringColumn(yposCol, POSCOLWIDTH);
		yposCol.setEditable(true);
		yposCol.setCellFactory(TextFieldTableCell.<TurtleListInsertion>forTableColumn());
		yposCol.setOnEditCommit((CellEditEvent<TurtleListInsertion, String> t) -> {
			((TurtleListInsertion) t.getTableView().getItems().get(t.getTablePosition().getRow())).setYpos(Double.parseDouble(t.getNewValue()));
		});
		
		TableColumn<TurtleListInsertion, String> headingCol = new TableColumn("Heading");
		headingCol.setCellValueFactory(f -> f.getValue().getHeading());
		setupStringColumn(headingCol, HEADINGCOLWIDTH);
		headingCol.setEditable(true);
		headingCol.setCellFactory(TextFieldTableCell.<TurtleListInsertion>forTableColumn());
		headingCol.setOnEditCommit((CellEditEvent<TurtleListInsertion, String> t) -> {
			((TurtleListInsertion) t.getTableView().getItems().get(t.getTablePosition().getRow())).setHeading(Double.parseDouble(t.getNewValue()));
		});
		
		TableColumn<TurtleListInsertion, Boolean> penUpCol = new TableColumn("Pen Down");
		penUpCol.setCellValueFactory(f -> f.getValue().isPenActive());
		penUpCol.setCellFactory(tc -> new CheckBoxTableCell<>());
		setupBooleanColumn(penUpCol, PENCOLWIDTH);
		penUpCol.setEditable(true);
		penUpCol.setOnEditCommit((CellEditEvent<TurtleListInsertion, Boolean> t) -> {
			((TurtleListInsertion) t.getTableView().getItems().get(t.getTablePosition().getRow())).setPenActive(t.getNewValue());
		});
		
		TableColumn<TurtleListInsertion, String> penColorCol = new TableColumn("Color");
		penColorCol.setCellValueFactory(f -> f.getValue().getPenColor());
		setupStringColumn(penColorCol, PENCOLWIDTH);
		penColorCol.setEditable(true);
		penColorCol.setCellFactory(TextFieldTableCell.<TurtleListInsertion>forTableColumn());
		penColorCol.setOnEditCommit((CellEditEvent<TurtleListInsertion, String> t) -> {
			((TurtleListInsertion) t.getTableView().getItems().get(t.getTablePosition().getRow())).setPenColor(t.getNewValue());
		});
		
		TableColumn<TurtleListInsertion, String> penThickCol = new TableColumn("Thickness");
		penThickCol.setCellValueFactory(f -> f.getValue().getPenThickness());
		setupStringColumn(penThickCol, PENCOLWIDTH);
		penThickCol.setEditable(true);
		penThickCol.setCellFactory(TextFieldTableCell.<TurtleListInsertion>forTableColumn());
		penThickCol.setOnEditCommit((CellEditEvent<TurtleListInsertion, String> t) -> {
			((TurtleListInsertion) t.getTableView().getItems().get(t.getTablePosition().getRow())).setPenThickness(Double.parseDouble(t.getNewValue()));
		});
		
		//ObservableList<TurtleListInsertion> data = FXCollections.observableArrayList(new TurtleListInsertion(true, 1, turtles.get(0).getX(), turtles.get(0).getY(), turtles.get(0).getOrientation(), turtles.get(0).getPenDown(), "TEMP", 0.0));
				
		//table.setItems(data);
		table.getColumns().addAll(activeCol, idCol, xposCol, yposCol, headingCol, penUpCol, penColorCol, penThickCol);
	
		
	}

	
	private void setupTableProperties(double xPos, double yPos, double width, double height) {
		table.setEditable(false);
		table.setLayoutX(xPos);
		table.setLayoutY(yPos);
		table.setMaxWidth(width);
		table.setMaxHeight(height);
	}
	
	@Override
	public void updateBox() {
		//thisPane.getChildren().remove(table);
		//thisPane.getChildren().add(table);
	}
	
	public void updateTurtles(List<Turtle> tlist) {
		List<TurtleListInsertion> insertionList = new ArrayList<>();
		for (Turtle t : tlist) {
			insertionList.add(new TurtleListInsertion(t, t.getActive(), t.getID(), t.getX(), t.getY(), t.getOrientation(), t.getPenDown(), "Black", 0.0));
		}
		ObservableList<TurtleListInsertion> finalList = FXCollections.observableArrayList(insertionList);
		table.setItems(finalList);
		
		
	}

}
