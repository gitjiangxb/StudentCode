package algorithm.study.rbtree.test;

import java.util.ArrayList;
import java.util.Collections;

import algorithm.study.avltree.AVLTree;
import algorithm.study.avltreeorbst.BSTMap;
import algorithm.study.bstset.FileOperation;
import algorithm.study.rbtree.RBTree;

/**
 * ���Զ��������� / AVL�� / �����
 * @Package:algorithm.study.rbtree.test
 * @ClassName:Main
 * @Description:TODO 
 * @author:Jiangxb
 * @date:2019��4��12�� ����3:37:20
 *	�ۺϲ��ԣ����Ĳ�
 */
public class Main {
	public static void main(String[] args){
		System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile("pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());

            /**
             * ��������������words����ĵ��ʽ����������ȥ������
             * 		BST�����˻�������
             * 		AVL������ƽ�����
             *	�������ԣ�Ч���ǳ�����
             *		BST: 22.856811841 s
			 *		AVL: 0.094246362 s
			 *		RBT: 0.080776175 s
             */
            Collections.sort(words);

            // Test BST
            long startTime = System.nanoTime();

            BSTMap<String, Integer> bst = new BSTMap<>();
            for (String word : words) {
                if (bst.contains(word))
                    bst.set(word, bst.get(word) + 1);
                else
                    bst.add(word, 1);
            }

            for(String word: words){
            	bst.contains(word);
            }

            long endTime = System.nanoTime();

            double time = (endTime - startTime) / 1000000000.0;
            System.out.println("BST: " + time + " s");


            // Test AVL Tree
            startTime = System.nanoTime();

            AVLTree<String, Integer> avl = new AVLTree<>();
            for (String word : words) {
                if (avl.contains(word))
                    avl.set(word, avl.get(word) + 1);
                else
                    avl.add(word, 1);
            }

            for(String word: words){
            	avl.contains(word);
            }

            endTime = System.nanoTime();

            time = (endTime - startTime) / 1000000000.0;
            System.out.println("AVL: " + time + " s");
            
         // Test RBTree
            startTime = System.nanoTime();

            RBTree<String, Integer> rbt = new RBTree<>();
            for (String word : words) {
                if (rbt.contains(word))
                	rbt.set(word, rbt.get(word) + 1);
                else
                	rbt.add(word, 1);
            }

            for(String word: words){
            	rbt.contains(word);
            }

            endTime = System.nanoTime();

            time = (endTime - startTime) / 1000000000.0;
            System.out.println("RBT: " + time + " s");
        }

        System.out.println();
	}
}
