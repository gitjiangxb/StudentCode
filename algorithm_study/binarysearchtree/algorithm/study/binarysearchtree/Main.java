package algorithm.study.binarysearchtree;
/**
 * ���Զ���������
 * @Package:algorithm.study.binarysearchtree
 * @ClassName:Main
 * @Description:TODO 
 * @author:Jiangxb
 * @date:2019��3��19�� ����3:19:06
 *
 */
public class Main {
	public static void main(String[] args) {
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		
		int[] nums = {5,3,6,8,4,2};
	/*
				5
			  /	  \
			 3	   6
		   /  \		\
		  2	   4	 8
	*/
		for (int num : nums) {
			bst.add(num);
		}
		
		System.out.println(bst);
//		bst.preOrderNR();
//		bst.removeMin();
//		bst.removeMax();
		bst.remove(5);
		System.out.println(bst);
//		bst.postOrderNR();
//		bst.inOrder();
//		bst.postOrder();
		
//		bst.levelOrder();
		
	}
}
