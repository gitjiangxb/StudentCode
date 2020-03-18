package algorithm.study.queue;
/**
 * ѭ�����С�������java����ʵ��
 * @Package:algorithm.study.queue
 * @ClassName:LoopQueue
 * @Description:TODO 
 * @author:Jiangxb
 * @date:2019��3��13�� ����4:24:50
 *	front == tail ����Ϊ��
 *	(tail + 1) % capacity == front ������
 */
public class LoopQueue<E> implements Queue<E>{
	/**
	 * ���������capacity(����)=data����ĳ���
	 */
	private E[] data;
	
	/**
	 * �������ڵ�������
	 */
	private int front;
	
	/**
	 * �������һ��Ԫ�ص���һ��λ�ã�Ҳ������Ԫ�����ʱ��������
	 */
	private int tail;
	
	/**
	 * ʵ�ʵ�Ԫ�ظ���
	 */
	private int size;
	
	public LoopQueue(int capacity){
		// ����ѭ������Ҫ����ʶ���˷�һ������
		data = (E[]) new Object[capacity + 1];
		front = 0;
		tail = 0;
		size = 0;
	}
	
	public LoopQueue(){
		this(10);
	}
	
	/**
	 * @Title:getCapacity
	 * @Description:TODO �õ�����
	 * @return:int
	 * @author:Jiangxb
	 * @date: 2019��3��13�� ����4:46:32
	 */
	public int getCapacity(){
		return data.length - 1;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return front == tail;
	}

	@Override
	public void enqueue(E e) {
		// TODO Auto-generated method stub
		// �ж϶����Ƿ���
		if((tail + 1) % data.length == front){
			resize(getCapacity() * 2);
		}
		// ���Ԫ��
		data[tail] = e;
		// ά����һ��Ԫ������������λ��
		tail = (tail + 1) % data.length;
		size ++;
	}

	/**
	 * @Title:resize
	 * @Description:TODO ����
	 * @return:void
	 * @author:Jiangxb
	 * @date: 2019��3��13�� ����4:51:54
	 */
	private void resize(int newCapacity){
		// �µ��������(��ת)
		E[] newData = (E[])new Object[newCapacity + 1];
		for (int i = 0; i < size; i++) {
			/**
			 * ˵��������ǰ���׵���������0��λ���ϣ���ônewData[0] = data[���׵�����]��
			 * 	��Ϊ��ѭ������� i+���׵�������ģ��data.lenth Ϊ���Ƿ�ֹ�±�Խ�硣
			 */
			newData[i] = data[(i + front) % data.length];
		}
		data = newData;
		// ά���������ڵ�����λ��
		front = 0;
		tail = size;
	}
	
	/**
	 * �����з���ʱ�临�Ӷ�O(1)��
	 */
	@Override
	public E dequeue() {
		// TODO Auto-generated method stub
		if(isEmpty()){
			throw new IllegalArgumentException("Cannot dequeue from an empty queue");
		}
		// �õ�����
		E ret = data[front];
		// ���׸�ֵΪnull������GC
		data[front] = null;
		// ά���������ڵ�����λ�ã�����Ӧ��ֱ��front++������������ѭ�������У�
		front = (front + 1) % data.length;
		size --;
		
		// �����ӵ�ʵ��Ԫ������ ���� �������ķ�֮һʱ�����ݶ���֮һ
		if(size == getCapacity() / 4 && getCapacity() / 2 != 0){
			resize(getCapacity() / 2);
		}
		
		return ret;
	}

	@Override
	public E getFront() {
		// TODO Auto-generated method stub
		if(isEmpty()){
			throw new IllegalArgumentException("Queue is empty");
		}
		return data[front];
	}
	
	@Override
	public String toString(){
		StringBuilder res = new StringBuilder();
		res.append(String.format("LoopQueue:size = %d,capatity=%d\n", size,getCapacity()));
		res.append("front [");
		// ѭ������
		for(int i = front; i != tail ;i = (i + 1) % data.length){
			res.append(data[i]);
			// �ж�i�Ƿ������һ��Ԫ��
			if((i + 1) % data.length != tail){
				res.append(", ");
			}
		}
		res.append("] tail");
		return res.toString();
	}
}
