package algorithm.study.unionfind;
/**
 * ���ڡ����顿���ڶ���Union-Find
 * @Package:algorithm.study.unionfind
 * @ClassName:UnionFind2
 * @Description:TODO 
 * @author:Jiangxb
 * @date:2019��4��3�� ����2:41:46
 *
 */
public class UnionFind2 implements UnionFind {
	// parent i,��ʾ��i��Ԫ����ָ���һ���ڵ�
	private int[] parent;
	
	public UnionFind2(int size){
		parent = new int[size];
		
		for (int i = 0; i < parent.length; i++) {
			// �ڳ�ʼ��ʱ��ÿ���ڵ㶼ָ���Լ���Ҳ����ÿ���ڵ��Ƕ�������
			parent[i] = i;
		}
	}

	/**
	 * �鿴Ԫ��p��Ԫ��q�Ƿ�����һ������;O(h)
	 */
	@Override
	public boolean isConnected(int p, int q) {
		// TODO Auto-generated method stub
		return find(p) == find(q);
	}

	/**
	 * �ϲ�����:�ϲ�Ԫ��p��Ԫ��q�����ļ��ϣ�O(h)
	 */
	@Override
	public void unionElements(int p, int q) {
		// TODO Auto-generated method stub
		int pRoot = find(p);
		int qRoot = find(q);
		
		// ���p�ĸ��ڵ� == q�ĸ��ڵ㣬��ʾ�Ѿ���ͬһ�������ˣ�ֱ�ӷ��ؼ���
		if(pRoot == qRoot){
			return;
		}
		// ����q�ĸ��ڵ� ָ��p�ĸ��ڵ�
		parent[pRoot] = qRoot;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return parent.length;
	}
	
	/**
	 * @Title:find
	 * @Description:TODO ���ҹ��̣�����Ԫ��p����Ӧ�ļ��ϱ��
	 * @return:int
	 * @author:Jiangxb
	 * @date: 2019��4��3�� ����2:45:41
	 * O(h)���Ӷȣ�hΪ���ĸ߶�
	 */
	private int find(int p){
		if(p < 0 && p >= parent.length){
			throw new IllegalArgumentException("p is not of bound.");
		}
		// ���Ҹ��ڵ�λ��
		while(p != parent[p]){
			p = parent[p];
		}
		return p;
	}
}
