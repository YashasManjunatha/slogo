package GUIBoxes;

import javafx.scene.Group;

public interface GUIBoxes {
	/**
	 * this is part of the external frontend API. The backend can call this method, which will
	 * update the box based on any actions such as adding text
	 */
	public void updateBox();

}
