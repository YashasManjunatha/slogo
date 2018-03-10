package GUIBoxes;

import java.util.Map;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.Pane;

public class VariableTable extends UserDefTable {

	private Map<String, Double> mainVariableMap;

	private final static int NAMECOLWIDTH = 65;
	private final static int VALCOLWIDTH = 133;

	public VariableTable(Pane pane, double[] properties, String type, Map<String, Double> variableMap) {
		super(pane, properties, type);

		setupTableColumns();

		mainVariableMap = variableMap;

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

		valCol.setCellFactory(TextFieldTableCell.<TableInsertion>forTableColumn());
		valCol.setOnEditCommit((CellEditEvent<TableInsertion, String> t) -> {
			System.out.println("HI "
					+ ((TableInsertion) t.getTableView().getItems().get(t.getTablePosition().getRow())).getValue());
			((TableInsertion) t.getTableView().getItems().get(t.getTablePosition().getRow())).setValue(t.getNewValue());

			System.out.println(valCol.getTableView().getItems().size());

			System.out.println(nameCol.getCellData(0));

			for (int i = 0; i < valCol.getTableView().getItems().size(); i++) {
				mainVariableMap.replace(nameCol.getCellData(0), Double.parseDouble(
						((TableInsertion) t.getTableView().getItems().get(t.getTablePosition().getRow())).getValue()));
			}

		});


		getTable().getColumns().addAll(nameCol, valCol);
	}

}
