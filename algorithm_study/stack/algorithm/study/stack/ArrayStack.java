package algorithm.study.stack;

/**
 * ���ڡ���̬���顿ʵ�ֵ�ջ
 * @Package:algorithm.study.stack
 * @ClassName:ArrayStack
 * @Description:TODO 
 * @author:Jiangxb
 * @date:2019��3��13�� ����10:21:17
 * 	��������ʱ�临�Ӷȶ��� O(1)
 * @param <E>
 */
public class ArrayStack<E> implements Stack<E> {
	
	/**
	 * ���ڶ�̬����ĳ�Ա����
	 */
	private Array<E> array;
	
	/**
	 * ���ݻ��Ĺ��캯��
	 * @Title:ArrayStack
	 * @param capacity
	 */
	public ArrayStack(int capacity) {
		array = new Array<>(capacity);
	}
	
	/**
	 * Ĭ���޲ι��캯��
	 * @Title:ArrayStack
	 */
	public ArrayStack() {
		array = new Array<>();
	}
	
	
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return array.getSize();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return array.isEmpty();
	}

	@Override
	public void push(E e) {
		// TODO Auto-generated method stub
		array.addLast(e);
	}

	@Override
	public E pop() {
		// TODO Auto-generated method stub
		return array.removeLast();
	}

	@Override
	public E peek() {
		// TODO Auto-generated method stub
		return array.getLast();
	}
	
	/**
	 * @Title:getCapacity
	 * @Description:TODO ���еķ���������Stack�ӿڵġ��õ��ݻ�
	 * @return:int
	 * @author:Jiangxb
	 * @date: 2019��3��13�� ����10:28:44
	 */
	public int getCapacity(){
		return array.getCapacity();
	}
	
	@Override
	public String toString(){
		StringBuilder res = new StringBuilder();
		res.append("Stack��");
		res.append('[');
		for (int i = 0; i < array.getSize(); i++) {
			res.append(array.get(i));
			if(i != array.getSize()-1){
				res.append(", ");
			}
		}
		// �Ҳ�Ϊջ��
		res.append("] top");	
		return res.toString();
	}

}
