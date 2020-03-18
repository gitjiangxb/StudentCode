package algorithm.study.hashmore;

import java.util.TreeMap;

/**
 * ���ڡ�TreeMap,�������ʵ�ֹ�ϣ��
 * @Package:algorithm.study.hashmore
 * @ClassName:HashTable
 * @Description:TODO 
 * @author:Jiangxb
 * @date:2019��4��17�� ����3:13:44
 * �����ӵĶ�̬�ռ䴦����
 * @param <K>
 * @param <V>
 */
public class HashTable<K,V> {
	
	/**
	 * �ο�http://planetmath.org/goodhashtableprimes �ṩ������������
	 * 	δд����������
	 */
	private final int[] capacity = {53,97,193,389,769,1543,3079,6151,12289,24593,49157,98317,196613,393241,786433};
	
	// TreeMap����
	private TreeMap<K,V>[] hashtable;
	// hashTable����
	private int size;
	// hashTable�洢�˶��ٸ�Ԫ��(���ֵ�����ܵ�Ӱ��ǳ���)
	private int M;
	
	/**
	 * ����/���� ����
	 */
	private static final int upperTol = 10;		// ƽ��ÿ��Ԫ�س�ͻ��Ԫ�ظ��� �Ͻ�Ϊ10
	private static final int lowerTol = 2;		// ƽ��ÿ��Ԫ�س�ͻ��Ԫ�ظ��� �½�Ϊ2
	private int capacityIndex = 0;				// Ĭ�ϵĳ�ʼ����(��capacity�������������ȡ)
	
	@SuppressWarnings("unchecked")
	public HashTable(){
		this.M = capacity[capacityIndex];	// ��ʼʱΪ capacity[0] = 53
		size = 0;
		hashtable = new TreeMap[M];
		for (int i = 0; i < M; i++) {
			// ��ʼ�������ÿ������λ�ö���һ��TreeMap����
			hashtable[i] = new TreeMap<>();
		}
	}
	
	
	/**
	 * @Title:hash
	 * @Description:TODO �õ�key������ֵ
	 * @return:int
	 * @author:Jiangxb
	 * @date: 2019��4��16�� ����5:32:38
	 */
	private int hash(K key){
		// ��һ����λ�������ȥ�����λ��Ҳ���Ƿ���λ����ģ��M��Ϊ����ʹ��ϣֵ���ȷֲ�
		return (key.hashCode() & 0x7fffffff) % M;
	}
	
	/**
	 * @Title:getSize
	 * @Description:TODO �õ�hax���е�Ԫ�ظ���
	 * @return:int
	 * @author:Jiangxb
	 * @date: 2019��4��16�� ����5:33:22
	 */
	public int getSize(){
		return size;
	}
	
	/**
	 * @Title:add
	 * @Description:TODO ���Ԫ��
	 * @return:void
	 * @author:Jiangxb
	 * @date: 2019��4��17�� ����9:03:20
	 */
	public void add(K key,V value){
		// TreeMap�ݴ�hashtable��hash(key)����λ���ϵ�ֵ
		TreeMap<K, V> map = hashtable[hash(key)];
		
		if(map.containsKey(key)){
			map.put(key, value);
		}else{
			map.put(key, value);
			size ++;
			
			/**	
			 * N / M >= upperTol ==�� N >= upperTol * M
			 * capacityIndex + 1 < capacity.length
			 * 	capacity��������������н�ģ�����++���ܳ���������Ĵ�С����ֹ�±�Խ��
			 */
			if(size >= upperTol * M && capacityIndex + 1 < capacity.length){
				capacityIndex ++;
				resize(capacity[capacityIndex]);	// ����
			}
		}
	}
	
	/**
	 * @Title:remove
	 * @Description:TODO ɾ��key����λ���ϵ�ֵ
	 * @return:V
	 * @author:Jiangxb
	 * @date: 2019��4��17�� ����9:22:53
	 */
	public V remove(K key){
		// TreeMap�ݴ�hashtable��hash(key)����λ���ϵ�ֵ
		TreeMap<K, V> map = hashtable[hash(key)];
		V ret = null;
		if(map.containsKey(key)){
			ret = map.remove(key);
			size --;
			
			/**
			 * N / M < lowerTol ==�� N < lowerTol * M
			 * �����ݵ�ʱ��Ҫ����߽�ֵ:
			 * 		capacityIndex - 1 >= 0����˼����capacity������������ܱ�0С����ֹ�±�Խ��
			 */
			if(size < lowerTol * M && capacityIndex - 1 >= 0){
				capacityIndex --;
				resize(capacity[capacityIndex]);	// ����
			}
		}
		return ret;
	}
	

	/**
	 * @Title:set
	 * @Description:TODO �޸�key����λ���ϵ�ֵΪvalue
	 * @return:void
	 * @author:Jiangxb
	 * @date: 2019��4��17�� ����9:24:27
	 */
	public void set(K key,V value){
		// TreeMap�ݴ�hashtable��hash(key)����λ���ϵ�ֵ
		TreeMap<K, V> map = hashtable[hash(key)];
		
		// ��������ʱ���׳��쳣
		if(!map.containsKey(key)){
			throw new IllegalArgumentException(key + " doesn't exist!");
		}
		map.put(key, value);
	}
	
	/**
	 * @Title:contains
	 * @Description:TODO �ж��Ƿ����key���������ֵ
	 * @return:boolean
	 * @author:Jiangxb
	 * @date: 2019��4��17�� ����9:25:27
	 */
	public boolean contains(K key){
		return hashtable[hash(key)].containsKey(key);
	}
	
	/**
	 * @Title:get
	 * @Description:TODO ����key�õ�key��Ӧ��ֵ
	 * @return:V
	 * @author:Jiangxb
	 * @date: 2019��4��17�� ����9:28:12
	 */
	public V get(K key){
		return hashtable[hash(key)].get(key);
	}
	
	/**
	 * @Title:resize
	 * @Description:TODO ���� /���� ����
	 * @return:void
	 * @author:Jiangxb
	 * @date: 2019��4��17�� ����10:43:10
	 */
	private void resize(int newM) {
		// ����һ���µ�ƽ���� ����
		TreeMap<K, V>[]  newHashTable = new TreeMap[newM];
		
		for (int i = 0; i < newM; i++) {
			// ��ʼ�������ÿ������λ�ö���һ��TreeMap����
			newHashTable[i] = new TreeMap<>();
		}
		
		/**
		 * ��ԭhashtable�е����ݣ�����newHashTable��
		 */
		int oldM = M;	// ϸ��˵������������/���� ֮ǰ��M��С
		this.M = newM;	// ϸ��˵������Ϊhash()�������������ģ��M���������M��С�Ѿ��ı���(newM)
		for (int i = 0; i < oldM; i++) {
			TreeMap<K, V> map = hashtable[i]; // �õ�ԭhashtable����λ���ϵ�ֵ
			/**
			 * һ������λ���ϵ�ֵ�������ʽ��
			 * 	{anonymous=1, away=1, for=1, language=1,��������}
			 */
			for(K key : map.keySet()){
				// ȡ��������λ���е�ȫ��key����һһ��hashֵ���ٷ����µ�newHashTable��
				newHashTable[hash(key)].put(key, map.get(key));
			}
		}
		
		this.hashtable = newHashTable;
	}
}
