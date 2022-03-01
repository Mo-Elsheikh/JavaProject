
public class TestClass {

	public static void main(String[] args) {
		MyStack stack = new MyStack <String> ();
		stack.push("l");
		stack.push("j");
		stack.peek();
		System.out.println(stack.pop());
		System.out.println(stack.peek());

	}

}
