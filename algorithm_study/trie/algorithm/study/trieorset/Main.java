package algorithm.study.trieorset;

import java.util.ArrayList;
import java.util.Iterator;

import algorithm.study.bstset.BSTSet;
import algorithm.study.bstset.FileOperation;
import algorithm.study.trie.Trie;

/**
 * �ԱȻ��ڡ������������� ʵ�� ���� �� ���ڡ�java�ṩ��TreeMap��ʵ��Trie
 * @Package:algorithm.study.trieorset
 * @ClassName:Main
 * @Description:TODO 
 * @author:Jiangxb
 * @date:2019��3��31�� ����4:55:42
 *	��ȥ�洢�ַ������Ƚ����ܲ��죻�ȽϷ�ʽ����ȡԭ�����ĵ���
 */
public class Main {
	public static void main(String[] args){
		System.out.println("Pride and Prejudice");
		
		ArrayList<String> words = new ArrayList<>();
		if(FileOperation.readFile("pride-and-prejudice.txt", words)){
			/**
             * BSTSet
             */
			long startTime = System.nanoTime();
			BSTSet<String> set = new BSTSet<>();
			for(String word : words){
				set.add(word);
			}
			
			for(String word : words){
				set.contains(word);
			}
			
			long endTime = System.nanoTime(); 
			double time = (endTime - startTime) / 1000000000.0;
			System.out.println("Total different words: " + set.getSize());
            System.out.println("BSTSet: " + time + " s");
            
            /**
             * Trie
             */
            startTime = System.nanoTime();
            Trie trie = new Trie();
            for(String word: words)
                trie.add(word);

            for(String word: words)
                trie.contains(word);

            endTime = System.nanoTime();
            time = (endTime - startTime) / 1000000000.0;
            System.out.println("Total different words: " + trie.getSize());
            System.out.println("Trie: " + time + " s");
		}
	}
}
