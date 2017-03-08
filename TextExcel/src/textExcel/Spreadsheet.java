package textExcel;
//Nathan Tang 2nd period
// Update this file with your own code.

public class Spreadsheet implements Grid{
	Cell[][] sprsheet;
	public Spreadsheet(){
		sprsheet=new Cell[20][12];
	}
	@Override
	public String processCommand(String command){
		// TODO Make it not have errors
		String[] commandParts = command.split(" ");
		if(commandParts.length==1&&commandParts[0].equals("clear"))
			return clear();
		SpreadsheetLocation loc=new SpreadsheetLocation(commandParts[0]);
		if(commandParts.length==1&&!commandParts[0].equals("clear"))
			return getCell(loc).fullCellText();
		else if(commandParts[1].equals("=")){
			sprsheet[loc.getRow()][loc.getCol()]= new TextCell(commandParts[2]);
			return getGridText();
		}
		else if(commandParts[0].equals("clear")){
			sprsheet[loc.getRow()][loc.getCol()]=new EmptyCell();
			return getGridText();
		}
		else
			return command;
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
		return sprsheet[loc.getRow()][loc.getCol()];
	}

	@Override
	public String getGridText(){
		String s="   |";
		for(int i=0;i<12;i++){
			s=s+(char)('A' + i)+"         |";
		}
		for(int i=0;i<sprsheet.length;i++){
			s+=String.format("%-3d|", i+1);
			for(int j=0;j<sprsheet[i].length;j++){
				char row=(char) (j+65);
				int col=j+1;
				String loc=row+""+col;
				SpreadsheetLocation cellLoc=new SpreadsheetLocation(loc);
				s=s+getCell(cellLoc).abbreviatedCellText()+"|";
			}
			s=s+"\n";
		}
		return s;
	}
	public String clear(){
		for(Cell[] i: sprsheet){
			for(Cell j: i)
				j=new EmptyCell();
		}
		return getGridText();
	}
}

