package algorithm.study.queue;

import java.util.Random;

/**
 * ����������С�ѭ�����С����������ѭ���������������(linkedlist����)�ıȽ�
 * @Package:algorithm.study.queue
 * @ClassName:Main
 * @Description:TODO 
 * @author:Jiangxb
 * @date:2019��3��14�� ����3:51:33
 *
 */
public class Main {
	public static void main(String[] args) {
//		ArrayQueue<Integer> queue = new ArrayQueue<>();
//		for (int i = 0; i < 6; i++) {
//			queue.enqueue(i);
//			System.err.println(queue);
//			// ÿ�������Ԫ�� �ͳ���һ��Ԫ��
//			if(i % 3 == 2){
//				queue.dequeue();
//				System.err.println(queue);
//			}
//		}
		
//		LoopQueue<Integer> loopQueue = new LoopQueue<>();
//		for (int i = 0; i < 10; i++) {
//			loopQueue.enqueue(i);
//			System.err.println(loopQueue);
//			// ÿ�������Ԫ�� �ͳ���һ��Ԫ��
//			if(i % 3 == 2){
//				loopQueue.dequeue();
//				System.err.println(loopQueue);
//			}
//		}
		
		// ����10�����
		int opCount = 100000;
		ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
		double arrayQueueTime = testQueus(arrayQueue, opCount);
		System.out.println("ArrayQueue Time:" + arrayQueueTime + " s");
		
		LoopQueue<Integer> loopQueue = new LoopQueue<>();
		double loopQueueTime = testQueus(loopQueue, opCount);
		System.out.println(" LoopQueue Time:" + loopQueueTime + " s");
		
		LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
		double linkedListQueueTime = testQueus(linkedListQueue, opCount);
		System.out.println("LinkedListQueue Time:" + linkedListQueueTime + " s");
	}
	
	/**
	 * ����ʹ��q����opCount��enqueue(���) �� dequeue(����)��������Ҫ��ʵ�ʣ���λ����
	 * @Title:testQueus
	 * @Description:TODO 
	 * @return:double
	 * @author:Jiangxb
	 * @date: 2019��3��14�� ����10:01:19
	 */
	private static double testQueus(Queue<Integer> q,int opCount){
		// ��ʼʱ��
		long startTime = System.nanoTime();
		
		// �����
		Random random = new Random();
		
		// ���
		for (int i = 0; i < opCount; i++) {
			q.enqueue(random.nextInt(Integer.MAX_VALUE));
		}
		// ����
		for (int i = 0; i < opCount; i++) {
			q.dequeue();
		}
		
		//����ʱ��
		long endTime = System.nanoTime();
		
		// ����ʱ��(��)
		return  (endTime - startTime) / 1000000000.0;
	}
}
