## [SLogo](https://www2.cs.duke.edu/courses/compsci308/spring18/assign/03_slogo) API Review

By: asa48, bmh43, dbp20, as734, and ym101

### Part 1
1.  What about your API/design is intended to be flexible?
    
    Our front end API, especially in the Turtle Object, is designed to be flexible in allowing additional movements and operations by just creating more public external methods that can be called on the back end. Additionally, by splitting the different object in the GUI into seperate classes and populating the GUI with them, it allows for reusability and customization of these objects.
    
2.  How is your API/design encapsulating your implementation decisions?
    
    Our design for the front end API encapsulates our implementation decsisions by including interfaces and abstract methods to make our objects customizable and flexible.
    
3.  What exceptions (error cases) might occur in your part and how will you handle them (or not, by throwing)?
    
    Exceptions are mainly handled on the front end using error box objects, which have a public external constructor. So when errors are discovered on the back end, they can create an instance of error box and pass in a string with the error message to be displayed on the front end.
    
4.  Why do you think your API/design is _good_ (also define what your measure of good is)?
    
    I think our API is well designed in the sense that we kept extensibility in mind and that our external part is well defined, making sure that communication with the back end has been thought out. I think the measure of good design is not only extensibility and flexibility, but also straightforwardness in communication with other parts of the program.
    

### Part 2
1.  How do you think Design Patterns are currently represented in the design or could be used to help improve the design?

    Currently, I think the Mediator and Model-View-Controllor design patterns best represent the current design of our project. This is mainly because we have separate front end GUI, back end model, and a mediator/controllor in the middle that has actions dictated by the model which is then updated in the view/GUI/

2.  What feature/design problem are you most excited to work on?

    I am most excited to work on implementing the resource files to support differnt languages.

3.  What feature/design problem are you most worried about working on?

    I am most worried about working on the separation of objects on the front end because although I didn't work on the front end in the previous project, I know we had a hard time with the isolation of GUI objects, so hopefully I can come up with solutions to separate out objects for the GUI.

4.  Come up with at least five use cases for your part (it is absolutely fine if they are useful for both teams).

    * Moving the Turtle
    * Setting a Background Color
    * Setting an Image for the Turtle
    * Clearing and Resetting the Screen
    * Displaying Error Boxes for Incorrect Commands