package algorithm.study.linkedlistmap;

import algorithm.study.map.Map;

/**
 * ���ڡ�����ʵ�� ӳ����Map
 * @Package:algorithm.study.linkedlistmap
 * @ClassName:LinkedListMap
 * @Description:TODO 
 * @author:Jiangxb
 * @date:2019��3��25�� ����5:04:36
 * 
 * @param <K>
 * @param <V>
 */ 
public class LinkedListMap<K,V> implements Map<K, V> {
	private class Node{
		public K key;
		public V value;
		public Node next;
		
		public Node(K key,V value,Node next){
			this.key = key;
			this.value = value;
			this.next = next;
		}
		
		public Node(){
			this(null,null,null);
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return key.toString() + " : " + value.toString();
		}
	}
	// ����ͷ�ڵ�(Ϊnull��ָ����ʵ��ͷ�ڵ�)
	private Node dummyHead;
	private int size;
	
	public LinkedListMap(){
		dummyHead = new Node();
		size = 0;
	}

	/**
	 * @Title:getNode
	 * @Description:TODO ͨ��key�õ�Map
	 * @return:Node
	 * @author:Jiangxb
	 * @date: 2019��3��25�� ����5:19:55
	 */
	private Node getNode(K key){
		Node cur = dummyHead.next;
		// ����ѭ������(�ҵ�key��Ӧ��Node����)��ֱ��Ϊ��ʱ�˳���
		while(cur != null){
			if(cur.key.equals(key)){
				return cur;
			}
			cur = cur.next;
		}
		return null;	// ��ʾ���������key��Map
	}
	
	// key Ψһ
	@Override
	public void add(K key, V value) {
		// TODO Auto-generated method stub
		Node node = getNode(key);
		if(node == null){	// ��ʾ������key
			dummyHead.next = new Node(key, value, dummyHead.next);
			size ++;
		}else{
			// ������key�����滻value��keyΨһ
			node.value = value;
		}
	}

	@Override
	public V remove(K key) {
		// TODO Auto-generated method stub
		Node prev = dummyHead;
		while(prev.next != null){
			if(prev.next.key.equals(key)){
				break;
			}
			prev = prev.next;
		}
		
		if(prev.next != null){
			Node delNode = prev.next;
			prev.next = delNode.next;
			delNode.next = null;
			size--;
			return delNode.value;
		}
		return null;
	}

	@Override
	public boolean contains(K key) {
		// TODO Auto-generated method stub
		return getNode(key) != null;
	}

	@Override
	public V get(K key) {
		// TODO Auto-generated method stub
		Node node = getNode(key);
		return node == null ? null : node.value;
	}

	@Override
	public void set(K key, V newValue) {
		// TODO Auto-generated method stub
		Node node = getNode(key);
		
		if(node == null){	// ������ʱ������
			throw new IllegalArgumentException(key + " doesn`t exist");
		}
		// �滻ֵ
		node.value = newValue;
		
		
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
	
	
}
