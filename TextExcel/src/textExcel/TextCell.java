package textExcel;

public class TextCell implements Cell {
	private String text;
	public TextCell(String line){
		text=line;
	}
	
	public String abbreviatedCellText() {
		//Returns the text of the cell, cut off at ten characters
		if(text.length()-1>10){
			if(text.substring(0, 1).equals("\"")){
				if(text.substring(10, 11).equals("\""))
					return text.substring(1, 10);
				return text.substring(1, 11);
			}
			else
				return text.substring(0, 10);
		}	
		else
			return String.format("%-10s", text.substring(1, text.length()-1));
				
	}
	
	public String fullCellText() {
		//Returns the full String inputted
		return text;
	}

}
