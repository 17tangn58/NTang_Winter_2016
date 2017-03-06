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
			getGridText();
		if(commandParts.length==1&&commandParts[0].equals("clear"))
			clear();
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
		return cellSpreadsheet[loc.getRow()][loc.getCol()];
	}

	@Override
	public String getGridText(){
		System.out.println("   |A         |B         |C         |D         |E         |F         |G         |H         |I         |J         |K         |L         |");
		for(int i=0;i<cellSpreadsheet.length;i++){
			System.out.printf(i+1+"");
			for(int j=0;j<cellSpreadsheet[i].length;j++){
				char row=(char) (i+65);
				int col=j+1;
				String loc=row+""+col;
				SpreadsheetLocation cellLoc=new SpreadsheetLocation(loc);
				System.out.print(getCell(cellLoc));
			}
		}
		return "";
	}
	public void clear(){
		for(Cell[] i: cellSpreadsheet){
			for(Cell j: i)
				j=new EmptyCell();
		}
		getGridText();
	}
}

