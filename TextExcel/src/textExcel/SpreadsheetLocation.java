package textExcel;
//Nathan Tang 2nd period
//Update this file with your own code.

public class SpreadsheetLocation implements Location{
    private int row;
    private int col;
	@Override
    public int getRow(){
        return row;
    }

    @Override
    public int getCol(){
        return col;
    }
    
    public SpreadsheetLocation(String cellName){
    	char column =cellName.charAt(0);
    	col=column-65;
    	row=Integer.parseInt(cellName.substring(1))-1;
    }

}
