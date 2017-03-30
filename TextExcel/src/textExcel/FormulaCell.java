package textExcel;

public class FormulaCell extends RealCell {
	private Spreadsheet spr;
	public FormulaCell(String value){
		//stores original string to be used
		super(value);
	}
	public FormulaCell(String value, Spreadsheet spr) {
		//Also has spreadsheet so the FormulaCell's value is updated as the Spreadsheet is updated
		super(value);
		this.spr=spr;
	}

	public String fullCellText(){
		//Returns formula
		return getString();
	}
	public String abbreviatedCellText(){
		//returns answer of the formula as a string
		return (getDoubleValue()+"           ").substring(0, 10);
	}
	public double getDoubleValue(){
		//returns the answer to the formula as a double
		String[] split = getString().split(" ");
		double answer=0;
		if(Character.isLetter(split[1].charAt(0))){
			SpreadsheetLocation loc = new SpreadsheetLocation(split[1]);
			answer=((RealCell) spr.getCell(loc)).getDoubleValue();
		}
		else
			answer=Double.parseDouble(split[1]);
		for(int i=0;i<split.length;i++){
			if(split[i].equals("+")){
				if(Character.isLetter(split[i+1].charAt(0))){
					SpreadsheetLocation loc = new SpreadsheetLocation(split[i+1]);
					answer+=((RealCell) spr.getCell(loc)).getDoubleValue();
				}
				else answer += Double.parseDouble(split[i+1]);
			}
			else if(split[i].equals("/")){
				if(Character.isLetter(split[i+1].charAt(0))){
					SpreadsheetLocation loc = new SpreadsheetLocation(split[i+1]);
					answer/=((RealCell) spr.getCell(loc)).getDoubleValue();
				}
				else answer /= Double.parseDouble(split[i+1]);
			}
				
			else if(split[i].equals("*")){
				if(Character.isLetter(split[i+1].charAt(0))){
					SpreadsheetLocation loc = new SpreadsheetLocation(split[i+1]);
					answer*=((RealCell) spr.getCell(loc)).getDoubleValue();
				}
				else answer *= Double.parseDouble(split[i+1]);
			}
			else if(split[i].equals("-")){
				if(Character.isLetter(split[i+1].charAt(0))){
					SpreadsheetLocation loc = new SpreadsheetLocation(split[i+1]);
					answer-=((RealCell) spr.getCell(loc)).getDoubleValue();
				}
				else answer -= Double.parseDouble(split[i+1]);
			}
		}
		return answer;
	}
	
}
