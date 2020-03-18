package algorithm.study.avltree;

import java.util.ArrayList;

/**
 * AVLTree����Ŀ�ܺͶ�����������һ�µ�
 * @Package:algorithm.study.avltree
 * @ClassName:AVLTree
 * @Description:TODO 
 * @author:Jiangxb
 * @date:2019��4��7�� ����10:51:22
 *	���ƣ�algorithm.study.bstmap.BSTMap<K, V>
 *	
 *	�޸�˼�룺
 *		AVL�������ڶ����������Ĵ�������ϲ���һЩ���룬��ʵ��������ϡ���ƽ��Ļ��ơ���
 *	ʹ��ԭ��ʵ�ֵĶ����������ڶԽڵ���в�����ʱ����Ա�֤��������ƽ��ģ���ô������
 *	����ƽ��Ķ������(����ÿһ���ڵ�����������ĸ߶Ȳ����1)
 */
public class AVLTree<K extends Comparable<K>,V>{
	
	private class Node{
		public K key;
		public V value;
		public Node left,right;	// ���� �Һ���
		
		/**
		 * AVL ��Ҫ�Ļ��ƣ����Ǽ�¼��ǰ�ڵ������ĸ߶�ֵ
		 */
		public int height;	
		
		public Node(K key,V value){
			this.key = key;
			this.value = value;
			left = null;
			right = null;
			/**
			 * Ĭ�϶���һ���µĽڵ���˵���൱��Ҷ�ӽڵ㣬Ĭ�ϸ߶�Ϊ1.
			 * 	���һ���ڵ㶼�ǴӸ��ڵ㿪ʼ������ȥ�ҵ������յ����λ�ã�
			 * ������յ����λ��һ����һ��Ҷ�ӽڵ��λ�á�
			 */
			height = 1;
		}
	}
	
	private Node root;
	private int size;
	
	public AVLTree(){
		root = null;
		size = 0;
	}

	/**
	 * ���丨����������ýڵ�node�ĸ߶�
	 * @Title:getHeight
	 * @Description:TODO 
	 * @return:int
	 * @author:Jiangxb
	 * @date: 2019��4��7�� ����11:23:12
	 */
	private int getHeight(Node node){
		if(node == null){
			return 0;
		}
		return node.height;
	}
	
	/**
	 * ���丨����������ýڵ�node��ƽ������
	 * @Title:getBalanceFactor
	 * @Description:TODO 
	 * @return:int
	 * @author:Jiangxb
	 * @date: 2019��4��7�� ����11:37:41
	 * 	ƽ�����ӣ�����ÿһ���ڵ���ԣ��������������ĸ߶Ȳ�(�������ĸ߶�-�������ĸ߶�)
	 */
	private int getBalanceFactor(Node node){
		if(node == null){
			return 0;
		}
		
		return getHeight(node.left) - getHeight(node.right);
	}
	
	/**
	 * ���丨���������жϸö������Ƿ���һ�Ŷ���������
	 * @Title:isBST
	 * @Description:TODO 
	 * @return:boolean
	 * @author:Jiangxb
	 * @date: 2019��4��7�� ����11:47:07
	 * ���ö�����������һ���������жϣ�
	 * 		����һ�Ŷ�����������˵��������ʹ�����������ʱ�򣬱����Ľ�����е�Ԫ���ǰ�˳�����еġ�
	 */
	public boolean isBST(){
		ArrayList<K> keys = new ArrayList<>();
		// �������
		inOrder(root,keys);
		for (int i = 1; i < keys.size(); i++) {
			/**
			 * ����������������������������ʣ���ôkeys�б����Ԫ�ؾͻ�������Ľ��
			 * 	���keys[0] > keys[1] ,���������������
			 */
			if(keys.get(i-1).compareTo(keys.get(i)) > 0){
				return false;
			}
		}
		return true;
	}
	
	
	/**
	 * ���丨����������nodeΪ���ڵ�Ķ�����������������������ݹ�ʵ��
	 * @Title:inOrder
	 * @Description:TODO 
	 * @return:void
	 * @author:Jiangxb
	 * @date: 2019��4��7�� ����11:50:55
	 */
	private void inOrder(Node node, ArrayList<K> keys) {
		/**
		 * ��һ�����ݹ���ֹ����
		 */
		if(node == null){
			return;
		}
		
		/**
		 * �ڶ������ݹ�ϸ��
		 * 	����������� �� ��
		 */
		inOrder(node.left, keys);
		keys.add(node.key);	// keys�б�������������еļ�
		inOrder(node.right, keys);
	}
	
	/**
	 * ���丨���������жϸö������Ƿ���һ��ƽ�������
	 * @Title:isBalanced
	 * @Description:TODO 
	 * @return:boolean
	 * @author:Jiangxb
	 * @date: 2019��4��7�� ����11:59:51
	 */
	public boolean isBalanced(){
		return isBalanced(root);
	}

