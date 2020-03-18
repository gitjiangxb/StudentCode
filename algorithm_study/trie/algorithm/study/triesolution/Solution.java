package algorithm.study.triesolution;

import java.util.TreeMap;

/**
 * leetcode208. ʵ�� Trie (ǰ׺��)
 * @Package:algorithm.study.triesolution
 * @ClassName:Solution
 * @Description:TODO 
 * @author:Jiangxb
 * @date:2019��3��31�� ����5:17:02
 *
 */
public class Solution {
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
	
	public Solution(){
		root = new Node();
	}
	
	public void insert(String word){
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
		}
	}
	
	public boolean search(String word){
		
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
	
	public boolean startsWith(String prefix){
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
	
	public static void main(String[] args){
		Solution trie = new Solution();
		trie.insert("apple");
		
		System.out.println(trie.search("apple"));   // ���� true
		System.out.println(trie.search("app"));     // ���� false
		
		System.out.println(trie.startsWith("app")); // ���� true
		trie.insert("app");   
		System.out.println(trie.search("app"));     // ���� true
	}
}
