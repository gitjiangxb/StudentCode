package algorithm.study.linkedlist;


/**
 * ����
 * @Package:algorithm.study.linkedlist
 * @ClassName:LinkedList
 * @Description:TODO 
 * @author:Jiangxb
 * @date:2019��3��14�� ����10:41:08
 * 
 * @param <E>
 */
public class LinkedList1<E> {
	
	// ˽�нڵ���(�ڲ���)
	private class Node{
		/**
		 * �洢�����ݶ���(����������)
		 */
		public E e;
		/**
		 * ��һ���ڵ���������
		 */
		public Node next;
		
		public Node(E e,Node node){
			this.e = e;
			this.next = next;
		}
		
		public Node(E e){
			this(e,null);
		}
		
		public Node(){
			this(null,null);
		}
		
		@Override
		public String toString(){
			return e.toString();
		}
	}
	
	/**
	 * ͷ�ڵ�
	 */
	private Node head;
	/**
	 * �����е�Ԫ�ظ���
	 */
	int size;
	
	public LinkedList1(){
		head = null;
		size = 0;
	}
	
	/**
	 * @Title:getSize
	 * @Description:TODO ��ȡ�����е�Ԫ�ظ���
	 * @return:int
	 * @author:Jiangxb
	 * @date: 2019��3��14�� ����10:47:20
	 */
	public int getSize(){
		return size;
	}
	
	/**
	 * @Title:isEmpty
	 * @Description:TODO ���������Ƿ�Ϊ��
	 * @return:boolean
	 * @author:Jiangxb
	 * @date: 2019��3��14�� ����10:48:01
	 */
	public boolean isEmpty(){
		return size == 0;
	}
	
	/**
	 * @Title:addFirst
	 * @Description:TODO ������ͷ���Ԫ��
	 * @return:void
	 * @author:Jiangxb
	 * @date: 2019��3��14�� ����10:51:25
	 */
	public void addFirst(E e){
		// ����һ��node�ڵ�
		Node node = new Node(e);
		// �½ڵ�ָ��ԭ����ͷ�ڵ�
		node.next = head;
		// ά�� ͷ�ڵ�
		head = node;
		// ���������д���
//		head = new Node(e,head);
		
		// ά�� ��������
		size ++;
	}
	
	/**
	 * @Title:add
	 * @Description:TODO ��ָ��λ�ò���Ԫ��
	 * @return:void
	 * @author:Jiangxb
	 * @date: 2019��3��14�� ����11:05:59
	 * ˵����
	 * 	�������index(0-based)λ������µ�Ԫ��e
	 *  �������в���һ�����õĲ�������ϰ��
	 *  �ؼ����ڣ��ҵ�Ҫ��ӵĽڵ��ǰһ���ڵ�(prev)
	 */
	public void add(int index,E e){
		// �������ж�
		if(index < 0 || index > size){
			throw new IllegalArgumentException("Add failed.Illegal index.");
		}
		
		if(index == 0){
			// ���ָ��λ��Ϊ0����������ͷ���뷽��
			addFirst(e);	// ������ͷ�Ĳ������Լ򻯣�Ϊ������������ͷ�ڵ�(dummyHead)
		}else{
			// �Ƚ�ͷ�ڵ㸳ֵ��prev
			Node prev = head;
			// ѭ������=ָ��λ��-1����Ϊprev��Ҫָ������ָ��λ�õ�ǰһ��
			for (int i = 0; i < index -1; i++) {
				prev = prev.next;
			}
			// ����һ��node�ڵ�
			Node node = new Node(e);
			// ��;�ҽ�(��Ҫ��ָ�� ��һ���ڵ㣬Ҫ��Ȼ��������ݶ�ʧ)
			node.next = prev.next;
			prev.next = node;
			// ����������
//			prev.next = new Node(e,prev.next);
			// ά�� ��������
			size ++;
		}
	}
	
	/**
	 * @Title:addLast
	 * @Description:TODO ������β�����Ԫ��
	 * @return:void
	 * @author:Jiangxb
	 * @date: 2019��3��14�� ����11:22:17
	 */
	public void addLast(E e){
		add(size,e);
	}
	
	
}