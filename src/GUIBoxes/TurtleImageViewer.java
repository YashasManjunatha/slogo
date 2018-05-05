package GUIBoxes;

import java.util.ArrayList;
import java.util.List;

import Turtle.Turtle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class TurtleImageViewer {

	private Pane myPane;
	private List<Turtle> turtleList;
	private ScrollPane scrollPane;
	private VBox vBox;
	private Stage myStage;

	private static final int TEXT_X = 10;
	private static final int TEXT_Y = 5;
	private final static int IMAGE_X = 25;
	private final static int IMAGE_Y = 35;

	public TurtleImageViewer(Pane myPane, double[] properties, List<Turtle> turtleList, Stage myStage) {
		this.myPane = myPane;
		this.turtleList = turtleList;
		scrollPane = new ScrollPane();
		setupScrollPane(properties);
		myPane.getChildren().add(scrollPane);
		this.myStage = myStage;
	}

	private void setupScrollPane(double[] properties) {
		scrollPane.setLayoutX(properties[0]);
		scrollPane.setLayoutY(properties[1]);
		scrollPane.setMinWidth(properties[2]);
		scrollPane.setMaxWidth(properties[2]);

		scrollPane.setMinHeight(properties[3]);
		scrollPane.setMaxHeight(properties[3]);
		scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
		vBox = new VBox();

		setupVBox();

		scrollPane.setContent(vBox);

	}

	private void setupVBox() {

		for (Turtle t : turtleList) {
			Pane miniViewPane = setupMiniView(t);
			vBox.getChildren().add(miniViewPane);
		}

	}

	private Pane setupMiniView(Turtle t) {
		Pane p = new Pane();
		p.setMinHeight(120);
		p.setMinWidth(100);
		p.setMaxWidth(100);
		p.setStyle("-fx-border-color: black");
		Label text = new Label("ID: " + t.getID());

		text.setLayoutX(TEXT_X);
		text.setLayoutY(TEXT_Y);
		// Rectangle r = new Rectangle(0, 0, 200, 100);
		// r.setFill(Color.ALICEBLUE);
		// p.getChildren().add(r);
		ImageView turtleImage = new ImageView(t.getImage());
		turtleImage.setX(IMAGE_X);
		turtleImage.setY(IMAGE_Y);
		setupPressAction(t, turtleImage);
		p.getChildren().add(turtleImage);
		p.getChildren().add(text);
		return p;
	}

	private void setupPressAction(Turtle t, ImageView turtleImage) {

		turtleImage.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
			FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("Choose New Image");
			try {
				String fileName = fileChooser.showOpenDialog(myStage).getPath();

				t.changeImage(fileName);
				refreshView();
			}

			catch (Exception e) {
				new ErrorBox("Invalid Image", "Please Select Valid Image");
			}

		});

	}

	public void refreshView() {
		vBox.getChildren().clear();
		setupVBox();
	}

}
