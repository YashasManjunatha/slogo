SLogo API Review
===
rp159, mw350, mt265
## Ryan Pond's API
### Part 1
* Implementing propertyChange-listener keeps the front end from having to make calls to the backend and thereby keeps all of the text handling on the backend
* Command interface is extended by various superclasses (potentially abstract i.e. movement, TurtleCommands, MathOperations) which are extended by specific commands (i.e. Forward).
* Process for adding command: new command class that extends the proper super class, write required methods, add to properties file (for reflection)
* Invalid command errors are handled by passing the parsed command into the ErrorHandling class which throws a custom exception
* Errors are thrown from backend, caught by frontend and then an error message is displayed on the GUI
* Good because only necessary objects/variables are passed

### Part 2
* ModelViewController design pattern implemented
* Factory -- instantiate some CommandObject, and the parser determines which specific subclass of the CommandObject is instatiated
* Ryan is excited to work on parsing! and creating command objects! and using reflection! and learning about design patters!
* Ryan is a little bit worried to work on the CommandCenter class becuase he thinks it may not be well enough purposed
* The user types 'fd 50' in the command window, and sees the turtle move in the display window leaving a trail, and the command is added to the environment's history.
* The user types 'ffd 50' in the command line, the program parses it and recognizes that it is an invalid command, then an error message is displayed on the canvas. An addition to the code mentioned above:
* The user types 'PRODUCT 21 8', the CommandParser checks and returns that this Math Operation command, then the product of 21 and 8 is printed in the Console.
* The user types 'pu fd 50'. The Turtle moves forward without leaving a trail. The command 'pu fd 50' is added to command history as one command.


## Miles Todzo's API
### Part 1
* Creating new commands is easy because you can just add a new command class that is extended. Adding another turtle is also easy because you can just create another object
* The Command interface is implemented by all the subclasses; this means that the front end doesn't have to deal with specific commands, just a general CommandObject (which implements Command). Another example is the private Pen class, which only the Turtle class can access. This encapsulation allows more functionalities to be delegated while containing those functionalities within their respective classes.
* CommandException is thrown from the Parser and is caught in the CommandObject class, which sets a boolean in the Turtle class (setError()) to true and displays the error in the GUI.
* One good thing about the design is that many potential extensions were conisdered, and the design was made as flexible as possible to incorporate such future extensions.

### Part 2
* The Factory design pattern will be used.
* Miles is excited to work on saving the methods that the user inputs.
* However, he is also most worried about the same problem.

### Use Cases
* When an invalid command is ran: after the user presses run on an invalid command, the command string goes to our backend and is picked up by a CommandObject. The CommandObject calls on the parser to read in the command string. For an invalid command/parameter, the parser throw a CommandException, which will be caught in the CommandObject execute method. The GUI will have method public boolean setError() which will have variable error set to false. When CommandObject catches the exception it will call showError() method in the GUI class which will display the error on the screen.
* To execute a command, the execute method will be called on a command object. For example, if command is a back command object, the execute method for this command would first parse the text following the command and apply that to the appropriate method calls on the Turtle object. Ex. for 'back 50' the execute method would look like 

    ```java
    turtle.move(-1 * "50".parse().execute());
    ```
* In the case of a nested command being inputted by the user, for this example fwd fwd 50, the text will be all be passed into a CommandObject. Then, when mainExecute is called from the frontend, the text is parsed and a ForwardCommand (subclass of CommandObject) will be created with and given the text "fwd 50". The execute method for the ForwardCommand is then called which looks like:

    ```java
    turtle.move("fwd 50".parse().execute());
    ```
    
   The next parsing then returns a new ForwardCommand with the text "50". This object's execute is then run which parses the "50" to a double and then moves the turtle forward 50 spaces. This execute returns the value by which the turtle was moved, so the move from the initial ForwardCommand execute() is given 50 and the turtle is moved forward 50 again.


## Maddie Wilkinson
### Part 1
* Command interface is going to be flexible, because there is  a List as the parameter. ALso easy to add new commands because it is easy to add a new subclass
* All the command classes are protected, only able to access Turtle. Front end will also be private/protected.
* Syntax 
* Exception Handling: throws different exceptions based on what type of error. if an invalid command is entered, Parser throws exception if there is an invalid command, Executer throws exception if there are inocrrect number of arguments for a command
* CommandInterface is flexible. Each execute method takes an array of doubles as a parameter and therefore the commands can take as many parameters as they need.
### Part 2
* Facotry design pattern allows frontend to make Command objects without specifying the exact command that will be executed
* Excited to work on parsing
* Nervous about regular expressions becuase they are "weird things" and "I don't know what they are"

Use Cases
* fd 50
    * command will be processed by parser
    * passed to Execute class, which executes the forward command and saves fd 50 into the appropriate data structure in the UserCommands class
    * forward(50); 
        * edits the position of the turtle
        * new location will be added to array of points to move to
    * front end calls update()
* fd fd 50
    * command will be processed by parser
    * passed to Execute class
    * forward(50)
        * turtle x and y updated
        * point added to array of places to move
    * Execute class checks if its done - its not 
    * forward(50)
        * turtle x and y updated
        * point added to array of places to move
    * front end calls update
