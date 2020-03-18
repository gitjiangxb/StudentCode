package algorithm.study.triesolution;

import java.util.TreeMap;

/**
 * leetcode211. ������������� - ���ݽṹ���
 * @Package:algorithm.study.triesolution
 * @ClassName:WordDictionary
 * @Description:TODO 
 * @author:Jiangxb
 * @date:2019��3��31�� ����5:28:45
 *
 */
public class WordDictionary {
	
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
	
	private Node root;
	
	/** Initialize your data structure here. */
    public WordDictionary() {
        root = new Node();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if(cur.next.get(c) == null){
				cur.next.put(c, new Node());
			}
			cur = cur.next.get(c);
		}
        cur.isWord = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return match(root, word, 0);
    }
    
    /**
     * @Title:match
     * @Description:TODO ����nodeΪ����ȥƥ��word�ַ����е��ַ�(index����λ���϶�Ӧ���ַ�)
     * @return:boolean
     * @author:Jiangxb
     * @date: 2019��3��31�� ����5:35:10
     */
    private boolean match(Node node,String word,int index){
    	/**
    	 * ��һ�����ݹ���ֹ
    	 */
    	if(index == word.length()){
    		return node.isWord;
    	}
    	
    	/**
    	 * �ڶ������ݹ�ϸ��
    	 */
    	char c = word.charAt(index);	// ��ǰ���ǵ��ַ�
    	if(c != '.'){
    		if(node.next.get(c) == null){
    			return false;
    		}
    		return match(node.next.get(c),word,index +1);
    	}else{
    		/**
    		 * ���ڡ�.�� ʱ����node.next����ƥ��һ������˵õ�node.next.keySet()��key�ļ���
    		 */
    		for (char nextChar : node.next.keySet()) {
				if(match(node.next.get(nextChar),word,index+1)){
					return true;
				}
			}
    		return false;
    	}
    }
    
    public static void main(String[] args){
    	WordDictionary wordDictionary = new WordDictionary();
    	wordDictionary.addWord("bad");
    	wordDictionary.addWord("dad");
    	wordDictionary.addWord("mad");
    	System.out.println(wordDictionary.search("pad")); 	// false
    	System.out.println(wordDictionary.search("bad")); 	// true
    	System.out.println(wordDictionary.search(".ad")); 	// true
    	System.out.println(wordDictionary.search("b..")); 	// true
    }
}
