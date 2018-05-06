package GUIBoxes;

import java.util.List;

import Turtle.Turtle;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;

public class TurtleViewTable extends TableView{
	private TableView table;
	
	private Stage mainStage;
	private Pane thisPane;
	private final static int ACTIVECOLWIDTH = 50;
	private final static int IDCOLWIDTH = 25;
	private final static int POSCOLWIDTH = 50;
	private final static int HEADINGCOLWIDTH = 75;
	private final static int PENCOLWIDTH = 60;
	private final static int ROWHEIGHT = 120;
	private final static String FILECHOOSERLABEL = "Choose Turtle Image";
	private List<Turtle> turtles;
	private int iteratingID = 1;
	private ObservableList<TurtleListInsertion> data;
	
	public TurtleViewTable(Stage stage, Pane pane, double[] properties, List<Turtle> turtles) {
		this.mainStage = stage;
		thisPane = pane;
		this.turtles = turtles;
		table = new TableView<>();
		setupTableProperties(properties[0], properties[1], properties[2], properties[3]);
		setupTableColumns();
		thisPane.getChildren().add(table);
	}
	
	private void setupActiveCol(TableColumn<TurtleListInsertion, Boolean> activeCol) {
		activeCol.setCellValueFactory(f -> f.getValue().isActive());
		activeCol.setCellFactory(tc -> new CheckBoxTableCell<>());
		activeCol.setMaxWidth(ACTIVECOLWIDTH);
		activeCol.setMinWidth(ACTIVECOLWIDTH);
		activeCol.setResizable(false);
	}
	
	private void setupIdCol(TableColumn<TurtleListInsertion, String> idCol) {
		idCol.setCellValueFactory(f -> f.getValue().getId());
		idCol.setMaxWidth(IDCOLWIDTH);
		idCol.setMinWidth(IDCOLWIDTH);
		idCol.setResizable(false);
	}
	
	private void setupImageCol(TableColumn<TurtleListInsertion, ImageView> turtleImageCol) {
		turtleImageCol.setCellValueFactory(new PropertyValueFactory<TurtleListInsertion, ImageView>("image"));
		turtleImageCol.setPrefWidth(60);

		turtleImageCol.setEditable(true);
		turtleImageCol.setOnEditStart((CellEditEvent<TurtleListInsertion, ImageView> t) -> {
			FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle(FILECHOOSERLABEL);
			try {
				String fileName = fileChooser.showOpenDialog(mainStage).getPath();
				((TurtleListInsertion) t.getTableView().getItems().get(t.getTablePosition().getRow())).setImage(fileName);
			} catch (Exception e) {
				new ErrorBox("Invalid Image", "Please Select Valid Image");
			}
		});
	}
	
	private void setupXposCol(TableColumn<TurtleListInsertion, String> xposCol) {
		xposCol.setCellValueFactory(f -> f.getValue().getXpos());
		xposCol.setMinWidth(POSCOLWIDTH);
		xposCol.setMaxWidth(POSCOLWIDTH);
		xposCol.setResizable(false);
		xposCol.setEditable(true);
		xposCol.setCellFactory(TextFieldTableCell.<TurtleListInsertion>forTableColumn());
		xposCol.setOnEditCommit((CellEditEvent<TurtleListInsertion, String> t) -> {
			((TurtleListInsertion) t.getTableView().getItems().get(t.getTablePosition().getRow())).setXpos(Double.parseDouble(t.getNewValue()));
		});
	}
	
	private void setupYposCol(TableColumn<TurtleListInsertion, String> yposCol) {
		yposCol.setCellValueFactory(f -> f.getValue().getYpos());
		yposCol.setMinWidth(POSCOLWIDTH);
		yposCol.setMaxWidth(POSCOLWIDTH);
		yposCol.setResizable(false);
		yposCol.setEditable(true);
		yposCol.setCellFactory(TextFieldTableCell.<TurtleListInsertion>forTableColumn());
		yposCol.setOnEditCommit((CellEditEvent<TurtleListInsertion, String> t) -> {
			((TurtleListInsertion) t.getTableView().getItems().get(t.getTablePosition().getRow())).setYpos(Double.parseDouble(t.getNewValue()));
		});
	}
	
	private void setupHeadingCol(TableColumn<TurtleListInsertion, String> headingCol) {
		headingCol.setCellValueFactory(f -> f.getValue().getHeading());
		headingCol.setMinWidth(HEADINGCOLWIDTH);
		headingCol.setMaxWidth(HEADINGCOLWIDTH);
		headingCol.setResizable(false);
		headingCol.setEditable(true);
		headingCol.setCellFactory(TextFieldTableCell.<TurtleListInsertion>forTableColumn());
		headingCol.setOnEditCommit((CellEditEvent<TurtleListInsertion, String> t) -> {
			((TurtleListInsertion) t.getTableView().getItems().get(t.getTablePosition().getRow())).setHeading(Double.parseDouble(t.getNewValue()));
		});
	}
	
