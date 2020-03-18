package algorithm.study.maxheapqueue;
/**
 * ������нӿ�
 * @Package:algorithm.study.queue
 * @ClassName:Queue
 * @Description:TODO 
 * @author:Jiangxb
 * @date:2019��3��13�� ����3:27:57
 * 
 * @param <E>
 */
public interface Queue<E> {
	/**
	 * @Title:getSize
	 * @Description:TODO ���д�С
	 * @return:int
	 * @author:Jiangxb
	 * @date: 2019��3��13�� ����3:29:40
	 */
	int getSize();
	
	/**
	 * @Title:isEmpty
	 * @Description:TODO �Ƿ�Ϊ��
	 * @return:boolean
	 * @author:Jiangxb
	 * @date: 2019��3��13�� ����3:29:47
	 */
	boolean isEmpty();
	
	/**
	 * @Title:enqueue
	 * @Description:TODO ���
	 * @return:void
	 * @author:Jiangxb
	 * @date: 2019��3��13�� ����3:29:50
	 */
	void enqueue(E e);
	
	/**
	 * @Title:dequeue
	 * @Description:TODO ����
	 * @return:E
	 * @author:Jiangxb
	 * @date: 2019��3��13�� ����3:29:54
	 */
	E dequeue();
	
	/**
	 * @Title:getFront
	 * @Description:TODO ����
	 * @return:E
	 * @author:Jiangxb
	 * @date: 2019��3��13�� ����3:29:58
	 */
	E getFront();
}

