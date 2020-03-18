package algorithm.study.unionfind;
/**
 * ���ڡ����顿��������Union-Find
 * @Package:algorithm.study.unionfind
 * @ClassName:UnionFind3
 * @Description:TODO 
 * @author:Jiangxb
 * @date:2019��4��6�� ����2:04:26
 *	����ÿ�����Ľڵ��С���ϲ�
 */
public class UnionFind3 implements UnionFind {
	// parent i,��ʾ��i��Ԫ����ָ���һ���ڵ�
	private int[] parent;
	// sz[i] ��ʾ��iΪ���ļ�����Ԫ�ظ���
	private int[] sz;
	
	
	public UnionFind3(int size){
		parent = new int[size];
		sz = new int[size];
		
		for (int i = 0; i < parent.length; i++) {
			// �ڳ�ʼ��ʱ��ÿ���ڵ㶼ָ���Լ���Ҳ����ÿ���ڵ��Ƕ�������
			parent[i] = i;
			// ��ʼ����ʱ��ÿ��Ԫ�ض���һ�����ϣ���ʼԪ�ظ���Ϊ1
			sz[i] = 1;	
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
		/**
		 * ����q�ĸ��ڵ� ָ��p�ĸ��ڵ�
		 * 	��������Ԫ����������Ԫ�ظ�����ͬ �ж� �ϲ�����
		 * 		��Ԫ�ظ����ٵļ��� �ϲ��� Ԫ�ظ�����ļ����ϡ�
		 */
		if(sz[pRoot] < sz[qRoot]){
			parent[pRoot] = qRoot;
			sz[qRoot] += sz[pRoot];
		}else{	// sz[pRoot] >= sz[qRoot]
			parent[qRoot] = pRoot;
			sz[pRoot] += sz[qRoot];
		}
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
