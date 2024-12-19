import java.util.Scanner;

class StackNode {
    char data;
    StackNode next;

    // Constructor to initialize a node with given data
    public StackNode(char data) {
        this.data = data;
        this.next = null;
    }
}

class CustomStack {
    private StackNode top; // top node of the stack

    // Pushes (adds) a character onto the top of the stack
    public void push(char data) {
        StackNode newNode = new StackNode(data);
        newNode.next = top;
        top = newNode;
    }

    // Pops (removes) the topmost character from the stack
    public char pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop.");
            return '\0'; // Return null character for an empty stack (modify as needed)
        } else {
            char data = top.data;
            top = top.next;
            return data;
        }
    }

    // Checks if the stack is empty
    public boolean isEmpty() {
        return top == null;
    }
}

public class Q3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an arithmetic operation string: ");
        String input = scanner.nextLine();
        scanner.close();

        // Check if brackets are balanced and display result
        if (checkBalancedBrackets(input)) {
            System.out.println("Brackets are balanced.");
        } else {
            System.out.println("Brackets are not balanced.");
        }
    }

    // Function to check if brackets are balanced in the input string
    public static boolean checkBalancedBrackets(String input) {
        CustomStack stack = new CustomStack();

        // Iterate through each character in the input string
        for (char x : input.toCharArray()) {
            // Check if the character is a valid character (number, operator, or brackets)
            if (isValidCharacter(x)) {
                // If it's an opening bracket, push onto the stack
                if (isOpenBracket(x)) {
                    stack.push(x);
                }
                // If it's a closing bracket, check if it matches the most recent opening bracket on the stack
                else if (isCloseBracket(x)) {
                    if (stack.isEmpty() || !areMatchingBrackets(stack.pop(), x)) {
                        return false;
                    }
                }
            }
            // If it's an invalid character, print an error message and return false
            else {
                System.out.println("Error: Invalid character found in the input: " + x);
                return false;
            }
        }

        // Check if the stack is empty; if yes, brackets are balanced
        return stack.isEmpty();
    }

    // Function to check if a character is a valid character
    public static boolean isValidCharacter(char x) {
        return (x == '(' || x == ')' || x == '[' || x == ']' || x == '{' || x == '}' ||
                (x >= '0' && x <= '9') || x == '+' || x == '-' || x == '*' || x == '/');
    }

    // Function to check if a character is an opening bracket
    public static boolean isOpenBracket(char x) {
        return (x == '(' || x == '[' || x == '{');
    }

    // Function to check if a character is a closing bracket
    public static boolean isCloseBracket(char x) {
        return (x == ')' || x == ']' || x == '}');
    }

    // Function to check if two brackets are matching
    public static boolean areMatchingBrackets(char openBracket, char closeBracket) {
        return (openBracket == '(' && closeBracket == ')') ||
                (openBracket == '[' && closeBracket == ']') ||
                (openBracket == '{' && closeBracket == '}');
    }
}
