package algorithm.study.bstset;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

import algorithm.study.queue.ArrayQueue;

/**
 * �������������������ظ�Ԫ��
 * @Package:algorithm.study.binarysearchtree
 * @ClassName:BinarySearchTree
 * @Description:TODO 
 * @author:Jiangxb
 * @date:2019��3��17�� ����4:21:22
 * 	<E extends Comparable<E>> ����> �޶�����Ϊ�ɱ���
 * 	
 * @param <E>
 */
public class BinarySearchTree<E extends Comparable<E>> {
	
	/* �ڵ��� */
	private class Node{
		public E e;
		public Node left;	// ����
		public Node right;	// �Һ���
		
		public Node(E e){
			this.e = e;
			left = null;
			right = null;
		}
	}
	/**
	 * ���ڵ�
	 */
	private Node root;
	
	/**
	 * �ڵ���
	 */
	private int size;
	
	public BinarySearchTree(){
		root = null;
		size = 0;
	}
	
	/**
	 * @Title:size
	 * @Description:TODO ���Ľڵ����
	 * @return:int
	 * @author:Jiangxb
	 * @date: 2019��3��17�� ����4:25:22
	 */
	public int size(){
		return size;
	}
	
	/**
	 * @Title:isEmpty
	 * @Description:TODO ���������� �Ƿ�Ϊ��
	 * @return:boolean
	 * @author:Jiangxb
	 * @date: 2019��3��17�� ����4:25:46
	 */
	public boolean isEmpty(){
		return size == 0;
	}
	
	/**
	 * @Title:add
	 * @Description:TODO �����Ƕ����������������Ԫ��e
	 * @return:void
	 * @author:Jiangxb
	 * @date: 2019��3��17�� ����4:36:57
	 */
	public void add(E e){
		// ���ڵ�Ϊ��ʱ
//		if(root == null){
//			root = new Node(e);
//			size ++ ;
//		}else{
//			add1(root,e);
//		}
		
		// add() ���ƺ�ķ������ã���Ϊ�Ѿ�������ݹ鷽������������Ϊ�յĲ���������Ͳ���Ҫ�ظ��ж���
		root = add(root,e);
	}
	
	/**
	 * @Title:add1
	 * @Description:TODO ����nodeΪ���Ķ��������� �в���Ԫ��e���ݹ��㷨
	 * @return:void
	 * @author:Jiangxb
	 * @date: 2019��3��17�� ����4:38:43
	 */
	private void add1(Node node,E e){
		/**
		 * ��һ�����ݹ���ֹ����
		 */
		if(e.equals(node.e)){
			return;	// �������Ԫ��e �� �ڵ��ֵ һ��
		}else if(e.compareTo(node.e) < 0 && node.left == null){
			// �������Ԫ��e < �ڵ�Ԫ�أ����ҽڵ�����Ϊ�գ���Ϊ�ڵ�����Ӳ���
			node.left = new Node(e);
			size ++;
			return;
		}else if(e.compareTo(node.e) > 0 && node.right == null){
			// �������Ԫ��e > �ڵ�Ԫ�أ����ҽڵ��Һ���Ϊ�գ���Ϊ�ڵ���Һ��Ӳ���
			node.right = new Node(e);
			size ++;
			return;
		}
		
		/**
		 * �ڶ�����ϸ������
		 */
		if(e.compareTo(node.e) < 0){
			add1(node.left,e);	// ����
		}else{ //e.compareTo(node.e) > 0
			add1(node.right,e);	// �Һ���
		}
	}
	
	/**
	 * @Title:add
	 * @Description:TODO �����淽���ļ�(�ݹ��ʵ��)
	 * @return:Node	���ز����½ڵ������������ĸ�
	 * @author:Jiangxb
	 * @date: 2019��3��17�� ����5:00:53
	 */
	private Node add(Node node,E e){
		/**
		 * ��һ�����ݹ���ֹ����
		 * 	������ڵ�Ϊ����ֱ�Ӵ���һ���ڵ�
		 */
		if(node == null){
			size ++;
			return new Node(e);
		}
		
		/**
		 * �ڶ�����ϸ������
		 */
		if(e.compareTo(node.e) < 0){
			node.left = add(node.left,e);	// ����
		}else if(e.compareTo(node.e) > 0){ 
			node.right = add(node.right,e);	// �Һ���
		}
		
		return node;
	}
	
