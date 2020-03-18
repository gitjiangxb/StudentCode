package algorithm.study.avltree;

import java.util.ArrayList;

import javax.management.RuntimeErrorException;

import algorithm.study.bstset.FileOperation;

/**
 * ���� ��AVLTree��
 * @Package:algorithm.study.avltree
 * @ClassName:Main
 * @Description:TODO 
 * @author:Jiangxb
 * @date:2019��4��7�� ����11:14:55
 *
 */
public class Main{
	public static void main(String[] args) {
		System.out.println("Pride and prejudice");
		
		ArrayList<String> words = new ArrayList<>();
		if(FileOperation.readFile("pride-and-prejudice.txt", words)){
			System.out.println("Total words : " + words.size());
			
			AVLTree<String, Integer> avlTree = new AVLTree<>();
			for (String word : words) {
				if(avlTree.contains(word)){
					// ���жϸõ����Ƿ���ڣ���������ȡ��value+1
					avlTree.set(word, avlTree.get(word) + 1);
				}else{
					avlTree.add(word, 1);
				}
			}
			System.out.println("Total different words: " + avlTree.getSize());
			System.out.println("���Ժܷ���Ŀ���֪��ĳһ���ʵĴ�Ƶ��" + avlTree.get("pride"));
			
			System.out.println("is BST : " + avlTree.isBST());
			
			System.out.println("is Balanced : " + avlTree.isBalanced());
			
			for (String word : words){
				avlTree.remove(word);	// ִ��ɾ������
				if(!avlTree.isBST() || !avlTree.isBalanced()){
					// ����������������� ���� ƽ�������������ʱ���׳��쳣
					throw new RuntimeException("error");
				}
			}
		}
	}
}
