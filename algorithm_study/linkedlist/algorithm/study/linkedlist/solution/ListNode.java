package algorithm.study.linkedlist.solution;
/**
 * leetcode ����203��ɾ�������е�Ԫ�� ��Ŀ������ListNode
 * @Package:algorithm.study.solution
 * @ClassName:ListNode
 * @Description:TODO 
 * @author:Jiangxb
 * @date:2019��3��15�� ����2:12:17
 *
 */
public class ListNode {
	public int val;
	public ListNode next;
	
	public ListNode(int x){
		val = x;
	}
	
// ���·���ʱΪ�˱��ز��Դ����߼����ӵ�	
	
	/**
	 * ����ڵ�Ĺ��캯��
	 * @Title:List
	 * @Description:TODO 
	 * @return:void
	 * @author:Jiangxb
	 * @date: 2019��3��15�� ����2:49:24
	 * 	ʹ��arrΪ����������һ��������ǰ��ListNodeΪ
	 * ����ͷ�ڵ�
	 */
	public ListNode(int[] arr){
		if(arr == null || arr.length ==0){
			throw new IllegalArgumentException("arr can not be empty");
		}
		this.val = arr[0];
		// ͷ�ڵ�
		ListNode cur = this;
		for (int i = 1; i < arr.length; i++) {
			cur.next = new ListNode(arr[i]);
			cur = cur.next;
		}
	}
	
	/**
	 * �Ե�ǰ�ڵ�Ϊͷ�ڵ��������Ϣ�ַ���
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder res = new StringBuilder();
		ListNode cur = this;
		while(cur != null){
			res.append(cur.val + "->");
			cur = cur.next;
		}
		res.append("NULL ");
		return res.toString();
	}
}
