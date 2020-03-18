package algorithm.study.segmenttreesolution;
/**
 * leetcode307. ����ͼ��� - ������޸�
 * @Package:algorithm.study.segmenttreesolution
 * @ClassName:NumArray3
 * @Description:TODO 
 * @author:Jiangxb
 * @date:2019��3��31�� ����1:32:18
 *	��ʹ���߶������н�������ܷǳ���
 */
public class NumArray3 {
	// �������������ͳ��nums[]����ĺͣ�Ԥ����Ĳ�����
	private int[] sum;
	// ��Ҫ���������
	private int[] data;
 	
	public NumArray3(int[] nums) {
		
		// ��ʼ��
		data = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			data[i] = nums[i];
		}
		
        sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 1; i < nums.length; i++) {
			sum[i] = sum[i-1] + data[i-1];
		}
    }
    
	/**
	 * @Title:update
	 * @Description:TODO �޸�ԭ����data��index����λ�õ�ֵΪval
	 * @return:void
	 * @author:Jiangxb
	 * @date: 2019��3��31�� ����1:47:01
	 * O(n)���Ӷ�
	 */
    public void update(int index, int val) {
        data[index] = val;
        /**
         * ˵����
         * 	��Ϊsum[index] = sum[index-1] + data[index-1]
         * 	���Ե��޸���data[index]��ֵʱ������Ӱ��sum[index]��ֵ��
         *  ��Ӱ�������index������������ݡ��� i = index+1��
         */
        for (int i = index+1; i < sum.length; i++) {
        	sum[i] =sum[i-1] + data[i-1];
		}
    }
    // O(1) ���Ӷ�
    public int sumRange(int i, int j) {
        return sum[j+1] - sum[i];
    }
    
    public static void main(String[] args) {
    	int[] nums = {-2,0,3,-5,2,-1};
    	
    	NumArray3 obj = new NumArray3(nums);
    	obj.update(1, 1);
    	System.out.println(obj.sumRange(1,2));
	}
}
