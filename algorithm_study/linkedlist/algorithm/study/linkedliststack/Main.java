package algorithm.study.linkedliststack;

/**
 * ���� ����ʵ�ֵ�ջ
 * @Package:algorithm.study.linkedliststack
 * @ClassName:Main
 * @Description:TODO 
 * @author:Jiangxb
 * @date:2019��3��14�� ����3:43:29
 *
 */
public class Main {
	public static void main(String[] args) {
		LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
		
		for (int i = 0; i < 5; i++) {
			linkedListStack.push(i);
			System.out.println(linkedListStack);
		}
		
		linkedListStack.pop();
		System.out.println(linkedListStack);
	}
}
