package algorithm.study.linkedlistqueue;


/**
 * ������ʵ�ֶ���
 * @Package:algorithm.study.linkedlistqueue
 * @ClassName:LinkedListQueue
 * @Description:TODO 
 * @author:Jiangxb
 * @date:2019��3��14�� ����5:02:11
 * 
 * @param <E>
 */
public class LinkedListQueue<E> implements Queue<E> {
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
			this.next = node;
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
	 * β�ڵ�
	 */
	private Node tail;
	
	/**
	 * ����Ԫ�ظ���
	 */
	private int size;
	
	public LinkedListQueue(){
		head = null;
		tail = null;
		size = 0;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0;
	}

	// ��tail�˲���Ԫ�أ�O(1)��
	@Override
	public void enqueue(E e) {
		// TODO Auto-generated method stub
		if(tail == null){
			tail = new Node(e);
			head = tail;
		}else{
			tail.next = new Node(e);
			tail = tail.next;
		}
		size ++;
	}

	// ��head��ɾ��Ԫ�أ�O(1)��
	@Override
	public E dequeue() {
		// TODO Auto-generated method stub
		if(isEmpty()){
			throw new IllegalArgumentException("Cannot dequeue from an empty queue");
		}
		
		// ��Ҫɾ���Ľڵ�
		Node retNode = head;
		// ɾ������
		head = head.next;
		retNode.next = null;
		// ע�⣺��ɾ�����һ���ڵ�ʱ����Ҫά����tail��
		if(head == null){
			tail = null;
		}
		size --;
		return retNode.e;
	}

	@Override
	public E getFront() {
		// TODO Auto-generated method stub
		if(isEmpty()){
			throw new IllegalArgumentException("Queue is empty");
		}
		return head.e;
	}
	
	@Override
	public String toString(){
		StringBuilder res = new StringBuilder();
		res.append("LinkedListQueue front [");
		Node cur = head;
		while(cur != null){
			res.append(cur + "->");
			cur = cur.next;
		}
		res.append("NULL ] tail");
		return res.toString();
	}
}
