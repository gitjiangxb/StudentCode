package algorithm.study.linkedlistset;

import algorithm.study.set.Set;

/**
 * ���ڡ����� ʵ��set����
 * @Package:algorithm.study.linkedlistset
 * @ClassName:LinkedListSet
 * @Description:TODO 
 * @author:Jiangxb
 * @date:2019��3��24�� ����5:26:31
 *
 */
public class LinkedListSet<E> implements Set<E> {

	private LinkedList<E> linkedList;
	
	public LinkedListSet() {
		linkedList = new LinkedList<>();
	}
	
	@Override
	public void add(E e) {
		// TODO Auto-generated method stub
		/**
		 * ������Ҫ�����ظ���Ԫ�أ���Ϊ�������ʵ���У���û�����Ʋ��������ظ���Ԫ��
		 * ����������Ҫ���ж��Ƿ���ڲ����Ԫ��e���������򲻲���
		 */
		// ��������ʱ������ӽ�ȥ
		if(!linkedList.contains(e)){
			linkedList.addFirst(e);
		}
	}

	@Override
	public void remove(E e) {
		// TODO Auto-generated method stub
		linkedList.removeElement(e);
	}

	@Override
	public boolean contains(E e) {
		// TODO Auto-generated method stub
		return linkedList.contains(e);
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return linkedList.getSize();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return linkedList.isEmpty();
	}
	
}
