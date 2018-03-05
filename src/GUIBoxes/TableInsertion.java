package GUIBoxes;

public class TableInsertion {
    private String VarName;
    private String Value;
 
    public TableInsertion(String varName, String value) {
        this.VarName = varName;
        this.Value = value;
    }
    
    public String getVarName() {
    	return VarName;
    }
    
    public String getValue() {
    	return Value;
    }
    

	public void setValue(String newValue) {
		Value = newValue;
		
	}
}