	/**
	 * @Title:contains
	 * @Description:TODO ���������������Ƿ����Ԫ��e(�ݹ�ʵ��)
	 * @return:boolean
	 * @author:Jiangxb
	 * @date: 2019��3��19�� ����2:37:58
	 */
	public boolean contains(E e){
		return contains(root, e);
	}
	
	/**
	 * @Title:contains
	 * @Description:TODO ����nodeΪ���Ķ������������Ƿ����Ԫ��e���ݹ��㷨
	 * @return:boolean
	 * @author:Jiangxb
	 * @date: 2019��3��19�� ����2:39:41
	 */
	private boolean contains(Node node,E e){
		/**
		 * ��һ�����ݹ���ֹ����
		 * 	������ڵ�nodeΪ����ֱ�ӷ��� false
		 */
		if(node == null){
			return false;
		}
		
		/**
		 * �ڶ�����ϸ������(����Ĳ����߼�)
		 */
		if(e.compareTo(node.e) == 0){		// Ԫ��e ���� ���ڵ�
			return true;	
		}else if(e.compareTo(node.e) < 0){	// Ԫ��e ������ڵ� ������
			return contains(node.left,e);
		}else{ //e.compareTo(node.e) > 0	// Ԫ��e ������ڵ� ������
			return contains(node.right,e);
		}
	}
	
	/**
	 * @Title:preOrder
	 * @Description:TODO ������������ǰ�����(�� �� ��)
	 * @return:void
	 * @author:Jiangxb
	 * @date: 2019��3��19�� ����3:02:14
	 */
	public void preOrder(){
		preOrder(root);
	}
	
	/**
	 * @Title:preOrder
	 * @Description:TODO ǰ����� ��nodeΪ���Ķ������������ݹ��㷨
	 * @return:void
	 * @author:Jiangxb
	 * @date: 2019��3��19�� ����3:03:30
	 */
	private void preOrder(Node node){
		/**
		 * ��һ�����ݹ���ֹ�㷨
		 */
		if(node == null){
			return;
		}
		/**
		 * �ڶ�����ϸ������(Ҳ�������ĵݹ��߼�)
		 */
		System.out.println(node.e);
		preOrder(node.left);
		preOrder(node.right);
	}
	
	/**
	 * @Title:preOrderNR
	 * @Description:TODO ����������ǰ������ķǵݹ�д��
	 * @return:void
	 * @author:Jiangxb
	 * @date: 2019��3��19�� ����4:41:30
	 * ���� �� �ҡ�
	 */
	public void preOrderNR(){
		Stack<Node> stack = new Stack<>();
		stack.push(root);	// ��һ�����Ƚ����ڵ���ջ
		while(!stack.isEmpty()){
			// ��ǰҪ���ʵĽڵ�(ջ��Ԫ��)
			Node cur = stack.pop();
			
			System.out.println(cur.e);
			
			// ���Һ�����ջ
			if(cur.right != null){
				stack.push(cur.right);
			}
			
			// ��������ջ
			if(cur.left != null){
				stack.push(cur.left);
			}
		}
	}
	
	/**
	 * @Title:inOrderNR
	 * @Description:TODO ������������������ķǵݹ�д��
	 * @return:void
	 * @author:Jiangxb
	 * @date: 2019��3��20�� ����9:49:03
	 * ���� �� �ҡ�
	 */
	public void inOrderNR(){
		Stack<Node> stack = new Stack<>();
		// ��ǰҪ���ʵĽڵ�(���ڵ�)
		Node cur = root;
		while(cur != null || !stack.isEmpty()){
			// ѹ��ýڵ������������
			while(cur != null){
				stack.push(cur);
				cur = cur.left;
			}
			// ȡ��ջ��Ԫ��(��ջ)
			cur = stack.pop();
			System.out.println(cur.e);
			// ��ջ��Ԫ�ص��Һ�����ջ:�����Һ��ӣ�����ų�ջ�������Һ��ӣ�ִ���ڲ��while������ջ��
			cur = cur.right;
		}
	}
	
