package algorithm.study.maxheapsolution;

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
public class Solution5 {
	
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
		PriorityQueue<Integer> pq = new PriorityQueue<>(
				// jdk1.8 �ṩ��Lambda ���ʽ�������Solution4�е�������
				(a,b) -> treeMap.get(a) - treeMap.get(b)
		);
		
        for(int key: treeMap.keySet()){
            if(pq.size() < k)
                pq.add(key);
            else if(treeMap.get(key).compareTo(treeMap.get(pq.peek())) > 0){
                pq.remove();
                pq.add(key);
            }
            
            if(pq.size() > 0){
				System.out.println(treeMap.get(pq.peek()));	// �������ȶ��� ����
			}
        }

        LinkedList<Integer> res = new LinkedList<>();
        while(!pq.isEmpty())
            res.add(pq.remove());
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
        printList((new Solution5()).topKFrequent(nums, k));
	}
}
