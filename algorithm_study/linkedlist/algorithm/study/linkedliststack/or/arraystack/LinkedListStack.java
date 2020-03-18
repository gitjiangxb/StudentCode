package algorithm.study.linkedliststack.or.arraystack;
/**
 * ���ڡ�����ʵ�ֵ�ջ
 * @Package:algorithm.study.linkedliststack
 * @ClassName:LinkedListStack
 * @Description:TODO 
 * @author:Jiangxb
 * @date:2019��3��14�� ����3:20:08
 * 
 * @param <E>
 */
public class LinkedListStack<E> implements Stack<E> {
	/**
	 * �����������
	 */
	private LinkedList<E> list;
	
	public LinkedListStack(){
		list = new LinkedList<>();
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return list.getSize();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return list.isEmpty();
	}

	@Override
	public void push(E e) {
		// TODO Auto-generated method stub
		// ��ջ == ����ͷ����Ԫ��
		list.addFirst(e);
	}

	@Override
	public E pop() {
		// TODO Auto-generated method stub
		// ��ջ == ����ͷɾ��Ԫ��
		return list.removeFrist();
	}

	@Override
	public E peek() {
		// TODO Auto-generated method stub
		// ջ�� == ����ͷ�ڵ�
		return list.getFirst();
	}
	
	@Override
	public String toString(){
		StringBuilder res = new StringBuilder();
		res.append("LinkedListStack: top ");
		res.append(list);
		return res.toString();
	}
	
}
