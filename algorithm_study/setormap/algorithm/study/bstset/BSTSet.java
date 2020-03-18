package algorithm.study.bstset;

import algorithm.study.set.Set;

/**
 * ���ڡ������������� ʵ�� ����
 * @Package:algorithm.study.set
 * @ClassName:BSTSet
 * @Description:TODO 
 * @author:Jiangxb
 * @date:2019��3��24�� ����3:54:29
 *
 */
public class BSTSet<E extends Comparable<E>> implements Set<E> {
	
	private BinarySearchTree<E> bst;
	
	public BSTSet() {
		bst = new BinarySearchTree<>();
	}

	@Override
	public void add(E e) {
		// TODO Auto-generated method stub
		bst.add(e);
	}

	@Override
	public void remove(E e) {
		// TODO Auto-generated method stub
		bst.remove(e);
	}

	@Override
	public boolean contains(E e) {
		// TODO Auto-generated method stub
		return bst.contains(e);
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return bst.size();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return bst.isEmpty();
	}
	
}
