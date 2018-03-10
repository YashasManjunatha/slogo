package GUIBoxes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Turtle.Turtle;
import commands.Command;
import commands.ImportData;
import commands.SaveCurrentStates;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * Subclass of button - used to import a file containing user defined variables
 * and commands
 * 
 * @author Calvin Ma
 *
 */
public class ImportButton extends Buttons {

	private Map<String, Double> mainVariableMap;

	private Map<String, Command> mainCommandMap;

	private Stage mainStage;

	private UserDefTable mainVarTable;

	private UserDefTable mainFuncTable;

	/**
	 * Constructor for import button - see superclass for unspecified parameters
	 * 
	 * @param pane
	 * @param properties
	 * @param text
	 * @param turtleList
	 * @param variableMap
	 *            - needs variablemap to pass into Command class. Also needs it to
	 *            update var table
	 * @param commandMap
	 *            - commandmap is needed to pass into a new command. also needs it
	 *            to update func table
	 * @param myStage
	 *            - for opening a dialog box
	 * @param varTable
	 *            - we want to update the var table after we read in the new
	 *            variables
	 * @param funcTable
	 *            - for updating the func table after reading in new functions
	 */

	public ImportButton(Pane pane, double[] properties, String text, List<Turtle> turtleList,
			Map<String, Double> variableMap, Map<String, Command> commandMap, Stage myStage, UserDefTable varTable,
			UserDefTable funcTable) {
		super(pane, properties, text, turtleList);
		mainVariableMap = variableMap;
		mainCommandMap = commandMap;
		mainStage = myStage;
		mainVarTable = varTable;
		mainFuncTable = funcTable;
	}

	/**
	 * sets action on press - on press, the button opens dialog box for user to
	 * choose text file. once file is chosen, the var table and func tables are
	 * updated
	 */
	@Override
	void setupAction() {
		getButton().setOnAction(event -> {

			FileChooser fileChooser = new FileChooser();

			try {
				String fileName = fileChooser.showOpenDialog(mainStage).getPath();
				ImportData data = new ImportData();
				List<Map> maps = data.importFile(fileName);
				mainVarTable.updateVars(maps.get(0));
				mainFuncTable.updateStringFuncs(maps.get(1));

			} catch (Exception e) {
				new ErrorBox("Invalid File", "Please Select Valid Import File");
				e.printStackTrace();
			}

		});

	}

}
