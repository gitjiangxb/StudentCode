package algorithm.study.stack;

/**
 * ����ջ�ӿ�
 * @Package:algorithm.study.stack
 * @ClassName:Stack
 * @Description:TODO 
 * @author:Jiangxb
 * @date:2019��3��13�� ����10:17:00
 * 
 * @param <E>
 */
public interface Stack<E> {
	/**
	 * @Title:getSize
	 * @Description:TODO �õ�ջ�Ĵ�С
	 * @return:int
	 * @author:Jiangxb
	 * @date: 2019��3��13�� ����10:18:13
	 */
	int getSize();
	/**
	 * @Title:isEmpty
	 * @Description:TODO �ж�ջ�Ƿ�Ϊ��
	 * @return:boolean
	 * @author:Jiangxb
	 * @date: 2019��3��13�� ����10:18:27
	 */
	boolean isEmpty();
	/**
	 * @Title:push
	 * @Description:TODO ��ջ
	 * @return:void
	 * @author:Jiangxb
	 * @date: 2019��3��13�� ����10:18:38
	 */
	void push(E e);
	/**
	 * @Title:pop
	 * @Description:TODO ��ջ
	 * @return:E
	 * @author:Jiangxb
	 * @date: 2019��3��13�� ����10:18:56
	 */
	E pop();
	
	/**
	 * @Title:peek
	 * @Description:TODO �鿴ջ����Ԫ��
	 * @return:E
	 * @author:Jiangxb
	 * @date: 2019��3��13�� ����10:19:34
	 */
	E peek();
}
