import java.util.Scanner;
import java.util.Stack;

public class Skyscraper {
	// To order the stack values

	static void sortStack(Stack<Integer> refstack, Stack<Integer> tempstack) {
		while (!refstack.isEmpty()) {
			int x = refstack.pop();
			while (!tempstack.isEmpty() && tempstack.peek() > x) {
				refstack.push(tempstack.pop());
			}
			tempstack.push(x);
		}
	}

	// To reverse the stack values
	static void reverseStack(Stack<Integer> stack, Stack<Integer> refstack) {
		while (!stack.isEmpty()) {
			refstack.push(stack.pop());
		}
	}

	// Output part
	static void printStack(Stack<Integer> refstack, Stack<Integer> tempstack, Stack<Integer> stack, int count) {
		int day = count - (count - 1);
		int j;
		Stack<Integer> holdstack = new Stack<>();
		for (j = 1; j <= count; j++) {
			int a = refstack.pop();
			int b = tempstack.peek();
			if (a == b || j == count) {
				stack.push(a);
				tempstack.pop();
				while (!holdstack.isEmpty()) {
					stack.push(holdstack.pop());
				}
			} else {
				if (!holdstack.isEmpty()) {
					if (a < holdstack.peek()) {
						int k = holdstack.pop();
						holdstack.push(a);
						holdstack.push(k);
					} else {
						holdstack.push(a);
					}
				} else {
					holdstack.push(a);
				}
			}
			System.out.print("on day" + " " + day + " ");
			System.out.println(stack);
			day++;
			stack.clear();

		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Total Floor Count!");
		int count = sc.nextInt();
		int i;
		int size = 0;
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> refstack = new Stack<>();
		Stack<Integer> tempstack = new Stack<>();

		for (i = 1; i <= count; i++) {
			System.out.println("Enter the Floor Size for day:" + i);
			size = sc.nextInt();
			stack.add(size);
			refstack.add(size);

		}
		sortStack(refstack, tempstack);
		reverseStack(stack, refstack);
		printStack(refstack, tempstack, stack, count);

	}

}
