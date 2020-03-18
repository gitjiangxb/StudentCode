package algorithm.study.setsolution;

import java.util.ArrayList;
import java.util.TreeMap;


/**
 * leetcode350����������Ľ���(�����ظ���Ԫ��)
 * @Package:algorithm.study.setsolution
 * @ClassName:Solution1
 * @Description:TODO 
 * @author:Jiangxb
 * @date:2019��3��27�� ����10:49:28
 * 	TreeMap �ײ���ڡ�ƽ�����������ʵ��
 *	��������ü�����ʵ�֣�������ӳ����ʵ��
 */
public class Solution2 {
	
	public static int[] intersection(int[] nums1,int[] nums2){
		// key��Ԫ�� ��value��Ƶ��
		TreeMap<Integer, Integer> treeMap = new TreeMap<>();
		
		for (int num : nums1) {
			if(!treeMap.containsKey(num)){
				treeMap.put(num, 1);	// ���������keyʱ��Ƶ�θ�ֵ1
			}else{
				treeMap.put(num, treeMap.get(num) + 1);	// �����ڣ�value+1
			}
		}
		
		// ������¼����
		ArrayList<Integer> list = new ArrayList<>();
		
		for (int num : nums2) {
			// treeMap�д������key��ʱ����ӵ�list��
			if(treeMap.containsKey(num)){
				list.add(num);
				treeMap.put(num, treeMap.get(num) - 1);	// ���ҵ�һ�Σ����޸�Ƶ��-1
				if(treeMap.get(num) == 0){
					treeMap.remove(num);	// ��Ƶ�ε���0������ɾ����
				}
			}
		}
		
		int[] res = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			res[i] = list.get(i);
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] nums1 = {4,9,5,8};
		int[] nums2 = {4,9,8,9,4};
			
		int[] num = intersection(nums1, nums2);
		System.out.println(num.length);
	}
}
