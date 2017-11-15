package InfixToPostfix;
import java.util.*;



public class GetInput {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the number of variables");
		int var_num = sc.nextInt();
	    String [] ar_var = new String[var_num];
	    String[] ar_values = new String[var_num];
	   
	    for(int i=0; i<var_num; i++) {
	    	System.out.println("Please enter the variable and its value");
			String str = sc.next();
		    String[] words = str.split("=");
			ar_var[i] = words[0];
			ar_values[i] = words[1];
		
			
	    }
	    
	    System.out.println("Please enter the number of expressions");
	    int exp_num = sc.nextInt();
	    String [] ar_exp = new String[exp_num];
	    String [] ar_postfix = new String[exp_num];
	    int [] ar_numbers = new int[var_num];
	    
	    
	    
	    for(int i=0; i<var_num; i++) {
	    	
	    	ar_numbers[i]= Integer.parseInt(ar_values[i]);
	    	
	    }
	    
	    
	    
	    
	    for(int i=0; i<exp_num; i++) {
	    	
	    	System.out.println("Please enter expression number "+(i+1));
			String str = sc.next();
			ar_exp[i] = str;
			//System.out.println(ar_exp[i]);
			
	    }
	    
	   // ToPostFix p = new ToPostFix("a+b-c+d");
	    for(int i=0; i<exp_num; i++) {
	    	String str = ar_exp[i];
	    	MyConverter mc = new MyConverter(str);
	    	ar_postfix[i] =  mc.releaseExp();
	    	//System.out.println(ar_postfix[i]);	
	    }
	    
	    for(int i=0; i< exp_num; i++) {
	    	Stack st = new Stack();
	    	String expression = ar_postfix[i];
	    	for(int a =0; a< expression.length(); a++) {
	    		char curchar = expression.charAt(a);
	    		if(!isitOperator(curchar)) {
	    			
	    			for(int x=0; x< var_num; x++) {
	    				String varString = ar_var[x];
	    				char varchar = varString.charAt(0);
	    				if(curchar == varchar) {
	    					st.push(ar_numbers[x]);
	    				}
	    				
	    			}
	    			
	    		}
	    		else{
	    			
	    			int pop1 = (int) st.pop();
	    			
	    			int pop2 = (int) st.pop();
	    			int result;
	    			
					if(curchar == '*') {
	    				result = pop1*pop2;
	    				st.push(result);
	    			}
	    			else if(curchar == '/') {
	    				result = (pop2/pop1);
	    				st.push(result);
	    			}
	    			else if(curchar == '+') {
	    				result = pop2 + pop1;
	    				st.push(result);
	    				
	    			}
	    			else if(curchar == '-'){
	    				result = pop2 - pop1;
	    				st.push(result);
	    			}
	    			else {
	    				System.out.println("Compilation error");
	    				break;
	    			}
	    		}
	    	}
	    	System.out.println("result: "+ st.pop());
	    }
	   

	}

	private static boolean isitOperator(char curchar) {
		switch (curchar) {
		case '+':
			return true;
		case '-':
			return true;
		case '*':
			return true;
		case '/':
			return true;
		default:
			return false;

		}

	}
}
	  
