package algorithm.study.linkedlist.solution;
/**
 * leetcode ����203��ɾ�������е�Ԫ��
 * @Package:algorithm.study.solution
 * @ClassName:Solution
 * @Description:TODO 
 * @author:Jiangxb
 * @date:2019��3��15�� ����2:13:03
 *		ʵ�������� 1-->	2-->6-->3-->4-->5-->6,val = 6,
 *			����  1-->	2-->3-->4-->5
 */
public class Solution {
	
	/**
	 * ��������ɾ��ָ����Ԫ��(��������ͷ�ڵ�)
	 * @Title:removeElements
	 * @Description:TODO 
	 * @return:ListNode
	 * @author:Jiangxb
	 * @date: 2019��3��15�� ����2:37:22
	 */
	public ListNode removeElements(ListNode head,int val){
		/**
		 * ��һ�֣�Ҫɾ���Ľڵ�������ͷ�ڵ㣻��ѭ����Ϊ�˴��ڶ����ͷ�ڵ�һ�µ�Ԫ��
		 */
		while(head != null && head.val == val){
			ListNode delNode = head;
			head = head.next;
			delNode.next = null;
			
			// ��leetcode������Լ�Ϊ
//			head = head.next;
		}
		
		/**
		 * �ڶ��֣�Ҫɾ���Ľڵ�Ϊ�����м�Ľڵ�
		 * 	�������пգ���ΪҲ���ڵ�һ�������ʱ�������Ϊ���ˡ�
		 */
		if(head == null){
			return null;
		}
		ListNode prev = head;	// ��ʱ��headͷ�ڵ�һ�㲻��ΪҪɾ���Ľڵ㣨��Ϊ�Ѿ������˵�һ�������
		while(prev.next != null){
			// ��ʱprevΪ��ɾ���ڵ����һ���ڵ�
			if(prev.next.val == val){
				ListNode delNode = prev.next;
				prev.next = delNode.next;
				delNode.next = null;
				// ��leetcode������Լ�Ϊ
//				prev.next = prev.next.next;
			}else{
				// ��prev.next.val != valʱ��prev���Ų��һ�������ж�
				prev = prev.next;
			}
		}
		return head;
	}
	
	/**
	 * ��������ɾ��ָ����Ԫ��(������ͷ�ڵ�)
	 * @Title:removeElements1
	 * @Description:TODO 
	 * @return:ListNode
	 * @author:Jiangxb
	 * @date: 2019��3��15�� ����2:44:05
	 */
	public ListNode removeElements1(ListNode head,int val){
		
		// ��������ͷ�ڵ�
		ListNode dummyHead = new ListNode(-1);
		dummyHead.next = head;	// ָ����ʵ��ͷ�ڵ�
		
		ListNode prev = dummyHead;	// ��ɾ���ڵ��ǰһ���ڵ�
		while(prev.next != null){
			if(prev.next.val == val){
				ListNode delNode = prev.next;
				prev.next = delNode.next;
				delNode.next = null;
			}else{
				// Ԫ��ֵ����ʱ�����Ų��һλ
				prev = prev.next;
			}
		}
		return dummyHead.next;
	}
	
	/**
	 * @Title:removeElements3
	 * @Description:TODO ���á��ݹ顿���������ɾ��Ԫ�ص�����
	 * @return:ListNode
	 * @author:Jiangxb
	 * @date: 2019��3��17�� ����12:38:34
	 * ˼·�������������ݹ���������ɾ��Ԫ������.png��
	 */
	public ListNode removeElements3(ListNode head,int val){
		/**
		 * ����ֽ⣺��һ����������������
		 */
		if(head == null){
			return null;
		}
		
		/**
		 * ����ֽ⣺�ڶ�������ԭ����ת���ɸ�С������ 
		 */
		ListNode res = removeElements3(head.next,val);
		// �������ɾ���߼�
		if(head.val == val){
			return res;	// ���ͷ�ڵ� = ��ɾ����ֵ������ͷ�ڵ�����Ԫ��
		}else{
			head.next = res;
			return head;	// ���ͷ�ڵ� != ��ɾ����ֵ������ͷ�ڵ�ͺ����Ԫ��
		}
	}
	
	/**
	 * @Title:removeElements4
	 * @Description:TODO ��removeElements3 �����ļ򻯲���
	 * @return:ListNode
	 * @author:Jiangxb
	 * @date: 2019��3��17�� ����12:59:49
	 */
	public ListNode removeElements4(ListNode head,int val){
		// ���ȡ�������Ĳ���
		if(head == null){
			return null;
		}
		// Ȼ�󡢹����ݹ���̣������ø�С��ģ���Ǹ�����Ľ�ȥ����ԭ��ģ�������Ľ�
		head.next = removeElements4(head.next,val);
		 // ��󡢹������յ��߼�����ִ��ɾ���Ĳ���
		return head.val == val ? head.next : head;
	}
	
	/**
	 * �ڱ��ز���leetcode�������
	 * @Title:main
	 * @Description:TODO 
	 * @return:void
	 * @author:Jiangxb
	 * @date: 2019��3��15�� ����2:58:06
	 * ��ListNode���� ���������������
	 */
	public static void main(String[] args) {
		int[] nums = {1,2,6,3,4,5,6};
		ListNode head = new ListNode(nums);
		System.out.println(head);
		
		ListNode res = (new Solution().removeElements4(head, 6));
		System.out.println(res);
 	}
}
