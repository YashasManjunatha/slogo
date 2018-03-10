# Slogo Team 09

A development environment that helps users write SLogo programs.

**Date Started:** February 15, 2018

**Date Finished:** March 9, 2018

**Number of Hours:** Around 25 hours for each person.

## Project Information
### Team Members:
* Stefani Vukajlovic (sv116) - Back End Commands
* Miles Todzo (mt256) - Back End Parser
* Yashas Manjunatha (ym101) - Front End Turtle and GUI
* Calvin Ma (cm298) - Front End Turtle and GUI

### Resources Used

### Important Files
* [Main.java](https://coursework.cs.duke.edu/CompSci308_2018Spring/slogo_team09/blob/master/src/main/Main.java) in package "main" is used to start the application.
* [Turtle.java](https://coursework.cs.duke.edu/CompSci308_2018Spring/slogo_team09/blob/master/src/Turtle/Turtle.java) implements the Front End external interface and creates Turtle objects to be displayed and manipulated and implements the interations with the turtle.
* [Parser.java](https://coursework.cs.duke.edu/CompSci308_2018Spring/slogo_team09/blob/master/src/commands/Parser.java) implements the parsing of commands.

### Resources Used
* JavaFX Documentation on Oracle Website
* To Start Project: None
* To Test Project and Associated Error: We were given some example commands to run from Professor Duvall, we used to text our functionality. In terms of errors - we had to check for invalid commands and invalid files in various places. The invalid commands is checked within the parser, and the invalid files is checked whenever a file uploaded from the local machine is uploaded and used. 
* Data or Resource Files: For the properties of the GUI Objects, a properties file was created that included the x position, y position, width and height of each GUI Object. Properties files for languages was also used for the various languages which acted as a translator. 

### Information about Program
* Front End Designs, Assumptions, Simplifications: Our frontend is built based around a pane, which is put into a tab for a tab pane. Within this generic Pane contains all of the GUI Objects. As such, various GUI Objects need to interact with each other, which is why many of our GUI Objects have so many parameters. Despite this, I feel as our classes are still relatively well encapusalted, as we minimized the amount of setters the best we would. Also, all of our instance variables are private and are never remotely accessed except through protected methods within a class hierarchy. The foundation of our frontend is the Turtle API (Interface and Class). The turtle contains a lot of information and each turtle tells the screen what to draw. For colors, the pallete idea seemed weird and unncessary, so we stuck with our default colors which can still be chosen by the user. This may inhibit flexibility for the colors, but it leads to less possility of error. How the frontend was able to controller the properties of the turtles and pens was also quite vague - to account for this, we just had a tableview with all these qualities associated with the respective turtle, giving the user maximum flexibility. 


### Design Assumptions
* Some of our assumtions include that in order to run some commands that already use user defined variables or commands, those need to be processed separately in the parser before the running of the commands that use them. So for example in order to make following code work properly:

```java
# put a bunch of turtles 100 units away from the center
tell \[ 1 2 3 4 5 6 7 8 9 10 \]
st pu
rt \* / 360 turtles id
fd 100

```

First we need to run:

```java
# put a bunch of turtles 100 units away from the center
tell \[ 1 2 3 4 5 6 7 8 9 10 \]
```

* And then when that is finished parsing we can type in the rest and it will work perfectly. This is due to the way we visualized the parser and how we implemented it as a result.

### Known Bugs
* toroidal works, but doesn't seem to be fully effective with very larger numbers where the turtle has to wrap around the screen many times
* the change of image occasionally messes up because of the change of dimension for the pictures

### Extra Features
* There were no obvious extra features that weren't included in the advanced implementation

### Impressions of the Project
* This project was really interesting to work on. We were able to implement the design pattern we learned about, however, maybe it would have been easier to implement more lambdas in the code if we learned about it before the start of the project and if we spent a little bit more time going over it in the class, but otherwise we only have good impressions. 