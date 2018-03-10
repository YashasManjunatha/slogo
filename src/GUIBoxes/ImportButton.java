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

public class ImportButton extends Buttons {

	private Map<String, Double> mainVariableMap;

	private Map<String, Command> mainCommandMap;

	private Stage mainStage;
	
	private UserDefTable mainVarTable;
	
	private UserDefTable mainFuncTable;

	public ImportButton(Pane pane, double[] properties, String text, List<Turtle> turtleList,
			Map<String, Double> variableMap, Map<String, Command> commandMap, Stage myStage, UserDefTable varTable, UserDefTable funcTable) {
		super(pane, properties, text, turtleList);
		mainVariableMap = variableMap;
		mainCommandMap = commandMap;
		mainStage = myStage;
		mainVarTable = varTable;
		mainFuncTable = funcTable;
	}

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
