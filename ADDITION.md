CompSci 308: SLogo Addition
===================

### Estimation: before looking at the old code:
how long do you think it will take you to complete this new feature?

I think it will take me about 30 minutes to an hour to implement this new front end extension feature of adding  a new view that allows users to see the images of all of the turtles (active or not) and clicking on an image allowing the user change just that turtle's image.

how many files will you need to add or update? Why?

I will need to add and update quite a few files because first I will have to create a new class for this new view, then I will need to update resource files, the main GUI class, and the Turtle object to properly interact with the new class according to specifications. First, I will probably need to update the resource file to include the properties of this view. Then, I will need to update the main GUI class to instantiate and display this view on the workspace. Finally, I may need to make changes in the Turtle object to update its image because I am not sure if changing the image of the turtle was a feature implemented in the original product.

### Review: after completing the feature:
how long did it take you to complete this new feature?

It took me an hour and a half to two hours to implement this new feature. This was due to a number of reasons including unfamiliarity with code, thought of a better way to incorporate the feature into the existing features, difficulty with implementation in Java working with TableView, CellValueFactory, CellEditEvent, and Observable objects. To use this new front end extension feature, users can view the image associated with each turtle in the workspace (whether they are active or not) in the table view on the right hand side of the workspace. To change the image of just that turtle, users only need to DOUBLE click on that image and a file chooser pops up to allow the user to pick a new image for the turtle. The turtle's image is immediately updated in the workspace view, but to update it in the turtle list/table view the user needs to commit an action (like pressing the move forward button directly below the turtle list/table view). This is a direct result of a design decision made during the project to have this list/table update immediately after any command is executed.

how many files did you need to add or update? Why?

So instead of adding a new view to the workspace like I originally planned, I realized that I could incorporate this feature into the already existing table that displays all the turtles in the workspace and their properties (including ID, Position, etc.) and allows users to edit these properties in the workspace. So, I ended up only having to update 3 files. I updated the TurtleListInsertion class (the class the contains the entries for each row in the table) to add a variable to hold the Image data (which maps to a new column) and getters and setters for this data. I updated the TurtleViewTable class to add a new column and linked it to the new field created in the TurtleListInsertion class. This class is also where I had the most trouble with adding the CellValueFactory and onEditEvent using a CellEditEvent because I was not entirely comfortable with how these work and are implemented in Java. I also added a file chooser in this class to allow the user to select the new image they want to use for the turtle, so I had to pass in the JavaFX scene node to this class in order for the file chooser to display. Thus, an additional update needed to be made in the GUI class to pass in the scene to the TurtleViewTable class when it is instantiated in the main GUI class. 

did you get it completely right on the first try?

No, I did not get it completely right on the first try because of my unfamiliarity with using the Java objects mentioned above. 

### Analysis: what do you feel this exercise reveals about your project's design and documentation?
was it as good (or bad) as you remembered?

In the end, the code to implement this feature was pretty straightforward and concise (once I figured out how to work with the CellValueFactory and CellEditEvent in Java TableView). While that must mean that we did something right with our design, I also recognized so many flaws and things that we could have done better while reviewing the code.

what could be improved?

I think the main thing that could have been improved in front end design for this project would be implementing more of a Button hierarchy and more importantly controlling access and what gets passed in to instantiate these buttons (since some of the constructors took in ~ 7 or 8 parameters). Also, while doing the code review, I noticed a lot of small things stylistically that I would have liked to refactor.

what would it have been like if you were not familiar with the code at all?

I think it would have been a bit difficult to implement this feature (and in general work with the project's code) if I was not familiar with the code primarily because the code is not documented well enough that it is straightforward to a new programmer. Going back and trying to figure out certain dependencies in the code had made me appreciate rigorous documentation spelling out all the dependencies located in each class. During the individual projects, I didn't really recognize the need for this since all the design was fresh in my mind.
