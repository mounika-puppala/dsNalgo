import java.util.*;

class ValidParenthesis {
  public static void main(String[] args){
    String s  = "[({[[{{{{{((((((}";
    System.out.print(isValidUsingCharArray(s));
  }

  //Solution 1 - using char array, Time Complexity(TC) - O(N), Space Complexity(SC) - O(N) 
  //Solution Rank=1,top solution bcs stack takes time due to thread safety, ArrayDeque also takes time
  public static boolean isValidUsingCharArray(String s){
    char[] ch = new char[s.length()];
    int i=-1;
    for(char c: s.toCharArray()){
      if(i==-1){
        ch[++i] = c;
      } else {
        if((ch[i]=='(' && c==')') || (ch[i]=='{' && c=='}') || (ch[i]=='[' &&c==']')){
           i--;  
        } else {
          ch[++i] = c;
        }
      }
    }
    return i==-1;
  }
  
  //Solution 2 - using stack, Time Complexity(TC) - O(N), Space Complexity(SC) - O(N)
  //Solution Rank=3
  public static boolean isValidUsingStack(String s){
    Stack<Character> stack = new Stack<>();
    for(Character c : s.toCharArray()){
        if(stack.empty()){
          stack.push(c);
      }else {
          if((stack.peek()=='(' && c==')') || (stack.peek()=='{' && c=='}') || (stack.peek()=='[' &&c==']')){
            stack.pop();
          } else {
            stack.push(c);
          }
      }
    }
    return stack.empty();
  }
  
  //Solution 3 - using ArrayDeque, Time Complexity(TC) - O(N), Space Complexity(SC) - O(N)
  //Solution Rank=2
  public static boolean isValidUsingArrayDeque(String s){
    // Using ArrayDeque is faster than using Stack class
    Deque<Character> stack = new ArrayDeque<>();
    for(int i=0; i< s.length(); i++){
      char c = s.charAt(i);
      
      //only push opening brackets
      if(c=='(' || c=='{' || c=='['){
        stack.push(c);
        continue;   
      }
      
      //reached this line means closing bracket
      // stack cannot be empty for closing bracket
      if(stack.isEmpty()) // --> stack has empty() method, ArrayDeque has isEmpty()
        return false;
      
      char check;
      switch(c){
      case ')':
          check = stack.pop();
          if(check!='(')
            return false;
          break;
      case '}':
          check = stack.pop();
          if(check!='{')
            return false;
          break;
      case ']':
          check = stack.pop();
          if(check!='[')
            return false; 
          break;
      }      
    }
    return stack.isEmpty();
  }
  
  
}
