package algorithm.study.linkedliststack;


/**
 * ����(������ͷ�ڵ�dummyHead)
 * @Package:algorithm.study.linkedlist
 * @ClassName:LinkedList
 * @Description:TODO 
 * @author:Jiangxb
 * @date:2019��3��14�� ����10:41:08
 * 
 * @param <E>
 */
public class LinkedList<E> {
	
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
	 * ����ͷ�ڵ�(Ϊnull��ָ����ʵ��ͷ�ڵ�)
	 */
	private Node dummyHead;
	/**
	 * �����е�Ԫ�ظ���
	 */
	int size;
	
	public LinkedList(){
		dummyHead = new Node(null,null);
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
		// �Ƚ�����ͷ�ڵ㸳ֵ��prev
		Node prev = dummyHead;
		// ѭ������=ָ��λ�ã���ΪprevĿǰָ����� ����ͷ�ӿ�(null)
		for (int i = 0; i < index; i++) {
			prev = prev.next;	// �����λ�õ�ǰһ���ڵ�
		}
		// ����һ��node�ڵ�
		Node node = new Node(e);
		// ��Ӳ���(��Ҫ��ָ�� ��һ���ڵ㣬Ҫ��Ȼ��������ݶ�ʧ)
		node.next = prev.next;
		prev.next = node;
		// ����������
//		prev.next = new Node(e,prev.next);
		// ά�� ��������
		size ++;
	}
	
	/**
	 * @Title:addFirst
	 * @Description:TODO ������ͷ���Ԫ��
	 * @return:void
	 * @author:Jiangxb
	 * @date: 2019��3��14�� ����11:34:29
	 */
	public void addFirst(E e){
		add(0,e);
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
	
	/**
	 * @Title:get
	 * @Description:TODO ��ȡ�����Ԫ��
	 * @return:E
	 * @author:Jiangxb
	 * @date: 2019��3��14�� ����2:06:10
	 * ˵�����������ĵ�index(0-based)��λ�õ�Ԫ��
	 * 	�������в���һ�����ò�������ϰ��
	 */
	public E get(int index){
		// �������ж�
		if(index < 0 || index > size){
			throw new IllegalArgumentException("Get failed.Illegal index.");
		}
		// ��ȡ��ǰ������ʵ�ĵ�һ��Ԫ��(ͷ�ڵ�)
		Node cur = dummyHead.next;
		for(int i=0 ; i < index ; i ++){
			cur = cur.next;
		}
		// ���ؽڵ� ���Ԫ��
		return cur.e;
	}
	
	/**
	 * @Title:getFirst
	 * @Description:TODO �������ĵ�һ��Ԫ��
	 * @return:E
	 * @author:Jiangxb
	 * @date: 2019��3��14�� ����2:10:13
	 */
	public E getFirst(){
		return get(0);
	}
	
	/**
	 * @Title:getLast
	 * @Description:TODO �����������һ��Ԫ��
	 * @return:E
	 * @author:Jiangxb
	 * @date: 2019��3��14�� ����2:10:27
	 */
	public E getLast(){
		return get(size - 1);
	}
	
	/**
	 * @Title:set
	 * @Description:TODO ��������Ԫ��
	 * @return:void
	 * @author:Jiangxb
	 * @date: 2019��3��14�� ����2:13:54
	 * ˵�����޸�����ĵ�index(0-based)��λ�õ�Ԫ��Ϊe
	 * 	�������в���һ�����õĲ�������ϰ��
	 */
	public void set(int index,E e){
		// �������ж�
		if(index < 0 || index > size){
			throw new IllegalArgumentException("Get failed.Illegal index.");
		}
		
		Node cur = dummyHead.next;
		for(int i=0 ; i < index ; i ++){
			cur = cur.next;
		}
		cur.e = e;
	}
	
	/**
	 * @Title:contains
	 * @Description:TODO �����������Ƿ���Ԫ��e
	 * @return:boolean
	 * @author:Jiangxb
	 * @date: 2019��3��14�� ����2:16:48
	 */
	public boolean contains(E e){
		Node cur = dummyHead.next;
		// cur Ϊ�յ�ʱ���˳�
		while(cur != null){
			if(cur.e.equals(e)){
				return true;
			}
			cur = cur.next;
		}
		return false;
	}
	
	/**
	 * @Title:remove
	 * @Description:TODO ɾ�������е�Ԫ��
	 * @return:E
	 * @author:Jiangxb
	 * @date: 2019��3��14�� ����2:31:50
	 * ˵������������ɾ��index(0-based)λ�õ�Ԫ�أ�����ɾ����Ԫ��
	 * 	�������в���һ�����õĲ�������ϰ��
	 * �ؼ����ڣ��ҵ�Ҫ��ӵĽڵ��ǰһ���ڵ�(prev)
	 */
	public E remove(int index){
		// �������ж�
		if(index < 0 || index > size){
			throw new IllegalArgumentException("Remove failed.Illegal index.");
		}
		
		Node prev = dummyHead;
		// �õ���ɾ��λ�õ�ǰһ���ڵ�
		for (int i = 0; i < index; i++) {
			prev = prev.next;
		}
		// �õ���ɾ���ڵ�
		Node retNode = prev.next;
		// ɾ���Ĳ���
		prev.next = retNode.next;
		retNode.next = null;
		// ά����������
		size --;
		return retNode.e;
	}
	
	/**
	 * @Title:removeFrist
	 * @Description:TODO ɾ�������ͷ�ڵ�
	 * @return:E
	 * @author:Jiangxb
	 * @date: 2019��3��14�� ����2:37:05
	 */
	public E removeFrist(){
		return remove(0);
	}
	
	/**
	 * @Title:removeLast
	 * @Description:TODO ɾ�������β�ڵ�
	 * @return:E
	 * @author:Jiangxb
	 * @date: 2019��3��14�� ����2:37:17
	 */
	public E removeLast(){
		return remove(size - 1);
	}
	
	@Override
	public String toString(){
		StringBuilder res = new StringBuilder();
		Node cur = dummyHead.next;
		while(cur != null){
			res.append(cur + "->");
			cur = cur.next;
		}
		
		// ͬ������
//		for(Node cur = dummyHead.next ; cur != null ; cur = cur.next){
//			res.append(cur + "->");
//		}
		
		res.append("NULL");
		return res.toString();
	}
}