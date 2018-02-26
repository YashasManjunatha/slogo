Part 1

* What about your API/design is intended to be flexible: each turtle implements two interfaces (drawable and updatable). This makes it easy to add new features to the GUI- each aspect of the GUI has its own class. 

* How is your API/design encapsulating your implementation decisions: It is encapsulating the implementation decision because the API doesn't give direct access to the action of the turtle - they are simply public methods that can be called. The actual details of the method will be in whatever class implements the interface. 

* What exceptions (error cases) might occur in your part and how will you handle them (or not, by throwing): the backend will throw an exception and the front end will show an error message indicating the error. Then, the erroneous command will show up in its own box that can be clicked on and inserted into the text input area. 

* Why do you think your API/design is good (also define what your measure of good is): My partner's API is good because it allows for a lot of flexibility on the front end. With an API for the turtles and inheritance for other GUI objects, adding new objects is fairly simple. 

Part 2

* How do you think Design Patterns are currently represented in the design or could be used to help improve the design: There's a model view controller for communication between the front and and the back end. This keeps the front end and back end separate. Another design patter is a factory for the commands. Need to make sure how strictly to follow the model view design controller pattern. 

* What feature/design problem are you most excited to work on: changing the language. 

* What feature/design problem are you most worried about working on: integrating the front end with the back end, especially dealing with the model view controller design patter. 

* Use Cases: user types invalid command - the command goes to the backend where the parser will throw an error. The front end will catch this error and create an alert box on the GUI. The command will then saved in the previousCommandsBox. User wants to change color: there will be a combo box on the front end that has a drop down of different pretty colors for the user to choose from. This is the same with the other changes that can be made to the 


