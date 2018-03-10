package GUIBoxes;

/**
 * Class needed to insert a row into UserDefTables
 * 
 * @author Calvin Ma
 *
 */

public class TableInsertion {
	private String VarName;
	private String Value;

	/**
	 * Constructor for TableInsertion
	 * 
	 * @param varName
	 *            - name of the variable
	 * @param value
	 *            - value associated with the variable
	 */
	public TableInsertion(String varName, String value) {
		this.VarName = varName;
		this.Value = value;
	}

	/**
	 * gets the variable name
	 * 
	 * @return variable name
	 */
	public String getVarName() {
		return VarName;
	}

	/**
	 * gets the value associated with var name
	 * 
	 * @return value
	 */
	public String getValue() {
		return Value;
	}

	/**
	 * sets the variable name
	 * 
	 * @param newVarName
	 *            - new name of the variable
	 */
	public void setVarName(String newVarName) {
		VarName = newVarName;

	}

	/**
	 * sets the value
	 * 
	 * @param newValue - new value
	 */
	public void setValue(String newValue) {
		Value = newValue;

	}
}