	/**
	 * @Title:postOrderNR
	 * @Description:TODO ������������������ķǵݹ�д��
	 * @return:void
	 * @author:Jiangxb
	 * @date: 2019��3��20�� ����1:37:01
	 * ���� �� �С�
	 */
	public void postOrderNR(){
		Stack<Node> stack = new Stack<>();
		// ��ǰҪ���ʵĽڵ�(���ڵ�)
		Node cur = root;	
		// ǰһ�η��ʵĽڵ�
		Node last = null;
		while(cur != null || !stack.isEmpty()){
			// ѹ��ýڵ������������
			while(cur != null){
				stack.push(cur);
				cur = cur.left;
			}
			
			cur =  stack.peek();	// ջ��Ԫ��
			
			if(cur.right != null && last != cur.right){
				// �����ǰ�ڵ�����Һ��� �� �������ϴη��ʵĽڵ�
				cur = cur.right;
			}else if(null == cur.right || last == cur.right){
				System.out.println(cur.e);
				// ����ǰһ�η��ʵĽڵ�
				last = cur;
				stack.pop();
				cur = null;
			}
		}
	}
	
	/**
	 * @Title:inOrder
	 * @Description:TODO �������������������(��  �� ��)
	 * @return:void
	 * @author:Jiangxb
	 * @date: 2019��3��19�� ����3:42:22
	 */
	public void inOrder(){
		inOrder(root);
	}
	
	/**
	 * @Title:inOrder
	 * @Description:TODO ������� ��nodeΪ���Ķ������������ݹ��㷨
	 * @return:void
	 * @author:Jiangxb
	 * @date: 2019��3��19�� ����3:42:49
	 */
	private void inOrder(Node node){
		if(node == null){
			return;
		}
		
		inOrder(node.left);
		System.out.println(node.e);
		inOrder(node.right);
	}
	
	/**
	 * @Title:postOrder
	 * @Description:TODO �����������ĺ������(�� �� ��)
	 * @return:void
	 * @author:Jiangxb
	 * @date: 2019��3��19�� ����3:52:21
	 */
	public void postOrder(){
		postOrder(root);
	}
	
	/**
	 * @Title:postOrder
	 * @Description:TODO ������� ��nodeΪ���Ķ������������ݹ��㷨
	 * @return:void
	 * @author:Jiangxb
	 * @date: 2019��3��19�� ����3:52:08
	 */
	private void postOrder(Node node){
		if(node == null){
			return;
		}
		
		postOrder(node.left);
		postOrder(node.right);
		System.out.println(node.e);
	}
	
	/**
	 * @Title:levelOrder
	 * @Description:TODO �����������Ĳ������
	 * @return:void
	 * @author:Jiangxb
	 * @date: 2019��3��21�� ����9:48:29
	 * �������С��Ƚ��ȳ���
	 */
	public void levelOrder(){
		Queue<Node> queue = new LinkedList<>();
		// ���ڵ� ���
		queue.add(root);
		while(!queue.isEmpty()){
			// ��ǰҪ���ӵĽڵ�
			Node cur = queue.remove();
			System.out.println(cur.e);
			
			if(cur.left != null){
				queue.add(cur.left);
			}
			
			if(cur.right != null){
				queue.add(cur.right);
			}
		}
	}
	
	/**
	 * @Title:minmun
	 * @Description:TODO Ѱ�Ҷ�������������СԪ��
	 * @return:E
	 * @author:Jiangxb
	 * @date: 2019��3��21�� ����3:55:17
	 */
	public E minimun(){
		if(size == 0){
			throw new IllegalArgumentException("BST is empty!");
		}
		return minimun(root).e;
	}
	
	/**
	 * @Title:minimun
	 * @Description:TODO ������nodeΪ���Ķ�������������Сֵ���ڵĽڵ�
	 * @return:void
	 * @author:Jiangxb
	 * @date: 2019��3��21�� ����3:56:54
	 */
	private Node minimun(Node node) {
		/**
		 * ��һ�����ݹ���ֹ����
		 */
		if(node.left == null){
			return node;
		}
		/**
		 * �ڶ������ݹ�ϸ��(һֱ������)
		 */
		return minimun(node.left);
	}
	
