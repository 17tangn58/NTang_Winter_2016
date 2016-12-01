/* Nathan Tang
 * 
 * 2nd period
 */
package fracCalc;
import java.util.*;
public class FracCalc {

	 public static void main(String[] args) 
	    {
	        // TODO: Read the input from the user and call produceAnswer with an equation
	    	Scanner userInput=new Scanner(System.in);
	    	System.out.println("Please type your problem");
	    	String equation=userInput.nextLine();
	    	while(equation!="quit"){
	    		System.out.println(produceAnswer(equation));
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
	        String[] expressionParts=parseInput(input);
			int[] parts1=parseOperands(expressionParts[0]);
	        int[] parts2=parseOperands(expressionParts[2]);
	        String answer="";
	        if(input.indexOf("+")>-1){
	        	answer=addFrac(parts1, parts2);
	        }
	        else if(input.indexOf("-")>-1)
	        	answer=subtractFrac(parts1, parts2);
	        else if(input.indexOf("*")>-1)
	        	answer=multiplyFrac(parts1, parts2);
	        return answer;
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
	    	int[] improperFrac = toImproperFrac(operandInt[0], operandInt[1], operandInt[2]);
	    	return improperFrac;
	    }
	    public static int[] toImproperFrac(int num1, int num2, int num3) {
			//This method makes a mixed number an improper fraction in array form
			int[] toImproperFrac=new int[2];
			toImproperFrac[0] = num1 * num3+ num2;
			toImproperFrac[1] = num3;
			return toImproperFrac;
		}
	    public static String addFrac(int[] operand1, int[] operand2){
	    	int commonDenom = operand1[1]*operand2[1];
	    	operand1[0] = operand1[0]*operand2[1];
	    	operand2[0] = operand1[1]*operand2[0];
	    	int finalNumerator = operand1[0]+operand2[0];
	    	String ans = finalNumerator+"/"+commonDenom;
	    	return ans;
	    }
		public static String subtractFrac(int[] operand1, int[] operand2){
			operand2[0]=operand2[0]*(-1);
			String ans = addFrac(operand1, operand2);
			return ans;
		}
		public static String multiplyFrac(int[] operand1, int[] operand2){
			operand1[0]= operand1[0]*operand2[0];
			operand1[1] = operand2[1]*operand2[1];
			String ans = operand1[0]+"/"+operand1[1];
			return ans;
		}
		public static String divideFrac(int[] operand1, int[] operand2){
			int temp=operand2[0];
			operand2[0]=operand2[1];
			operand2[1]=temp;
			String ans = multiplyFrac(operand1,operand2);
			return ans;
		}
	}

