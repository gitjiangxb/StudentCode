package algorithm.study.linkedliststack.or.arraystack;

import java.util.Random;

/**
 * �Զ��嶯̬����ʵ�ֵ�ջ �Ա� ����ʵ�ֵ�ջ
 * @Package:algorithm.study.arraystack
 * @ClassName:Main
 * @Description:TODO 
 * @author:Jiangxb
 * @date:2019��3��14�� ����3:42:45
 * 
 */
public class Main {
	public static void main(String[] args) {
		// ����10�����
		int opCount = 100000;
		
		ArrayStack<Integer> arrayStack = new ArrayStack<>();
		double arrayStackTime = testStack(arrayStack, opCount);
		System.out.println("ArrayStack Time:" + arrayStackTime + " s");
		
		LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
		double linkedListStackTime = testStack(linkedListStack, opCount);
		System.out.println("LinkedListStack Time:" + linkedListStackTime + " s");
	}
	
	/**
	 * ����ʹ��stack����opCount��push(��ջ) �� pop(��ջ)��������Ҫ��ʵ�ʣ���λ����
	 * @Title:testStack
	 * @Description:TODO 
	 * @return:double
	 * @author:Jiangxb
	 * @date: 2019��3��14�� ����3:35:05
	 */
	private static double testStack(Stack<Integer> stack,int opCount){
		// ��ʼʱ��
		long startTime = System.nanoTime();
		
		// �����
		Random random = new Random();
		
		// ��ջ
		for (int i = 0; i < opCount; i++) {
			stack.push(random.nextInt(Integer.MAX_VALUE));
		}
		// ��ջ
		for (int i = 0; i < opCount; i++) {
			stack.pop();
		}
		
		//����ʱ��
		long endTime = System.nanoTime();
		
		// ����ʱ��(��)
		return  (endTime - startTime) / 1000000000.0;
	}
}
