package algorithm.study.linkedlistqueue;
/**
 * ���� ����ʵ�ֶ���
 * @Package:algorithm.study.linkedlistqueue
 * @ClassName:Main
 * @Description:TODO 
 * @author:Jiangxb
 * @date:2019��3��15�� ����1:42:13
 *
 */
public class Main {
	public static void main(String[] args) {
		LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
		
		for (int i = 0; i < 10; i++) {
			linkedListQueue.enqueue(i);
			System.out.println(linkedListQueue);
			// ÿ�������Ԫ�� �ͳ���һ��Ԫ��
			if(i % 3 == 2){
				linkedListQueue.dequeue();
				System.err.println(linkedListQueue);
			}
		}
	}
}
