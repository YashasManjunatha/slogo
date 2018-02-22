## [SLogo](https://www2.cs.duke.edu/courses/compsci308/spring18/assign/03_slogo/index.php) : Design Plan Document

By: Stefani Vukajlovic, Miles Todzo, Yashas Manjunatha and Calvin Ma

### Introduction

Objective: This project aims to develop an integrated development environment, IDE, that supports users to write SLogo programs. 

Design Goals: Have a flexible Turtle object that can have additional methods to support different movements and functionality and a backend that can support added Command objects for new commands.

Architecture of Design: A front end Turtle object that has many open public methods for all of the different movements/actions that the turtle can make. The back end which is mainly closed to the front end calls these methods on the Turtle object to update the turtle. Turtle object will then updated the GUI as necessary by calling the functions in the GUI class.

### Design Overview

Our project will be split between the frontend GUI and turtle/objects and the backend operations that determine how the frontend will be updated. The frontend is the placeholder for all of the objects - the user will only see the frontend as it updates from the backend. The GUI will also have text inputted from the user which is sent to our backend classes. 

![](https://i.imgur.com/5HYdGF8.jpg)

#### 4 APIs

Frontend (GUI, turtle objects, drawing objects)
* External: meant to support the backend methods used for "updating the grid". The public methods are unique to each class that shows up in the GUI. These methods will be called by the commandObject class when the commandObject identifies the text entered by the user. When called, the GUI object will update its properties such as location. Picture bellow shows Turtle Object's public methods that are going to be called for the backend. 
 ![](https://i.imgur.com/0yfBpFQ.jpg)

* Internal: the internal API for the frontend is used to improve the flexibility of adding new elements to the frontend. This includes the "turtle" object and pen. The object representing the turtle will have its own properties such as the color that can be editted through the internal API. There will be an interface for implementing the most basic GUI objects, but more can be added by implementing the interface. 
    
Backend (parser, commandObject)

* External: the external API for our backend will simply be some sort of execute method that lets the frontend call the backend and implement whatever code has been typed in the input area. We plan to use this method with the commandObject object in the backend that will ultimately "read" the user input. 

* Internal: we plan for our internal API for the backend to be pretty extensive due to the importance of the parser and commandObject in our project. We want commands to be easily added to the project. As so, we will be implementing an API for the commandObject that will allow us to split different commands into their respective categories: movement, properties, arithmetic. The API will provide a framework for any future commands to be implemented within the corresponding category. 


### User Interface
![](https://i.imgur.com/NL6ZFYO.jpg)

Above is the picture depicting what our user interface will look like. The largest box on the top left is where the turtle/drawings will be contained. This screen will be updated as commands are written out and ran through out backend. The text input where where most of the user interaction will occur. We envision it as something similar to a command prompt or terminal, where each row indicated by a > is a writtable line. At this line, the user will be able to type out one line commands or entire functions. Also similar to a command prompt, the previous functions will be kept in this box - you can access them by scrolling up. If this is not feasible, another box can be created in the GUI that holds these previously ran commands. The top right box will simply hold the variables that have been declared by the user. As you can see in the photograph, the left side will hold the names of the variables, or function name with parameters, while the right side will be what the variable or function is declared as. The boxes could change with size, especially for the functions, but we could also keep the boxes the same and implement the ability to scroll through. Finally is the run button. This button tells the program when a command has been written and indicates that the command needs be to sent to the backend. 

Any bad data or empty data errors will caught on our backend, and then sent forward to the front end. The way we display our error can be very flexible, but we are planning to have some error message pop up in the text input area or a popup could show up. The erroneous command will still be kept by the text input area just incase the user wants to keep track of it and modify it. An interesting concept that we could implement would be pressing the up and down arrows, which would go to previous/future commands, but our priority is still to have a working and flexible GUI. 


### API Details

#### Frontend External

```java
public interface Turtle{ //will implement a similar API to other objects in the Screen, this is mainly for moving objects
    public void move(double diffX, double diffY);
    public void turn(double degrees);
    public double getX();
    public double getY();
    public double getOrientation();
    public void setPenDown(boolean penDown);
    public boolean getPenDown();
    public void setTurtleShowing(boolean showing);
    public boolean getTurtleShowing();
    
}

public interface GUIObject{
    public void updateOnGUI(); //might extend to all GUI objects like the text input, variable boxes
    public void clearScreen();
    public void setError(boolean ifParserCatchesError);
}
```

#### Frontend Internal

Not necessarily an API, but there will be classes used to set properties of the GUI
```java=
/*GUIBoxes represents the general set of boxes that will show up on our GUI including the box with the turtle, the box holding user-determined variables, etc. The following methods will not exist within all of the GUIBoxes - they will be in the appropriate classes.*/
private class GUIBoxes{
    private void setBackground();
    private void setTurtleImage();
    private void setPenColor();
    private void displayPreviousCommands();
    private void displayVariables(Map<String, Double);
    private void displayUserCommands(Map<String, String>);
    private void setLanguage(String language);


}
```

#### Backend External

```java
/*
* CommandObject super class takes the text entered by the user and the turtle on which the command is executed
*/
public interface CommandObject{
    public CommandObject(String text, Turtle turtle, Map variables);
    /*
    * The mainExecute command carries in the super class merely calls parse on the text and executes on the retured specific command which has an execute method which does any more parsing and then carries out the specific commmand
    */
    public double mainExecute();
    /*
    * Returns immutable map to the frontend so that the variables and user-written methods can be displayed
    */
    public Map getVariableMap();
}
```

#### Backend Internal

```java
/*
* The ParserObject parses the passed String and checks if it is a valid command. If so, it creates and returns a new CommandObject 
*/
interface ParserObject{
    double parse(String text);
}
/*
* CommandException is thrown by the parser object upon reaching an invalid command/parameter. It is caught and handled by the CommandObject class and the frontend GUI
*/
interface CommandException(){
    commandException(String invalidText);
}
```


### API Example Code
-  The user types 'fd 50' in the command window, and sees the turtle move in the display window leaving a trail, and the command is added to the environment's history.
    When run button is pressed, GUI class will make new CommandObject that takes inputs turtle and the text from the command window and then it will call public method execute() from the CommandObject class. This method will call parser  on the text from the command window and than execute, which will execute what ever it was inputed by the user. The parser will identify which command has been initiated, in this case fd, thus it will make new Forward Command object that will take in String as an input in this case 50, then the execute method is called on this Forward object, which will then call method from turtle class turtle.move(text.parse.execute()), which moves the turtle 50 places forward. The GUI class method addToHistory will be also called when button run is pressed and will add the text inputed to an ArrayList which is displayed on the GUI. An updateGUI() function will be called that will refresh the main screen containing the turtle and drawing and update it based on the command. 
    
Use Cases
1. In our GUI, after the user types in text commands and hits the enter button, a new Command object will be instantiated with the text from the text box. And then, the execute method will be called on the Command object.
    ```java
    String text; //text from text box
    Command user_instructions = new Command(text, turtle)
    user_instructions.execute();
    ```
2. In the GUI after the user types in text commands and hits enter, the text will be stored in a List (String) of all the previously enetered commands. And then displayPreviousCommands() will be called to update the display in the GUI.

3. In the GUI methods like setTurtleImage and setBackground will called and prompt the user to choose what image or background in a dropdown box format. Once the user makes his/her choice, the values for this in the GUI will be updated.

4. When a new variable/method is declared by user (frontend): the user presses run, and the user input string is passed into the backend. The commandObject passes the string into the parser, where the variable/method name is put into a string as a key, and the value is what the user declared the key as. These are both put into the map and the command is run. The map will be passed back into the frontend, where we will parse out all of the information from the map and put it into the corresponding boxes for variable and function names. 

5. When an invalid command is ran: after the user presses run on an invalid command, the command string goes to our backend and is picked up by a CommandObject. The CommandObject calls on the parser to read in the command string. For an invalid command/parameter, the parser throw a CommandException, which will be caught in the CommandObject execute method. The GUI will have method public boolean setError() which will have variable error set to false. When CommandObject catches the exception it will call showError() method in the GUI class which will display the error on the screen.

6. To execute a command, the execute method will be called on a command object. For example, if command is a back command object, the execute method for this command would first parse the text following the command and apply that to the appropriate method calls on the Turtle object. Ex. for 'back 50' the execute method would look like 
    ```java
    turtle.move(-1 * "50".parse().execute());
    ```

7. In the case of a nested command being inputted by the user, for this example fwd fwd 50, the text will be all be passed into a CommandObject. Then, when mainExecute is called from the frontend, the text is parsed and a ForwardCommand (subclass of CommandObject) will be created with and given the text "fwd 50". The execute method for the ForwardCommand is then called which looks like:
    ```java
    turtle.move("fwd 50".parse().execute());
    ```
    The next parsing then returns a new ForwardCommand with the text "50". This object's execute is then run which parses the "50" to a double and then moves the turtle forward 50 spaces. This execute returns the value by which the turtle was moved, so the move from the initial ForwardCommand execute() is given 50 and the turtle is moved forward 50 again.

8. In this implementation of our back end, we can consider the exectution of nested commands as a recursive call with the base case of executing a double/constant value (i.e. "50"). Thus, the execute function for a constant command would just convert the string to a double and return the value of the double.

### Design Considerations

- How would we deal with commands after parsing the text?
        We decided to create a class called a commandObject. This commandObject receives the text from the frontend and then calls on the parser. This allows us to freely extend different commands by extending the commandObject into various movements and other properties changes in the GUI. The commandObject also allows us to isolate the parser and close it off to anything from the outside. This encapulates important information such as the user defined variable and methods that shouldn't change unless the appropriate command is executed. 

- Should we call backend methods in the frontend to update the gui, or should we update the frontend by calling the frontend methods from the backend?
      **Pros for 1st option:** We can isolate the backend completely from the frontend.
      **Cons for 1st option:** It will require many if statements, because we would need to check which         command was returned by the backend and than according to that to update the Turtle Object and GUI.
      **Pros for 2nd option:** We can isolate the frontend completely from the backend. Frontend methods       will be called in the backend and backend will update the Turtle and GUI as the parser reads the         command input, so no if statements.
      **Cons for 2nd option:** The backend is dependent on the methods from the frontend and frontend has       a lot of public methods
    - We decided to choose option 2, because it has more pros than cons.

- How to handle errors due to invalid text command? Should we throw and error to front end or to call certain method?
     **Pros for 1st option:** We could just throw an error in the parser and let the frontend deal with        it. 
     **Cons for 1st option:** There is more chance that the error will not be caught and it would cause        the problem in the frontend.
     **Pros for 2st option:** We can deal with exceptions in the backend and call the method in the front      end that displays popup window saying that there exists invalid input, which will                        make sure that no errors occur at the frontend due to throwing exceptions.
    - We decided to choose the second option due to above listed pros. 
- Where to keep track of user defined variables and commands, backend or frontend?
     Pros for backend: When user defined variables and commands are written, parser is called to read them and store them. Since parser is found in the backend, it makes sense to save the values in the map in the backend. The front ends just needs to display it. In addition, Parser will need those values when pasrsing text from command window and if some changes to those values happen it would happen in the parser - the frontend only needs the updated information once the command as executed.
     Cons for backend: Since the front end needs to call the map from the backend, an addtional dependency is created between our APIs. 
     Pros for frontend: the front is the one showing the variables, having the map exist in the front end is a way for us to add a variable/method directly to the GUI when a command is run.
     Cons for frontend: since the backend is where the value of a key is parsed into a command, it would make more sense for the map to exist in the backend. This way, the backend has direct access to the map and doesn't have to go through a series of methods passing it back and forth between our APIs, creating dependencies. Also, error checking is not really possible if we keep the map in the frontend because erroneous variables/methods will be kept here. 
    - We decided to keep track of the user defined variables and commands in the backend.

### Team Responsibilities

* Front End 
    * Primary: Yashas Manjunatha and Calvin Ma
    * Secondary: Stefani Vukajlovic and Miles Todzo
    * GUI of IDE
    * Turtle and other GUI Object Classes

* Back End 
    * Primary: Stefani Vukajlovic and Miles Todzo
    * Secondary: Yashas Manjunatha and Calvin Ma
    * Parser
    * Command Objects