package commands;

import java.util.List;

import Turtle.Turtle;

public class ClearStamps extends Command{

    @Override
    double execute(List<CommandNode> children, Turtle t) {
	int initialSize = t.getStampMap().size();
	t.removeStamps();
	if (initialSize > t.getStampMap().size()) {
	    return 1;
	}
	return 0;
    }

    @Override
    int getNumberOfParameters() {
	return 0;
//=======
//	private final static int numParams = 0;
//	double one =1;
//	double zero =0;
//	
//	@Override
//	double execute(List<CommandNode> children, Turtle t) {
//	
//			return t.clearStamps();
//			




}

}
