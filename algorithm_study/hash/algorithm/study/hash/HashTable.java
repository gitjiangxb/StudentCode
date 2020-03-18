package algorithm.study.hash;

import java.util.TreeMap;

/**
 * ���ڡ�TreeMap,�������ʵ�ֹ�ϣ��
 * @Package:algorithm.study.hash
 * @ClassName:HashTable
 * @Description:TODO 
 * @author:Jiangxb
 * @date:2019��4��16�� ����5:23:39
 *
 */
public class HashTable<K,V> {
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
	private static final int initCapacity = 7;	//	Ĭ�ϵĳ�ʼ����
	
	@SuppressWarnings("unchecked")
	public HashTable(int M){
		this.M = M;
		size = 0;
		hashtable = new TreeMap[M];
		for (int i = 0; i < M; i++) {
			// ��ʼ�������ÿ������λ�ö���һ��TreeMap����
			hashtable[i] = new TreeMap<>();
		}
	}
	
	public HashTable(){
		this(initCapacity);	// Ĭ�ϵĴ�С
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
			 */
			if(size >= upperTol * M){
				resize( 2 * M);	// ����
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
			 * 		M / 2 >= initCapacity
			 */
			if(size < lowerTol * M && M / 2 >= initCapacity){
				resize(M / 2);	// ����
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
