package algorithm.study.maxheapsolution;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * �����leetcode347:ǰk����ƵԪ��;����java�ṩ�����ȶ��С���С�ѡ�
 * @Package:algorithm.study.solution
 * @ClassName:Solution
 * @Description:TODO 
 * @author:Jiangxb
 * @date:2019��3��29�� ����2:22:40
 *	ʾ����[1,1,1,2,2,3]��k=2������[1,2]
 *	java�ṩ��PriorityQueue���ڲ�Ĭ���� ����С�ѡ�
 */
public class Solution1 {
	
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
         */
        @Override
        public int compareTo(Freq another){
        	// Ƶ��Խ�� ���ȼ� Խ��
            if(this.freq > another.freq)
                return 1;
            else if(this.freq < another.freq)
                return -1;
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
		PriorityQueue<Freq> pq = new PriorityQueue<>();
        for(int key: treeMap.keySet()){
            if(pq.size() < k)
                pq.add(new Freq(key, treeMap.get(key)));
            else if(treeMap.get(key).compareTo(pq.peek().freq) > 0){
                pq.remove();
                pq.add(new Freq(key, treeMap.get(key)));
            }
            
            if(pq.size() > 0){
				System.out.println(pq.peek().e);	// �������ȶ��� ����
			}
        }

        LinkedList<Integer> res = new LinkedList<>();
        while(!pq.isEmpty())
            res.add(pq.remove().e);
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
        printList((new Solution1()).topKFrequent(nums, k));
	}
}
