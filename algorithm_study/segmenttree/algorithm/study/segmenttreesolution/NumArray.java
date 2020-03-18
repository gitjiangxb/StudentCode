package algorithm.study.segmenttreesolution;

import algorithm.study.segmenttree.SegmentTree;

/**
 * leetcode303:����ͼ���-���ɱ�
 * @Package:algorithm.study.segmenttreesolution
 * @ClassName:NumArray
 * @Description:TODO 
 * @author:Jiangxb
 * @date:2019��3��30�� ����4:33:31
 * 	�����Զ�����߶�����������������߼� 
 *
 */
public class NumArray {
	
	private SegmentTree<Integer> segmentTree;
	
	public NumArray(int[] nums) {
        if(nums.length >0){
        	Integer[] data = new Integer[nums.length];
        	for (int i = 0; i < nums.length; i++) {
        		data[i] = nums[i];
			}
        	segmentTree = new SegmentTree<>(data, (a,b) -> a+b);
        }
    }
    
    public int sumRange(int i, int j) {
    	if(segmentTree == null){
    		throw new IllegalArgumentException("Segment Tree is null");
    	}
        return segmentTree.query(i, j);
    }
    
    public static void main(String[] args) {
    	int[] nums = {-2,0,3,-5,2,-1};
    	NumArray obj = new NumArray(nums);
    	
    	System.out.println(obj.sumRange(0,2));
    	System.out.println(obj.sumRange(2,5));
    	System.out.println(obj.sumRange(0,5));
	}
}
