package algorithm.study.triesolution;

import java.util.ArrayList;
import java.util.HashMap;

import algorithm.study.bstmap.BSTMap;
import algorithm.study.bstset.FileOperation;

/**
 * ��Ƶ���ܶԱȣ����� ��������������ʵ��ӳ��Map   ��      ���ڡ�java�ṩ��TreeMap��ʵ��Trie
 * @Package:algorithm.study.triesolution
 * @ClassName:Main
 * @Description:TODO 
 * @author:Jiangxb
 * @date:2019��4��1�� ����4:40:50
 *
 */
public class Main {
	private static int testBSTMap(String str){
		int wordCount = 0;	// ��Ƶ��
		long startTime = System.nanoTime();
		ArrayList<String> words = new ArrayList<>();
		if(FileOperation.readFile("a-tale-of-two-cities.txt", words)){
			BSTMap<String, Integer> map = new BSTMap<>();
			for (String word : words) {
				if(map.contains(word)){
					// ���жϸõ����Ƿ���ڣ���������ȡ��value+1
					map.set(word, map.get(word) + 1);
				}else{
					map.add(word, 1);
				}
			}
			System.out.println("Total different words: " + map.getSize());
			wordCount = map.get(str);
		}
		long endTime = System.nanoTime();
		System.out.println("BSTMap����ʱ�䣺" + (endTime - startTime) / 100000000.0);
		return wordCount;
	}
	
	private static int testHashMap(String str){
		int wordCount = 0;	// ��Ƶ��
		long startTime = System.nanoTime();
		ArrayList<String> words = new ArrayList<>();
		if(FileOperation.readFile("a-tale-of-two-cities.txt", words)){
			HashMap<String, Integer> map = new HashMap<>();
			for (String word : words) {
				if(map.containsKey(word)){
					// ���жϸõ����Ƿ���ڣ���������ȡ��value+1
					map.put(word, map.get(word) + 1);
				}else{
					map.put(word, 1);
				}
			}
			System.out.println("Total different words: " + map.size());
			wordCount = map.get(str);
		}
		long endTime = System.nanoTime();
		System.out.println("HashMap����ʱ�䣺" + (endTime - startTime) / 100000000.0);
		return wordCount;
	}
	
	private static int testTrie(String str){
		int count = 0;	// ��Ƶ��
		long startTime = System.nanoTime();
		ArrayList<String> words = new ArrayList<>();
		if(FileOperation.readFile("a-tale-of-two-cities.txt", words)){
			WordCount wordCount = new WordCount();
			for(String word: words)
				wordCount.add(word);
			System.out.println("Total different words: " + wordCount.getSize());
			count = wordCount.getCount(str);
		}
		long endTime = System.nanoTime();
		System.out.println("Trie����ʱ�䣺" + (endTime - startTime) / 100000000.0);
		return count;
	}
	
	public static void main(String[] args){
		System.out.println("a-tale-of-two-cities");
		System.out.println();
		System.out.println("to������ʵĴ�Ƶ�ǣ�" + Main.testHashMap("to"));
		System.out.println();
		System.out.println("to������ʵĴ�Ƶ�ǣ�" + Main.testBSTMap("to"));
		System.out.println();
		System.out.println("to������ʵĴ�Ƶ�ǣ�" + Main.testTrie("to"));
	}
}
