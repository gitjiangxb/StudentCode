package algorithm.study.setsolution;

import java.util.ArrayList;
import java.util.TreeSet;


/**
 * leetcode349����������Ľ���(�������ظ���Ԫ��)
 * @Package:algorithm.study.setsolution
 * @ClassName:Solution1
 * @Description:TODO 
 * @author:Jiangxb
 * @date:2019��3��27�� ����10:49:28
 * TreeSet �ײ���ڡ�ƽ�����������ʵ��
 */
public class Solution1 {
	
	public static int[] intersection(int[] nums1,int[] nums2){
		TreeSet<Integer> treeSet = new TreeSet<>();
		for (Integer num : nums1) {
			treeSet.add(num);
		}
		
		ArrayList<Integer> list = new ArrayList<>();
		for (Integer num : nums2) {
			if(treeSet.contains(num)){
				list.add(num);
				treeSet.remove(num);	// Ϊ�˽��������Ԫ�ز��ظ�
			}
		}
		
		int[] res = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			res[i] = list.get(i);
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] nums1 = {4,9,5};
		int[] nums2 = {4,9,8,9,4};
			
		int[] num = intersection(nums1, nums2);
		System.out.println(num.length);
	}
}
