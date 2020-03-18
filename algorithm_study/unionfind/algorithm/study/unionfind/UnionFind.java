package algorithm.study.unionfind;
/**
 * ���鼯�ӿ�
 * @Package:algorithm.study.unionfind
 * @ClassName:UnionFind
 * @Description:TODO 
 * @author:Jiangxb
 * @date:2019��4��2�� ����4:53:31
 *
 */
public interface UnionFind {
	/**
	 * @Title:isConnected
	 * @Description:TODO ���������Ƿ�����ͬһ������(Ҳ�����Ƿ�������ӵ�)
	 * @return:boolean
	 * @author:Jiangxb
	 * @date: 2019��4��2�� ����4:54:29
	 */
	boolean isConnected(int p,int q);
	
	/**
	 * @Title:unionElements
	 * @Description:TODO ������Ԫ�� �� ��һ��
	 * @return:void
	 * @author:Jiangxb
	 * @date: 2019��4��2�� ����4:57:20
	 */
	void unionElements(int p,int q);
	
	/**
	 * @Title:getSize
	 * @Description:TODO ���ز��鼯�ĸ���
	 * @return:int
	 * @author:Jiangxb
	 * @date: 2019��4��2�� ����4:57:56
	 */
	int getSize();
}
