package algorithm.study.maxheap;
/**
 * ���ڡ���̬���顿ʵ�� ����
 * @Package:algorithm.study.maxheap
 * @ClassName:MaxHeap
 * @Description:TODO 
 * @author:Jiangxb
 * @date:2019��3��27�� ����4:08:12
 * 
 * @param <E>
 */
public class MaxHeap<E extends Comparable<E>>  {
	private Array<E> data;
	
	public MaxHeap(int capacity){
		data = new Array<>(capacity);
	}
	
	public MaxHeap(){
		data = new Array<>();
	}
	
	public MaxHeap(E[] arr){
		data = new Array<>(arr);
		// �õ����һ����Ҷ�ӽڵ������
		int index = parent(arr.length - 1);
		// �����һ����Ҷ�ӽڵ���ǰ����
		for (int i = index; i >= 0; i--) {
			siftDown(i);	// �³�����
		}
	}
	
	/**
	 * @Title:size
	 * @Description:TODO ���ض��е�Ԫ�ظ���
	 * @return:int
	 * @author:Jiangxb
	 * @date: 2019��3��27�� ����4:41:57
	 */
	public int size(){
		return data.getSize();
	}
	
	/**
	 * @Title:isEmpty
	 * @Description:TODO ����һ������ֵ����ʾ���Ƿ�Ϊ��
	 * @return:boolean
	 * @author:Jiangxb
	 * @date: 2019��3��27�� ����4:42:35
	 */
	public boolean isEmpty(){
		return data.isEmpty();
	}
	
	/**
	 * @Title:parent
	 * @Description:TODO ������ȫ�������������ʾ�У�һ������index����ʾ��Ԫ�صĸ��׽ڵ�������ǣ�
	 * @return:int
	 * @author:Jiangxb
	 * @date: 2019��3��27�� ����4:43:30
	 */
	private int parent(int index){
		if(index == 0){
			throw new IllegalArgumentException("index-0 doesn`t have parent");
		}
		return (index - 1) / 2;
	}
	
	/**
	 * @Title:leftChild
	 * @Description:TODO ������ȫ�������������ʾ�У�һ������index����ʾ��Ԫ�ص����ӽڵ�������ǣ�
	 * @return:int
	 * @author:Jiangxb
	 * @date: 2019��3��27�� ����4:50:59
	 */
	private int leftChild(int index){
		return index * 2 + 1;
	}
	
	/**
	 * @Title:rightChild
	 * @Description:TODO ������ȫ�������������ʾ�У�һ������index����ʾ��Ԫ�ص��Һ��ӽڵ�������ǣ�
	 * @return:int
	 * @author:Jiangxb
	 * @date: 2019��3��27�� ����4:51:26
	 */
	private int rightChild(int index){
		return index * 2 + 2;
	}
	
	/**
	 * @Title:add
	 * @Description:TODO ��������Ԫ��
	 * @return:void
	 * @author:Jiangxb
	 * @date: 2019��3��27�� ����4:57:26
	 */
	public void add(E e){
		// ������ĺ������Ԫ��
		data.addLast(e);
		
		// ά���ѵ�����
		siftUp(data.getSize()-1);
	}

	/**
	 * @Title:siftUp
	 * @Description:TODO ���ݲ����Ԫ�����ڵ�������ȥ����ѵ�����
	 * @return:void
	 * @author:Jiangxb
	 * @date: 2019��3��27�� ����4:58:36
	 * �ϸ������ڵ� >= ���ӽڵ�
	 */
	private void siftUp(int k) {
		// TODO Auto-generated method stub
		/**
		 * ˵���������������0��k > 0
		 * 
		 * data.get(parent(k)).compareTo(data.get(k))<0
		 * ��������Ӧ�ĸ��ڵ��ֵ С�� ��������ֵ�����ϸ�
		 */
		while(k > 0 && data.get(parent(k)).compareTo(data.get(k))<0){
			// k���ڵ�Ԫ�� �� k�ĸ��ڵ�Ԫ�� ����λ�ý���
			data.swap(k, parent(k));
			k = parent(k);
		}
	}
	