	/**
	 * @Title:maximun
	 * @Description:TODO Ѱ�Ҷ��������������Ԫ��
	 * @return:E
	 * @author:Jiangxb
	 * @date: 2019��3��21�� ����3:59:49
	 */
	public E maximun(){
		if(size == 0){
			throw new IllegalArgumentException("BST is empty!");
		}
		return maximun(root).e;
	}
	
	/**
	 * @Title:maximun
	 * @Description:TODO ������nodeΪ���Ķ��������������ֵ���ڵĽڵ�
	 * @return:Node
	 * @author:Jiangxb
	 * @date: 2019��3��21�� ����4:00:10
	 */
	private Node maximun(Node node) {
		/**
		 * ��һ�����ݹ���ֹ����
		 */
		if(node.right == null){
			return node;
		}
		/**
		 * �ڶ������ݹ�ϸ��(һֱ������)
		 */
		return maximun(node.right);
	}

	
	/**
	 * @Title:removeMin
	 * @Description:TODO �Ӷ�����������ɾ����Сֵ���ڵĽڵ㣬��������Сֵ
	 * @return:E
	 * @author:Jiangxb
	 * @date: 2019��3��21�� ����4:06:39
	 */
	public E removeMin(){
		E ret = minimun();
		root = removeMin(root);
		return ret;
	}
	
	/**
	 * @Title:removeMin
	 * @Description:TODO ɾ������nodeΪ���Ķ����������е���С�ڵ�
	 * @return:Node	����ɾ���ڵ���µĶ����������ĸ�
	 * @author:Jiangxb
	 * @date: 2019��3��21�� ����4:08:48
	 */
	private Node removeMin(Node node){
		/**
		 * ��һ�����ݹ���ֹ�������ݹ鵽��(���ҵ���С�ڵ�)
		 */
		if(node.left == null){
			// ���浱ǰ�ڵ��������(��Ϊ��ǰ�ڵ���������Ѿ�Ϊ���ˣ�ɾ��������ڵ�֮����ô����ڵ���������ĸ��ڵ�����µĸ��ڵ�)
			Node rightNode = node.right;
			node.right = null;
			size --;
			return rightNode;
		}
		
		/**
		 * �ڶ������ݹ��߼����ݹ�Ϊ����
		 * 	ȥɾ����ǰ�ڵ���������е���Сֵ����������ظ���ǰ�ڵ�����ӡ�
		 */
		node.left = removeMin(node.left);
		return node;
	}
	
	/**
	 * @Title:removeMax
	 * @Description:TODO �Ӷ�����������ɾ�����ֵ���ڵĽڵ㣬���������ֵ
	 * @return:E
	 * @author:Jiangxb
	 * @date: 2019��3��21�� ����4:18:45
	 */
	public E removeMax(){
		E ret = maximun();
		root = removeMax(root);
		return ret;
	}
	
	/**
	 * @Title:removeMax
	 * @Description:TODO ɾ������nodeΪ���Ķ����������е����ڵ�
	 * @return:Node	����ɾ���ڵ���µĶ����������ĸ�
	 * @author:Jiangxb
	 * @date: 2019��3��21�� ����4:19:25
	 */
	private Node removeMax(Node node){
		/**
		 * ��һ�����ݹ���ֹ����
		 * 	node.right == null���ﵽ�˵ݹ鵽��
		 */
		if(node.right == null){
			// ���浱ǰ�ڵ��������(��Ϊ��ǰ�ڵ���������Ѿ�Ϊ���ˣ�ɾ��������ڵ�֮����ô����ڵ���������ĸ��ڵ�����µĸ��ڵ�)
			Node rightNode = node.left;
			node.left = null;
			size --;	// ά�����Ľڵ����
			return rightNode;
		}
		/**
		 * �ڶ������ݹ�δ����
		 * 	ȥɾ����ǰ�ڵ���������е����ֵ����������ظ���ǰ�ڵ���Һ��ӡ�
		 */
		node.right = removeMax(node.right);
		return node;
	}
	
	
	/**
	 * @Title:remove
	 * @Description:TODO �Ӷ�����������ɾ��Ԫ��Ϊe�Ľڵ�
	 * @return:void
	 * @author:Jiangxb
	 * @date: 2019��3��22�� ����5:22:48
	 */
	public void remove(E e){
		root = remove(root,e);
	}
	
