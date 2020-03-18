package algorithm.study.segmenttree;


/**
 * ���ڡ����顿ʵ���߶���
 * @Package:algorithm.study.segmenttree
 * @ClassName:SegmentTree
 * @Description:TODO 
 * @author:Jiangxb
 * @date:2019��3��30�� ����2:18:49
 * 
 * @param <E>
 */
public class SegmentTree<E> {
	// ����߶���(����һ����������)
	private E[] tree;
	private E[] data;
	private Merger<E> merger;	// �ں���(ͨ�����캯�������û��Զ�����߼�������͡����ֵ)
	
	/**
	 * ���캯��
	 * @Title:SegmentTree
	 * @param arr
	 * @param merger
	 * 	E[] arr������Ԫ��
	 * 	Merger<E> merger����ʾ����Ԫ����ô�ں�
	 */
	public SegmentTree(E[] arr,Merger<E> merger){
		this.merger = merger;
		
		data = (E[]) new Object[arr.length];
		for (int i = 0; i < arr.length; i++) {
			data[i] = arr[i];
		}
		/**
		 * ˵�����߶�����������������ʵ�ֵĻ�����Ҫ���� 4 * n�Ŀռ����洢
		 */
		tree = (E[]) new Object[4 * arr.length];
		
		buildSegmentTree(0,0,data.length-1);
	}
	
	/**
	 * @Title:buildSegmentTree
	 * @Description:TODO ��treeIndex��λ�ô�����ʾ����[l,r]���߶���
	 * @return:void
	 * @author:Jiangxb
	 * @date: 2019��3��30�� ����2:36:52
	 */
	private void buildSegmentTree(int treeIndex,int l,int r){
		/**
		 * ��һ�����ݹ���ֹ����
		 */
		if(l == r){
			tree[treeIndex] = data[l];
			return;
		}
		
		/**
		 * �ڶ������ݹ�ϸ��
		 */
		int leftTreeIndex = leftChild(treeIndex);
		int rightTreeIndex = rightChild(treeIndex);
		
		/**
		 * �����м��ֵ��mid
		 * �ֳ�����������ǣ�[l,mid] ��  [mid+1,r]
		 * 	
		 */
		int mid = l + (r -l) / 2; 
		buildSegmentTree(leftTreeIndex, l, mid);
		buildSegmentTree(rightTreeIndex, mid+1, r);
		
		/**
		 * ����߼���ҵ����أ�
		 * ��������ͣ�
		 * 	tree[treeIndex] = tree[leftTreeIndex] + tree[rightTreeIndex];
		 * ��������������ֵ��
		 * 	tree[treeIndex] = Max(tree[leftTreeIndex] + tree[rightTreeIndex]);
		 * ������̾����ۺ����������߶ε���Ϣ���õ���ǰ���������߶ε���Ϣ��
		 * ��ô�ۺ������ҵ���߼��������ġ����ǲ���д������߼���
		 * ����ϣ���û����Ը����Լ���ҵ�񳡾������Ǿ���Ҫ����һ���ӿڣ�Merger,���û��Լ�ȥʵ��
		 */
		tree[treeIndex] = merger.meger(tree[leftTreeIndex],tree[rightTreeIndex]);
	}
	
	/**
	 * @Title:getSize
	 * @Description:TODO �õ�ʵ��Ԫ�ظ���
	 * @return:int
	 * @author:Jiangxb
	 * @date: 2019��3��30�� ����2:22:33
	 */
	public int getSize(){
		return data.length;
	}
	
	/**
	 * @Title:get
	 * @Description:TODO ����index�õ�ֵ
	 * @return:E
	 * @author:Jiangxb
	 * @date: 2019��3��30�� ����2:22:46
	 */
	public E get(int index){
		if(index < 0 || index >= data.length){
			throw new IllegalArgumentException("Index is illegal");
		}
		return data[index];
	}
	
	/**
	 * @Title:leftChild
	 * @Description:TODO ������ȫ�������������ʾ�У�һ����������ʾ��Ԫ�ص����ӽڵ������
	 * @return:int
	 * @author:Jiangxb
	 * @date: 2019��3��30�� ����2:25:30
	 */
	private int leftChild(int index){
		return 2 * index + 1;
	}
	
	/**
	 * @Title:rightChild
	 * @Description:TODO ������ȫ�������������ʾ�У�һ����������ʾ��Ԫ�ص��Һ��ӽڵ������
	 * @return:int
	 * @author:Jiangxb
	 * @date: 2019��3��30�� ����2:25:43
	 */
	private int rightChild(int index){
		return 2 * index + 2;
	}
	
