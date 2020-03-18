package algorithm.study.linkedlist.solution;
/**
 * �ݹ�ʵ�� ������Ԫ�صĺ�
 * @Package:algorithm.study.linkedlist.solution
 * @ClassName:Sum
 * @Description:TODO 
 * @author:Jiangxb
 * @date:2019��3��15�� ����4:09:55
 * ˵����1��������������
 * 		2����ԭ����ת���ɸ�С������
 */
public class Sum {
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8};
		System.out.println(new Sum().sum(arr));
	}
	
	/**
	 * @Title:sum
	 * @Description:TODO ��������������û�
	 * @return:int
	 * @author:Jiangxb
	 * @date: 2019��3��15�� ����4:17:06
	 */
	public static int sum(int[] arr){
		return sum(arr,0);
	}
	
	/**
	 * @Title:sum
	 * @Description:TODO ����arr[l...n)�������������Ԫ�صĺ�
	 * @return:int
	 * @author:Jiangxb
	 * @date: 2019��3��15�� ����4:11:11
	 * ע�⣺��д�ݹ麯����ʱ��һ��Ҫע�ء��ݹ麯�����������⡣�ݹ麯������һ�����������ĳ���
	 * 	����sum()������˵�����Ǽ���arr[l...n)��Χ������ֺ͡�
	 */
	private static int sum(int[] arr,int l){
		// ����Ϊ��
		if(l == arr.length){
			return 0;	// <����������������
		}
		return arr[l] + sum(arr,l+1); // <������ԭ����ת���ɸ�С������ 
	}
}
