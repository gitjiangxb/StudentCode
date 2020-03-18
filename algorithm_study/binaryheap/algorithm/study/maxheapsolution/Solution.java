package algorithm.study.maxheapsolution;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

import algorithm.study.maxheapqueue.PriorityQueue;

/**
 * �����leetcode347:ǰk����ƵԪ�أ����ڡ����ѡ�ʵ�ֵĶ���
 * @Package:algorithm.study.solution
 * @ClassName:Solution
 * @Description:TODO 
 * @author:Jiangxb
 * @date:2019��3��29�� ����2:22:40
 *	ʾ����[1,1,1,2,2,3]��k=2������[1,2]
 */
public class Solution {
	
	private class Freq implements Comparable<Freq>{
		
        public int e;		// ���Ƶ��<1,3>��key��1 ����(1����������)
        public int freq;	// ���Ƶ��<1,3>��value��3 ����(1����������)

        public Freq(int e, int freq){
            this.e = e;
            this.freq = freq;
        }
        
        /**
         * �������ȶ�����˵���ǿɱȽϵģ������д�����
         * compareTo
         * 	���ָ�������������ȷ���0��
         * 	���ָ������С�ڲ���ʱ����-1��
         * 	���ָ���������ڲ���ʱ����1
         * 
         * ��˵��������Ϊ�Լ�ʵ�ֵ�������ȶ����ǻ������ѣ�����Ϊ��Ƶ��Խ�� ���ȼ� Խ�ߡ���
         * 	�ʶ��Ƚ�ʱӦ�÷���������Ƶ�ε͵Ľڵ����Ѷ���
         * ������{1=1, 2=2, 3=3} k=2
         * 	��������(Ƶ��)����һ�����Ѷ�Ϊ1���ڶ��������ʱ(2>1)���Ѷ�Ϊ2������Ϊ1��
         */
        @Override
        public int compareTo(Freq another){
        	// Ƶ��Խ�� ���ȼ� Խ��
            if(this.freq > another.freq)
                return -1; 	// ������������return 1
            else if(this.freq < another.freq)
                return 1;	// ������������return -1
            else
                return 0;
        }
    }
	
	public List<Integer> topKFrequent(int[] nums, int k) {
		// Ƶ��ͳ��<num��ֵ��Ƶ��Ĭ��1>
		TreeMap<Integer, Integer> treeMap = new TreeMap<>();
		for (int num : nums) {
			if(treeMap.containsKey(num)){
				// ������key����value+1
				treeMap.put(num, treeMap.get(num) + 1);
			}else{
				treeMap.put(num, 1);
			}
		}
		
		// ���ȶ���(Ƶ��Խ�� ���ȼ� Խ��)
		PriorityQueue<Freq> queue = new PriorityQueue<>();
		for (int key : treeMap.keySet()) {
			if(queue.getSize() < k){
				queue.enqueue(new Freq(key, treeMap.get(key)));
			}else if(treeMap.get(key).compareTo(queue.getFront().freq) > 0){
				queue.dequeue();
				queue.enqueue(new Freq(key, treeMap.get(key)));
			}
			if(queue.getSize() > 0){
				System.out.println(queue.getFront().e);		// �������ȶ��� ����
			}
		}
		
		LinkedList<Integer> res = new LinkedList<>();
        while(!queue.isEmpty())
            res.add(queue.dequeue().e);
        return res;
	}
	
	private static void printList(List<Integer> nums){
        for(Integer num: nums)
            System.out.print(num + " ");
        System.out.println();
    }
	
	public static void main(String[] args) {
		int[] nums = {1, 2, 2, 3 , 3 ,3};
        int k = 2;
        printList((new Solution()).topKFrequent(nums, k));
	}
}
