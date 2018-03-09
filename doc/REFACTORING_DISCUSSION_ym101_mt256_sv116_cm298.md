# Static Code Review and Refactoring
By: Stefani Vukajlovic (sv116), Miles Todzo (mt256), Yashas Manjunatha (ym101) and Calvin Ma (cm298)

### Duplication Refactoring
* Additionaly, we are going to remove duplication in our code in GUI class by moving these hard coded values into a resources file. Also, in the TurtleViewTable we will create an abstract method to initalize each column of the table to reduce duplication, complexity, and length of the method.
* The back end duplication code is due to the print statements that we used to debug the code, we will remove those at the end.

### Checklist Refactoring
* The checklist was very helpful for refactoring a lot of small things including adding brackets, removing unused imports, and other issues.
* Code Smells return no errors, which is great. 

### General Refactoring
* In general, we have been continually refactoring our code as we have progressed in our project so we did not have to do as much work today.
* We didn't initially didn't account for the fact that we would be needing multiple screens, so we had to refactor our main class into an individual GUI class that holds all of the GUI objects. This allows us to initialize a new "gui" whenever we need a new workspace - in this case, a new tab for the tab pane. Also, in order to decrease the number of the parameters needed for each GUI object, we are planning to create a new object that contains all of the gui objects. this allows us to access each GUI object from this one object. 