	/**
	 * @Title:query
	 * @Description:TODO ��������[queryL,queryR]��ֵ
	 * @return:E
	 * @author:Jiangxb
	 * @date: 2019��3��30�� ����3:57:11
	 */
	public E query(int queryL,int queryR){
		if(queryL < 0 || queryL >= data.length ||
				queryR < 0 || queryR >= data.length || queryL > queryR){
			throw new IllegalArgumentException("Index is illegal");
		}
		
		return query(0,0,data.length-1,queryL,queryR);
	}
	
	/**
	 * @Title:query
	 * @Description:TODO ����treeIndexΪ�����߶�����[l,r]�ķ�Χ���������[queryL,queryR]��ֵ
	 * @return:E
	 * @author:Jiangxb
	 * @date: 2019��3��30�� ����4:03:43
	 */
	private E query(int treeIndex,int l,int r,int queryL,int queryR){
		/**
		 * ��һ�����ݹ���ֹ����
		 */
		if(l ==queryL && r ==queryR){
			return tree[treeIndex];
		}
		
		/**
		 * �ڶ������ݹ�ϸ��
		 */
		int mid = l + (r -l) / 2;	// ������м�ֵ,�ֳ�����������ǣ�[l,mid] ��  [mid+1,r]
		int leftTreeIndex = leftChild(treeIndex);
		int rightTreeIndex = rightChild(treeIndex);
		
		if(queryL >= mid +1){
			// ��� Ҫ��ѯ�������� >= �м�ֵ+1 ��˵��ֱ��ȥ�������Ǳ���
			return query(rightTreeIndex,mid+1,r,queryL,queryR);
		}else if(queryR <= mid){
			// ��� Ҫ��ѯ�������� <= �м�ֵ��˵��ֱ��ȥ�������Ǳ���
			return query(leftTreeIndex,l,mid,queryL,queryR);
		}else{
			// һ�������� һ�����Һ���
			E leftResult = query(leftTreeIndex,l,mid,queryL,mid);
			E rightResult = query(rightTreeIndex,mid+1,r,mid+1,queryR);
			return merger.meger(leftResult, rightResult);
		}
		
	}
	
	/**
	 * @Title:set
	 * @Description:TODO ��indexλ�õ�ֵ ����Ϊe
	 * @return:void
	 * @author:Jiangxb
	 * @date: 2019��3��31�� ����2:05:15
	 */
	public void set(int index,E e){
		// �����Ϸ��Ե�У��
		if(index < 0 || index >= data.length){
			throw new IllegalArgumentException("Index is illegal");
		}
		data[index] = e;
		set(0,0,data.length-1,index,e);
	}
	
	/**
	 * @Title:set
	 * @Description:TODO ����treeIndexΪ�����߶����и���index��ֵΪe
	 * @return:void
	 * @author:Jiangxb
	 * @date: 2019��3��31�� ����2:07:18
	 * O(logn)
	 */
	private void set(int treeIndex,int l,int r,int index,E e){
		/**
		 * ��һ�����ݹ���ֹ
		 */
		if(l == r){
			tree[treeIndex] = e;
			return;
		}
		
		/**
		 * �ڶ������ݹ�ϸ��
		 * 	˵����������ʵ����ȥ��index���λ�ö��ڵ�Ҷ��������
		 */
		int mid = l + (r -l) / 2;	// ������м�ֵ,�ֳ�����������ǣ�[l,mid] ��  [mid+1,r]
		int leftTreeIndex = leftChild(treeIndex);
		int rightTreeIndex = rightChild(treeIndex);
		
		// ȥ����������
		if(index >= mid +1){
			set(rightTreeIndex,mid + 1,r,index,e);
		}else{ // index <= mid	//ȥ����������
			set(leftTreeIndex,l,mid,index,e);
		}
		
		/**
		 * ����Ĳ���ֻ���޸���tree[treeIndex] = e��ֵ��
		 * ��.����Ҫ�޸����汲�ڵ��ֵ
		 */
		tree[treeIndex] = merger.meger(tree[leftTreeIndex], tree[rightTreeIndex]);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder res = new StringBuilder();
		res.append("[");
		for (int i = 0; i < tree.length; i++) {
			if(tree[i] != null){
				res.append(tree[i]);
			}else{
				res.append("null");
			}
			if(i != tree.length-1){
				res.append(", ");
			}
		}
		res.append("]");
		return res.toString();
	}
}