	/**
	 * ���丨���������ж���nodeΪ���Ķ������Ƿ���һ��ƽ����������ݹ�ʵ��
	 * @Title:isBalanced
	 * @Description:TODO 
	 * @return:boolean
	 * @author:Jiangxb
	 * @date: 2019��4��7�� ����12:00:59
	 */
	private boolean isBalanced(Node node) {
		// TODO Auto-generated method stub
		/**
		 * ��һ�����ݹ���ֹ����
		 */
		if(node == null){
			return true;
		}
		
		/**
		 * �ڶ������ݹ�ϸ��
		 */
		int balancedFactor = getBalanceFactor(node);	// �õ�ƽ������
		
		if(Math.abs(balancedFactor) > 1){
			return false;	// ƽ�����Ӵ��� 1ʱ����ʾ��������ƽ���������
		}
		// �ݹ�ȥ�ж��� ���������Ƿ������������
		return isBalanced(node.left) && isBalanced(node.right);
	}
	
	/**
	 * ���丨���������Խڵ�y����������ת������������ת���µĸ��ڵ�x
	 * @Title:rightRotate
	 * @Description:TODO 
	 * @return:Node
	 * @author:Jiangxb
	 * @date: 2019��4��7�� ����9:36:50
	 * 	// �Խڵ�y����������ת������������ת���µĸ��ڵ�x
	    //        y                              x
	    //       / \                           /   \
	    //      x   T4     ������ת (y)        	  z     y
	    //     / \       - - - - - - - ->    / \   / \
	    //    z   T3                       T1  T2 T3 T4
	    //   / \
	    // T1   T2
	 */
	private Node rightRotate(Node y){
		Node x = y.left;
		Node T3 = x.right;
		
		// ������ת����
		x.right = y;
		y.left = T3;
		
		// ����height(x y��ֵ�����˸߶ȱ仯)
		y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
		x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
		
		return x;
	}
	
	/**
	 * ���丨���������Խڵ�y����������ת������������ת���µĸ��ڵ�x
	 * @Title:leftRotate
	 * @Description:TODO 
	 * @return:Node
	 * @author:Jiangxb
	 * @date: 2019��4��7�� ����9:39:06
	 * 
	 *  //    y                             x
	    //  /  \                          /   \
	    // T1   x      ������ת (y)         y     z
	    //     / \   - - - - - - - ->   / \   / \
	    //   T2  z                     T1 T2 T3 T4
	    //      / \
	    //     T3 T4
	 */
	private Node leftRotate(Node y) {
		Node x = y.right;
		Node T2 = x.left;
		
		// ������ת����
		x.left = y;
		y.right = T2;
		
		// ����height(x y��ֵ�����˸߶ȱ仯)
		y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
		x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
		
		return x;
	}
	
	
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
		 * 	����һ��������Ҫά��height�߶�ֵ����Ϊ�ڹ��캯����Ĭ��Ϊ1
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
		
		/**
		 * �����Ե�ǰ���nodeΪ���Ķ��������������һ���µĽڵ��
		 * 	��Ӧ��������Ҫ�Ե�ǰnode��heightֵ���и���:
		 * 		��ǰ�ڵ�ĸ߶� = 1 + ���������е����߶�ֵ
		 */
		node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
		
		/**
		 * �����ڵ���ټ���ƽ������
		 */
		int balanceFactor = getBalanceFactor(node);
		
		// ���balanceFactor�ľ���ֵ����1��˵��������ڵ��ϣ��������ζ�����������������ƽ�������������
//		if(Math.abs(balanceFactor) > 1){
//			System.out.println("unbalanced : " + balanceFactor);
//		}
		
		/**
		 * ƽ��ά��
		 * ǰ�����롪��ƽ�����ӣ�����ÿһ���ڵ���ԣ��������������ĸ߶Ȳ�(�������ĸ߶�-�������ĸ߶�)
		 * 	
		 * ����ת��
		 * 	���ƽ������ > 1�����������������ĸ߶Ȳ��ǳ�����1�ģ�������������(���ƽ�����ӵ��㷨)��ߵ�ƽ������Ҫ�ߵġ�
		 * 	&&
		 * 	��ǰ����ڵ���������������ڵ��ƽ������ >= 0;
		 * 	 �����������˵������ʵ���ڵ�ǰ���node�ǲ�ƽ��ģ���ƽ���ԭ������������������������һ���ڵ㡣
		 * 										12
		 *								8				18
		 *							5		11		17
		 *						4		7
		 *					2
		 * 		˵�����ڵ㡾8��Ϊ��ƽ��ڵ㣬����ԭ��������������������һ���ڵ㡾2��,(�ڵ㡾5����ƽ�����ӣ�2-1=1���粻���ڽڵ㡾2������ʱƽ������Ϊ��1-1=0)
		 * 
		 * ����ת��
		 * 	....... ������ת �ԳƵ�
		 */
		if(balanceFactor > 1 && getBalanceFactor(node.left) >= 0){
			// (LL)_����ת
			return rightRotate(node);
		}
		