	/**
	 * @Title:findMax
	 * @Description:TODO �õ����е����Ԫ��
	 * @return:E
	 * @author:Jiangxb
	 * @date: 2019��3��27�� ����5:16:18
	 */
	public E findMax(){
		if(data.getSize() == 0){
			throw new IllegalArgumentException("Can not findMax when heap is empty");
		}
		return data.get(0);
	}
	
	/**
	 * @Title:extractMax
	 * @Description:TODO ȡ�����е����Ԫ��
	 * @return:E
	 * @author:Jiangxb
	 * @date: 2019��3��27�� ����5:15:50
	 */
	public E extractMax(){
		E ret = findMax();
		/**
		 * ɾ������
		 */
		data.swap(0, data.getSize()-1);	// ����һ��Ԫ�� �� ���һ��Ԫ�� ����λ�ã���һ��Ԫ�ر�������һ��Ԫ��
		data.removeLast();	// ɾ��ĩβ��Ԫ�أ�����Ԫ���Ѿ�ɾ���ˡ�
		siftDown(0);		// �����³�����(�����ڵĵ�һ��Ԫ��ȥ���ж����ʵ����㣬�³�)
		return ret;
	}
	
	/**
	 * @Title:siftDown
	 * @Description:TODO ����������ȥ����ѵ�����
	 * @return:void
	 * @author:Jiangxb
	 * @date: 2019��3��27�� ����5:20:49
	 * �³������ڵ� >= ���ӽڵ�
	 * ע�⣺�����³�������ʱ���ƶ���Ԫ�� �� ���һ��Ԫ�ؼ����˻���λ�ã��ٽ����һ��Ԫ��ɾ����
	 * 	����ԭ���һ��Ԫ�ؾ���Ϊ���µĶѶ������Ҫά���ѵ����ʡ�
	 */
	private void siftDown(int k){
		// k����λ�õ����� С�� �����Ԫ�ظ���(Խ��)����ʾû�к�����
		while(leftChild(k) < data.getSize()){
			// �õ����ӵ�����ֵ����Ϊ�ܽ���ѭ���壬��ʾ���ӱش��ڣ���˲���ҪУ�飩
			int j = leftChild(k);
			/**
			 * j+1 < data.getSize()		// �Һ�������������ֵ С�� �����Ԫ�ظ���(˵�������Һ��ӣ������±�Խ���˳��ж�)
			 * 
			 * data.get(j+1).compareTo(data.get(j)) >0
			 * 	// �Һ��ӵ�Ԫ��ֵ ���� ���ӵ�Ԫ��ֵ����j��ֵΪ�Һ��ӵ�����ֵ
			 */
			if(j+1 < data.getSize() && data.get(j+1).compareTo(data.get(j)) >0){
				j = rightChild(k);	// jΪ�Һ��ӵ�����ֵ
				// data[j] ��leftChild �� rightChile �е����ֵ
			}
			
			// �����ڵ��ֵ �����ҽڵ�������ֵ ����˵��û��Υ���ѵ�����(���ڵ� >= ���ӽڵ�)��ֱ���˳����������ִ��
			if(data.get(k).compareTo(data.get(j)) >= 0){
				break; 
			}
			
			data.swap(k, j);	// ���н���
			// ����ѭ��
			k = j;
		}
	}
	
	/**
	 * @Title:replace
	 * @Description:TODO ȡ������Ԫ�أ������滻��Ԫ��e
	 * @return:E
	 * @author:Jiangxb
	 * @date: 2019��3��29�� ����10:51:28
	 */
	public E replace(E e){
		E ret = findMax();
		data.set(0, e);		// ����Ԫ����Ϊ�Ѷ�Ԫ��
		siftDown(0);		// �µĶѶ�Ԫ�� Ҳ�� Υ���Ķѵ����ʣ���˽����³�����
		return ret;
	}
	
	
}
