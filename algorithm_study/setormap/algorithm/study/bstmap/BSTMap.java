package algorithm.study.bstmap;

import algorithm.study.map.Map;

/**
 * ���� ��������������ʵ��ӳ��Map
 * @Package:algorithm.study.bstmap
 * @ClassName:BSTMap
 * @Description:TODO 
 * @author:Jiangxb
 * @date:2019��3��26�� ����3:22:11
 * 
 * @param <K>
 * @param <V>
 * ˵����
 * 	BSTMap<K extends Comparable<K>,V> ���ڶ�������ʵ��ʱ��Key�����ǿɱȽϵ����ͣ���˼̳�Comparable
 */
public class BSTMap<K extends Comparable<K>,V> implements Map<K, V>{
	private class Node{
		public K key;
		public V value;
		public Node left,right;	// ���� �Һ���
		public Node(K key,V value){
			this.key = key;
			this.value = value;
			left = null;
			right = null;
		}
	}
	
	private Node root;
	private int size;
	
	public BSTMap(){
		root = null;
		size = 0;
	}

	@Override
	public void add(K key, V value) {
		// TODO Auto-generated method stub
		root = add(root,key,value);
	}
	
	/**
	 * 
	 * @Title:add
	 * @Description:TODO ����nodeΪ���Ķ����������в���Ԫ�أ�key��value�����ݹ��㷨
	 * @return:Node	���ز����½ڵ������������ĸ�
	 * @author:Jiangxb
	 * @date: 2019��3��26�� ����3:36:10
	 */
	private Node add(Node node,K key,V value){
		/**
		 * ��һ�����ݹ���ֹ����
		 */
		if(node == null){
			size ++;
			return new Node(key,value);
		}
		
		/**
		 * �ڶ������ݹ�ϸ��
		 */
		if(key.compareTo(node.key) < 0){
			node.left = add(node.left,key,value);
		}else if(key.compareTo(node.key) > 0){
			node.right = add(node.right,key,value);
		}else{ // key.compareTo(node.key) = 0
			// ��ӳ���У���keyһ��ʱ�����ɸ���ԭֵ
			node.value = value;
		}
		return node;
	}

	@Override
	public V remove(K key) {
		// TODO Auto-generated method stub
		Node node = getNode(root, key);
		if(node != null){
			root = remove(root, key);
            return node.value;
		}
		return null;
	}
	
	/**
	 * @Title:remove
	 * @Description:TODO ɾ����nodeΪ���Ķ����������еĽڵ�(key)���ݹ��㷨
	 * @return:Node	����ɾ���ڵ���µĶ����������ĸ�
	 * @author:Jiangxb
	 * @date: 2019��3��26�� ����4:25:28
	 */
	private Node remove(Node node, K key) {
		/**
		 * ��һ�����ݹ���ֹ����
		 */
		if(node == null){
			return null;
		}
		
		/**
		 * �ڶ������ݹ�ϸ��
		 */
		if(key.compareTo(node.key) < 0){	// ��ɾ���ڵ�key �� node�ڵ�keyС�����������Ҵ�ɾ���ڵ�
			node.left = remove(node.left,key);
			return node;
		}else if(key.compareTo(node.key) > 0){	// // ��ɾ���ڵ�key �� node�ڵ�key�����������Ҵ�ɾ���ڵ�
			node.right = remove(node.right, key);
			return node;
		}else{	 // ��ɾ���ڵ�key ��  node�ڵ�key��ȣ��ҵ���ɾ���ڵ��ˡ�
			// �١���ɾ���ڵ� ���������
			if(node.left == null){
				Node rightNode = node.right;
				node.right = null;
				size --;
				return rightNode;
			}
			// �ڡ���ɾ���ڵ� ���Һ������
			if(node.right == null){
				Node leftNode = node.left;
				node.left = null;
				size --;
				return leftNode;
			}
			/**
			 * �ۡ���ɾ���ڵ�������������Ϊ��
			 * 	��̽ڵ㣺�ҵ���ɾ���ڵ㡪������������С�Ľڵ�
			 */
			Node successor = minmun(node.right);	// ������С�ڵ�
			successor.right = removeMin(node.right); // ������С�ڵ�ĸ��ڵ�
			successor.left = node.left;
			node.left = node.right = null;
			return successor;
		}
	}
	
	/**
	 * @Title:removeMin
	 * @Description:TODO ɾ������nodeΪ���Ķ����������е���С�ڵ�
	 * @return:Node ����ɾ���ڵ���µĶ����������ĸ�
	 * @author:Jiangxb
	 * @date: 2019��3��27�� ����9:17:46
	 */
	private Node removeMin(Node node) {
		// TODO Auto-generated method stub
		/**
		 * ��һ�����ݹ���ֹ����
		 */
		if(node.left == null){
			Node rightNode = node.right;
			node.right = null;
			size --;
			return rightNode;
		}
		/**
		 * �ڶ������ݹ�ϸ��
		 */
		node.left = removeMin(node.left);
		return node;
	}

	/**
	 * @Title:minmun
	 * @Description:TODO ������nodeΪ���Ķ�������������Сֵ���ڵĽڵ�
	 * @return:Node
	 * @author:Jiangxb
	 * @date: 2019��3��27�� ����9:17:35
	 */
	private Node minmun(Node node) {
		/**
		 * ��һ�����ݹ���ֹ����
		 */
		if(node.left == null){
			return node;
		}
		/**
		 * �ڶ������ݹ�ϸ��
		 */
		return minmun(node.left);
	}

	/**
	 * ����������������nodeΪ���ڵ�Ķ����������У�key���ڵĽڵ�
	 * @Title:getNode
	 * @Description:TODO �ݹ�д��
	 * @return:Node
	 * @author:Jiangxb
	 * @date: 2019��3��26�� ����3:54:56
	 */
	private Node getNode(Node node,K key){
		/**
		 * ��һ�����ݹ���ֹ����
		 */
		if(node == null){
			return null;
		}
		
		/**
		 * �ڶ������ݹ�ϸ��
		 */
		if(key.compareTo(node.key) == 0){
			return node;
		}else if(key.compareTo(node.key) < 0){
			return getNode(node.left, key);		// ����������
		}else{ //key.compareTo(node.key) > 0
			return getNode(node.right, key);	// ����������
		}
		
	}
	
	@Override
	public boolean contains(K key) {
		// TODO Auto-generated method stub
		return getNode(root, key) != null;
	}

	@Override
	public V get(K key) {
		// TODO Auto-generated method stub
		Node node = getNode(root, key);
		if(node == null){
			return null;
		}
		return node.value;
	}

	@Override
	public void set(K key, V newValue) {
		// TODO Auto-generated method stub
		Node node = getNode(root, key);
		if(node == null){	// ������ʱ������
			throw new IllegalArgumentException(key + " doesn`t exist");
		}
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
