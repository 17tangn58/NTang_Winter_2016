/* Nathan Tang
 * 
 * 2nd period
 */
package fracCalc;
import java.util.*;
public class FracCalc {

	public static void main(String[] args) {
		// TODO: Read the input from the user and call produceAnswer with an equation
		Scanner userInput=new Scanner(System.in); 
		System.out.println("Please type your problem");
		String equation=userInput.nextLine();
		while(equation.equals("quit")==false){
			if(equation.indexOf("quit")<=0)
				System.out.println(produceAnswer(equation));
			System.out.println("Please type another problem or quit if you want to stop");
			equation=userInput.nextLine();
		}
	}

	// ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
	// This function takes a String 'input' and produces the result
	//
	// input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
	//      e.g. input ==> "1/2 + 3/4"
	//        
	// The function should return the result of the fraction after it has been calculated
	//      e.g. return ==> "1_1/4"
	public static String produceAnswer(String input){ 
		// TODO: Implement this function to produce the solution to the input
		if((input.equals("quit"))){
			return "";
		}
		else{
			String[] expressionParts=parseInput(input);
			int[] parts1=parseOperands(expressionParts[0]);
			int[] parts2=parseOperands(expressionParts[2]);
			int[] answer= new int[2];
			if(expressionParts[1].equals("+")){
				answer=addFrac(parts1, parts2);
			}
			else if(expressionParts[1].equals("-"))
				answer=subtractFrac(parts1, parts2);
			else if(expressionParts[1].equals("*"))
				answer=multiplyFrac(parts1, parts2);
			else
				answer=divideFrac(parts1, parts2);
			String simpAns = simplifyFrac(answer);
			return simpAns;
		}

	}

	// TODO: Fill in the space below with any helper methods that you think you will need
	public static String[] parseInput(String expression){
		String[] parts = expression.split(" ");
		return parts;
	}
	public static int[] parseOperands(String operand){
		String[] findWhole = operand.split("_");
		String[] fraction = findWhole[findWhole.length-1].split("/");
		String[] operandParts = new String[3];
		operandParts[2]="1";
		int[] operandInt = new int[3];
		if(operand.indexOf("_")<0&&operand.indexOf("/")>=0){
			operandParts[0]="0";
		}
		else {
			operandParts[0]=findWhole[0];
		}
		if(operand.indexOf("/")<0){
			operandParts[1]="0";
			operandParts[2]="1";
		}
		else {
			operandParts[1]=fraction[0];
			operandParts[2]=fraction[1];
		}
		for(int i=0;i<operandParts.length;i++){
			operandInt[i]=Integer.parseInt(operandParts[i]);
		}
		if(operandInt[0]<0)
			operandInt[1]=operandInt[1]*-1;
		int[] improperFrac = toImproperFrac(operandInt[0], operandInt[1], operandInt[2]);
		return improperFrac;
	}
	public static int[] toImproperFrac(int num1, int num2, int num3) {
		//This method makes a mixed number an improper fraction in array form
		int[] toImproperFrac=new int[2];
		toImproperFrac[0] = num1 * num3 + num2;
		toImproperFrac[1] = num3;
		return toImproperFrac;
	}
	public static int[] addFrac(int[] operand1, int[] operand2){
		int[] ans = new int[2];
		int commonDenom = operand1[1]*operand2[1];
		operand1[0] = operand1[0]*operand2[1];
		operand2[0] = operand1[1]*operand2[0];
		int finalNumerator = operand1[0]+operand2[0];
		ans[0]=finalNumerator;
		ans[1]=commonDenom;
		return ans;
	}
	public static int[] subtractFrac(int[] operand1, int[] operand2){
		operand2[0]=operand2[0]*(-1);
		int[] ans = addFrac(operand1, operand2);
		return ans;
	}
	public static int[] multiplyFrac(int[] operand1, int[] operand2){
		int[] ans = new int[2];
		ans[0]= operand1[0]*operand2[0];
		ans[1] = operand1[1]*operand2[1];
		return ans;
	}
	public static int[] divideFrac(int[] operand1, int[] operand2){
		int[] newOperand = new int[2];
		newOperand[0]=operand2[1];
		newOperand[1]=operand2[0];
		int[] ans = multiplyFrac(operand1, newOperand);
		return ans;
	}
	public static String simplifyFrac(int[] fraction){
		int[] mixedNum = new int[3];
		mixedNum[0]=fraction[0]/fraction[1];
		mixedNum[1]=fraction[0]%fraction[1];
		mixedNum[2]=fraction[1];			
		if(mixedNum[1]==0)
			return mixedNum[0]+"";
		
		else{
			int commonDenom=gcf(mixedNum[1], mixedNum[2]);
			if (mixedNum[1]<0&&mixedNum[0]==0)
				mixedNum[1]=(mixedNum[1]/commonDenom);
			else if (mixedNum[1]<0&&mixedNum[2]<0)
				mixedNum[1]=((-1)*mixedNum[1]/commonDenom);
			else if(mixedNum[1]<0)
				mixedNum[1]=Math.abs(mixedNum[1]/commonDenom);
			else
				mixedNum[1]=(mixedNum[1]/commonDenom);
			mixedNum[2]=Math.abs(mixedNum[2]/commonDenom);
			if(mixedNum[0]==0&&mixedNum[1]!=0)
				return mixedNum[1]+"/"+mixedNum[2];
			return mixedNum[0]+"_"+mixedNum[1]+"/"+mixedNum[2];
		}
	}
	public static int gcf(int num1, int num2){
		/*This method finds the greatest common factor between two numbers using a loop to calculate whether those two numbers are
			divisible by another number
		 */
		int ans= 1;
		for(int i=1; i<=num1 || i<=num2; i++){
			if (isDivisibleBy(num1, i) && isDivisibleBy(num2, i)) {
				ans= i;
			}
		}
		return ans;
	}
	public static boolean isDivisibleBy(int num1, int num2) {
		//This method tells the user whether one number divided by another results in a whole number
		if (num1%num2==0)
			return(true);
		else;
		return(false); 
	}
	public static void asdkfahsdlf(){
		
	}
}
