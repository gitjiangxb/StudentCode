package algorithm.study.unionfind;
/**
 * ���ڡ����顿����һ��Union-Find
 * @Package:algorithm.study.unionfind
 * @ClassName:UnionFind1
 * @Description:TODO 
 * @author:Jiangxb
 * @date:2019��4��3�� ����9:55:50
	0	1	2	3	4	5	6	7	8	9
	��������������������������������������������������������������������������	
	0	1	0	1	0	1	0	1	0	1
 */
public class UnionFind1 implements UnionFind{
	// ���ÿ�������������Ǹ����ϵı��
	private int[] id;
	
	/**
	 * 
	 * @Title:UnionFind1
	 * @param size	�����û����鼯������Ҫ���Ƕ��ٸ�Ԫ��
	 */
	public UnionFind1(int size){
		id = new int[size];
		// ��ʼʱ��ÿ��Ԫ���Ƕ����ģ���δ�ϲ���
		for (int i = 0; i < id.length; i++) {
			// ÿ��Ԫ�ص�idֵ����Ϊi(��Ϊ��ÿ��Ԫ�ض�Ӧ�ļ��ϱ�Ų�һ��)
			id[i] = i;
		}
	}

	/**
	 * �鿴Ԫ��p��Ԫ��q�Ƿ�����һ������;O(1)
	 */
	@Override
	public boolean isConnected(int p, int q) {
		// TODO Auto-generated method stub
		// �жϼ��ϱ���Ƿ����
		return find(p) == find(q);
	}

	/**
	 * �ϲ�����:�ϲ�Ԫ��p��Ԫ��q�����ļ��ϣ�O(n)
	 */
	@Override
	public void unionElements(int p, int q) {
		// TODO Auto-generated method stub
		int pID = find(p);
		int qID = find(q);
		
		if(pID == qID){
			return; // �Ѿ���ͬһ��������
		}
		
		// ����ĺϲ���������һ�����ϵ�id��ֵΪ����һ�����ϵ�id
		for (int i = 0; i < id.length; i++) {
			if(id[i] == pID){
				id[i] = qID;
			}
		}
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return id.length;
	}
	
	/**
	 * @Title:find
	 * @Description:TODO ����Ԫ��p����Ӧ�ļ��ϱ��
	 * @return:int
	 * @author:Jiangxb
	 * @date: 2019��4��3�� ����10:06:34
	 * O(1)
	 */
	private int find(int p){
		if(p < 0 && p >= id.length){
			throw new IllegalArgumentException("p is not of bound.");
		}
		return id[p];
	}
}
