# Slogo Team 09

## Slogo Design Discussion

### High-Level Design Goals
* Create a development environment that helps users write SLogo programs that is extendable and adds functionality as defined by 
  the programming language.
* Create External and Interal APIs for the frontend and backend. The backend should be able to use the frontend API and visa versa.
* Have a flexible Turtle object that can have additional methods to support different movements and functionality and a backend that 
  can support added Command objects for new commands.


### How to Add New Features
* Adding new features depends on what you want to add. If you want to add a new command, you just need to create a new class for the
  corresponding command. Then, you could either call the external API of the turtle if you want to do any movement actions on the 
  future. Otherwise, you could do any arithmetic you want, as long as it returns a single double value. If you want to add a new feature 
  onto the Gui, you would have to write a class for it and then create a new instance of it in the Gui class. Within the constructor, you 
  would have to add the other GUIObjects that you want the new object to interact with. It's also important to include the pane as part of
  the constructor, since the object will have to add itself to the pane. This means the new object that you want to use either has to extend
  a "Node" type or the new object you add is a "Node". 

### Major Design Choices
* Implementation of Factory Pattern in the back end for the implementation od command objects. This implementation allowed for easier 
  extentions of commands. 
* Turtle as an interface between front and backend
* Turtle movement will be kept in the frontend, in addition to the user-defined variables and user-defined functions. The maps of 
  user-defined things will be passed to the backend to update. 
* Turtle "moves itself" instead of the backend directly altering the x and y values. The backend simply gives a double and then the
  turtle determines what the next location it will be at is. 

### Assumptions to Simplify/Resolve Ambiguities
* We passed all turtles into the backend Command object instead of just active turtles like we had initially. This made it so that the
  backend determines how to operate on the turtle, given the turtle's external API, instead of the frontend. This gives the backend more
  flexibility of what turtle's to operate on. It also allows for more flexibility and extensibility within the backend since it has more
  control over the turtle and how the turtle responds as part of a command. 