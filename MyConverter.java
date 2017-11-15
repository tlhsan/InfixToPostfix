package InfixToPostfix;

import java.util.Stack;

public class MyConverter {
	String expression = "";
	
	public MyConverter(String str) {
		Stack st = new Stack();
		
		for(int i=0; i<str.length(); i++) {
			char currentChar = str.charAt(i);
			if(!isOperator(currentChar)) {
				expression += Character.toString(currentChar);
				
				if(i == (str.length()-1)) {
					
					while(!st.isEmpty()) {
						expression += st.pop();
						
						
					}
						
					
				}
			}
			else {
				if(st.isEmpty()) {
					st.push(currentChar);
					
					
				}
				else {
					
					char ch = (char) st.peek();
					if(ch=='+' || ch=='-' ){
						if(currentChar=='/' || currentChar=='*') {
							st.push(currentChar);
							continue;
						}
					}
					if(ch=='/' || ch=='*' ){
						if(currentChar=='+' || currentChar=='-') {
							while(!st.isEmpty()) {
								expression += st.pop();
							}
							
							
							
							st.push(currentChar);
							continue;
						}
					}

					
					expression += st.pop();
					
					st.push(currentChar);	
				
					
					
					
				}
				
			}
			
			
		}
		System.out.println(expression);
		releaseExp();
		
		
	}



	public String releaseExp() {
		return expression;
		
		
	}



	private boolean isOperator(char ch) {

		switch (ch) {
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