	private void setupPenUpCol(TableColumn<TurtleListInsertion, Boolean> penUpCol) {
		penUpCol.setCellValueFactory(
				new Callback<CellDataFeatures<TurtleListInsertion,Boolean>,ObservableValue<Boolean>>()
				{
				    //This callback tell the cell how to bind the data model 'Registered' property to
				    //the cell, itself.
				    @Override
				    public ObservableValue<Boolean> call(CellDataFeatures<TurtleListInsertion, Boolean> param)
				    {   
				        return param.getValue().isPenActive();
				    }   
				});
		
		//penUpCol.setCellValueFactory(f -> f.getValue().isPenActive());

		penUpCol.setCellFactory( CheckBoxTableCell.forTableColumn(penUpCol) );
		
		penUpCol.setCellFactory(tc -> new CheckBoxTableCell<>());
		penUpCol.setMaxWidth(PENCOLWIDTH);
		penUpCol.setMinWidth(PENCOLWIDTH);
		penUpCol.setResizable(false);
	}
	
	private void setupPenColor(TableColumn<TurtleListInsertion, String> penColorCol) {
		penColorCol.setCellValueFactory(f -> f.getValue().getPenColor());
		penColorCol.setMinWidth(PENCOLWIDTH);
		penColorCol.setMaxWidth(PENCOLWIDTH);
		penColorCol.setResizable(false);
		penColorCol.setEditable(true);
		penColorCol.setCellFactory(TextFieldTableCell.<TurtleListInsertion>forTableColumn());
		penColorCol.setOnEditCommit((CellEditEvent<TurtleListInsertion, String> t) -> {
			((TurtleListInsertion) t.getTableView().getItems().get(t.getTablePosition().getRow())).setPenColor(t.getNewValue());
		});
	}
	
	private void setupPenThickCol(TableColumn<TurtleListInsertion, String> penThickCol) {
		penThickCol.setCellValueFactory(f -> f.getValue().getPenThickness());
		penThickCol.setMinWidth(HEADINGCOLWIDTH);
		penThickCol.setMaxWidth(HEADINGCOLWIDTH);
		penThickCol.setResizable(false);
		penThickCol.setEditable(true);
		penThickCol.setCellFactory(TextFieldTableCell.<TurtleListInsertion>forTableColumn());
		penThickCol.setOnEditCommit((CellEditEvent<TurtleListInsertion, String> t) -> {
			((TurtleListInsertion) t.getTableView().getItems().get(t.getTablePosition().getRow())).setPenThickness(Double.parseDouble(t.getNewValue()));
		});
	}
	
	private void setupTableColumns() {
		table.setEditable(true);
		
		TableColumn<TurtleListInsertion, Boolean> activeCol = new TableColumn("Active");
		setupActiveCol(activeCol);
		
		TableColumn<TurtleListInsertion, String> idCol = new TableColumn("ID");
		setupIdCol(idCol);
		
		TableColumn<TurtleListInsertion, ImageView> turtleImageCol = new TableColumn("Image");
		setupImageCol(turtleImageCol);
		
		TableColumn<TurtleListInsertion, String> xposCol = new TableColumn("X");
		setupXposCol(xposCol);
		
		TableColumn<TurtleListInsertion, String> yposCol = new TableColumn("Y");
		setupYposCol(yposCol);
		
		TableColumn<TurtleListInsertion, String> headingCol = new TableColumn("Heading");
		setupHeadingCol(headingCol);
		
		TableColumn<TurtleListInsertion, Boolean> penUpCol = new TableColumn("Pen Down");
		setupPenUpCol(penUpCol);
		
		TableColumn<TurtleListInsertion, String> penColorCol = new TableColumn("Color");
		setupPenColor(penColorCol);
		
		TableColumn<TurtleListInsertion, String> penThickCol = new TableColumn("Thickness");
		setupPenThickCol(penThickCol);
		
		data = FXCollections.observableArrayList(new TurtleListInsertion(turtles.get(0), true, iteratingID, turtles.get(0).getRelativeX(), turtles.get(0).getRelativeY(), turtles.get(0).getOrientation(), turtles.get(0).getPenDown(), "Black", 3.0));
		iteratingID += 1;
		table.setItems(data);
		table.getColumns().addAll(activeCol, idCol, turtleImageCol, xposCol, yposCol, headingCol, penUpCol, penColorCol, penThickCol);
	}

	
	private void setupTableProperties(double xPos, double yPos, double width, double height) {
		table.setEditable(false);
		table.setLayoutX(xPos);
		table.setLayoutY(yPos);
		table.setMaxWidth(width);
		table.setMaxHeight(height);
		table.setFixedCellSize(ROWHEIGHT);
	}
	
	public void addTurtle(Turtle t) {
		
		data.add(new TurtleListInsertion(t, t.getActive(), iteratingID, 0.0, 0.0, 0.0, true, "Black", 3.0));
		System.out.println("iteratingID = " + iteratingID);
		iteratingID += 1;
		table.setItems(data);
		
	}

	public void updateValues() {
		
		data.clear();
		iteratingID = 1;
		for (Turtle t : turtles) {
			TurtleListInsertion newInsertion = new TurtleListInsertion(t, t.getActive(), iteratingID, t.getRelativeX(), t.getRelativeY(), t.getOrientation(), t.getPenDown(), "Black", t.getPenThickness());
			iteratingID += 1;
			data.add(newInsertion);
			t.updateOnScreen();

	/*public void updateValues() {
		List<TurtleListInsertion> insertionList = new ArrayList<>();
		for (Turtle t : turtles) {
			insertionList.add(new TurtleListInsertion(t, t.getActive(), t.getID(), t.getX(), t.getY(), t.getOrientation(), t.getPenDown(), "Black", 0.0));
*/
		}
		
		table.setItems(data);				
		
	}

}
