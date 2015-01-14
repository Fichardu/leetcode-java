/**
 *Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 *The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */

public class Solution {
    public boolean isValid(String s) {
        if (s == null || (s.length() % 2 != 0)) {
            return false;
        }
        LinkedList<Character> list = new LinkedList<Character>();
        char[] array = s.toCharArray();
        for (int i=0; i<array.length; ++i) {
            if (array[i] == ')') {
                if (list.isEmpty()) {
                    return false;
                }
                char c = list.pop();
                if (c != '(') return false; 
            } else if (array[i] == ']') {
                if (list.isEmpty()) {
                    return false;
                }
                char c = list.pop();
                if (c != '[') return false; 
            } else if (array[i] == '}') {
                if (list.isEmpty()) {
                    return false;
                }
                char c = list.pop();
                if (c != '{') return false; 
            } else {
                list.push(array[i]);
            }
        }
        if (list.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}