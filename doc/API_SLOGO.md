## SLogo API Design Exercise

By: 
* Yashas Manjunatha (ym101)
* Miles Todzo (mt265)
* Stefani Vukajlovic (sv116)
* Calvin Ma (cm298)

### SLogo Architecture Design

1.  When does parsing need to take place and what does it need to start properly?
Parsing should take place when run button is pressed. To work properly, it needs a text box for the user to type stuff into so that the parser knows what it needs to read. We'll also need GUI buttons to tell our simulation when to use the parser. 
2.  What is the result of parsing and who receives it?
A command object will take in the result of the parser. This command object will know what "type" (movements, etc.) of command it is and the value that follows the typed command. This command object is passed into the backend to execute the command, and the resulting action is passed to the front end to update the turtle accordingly.
3.  When are errors detected and how are they reported?
One important error that we will need to account for is if an invalid command is entered within the text area. Once the text is processed by the parser, it can either catch the error within the parser or in the command object. Either way, when the error is caught, a message will appear within the GUI. 
4.  What do commands know, when do they know it, and how do they get it?
Commands know the type of command that it is and the expression values it needs for the command. To execute the command, all of its expression values are evaluated by the parser and returns the results of the expressions, which are then plugged/applied into the command to execute it.
5.  How is the GUI updated after a command has completed execution?
During the execution of a command, if the command needs to update the GUI, it will call the appropriate method on the external front end API to update the GUI. In terms of movement, the backend can send the frontend an updated location of the turtle, and the frontend can display the new position. The trail can also be a series of lines or visible objects that the frontend will place on the screen.

### SLogo API

#### External Front End

The graphical interface and interpreter will be separated into separate classes (i.e. Turtle object and Command object). The front end object will have external methods for updating the GUI of the object (moving the turtle, turning the turtle, etc.) and the back end interpreter object will call the appropriate method on the front end object to move/update the turtle according to the command.

#### External Back End

The external back end will provide the necessary updates to the movement of turtles and trails to the front end. 

#### Internal Front End
By creating a Drawing class we can handle different drawings on the screen and new features can be easily added to this.

#### Internal Back End

By creating a Interpreter Object superclass, we are allowing for flexibility with the kinds of commands that we will encounter. For example, if a new command is implemented that involves movement, it was be created under a motion class instead of changing an existing class that interprets the appropriate movement for the turtle. If the commands become more complex, this also allows for easier communication between different interpretations and commands if we implement public methods within these classes as part of the API. 