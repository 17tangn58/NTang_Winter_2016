
package textExcel;
//Nathan Tang 2nd period
public class EmptyCell implements Cell {

	public String abbreviatedCellText() {
		// Empty
		return String.format("%-10s", "");
	}
	@Override
	public String fullCellText() {
		// Empty
		return "";
	}
}
