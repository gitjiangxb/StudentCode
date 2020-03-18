package algorithm.study.unionfind;

/**
 * ���ڡ����顿�������Union-Find
 * @Package:algorithm.study.unionfind
 * @ClassName:UnionFind5
 * @Description:TODO 
 * @author:Jiangxb
 * @date:2019��4��6�� ����3:03:15
 *	·��ѹ�������Ż�
 */
public class UnionFind5 implements UnionFind {
	// parent i,��ʾ��i��Ԫ����ָ���һ���ڵ�
	private int[] parent;
	// rank[i] ��ʾ���ڵ�Ϊi�����ĸ߶�
	private int[] rank;
	
	
	public UnionFind5(int size){
		parent = new int[size];
		rank = new int[size];
		
		for (int i = 0; i < parent.length; i++) {
			// �ڳ�ʼ��ʱ��ÿ���ڵ㶼ָ���Լ���Ҳ����ÿ���ڵ��Ƕ�������
			parent[i] = i;
			// ��ʼ����ʱ��ÿ��Ԫ�ض���һ�����ϣ���ʼԪ�صĲ���/�߶�Ϊ1
			rank[i] = 1;	
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
		 * 	��������Ԫ����������rank��ͬ �ж� �ϲ�����
		 * 		��rank�͵ļ��� �ϲ��� rank�ߵļ����ϡ�
		 */
		if(rank[pRoot] < rank[qRoot]){
			parent[pRoot] = qRoot;	// pRoot����ڵ� ָ�� qRoot����ڵ�
		}else if(rank[pRoot] > rank[qRoot]){	
			parent[qRoot] = pRoot;
		}else{// rank[pRoot] = rank[qRoot]
			parent[pRoot] = qRoot;
			rank[qRoot] +=1;
			// �������ֶ�����
//			parent[qRoot] = pRoot;
//			rank[pRoot] +=1;
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
			/**
			 * ·��ѹ���Ż�
			 * 	��p����ڵ�ĸ��� ָ��p����ڵ�ĸ��׵ĸ���
			 */
			parent[p] = parent[parent[p]];
			p = parent[p];
		}
		return p;
	}
}
