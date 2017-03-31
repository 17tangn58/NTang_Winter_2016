package textExcel;

public class PercentCell extends ValueCell {
	private double percent;
	public PercentCell(String value){
		//stores both original string and double value of the string
		super(value);
		percent=Double.parseDouble(value);
	}
	public String fullCellText(){
		//returns percentage as a string in decimal form
		return ""+percent/100;
	}
	public String abbreviatedCellText(){
		//truncates the percentage
		return String.format("%-10s", getString().substring(0, getString().indexOf("."))+"%");
	}
	public double getDoubleValue(){
		//returns percentage in decimal form
		return percent/100;
	}
	
}