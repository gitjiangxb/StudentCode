package algorithm.study.rbtree.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import algorithm.study.avltreemap.AVLMap;
import algorithm.study.bst.BST;
import algorithm.study.rbtree.RBTree;

/**
 * ���� ���������� / AVL�� / �����
 * @Package:algorithm.study.rbtree.test
 * @ClassName:Main2
 * @Description:TODO 
 * @author:Jiangxb
 * @date:2019��4��12�� ����3:44:41
 *	ֻ������Ӳ���,����������
 */
public class Main2 {
	public static void main(String[] args){
		int n = 20000000;
		
		Random random = new Random();
		ArrayList<Integer> testData = new ArrayList<>(n);
		for (int i = 0; i < n; i++) {
			// �����ӵ�����
			testData.add(random.nextInt(Integer.MAX_VALUE));
		}
		
		// ���Զ���������
		long startTime = System.nanoTime();
		BST<Integer, Integer> bst = new BST<>();
		for (Integer data : testData) {
			bst.add(data, null);
		}
		long entTime = System.nanoTime();
		double time = (entTime - startTime) / 1000000000.0;
		System.out.println("BST " + time + " s");
		
		// ����AVL��
		startTime = System.nanoTime();
		AVLMap<Integer, Integer> avl = new AVLMap<>();
		for (Integer data : testData) {
			avl.add(data, null);
		}
		entTime = System.nanoTime();
		time = (entTime - startTime) / 1000000000.0;
		System.out.println("AVL " + time + " s");
		
		// ���Ժ����
		startTime = System.nanoTime();
		RBTree<Integer, Integer> rbt = new RBTree<>();
		for (Integer data : testData) {
			rbt.add(data, null);
		}
		entTime = System.nanoTime();
		time = (entTime - startTime) / 1000000000.0;
		System.out.println("RBT " + time + " s");
		
	}
}
