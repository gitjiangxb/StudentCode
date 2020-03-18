package algorithm.study.maxheap;

import java.util.Iterator;
import java.util.Random;

/**
 * ���� �����顿ʵ������
 * @Package:algorithm.study.maxheap
 * @ClassName:Main
 * @Description:TODO 
 * @author:Jiangxb
 * @date:2019��3��28�� ����9:51:34
 *
 */
public class Main {
	/**
	 * @Title:testHeap
	 * @Description:TODO ��֤Heapify���� �� add�����ӵ�����
	 * @return:double
	 * @author:Jiangxb
	 * @date: 2019��3��29�� ����11:26:42
	 * 	isHeapifyΪtrue ��   Heapify����
	 * 	isHeapifyΪfalse �� add�����ӹ���
	 */
	private static double testHeap(Integer[] testData,boolean isHeapify){
		long startTime = System.nanoTime();
		MaxHeap<Integer> maxHeap;
		if(isHeapify){
			maxHeap = new MaxHeap<>(testData);
		}else{
			maxHeap = new MaxHeap<>();
			for (Integer num : testData) {
				maxHeap.add(num);
			}
		}
		/**
		 * ��֤�ѵ���ȷ��		
		 */
		// ������ѵ�Ԫ��
		int[] pop = new int[testData.length];
		for (int i = 0; i < testData.length; i++) {
			pop[i] = maxHeap.extractMax();
		}
		
		// ����У��(pop���飬Ӧ���ǴӴ�С���е�)
		for (int i = 1 ; i < testData.length ; i ++) {
			if(pop[i-1] < pop[i]){
				System.out.println("Error");
			}
		}
		System.out.println("Test MaxHeap completed.");
		
		long entTime = System.nanoTime();
		return (entTime - startTime) / 1000000000.0;
	}
	
	public static void main(String[] args){
		int n = 1000000;
		Random random = new Random();
		Integer[] testData = new Integer[n];
		// �����������в���n�������(0-���ֵ)
		for (int i = 0; i < n; i++) {
			testData[i] = random.nextInt(Integer.MAX_VALUE);
		}
		
		double time1 = testHeap(testData, false);
		System.out.println("Without heapify: " + time1 + " s");
		
		double time2 = testHeap(testData, true);
		System.out.println("With heapify: " + time2 + " s");
		
	}
}
