package textExcel;
//Nathan Tang 2nd period
// Update this file with your own code.

public class Spreadsheet implements Grid{
	Cell[][] cellSpreadsheet;
	public Spreadsheet(){
		cellSpreadsheet=new Cell[20][12];
	}
	@Override
	public String processCommand(String command){
		// TODO Auto-generated method stub
		String[] commandParts = command.split(" ");
		SpreadsheetLocation cell1=new SpreadsheetLocation(commandParts[0]);;
		if(commandParts.length==1&&!commandParts[0].equals("clear"))
			return getCell(cell1).abbreviatedCellText();
		return "";
	}
	@Override
	public int getRows(){
		return 20;
	}

	@Override
	public int getCols(){
		return 12;
	}

	@Override
	public Cell getCell(Location loc){
		return cellSpreadsheet[loc.getRow()][loc.getCol()];
	}

	@Override
	public String getGridText(){
		String top = "   "
				|A         |B         |C         |D         |E         |F         |G         |H         |I         |J         |K         |L         |"
		for(int i=)
		return null;
	}
}
