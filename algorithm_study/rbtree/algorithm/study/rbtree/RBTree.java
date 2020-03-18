package algorithm.study.rbtree;

import java.util.ArrayList;

import algorithm.study.bstset.FileOperation;
/**
 * ���ڡ�����������_Map��ʵ�ֺ����
 * @Package:algorithm.study.rbtree
 * @ClassName:RBTree
 * @Description:TODO 
 * @author:Jiangxb
 * @date:2019��4��11�� ����2:54:22
 * 
 * @param <K>
 * @param <V>
 */
public class RBTree<K extends Comparable<K>, V>  {
	
	private static final boolean RED = true;
	private static final boolean BLACK = false;
	
	 private class Node{
        public K key;
        public V value;
        public Node left, right;
        /**
         * ������������ԣ��Ƿ�Ϊ��ɫ�ڵ㣻
         * 	���������涨��ĳ���
         */
        public boolean color;

        public Node(K key, V value){
            this.key = key;
            this.value = value;
            left = null;
            right = null;
            /**
             * ����ڵ��ʱ��Ĭ����ɫΪ��ɫ
             */
            color = RED;
        }
    }

    private Node root;
    private int size;

    public RBTree(){
        root = null;
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * ��������������������жϽڵ�node����ɫ
     * @Title:isRed
     * @Description:TODO 
     * @return:boolean
     * @author:Jiangxb
     * @date: 2019��4��11�� ����3:21:32
     */
    private boolean isRed(Node node){
    	if(node == null){
    		return BLACK;
    	}
    	return node.color;
    }
    
    /**
     * ���������������������node��������ת
     * @Title:leftRotate
     * @Description:TODO 
     * @return:Node	������ת��õ��������ĸ�
     * @author:Jiangxb
     * @date: 2019��4��12�� ����10:09:53
     * 	//   node                     x
	    //  /   \     ����ת         		/  \
	    // T1   x   --------->   node   T3
	    //     / \              /   \
	    //    T2 T3            T1   T2
     */
    private Node leftRotate(Node node){
    	// ��ת�������ĸ��ڵ�
    	Node x = node.right;
    	
    	// ����ת����
    	node.right = x.left;
    	x.left = node;
    	
    	// �Խڵ����ɫ����ά��
    	x.color = node.color;
    	node.color = RED;
    	
    	return x;
    }
    
    /**
     * ���������������������node��������ת
     * @Title:rightRotate
     * @Description:TODO 
     * @return:Node	������ת��õ��������ĸ�
     * @author:Jiangxb
     * @date: 2019��4��12�� ����11:38:05
     * 	//     node                   x
    	//    /   \     ����ת       		/  \
    	//   x    T2   ------->   y   node
    	//  / \                       /  \
    	// y  T1                     T1  T2
     */
    private Node rightRotate(Node node){
    	
    	Node x = node.left;
    	
    	// ����ת
    	node.left = x.right;
    	x.right = node;
    	
    	// �Խڵ����ɫ����ά��
    	x.color = node.color;
    	node.color = RED;
    	
    	return x;
    }
    
    /**
     * ���������������������node�ڵ㼰�����Һ�������ɫ��ת
     * @Title:flipColors
     * @Description:TODO 
     * @return:void
     * @author:Jiangxb
     * @date: 2019��4��12�� ����11:04:46
     */
    private void flipColors(Node node){
    	
    	node.color = RED;
    	node.left.color = BLACK;
    	node.right.color = BLACK;
    }
    
    // ������������µ�Ԫ��(key, value)
    public void add(K key, V value){
        root = add(root, key, value);
        /**
         * �������������������
         * 	���ո��ڵ�Ϊ��ɫ�ڵ�(�߼�д�������ڵ��)
         */
        root.color = BLACK;
    }

    // ����nodeΪ���ĺ�����в���Ԫ��(key, value)���ݹ��㷨
    // ���ز����½ڵ�������ĸ�
    private Node add(Node node, K key, V value){

        if(node == null){
            size ++;
            return new Node(key, value);	// Ĭ�ϲ����ɫ�ڵ�
        }

        if(key.compareTo(node.key) < 0)
            node.left = add(node.left, key, value);
        else if(key.compareTo(node.key) > 0)
            node.right = add(node.right, key, value);
        else // key.compareTo(node.key) == 0
            node.value = value;
        
        /**
         * ά��������Ļ�������
         * 	��ע�⡿����ʱnodeΪ����ڵ�ĸ��ڵ�
         */
        if(isRed(node.right) && !isRed(node.left)){
        	node = leftRotate(node);	// ����ת
        }
        
        if(isRed(node.left) && isRed(node.left.left)){
        	node = rightRotate(node);	// ����ת
        }
        
        if(isRed(node.left) && isRed(node.right)){
        	flipColors(node);			// ��ɫ��ת
        }
        
        return node;
    }

    // ������nodeΪ���ڵ�ĺ�����У�key���ڵĽڵ�
    private Node getNode(Node node, K key){

        if(node == null)
            return null;

        if(key.equals(node.key))
            return node;
        else if(key.compareTo(node.key) < 0)
            return getNode(node.left, key);
        else // if(key.compareTo(node.key) > 0)
            return getNode(node.right, key);
    }

    public boolean contains(K key){
        return getNode(root, key) != null;
    }

    public V get(K key){

        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    public void set(K key, V newValue){
        Node node = getNode(root, key);
        if(node == null)
            throw new IllegalArgumentException(key + " doesn't exist!");

        node.value = newValue;
    }

    // ������nodeΪ���Ķ�������������Сֵ���ڵĽڵ�
    private Node minimum(Node node){
        if(node.left == null)
            return node;
        return minimum(node.left);
    }

    // ɾ������nodeΪ���Ķ����������е���С�ڵ�
    // ����ɾ���ڵ���µĶ����������ĸ�
    private Node removeMin(Node node){

        if(node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    // �Ӷ�����������ɾ����Ϊkey�Ľڵ�
    public V remove(K key){

        Node node = getNode(root, key);
        if(node != null){
            root = remove(root, key);
            return node.value;
        }
        return null;
    }

    private Node remove(Node node, K key){

        if( node == null )
            return null;

        if( key.compareTo(node.key) < 0 ){
            node.left = remove(node.left , key);
            return node;
        }
        else if(key.compareTo(node.key) > 0 ){
            node.right = remove(node.right, key);
            return node;
        }
        else{   // key.compareTo(node.key) == 0

            // ��ɾ���ڵ�������Ϊ�յ����
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            }

            // ��ɾ���ڵ�������Ϊ�յ����
            if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size --;
                return leftNode;
            }

            // ��ɾ���ڵ�������������Ϊ�յ����

            // �ҵ��ȴ�ɾ���ڵ�����С�ڵ�, ����ɾ���ڵ�����������С�ڵ�
            // ������ڵ㶥���ɾ���ڵ��λ��
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;

            node.left = node.right = null;

            return successor;
        }
    }

    public static void main(String[] args){

        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile("pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());

            RBTree<String, Integer> map = new RBTree<>();
            for (String word : words) {
                if (map.contains(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }

            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
        }

        System.out.println();
    }
}
