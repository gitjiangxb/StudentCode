package algorithm.study.trie;

import java.util.TreeMap;

/**
 * ���ڡ�java�ṩ��TreeMap��ʵ��Trie
 * @Package:algorithm.study.trie
 * @ClassName:Trie
 * @Description:TODO 
 * @author:Jiangxb
 * @date:2019��3��31�� ����3:51:59
 *
 */
public class Trie {
	
	private class Node{
		// ��ǰ����ڵ��Ƿ��ʾһ�����ʵĽ�β
		public boolean isWord;
		public TreeMap<Character, Node> next;
		
		public Node(boolean isWord){
			this.isWord = isWord;
			next = new TreeMap<>();
		}
		
		public Node(){
			this(false);
		}
	}
	
	private Node root;	// ���ڵ�
	private int size;	// ���ٸ�����
	
	public Trie(){
		root = new Node();
		size = 0;
	}
	
	/**
	 * @Title:getSize
	 * @Description:TODO ���Trie�д洢�ĵ�����
	 * @return:int
	 * @author:Jiangxb
	 * @date: 2019��3��31�� ����4:16:00
	 */
	public int getSize(){
		return size;
	}
	
	/**
	 * @Title:add
	 * @Description:TODO ��Trie�����һ���µĵ���word
	 * @return:void
	 * @author:Jiangxb
	 * @date: 2019��3��31�� ����4:17:12
	 * ��ϰ������������ĳɵݹ�д����
	 */
	public void add(String word){
		// cur�������ڵ�
		Node cur = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);	// ��ȡ�����е��ַ�
			
			// ���������ӳ��ʱ���򴴽�
			if(cur.next.get(c) == null){
				cur.next.put(c, new Node());
			}
			
			// �������� ֱ���ҵ�
			cur = cur.next.get(c);
		}
		
		// ��ǰ����ڵ㲢����ʾ�κ�һ�����ʵĽ�β���������ǲ���Ϊ����һ���µĵ���
		if(!cur.isWord){
			cur.isWord = true;
			size ++;
		}
	}
	
	/**
	 * @Title:contains
	 * @Description:TODO ��ѯ����word�Ƿ���Trie��
	 * @return:boolean
	 * @author:Jiangxb
	 * @date: 2019��3��31�� ����4:38:34
	 * ��ϰ������������ĳɵݹ�д����
	 */
	public boolean contains(String word){
		
		Node cur = root;	// ��ǰ�����Ľڵ㣬���ڵ�
		
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if(cur.next.get(c) == null){
				return false;	// Ϊnull��ʾ������
			}
			cur = cur.next.get(c);
		}
		
		return cur.isWord;	// �Ŀ��Ƿ���������ʵ����һ���ַ���β
	}
	
	/**
	 * @Title:isPrefix
	 * @Description:TODO ��ѯ�Ƿ���Trie���е�����prefixΪǰ׺
	 * @return:boolean
	 * @author:Jiangxb
	 * @date: 2019��3��31�� ����5:09:22
	 * 	һ������Ҳ��������ʵ�ǰ׺
	 */
	public boolean isPrefix(String prefix){
		Node cur = root;
		for (int i = 0; i < prefix.length(); i++) {
			char c = prefix.charAt(i);
			if(cur.next.get(c) == null){
				return false;
			}
			cur = cur.next.get(c);
		}
		return true;
	}
	
	/**
	 * @Title:remove
	 * @Description:TODO ��Trie��ɾ������word
	 * @return:boolean
	 * @author:Jiangxb
	 * @date: 2019��4��2�� ����3:06:15
	 */
	public boolean remove(String word){
		if(!contains(word)){
			return false;	// ����������ַ�����ʱ��ֱ�ӷ���
		}
		
		// ��ͷ��ʼ�����ҵ�������ʵ����һ���ַ�����λ��
		Node cur = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if(cur.next.get(c) == null){
				return false;
			}
			cur = cur.next.get(c);
		}
		
		// ����ǰcurΪ�ַ�����β�ַ� ���� ������һ��ʱ��ֻ��Ҫ��isWord��Ϊfalse����
		if(cur.isWord && cur.next.keySet().size() != 0){
			cur.isWord = false;
			size--;
		}else{
			root.next.remove(word.charAt(0));
			size--;
		}
		return true;
	}
	
	public static void main(String[] args){
		Trie trie = new Trie();
		trie.add("apple");
		trie.add("app");
		trie.add("w");
		System.out.println(trie.contains("app"));
		System.out.println(trie.remove("app"));
		System.out.println(trie.contains("app"));
		System.out.println(trie.size);
	}
}
