package algorithm.study.unionfind;

import java.util.Random;

/**
 * ���� UnionFind1 �� UnionFind2 ������
 * @Package:algorithm.study.unionfind
 * @ClassName:Main
 * @Description:TODO 
 * @author:Jiangxb
 * @date:2019��4��3�� ����3:14:33
 *
 */
public class Main {
	
	// �ڶ�����������ʾ�����ǵĲ��������ж�unionFind������鼯��Ӧ��ִ�ж��ٸ�����������������
	private static double testUF(UnionFind unionFind,int m){
		
		int size = unionFind.getSize();
		Random random = new Random();
		long startTime = System.nanoTime();
		
		for (int i = 0; i < m; i++) {
			int a = random.nextInt(size);
			int b = random.nextInt(size);
			unionFind.unionElements(a, b);	// m�κϲ�����
		}
		
		for (int i = 0; i < m; i++) {
			int a = random.nextInt(size);
			int b = random.nextInt(size);
			unionFind.isConnected(a, b);	// m�β�ѯ
		}
		
		long entTime = System.nanoTime();
		return (entTime - startTime) / 1000000000.0;
		 
	}
	
	public static void main(String[] args){
		int size = 10000000;	// ���鼯�е�Ԫ�ظ���
		int m = 10000000;		// Ϊ�����ٴβ���
		
//		UnionFind1 unionFind1 = new UnionFind1(size);
//		System.out.println("unionFind1 : " + testUF(unionFind1, m) + " s");
		
//		UnionFind2 unionFind2 = new UnionFind2(size);
//		System.out.println("unionFind2 : " + testUF(unionFind2, m) + " s");
		
//		UnionFind3 unionFind3 = new UnionFind3(size);
//		System.out.println("unionFind3 : " + testUF(unionFind3, m) + " s");
	
		UnionFind4 unionFind4 = new UnionFind4(size);
		System.out.println("unionFind4 : " + testUF(unionFind4, m) + " s");
		
		UnionFind5 unionFind5 = new UnionFind5(size);
		System.out.println("unionFind5 : " + testUF(unionFind5, m) + " s");
		
		UnionFind6 unionFind6 = new UnionFind6(size);
		System.out.println("unionFind6 : " + testUF(unionFind6, m) + " s");
	}
}