		if (balanceFactor < -1 && getBalanceFactor(node.right) <= 0){
            // (RR)_����ת
			return leftRotate(node);
		}
		
		if(balanceFactor > 1 && getBalanceFactor(node.left) < 0){
			// (LR)_����������ת
			node.left = leftRotate(node.left);
			return rightRotate(node);
		}
		
		if (balanceFactor < -1 && getBalanceFactor(node.right) > 0){
            // (RL)_����������ת
			node.right = rightRotate(node.right);
			return leftRotate(node);
		}
		
		return node;
	}

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
		Node retNode;	// ��������صĽڵ�
		
		if(key.compareTo(node.key) < 0){	// ��ɾ���ڵ�key �� node�ڵ�keyС�����������Ҵ�ɾ���ڵ�
			node.left = remove(node.left,key);
			// ����ֱ�ӷ����ˣ���ɾ��������ڵ���������еĽڵ㣬Ҳ���ƻ���ƽ���ԣ������Ҫά��
//			return node;
			retNode = node;
		}else if(key.compareTo(node.key) > 0){	// // ��ɾ���ڵ�key �� node�ڵ�key�����������Ҵ�ɾ���ڵ�
			node.right = remove(node.right, key);
//			return node;
			retNode = node;
		}else{	 // ��ɾ���ڵ�key ��  node�ڵ�key��ȣ��ҵ���ɾ���ڵ��ˡ�
			// �١���ɾ���ڵ� ���������
			if(node.left == null){
				Node rightNode = node.right;	// ��node��ɾ�����ڵ���µĸ��ڵ�
				node.right = null;
				size --;
//				return rightNode;	// ��Ҫά����ƽ����
				retNode = rightNode;	
			}
			// �ڡ���ɾ���ڵ� ���Һ������
			else if(node.right == null){
				Node leftNode = node.left;
				node.left = null;
				size --;
//				return leftNode;
				retNode = leftNode;
			}else{
				/**
				 * �ۡ���ɾ���ڵ�������������Ϊ��
				 * 	��̽ڵ㣺�ҵ���ɾ���ڵ㡪������������С�Ľڵ�
				 * 	�ҵ��ȴ�ɾ���ڵ�����С�ڵ㣬����ɾ���ڵ�����������С�ڵ㣻������ڵ㶥���ɾ���ڵ��λ��
				 */
				Node successor = minmun(node.right);	// ������С�ڵ�
				/**
				 * removeMin(node.right)
				 * ɾ����ɾ���ڵ��������е���С�ڵ㲢������С�ڵ�ĸ��ڵ�(���ɾ������ά��ƽ���������ֽ��������1������������Ҳ���ά��������2�����з����ĸ�д����)
				 * remove(node.right,successor.key);
				 * 		��Ϊsuccessor�Ѿ���������С�ڵ�
				 */
//				successor.right = removeMin(node.right);
				successor.right = remove(node.right,successor.key);
				successor.left = node.left;
				node.left = node.right = null;
				retNode = successor;
			}
		}
		
		// �пմ���
		if(retNode == null){
			return null;
		}
		
		/**
		 * ά��ƽ���ԵĲ�����������������
		 */
		// 1������height
        retNode.height = 1 + Math.max(getHeight(retNode.left), getHeight(retNode.right));

        // 2������ƽ������
        int balanceFactor = getBalanceFactor(retNode);

        // 3��ƽ��ά��
        if(balanceFactor > 1 && getBalanceFactor(retNode.left) >= 0){
			// (LL)_����ת
			return rightRotate(retNode);
		}
		
		if (balanceFactor < -1 && getBalanceFactor(retNode.right) <= 0){
            // (RR)_����ת
			return leftRotate(retNode);
		}
		
		if(balanceFactor > 1 && getBalanceFactor(retNode.left) < 0){
			// (LR)_����������ת
			retNode.left = leftRotate(retNode.left);
			return rightRotate(retNode);
		}
		
		if (balanceFactor < -1 && getBalanceFactor(retNode.right) > 0){
            // (RL)_����������ת
			retNode.right = rightRotate(retNode.right);
			return leftRotate(retNode);
		}
		
		return retNode;
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
	
	public boolean contains(K key) {
		// TODO Auto-generated method stub
		return getNode(root, key) != null;
	}

	public V get(K key) {
		// TODO Auto-generated method stub
		Node node = getNode(root, key);
		if(node == null){
			return null;
		}
		return node.value;
	}

	public void set(K key, V newValue) {
		// TODO Auto-generated method stub
		Node node = getNode(root, key);
		if(node == null){	// ������ʱ������
			throw new IllegalArgumentException(key + " doesn`t exist");
		}
		node.value = newValue;
	}

	public int getSize() {
		// TODO Auto-generated method stub
		return size;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0;
	}
}
