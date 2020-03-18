package algorithm.study.segmenttreesolution;
/**
 * leetcode303:����ͼ���-���ɱ�
 * @Package:algorithm.study.segmenttreesolution
 * @ClassName:NumArray2
 * @Description:TODO 
 * @author:Jiangxb
 * @date:2019��3��30�� ����4:40:38
 *	��ʹ���߶��� ������,��Ϊ����������Ǿ�̬��
 */
public class NumArray2 {
	
	// sum[i]�洢ǰi��Ԫ�غͣ�sum[0] = 0;
	// sum[i]�洢num[0,i-1]�ĺ�
	private int[] sum;
	
	public NumArray2(int[] nums) {
        sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 1; i < sum.length; i++) {
        	/**
        	 * ˵����
        	 * 		sum[1] = sum[0] + nums[0]
        	 * 		sum[2] = sum[1] + nums[1]
        	 * 		sum[3] = sum[2] + nums[2]
        	 * 		....
        	 */
        	sum[i] = sum[i-1] + nums[i-1];
		}
        
        // ���Դ�ӡ sum�еĺ�
        for (int i = 0; i < sum.length; i++) {
        	System.out.print(sum[i] + ",");
		}
    }
    
    public int sumRange(int i, int j) {
    	System.out.println();
    	/**
    	 * ������sumRange(1,2)
    	 * ==��sum[3] - sum[1]
    	 */
        return sum[j+1] - sum[i];
    }
    
    public static void main(String[] args) {
    	int[] nums = {-2,0,3,-5,2,-1};
    	
    	NumArray2 obj = new NumArray2(nums);
    	
    	System.out.println(obj.sumRange(1,2));
//    	System.out.println(obj.sumRange(2,5));
//    	System.out.println(obj.sumRange(0,5));
	}
}
