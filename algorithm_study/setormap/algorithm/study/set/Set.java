package algorithm.study.set;
/**
 * �Զ��弯�Ͻӿ�
 * @Package:algorithm.study.set
 * @ClassName:Set
 * @Description:TODO 
 * @author:Jiangxb
 * @date:2019��3��24�� ����3:48:32
 *
 */
public interface Set<E> {
	void add(E e);
	void remove(E e);
	boolean contains(E e);
	int getSize();
	boolean isEmpty();
}
