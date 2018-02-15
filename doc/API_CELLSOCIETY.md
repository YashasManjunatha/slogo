## API Critique

By: 
* Yashas Manjunatha (ym101)
* Miles Todzo (mt265)
* Stefani Vukajlovic (sv116)
* Calvin Ma (cm298)

### External API for Simulation
There was communication between the grid classes and the cell occupant classes. The cell occupant classes call the getNiehbors method within the cell glass. This allows the grid classes to independently modify how neighbors are determined, which would impact how the simulation is run. 

```java
public List<CellOccupant> getNeighbors(CellOccupant cell)
```

### Internal API for Simulation

Some of the methods included in the Simulation API were set as public, or externally available to all other parts, but should have been set as protected or private because they are only internally used within the simulation logic. The following methods like setNextState and setNextLocation are used by the internal logic of the simulation, and the other parts of the project would not need to call these methods.

```java
public void setNextState(int state)
public void setNextLocation(int\[\] location) 
public void noChange()

public abstract void calculateNextState(Grid grid); //--> package friendly
```


### External API for Configuration 

```java
public void createRandomXML(String simulationType, int xSize, int ySize, String\[\] colors) throws LoadGridException
public void currentGridToXML(DisplayGrid currentGrid) throws LoadGridException
public void createWithPopulationPercentages(String simulationType, int xSize, int ySize, String\[\] colors, int\[\] percentages) throws LoadGridException
````

These methods are good external methods for the XML class to interact with the grid/simulation to either generate new XML/simulation files or save the current state of the simulation.

### Internal API for Configuration

All of these methods should have been modified by private or protected rather than public since their only calls were made within the same class or within the same package. The backend never made any calls to these methods.

```java
public DisplayGrid(String smf, Stage ps)
public String getCURRENT_SIMULATION_TYPE() 
public CellOccupant[][] getCURRENT_CONFIGURATION() 
public Simulation getCURRENT_SIMULATION() 
public void setShowGridLines(boolean val)
public void fillSimulationArray() throws LoadGridException
public CellOccupant createCellOccupant(int initState, int[] initLocation, Paint initColor)
public Pane displaySimulationConfiguration() throws LoadGridException
```

### External API for Visualization 

There is no need for an external API for visualization because neither the simulation code or the configuration code depends on states of the visualization part of the project.

### Internal API for Visualization

These buttons pretty much exist on their own within the GUI. The other classes may call the the buttonEvent() functions in order for the user to interact with the simulations, but the main purpose of these public methods was to determine what event would happen depending on how the button is interacted with. Thus, these methods are part of the internal API that determines the actions of the button. 
 
```java
package userInterface;
public class StartButton extends Buttons 
  	public StartButton(String text, Properties prop, Timeline animation, Stage primaryStage) 
	public void buttonEvent(Button button, Properties prop, Timeline animation, Stage primaryStage) 
}
 
package userInterface;
public class StopButton extends Buttons { 
  	public StopButton(String text, Properties prop, Timeline animation, Stage primaryStage) 
	public void buttonEvent(Button button, Properties prop, Timeline animation, Stage primaryStage) 
}