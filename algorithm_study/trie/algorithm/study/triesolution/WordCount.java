package algorithm.study.triesolution;

import java.util.ArrayList;
import java.util.TreeMap;

import algorithm.study.bstset.FileOperation;


/**
 * ���ڡ��ֵ�����ʵ�ִ�Ƶͳ�ƹ���
 * @Package:algorithm.study.triesolution
 * @ClassName:WordCount
 * @Description:TODO 
 * @author:Jiangxb
 * @date:2019��4��1�� ����3:58:27
 *
 */
public class WordCount {
	private class Node{
		public int count;		// ͳ�ƴ�Ƶ��Ĭ��Ϊ1
		public boolean isWord;	// �Ƿ�Ϊһ�����ʵĽ�β��Ĭ��Ϊfalse
		public TreeMap<Character, Node> next;	// ����Ҳ����ʹ��HashMap��ʵ�֣�HashMap����
		
		public Node(int count,boolean isWord){
			this.count = count;
			this.isWord = isWord;
			next = new TreeMap<>();
		}
		
		public Node(){
			this(1,false);
		}
	}
	
	private int size;
	private Node root;
	
	public WordCount(){
		root = new Node();
		size = 0;
	}
	
	public int getSize(){
		return size;
	}
	
	public void add(String word){
		Node cur = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if(cur.next.get(c) == null){
				cur.next.put(c, new Node());
			}
			cur = cur.next.get(c);	// ��ʾΪ��ӵ��ʵ����һ���ַ�
		}
		// ������ַ���Ϊ���ʵĽ�β�����ʾ��һ�μ��룬�޸�Ϊtrue��ά��size
		if(!cur.isWord){
			cur.isWord = true;
			size ++;
		}else{
			cur.count = cur.count + 1;
		}
	}
	
	/**
	 * @Title:getCount
	 * @Description:TODO �����ַ���word�õ���Ƶ��
	 * @return:int
	 * @author:Jiangxb
	 * @date: 2019��4��1�� ����4:26:14
	 */
	public int getCount(String word){
		Node cur = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if(cur.next.get(c) == null){
				return 0;	// Ϊnull��ʾ������
			}
			cur = cur.next.get(c);
		}
		return cur.count;
	}
	
	public static void main(String[] args){
		System.out.println("Pride and Prejudice");
		
		ArrayList<String> words = new ArrayList<>();
		if(FileOperation.readFile("pride-and-prejudice.txt", words)){
			WordCount wordCount = new WordCount();
			for(String word: words)
				wordCount.add(word);
			System.out.println("Total different words: " + wordCount.getSize());
			System.out.println("���Ժܷ���Ŀ���֪��ĳһ���ʵĴ�Ƶ��" + wordCount.getCount("pride"));
		}
	}
}