	/**
	 * @Title:remove
	 * @Description:TODO ɾ����nodeΪ���Ķ�����������ֵΪe�Ľڵ㣬�ݹ��㷨
	 * @return:Node	����ɾ���ڵ���µĶ����������ĸ�
	 * @author:Jiangxb
	 * @date: 2019��3��22�� ����5:24:05
	 */
	private Node remove(Node node, E e) {
		/**
		 * ��һ�����ݹ���ֹ����
		 */
		if(node == null){
			return null;
		}
		
		/**
		 * �ڶ������ݹ�ϸ����
		 */
		if(e.compareTo(node.e) < 0){		// ��ɾ��Ԫ��e �� node��Ԫ��С��ʱ��(���������ߣ��ҵ���ɾ��Ԫ��e)
			node.left = remove(node.left,e);
			return node;
		}else if(e.compareTo(node.e) > 0){	// ��ɾ��Ԫ��e �� node��Ԫ�ش��ʱ��(���������ߣ��ҵ���ɾ��Ԫ��e)
			node.right = remove(node.right, e);
			return node;
		}else{ // e.compareTo(node.e) = 0  	// �ҵ��˴�ɾ��Ԫ��e �� ���е�λ��(Ҳ����Ҫɾ��node����ڵ�)
			
			// �١���ɾ���ڵ�������Ϊ�յ����
			if(node.left == null){
				Node rightNode = node.right;
				node.right = null;
				size --;
				return rightNode;
			}
			
			// �ڡ���ɾ���ڵ�������Ϊ�յ����
			if(node.right == null){
				Node leftNode = node.left;
				node.left = null;
				size--;
				return leftNode;
			}
			
			/**
			 * �ۡ���ɾ���ڵ�������������Ϊ��
			 * ˼·���ҵ��ȴ�ɾ���ڵ�����С�ڵ㣬����ɾ���ڵ�����������С�ڵ㣨��̣���ʵ��������ǰ��(�����������Ľڵ�)��
			 * 		������ڵ㶥���ɾ���ڵ��λ��
			 */
			 Node successor = minimun(node.right);		// successor����̽ڵ㡱ָ���˴�ɾ���ڵ�����������С�ڵ�
			 successor.right = removeMin(node.right);	// ɾ����ɾ���ڵ�����������С�ڵ�
			 successor.left = node.left;	// 
			 node.left = node.right = null;
			 return successor;
		}
	}

	
	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		generateBSTString(root,0,res);
		return res.toString();
	}
	
	/**
	 * @Title:generateBSTString
	 * @Description:TODO ������nodeΪ���ڵ㣬���Ϊdepth���������������ַ���
	 * @return:void
	 * @author:Jiangxb
	 * @date: 2019��3��19�� ����3:23:35
	 */
	private void generateBSTString(BinarySearchTree<E>.Node node, int depth, StringBuilder res) {
		/**
		 * ��һ�����ݹ���ֹ����
		 */
		if(node == null){
			res.append(generateDepthString(depth) + "null\n");
			return;
		}
		
		/**
		 * �ڶ�����
		 * 	����ǰ������ģ��ݹ��㷨
		 */
		res.append(generateDepthString(depth) + node.e + "\n");
		generateBSTString(node.left,depth + 1,res);
		generateBSTString(node.right,depth + 1,res);
	}

	/**
	 * @Title:generateDepthString
	 * @Description:TODO ��ӡ�������
	 * @return:String
	 * @author:Jiangxb
	 * @date: 2019��3��19�� ����3:29:32
	 */
	private String generateDepthString(int depth) {
		StringBuilder res = new StringBuilder();
		for(int i = 0 ; i <depth ; i++){
			res.append("- ");
		}
		return res.toString();
	}
	
}
