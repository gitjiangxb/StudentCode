package algorithm.study.queue;
/**
 * ������С��������Զ���ġ���̬���顿ʵ��
 * @Package:algorithm.study.queue
 * @ClassName:ArrayQueue
 * @Description:TODO 
 * @author:Jiangxb
 * @date:2019��3��13�� ����3:32:24
 * 
 * @param <E>
 */
public class ArrayQueue<E> implements Queue<E> {
	/**
	 * ���ڶ�̬����ĳ�Ա����
	 */
	private Array<E> array;
	
	public ArrayQueue(int capacity) {
		array = new Array<>(capacity);
	}
	
	public ArrayQueue() {
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
	public void enqueue(E e) {
		// TODO Auto-generated method stub
		array.addLast(e);
	}

	/**
	 * ���ӣ�ʱ�临�Ӷ�O(n),����O(1)��
	 */
	@Override
	public E dequeue() {
		// TODO Auto-generated method stub
		return array.removeFirst();
	}

	@Override
	public E getFront() {
		// TODO Auto-generated method stub
		return array.getFirst();
	}
	
	public int getCatacity(){
		return array.getCapacity();
	}
	
	@Override
	public String toString(){
		StringBuilder res = new StringBuilder();
		res.append("Queue��");
		// ����
		res.append("front [");
		for (int i = 0; i < array.getSize(); i++) {
			res.append(array.get(i));
			if(i != array.getSize()-1){
				res.append(", ");
			}
		}
		res.append("] tail");	
		return res.toString();
	}
	
}
