package algorithm.study.setsolution;

import java.util.TreeSet;


/**
 * leetcode 804 �����⣺ΨһĦ��˹�����
 * @Package:algorithm.study.setsolution
 * @ClassName:Solution
 * @Description:TODO 
 * @author:Jiangxb
 * @date:2019��3��25�� ����4:15:58
 * ����java�ṩ��TreeSet��ʵ�֣�
 * 	TreeSet �ײ���һ��ƽ������������ڡ��������ʵ�ֵ�
 *
 */
public class Solution {
	public static int uniqueMorseRepresentations(String[] words) {
		// 26��Ӣ����ĸ��ӦĦ��˹�����
        String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        // ����JDK�ṩ��TreeSet
        TreeSet<String> set = new TreeSet<>();
        for (String word : words) {
			StringBuilder res = new StringBuilder();
			// ����������ĸ��������ĸASCII���� - a(97)���õ�������ȡ����Ӧ��ĸ��Ħ��˹����
			for (int i = 0; i < word.length(); i++) {
				res.append(codes[word.charAt(i) - 'a']);
			}
			set.add(res.toString());
		}
        return set.size();
	}
	
	public static void main(String[] args) {
		String[] words = {"gin","zen","gig","msg"};
		int num = uniqueMorseRepresentations(words);
		System.out.println(num);
	}
}
