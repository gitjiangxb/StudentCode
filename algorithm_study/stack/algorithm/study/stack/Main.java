package algorithm.study.stack;

public class Main {
	public static void main(String[] args) {
		ArrayStack<Integer> stack = new ArrayStack<>();
		
		for (int i = 0; i < 5; i++) {
			// ��ջ
			stack.push(i);
			System.out.println(stack);
		}
		
		// ��ջ
		stack.pop();
		System.out.println(stack);
		
		System.out.println("ջ����" + stack.peek());
	}
}
