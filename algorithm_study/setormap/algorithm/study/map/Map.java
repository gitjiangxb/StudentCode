package algorithm.study.map;
/**
 * �Զ���ӳ��ӿ� Map
 * @Package:algorithm.study.map
 * @ClassName:Map
 * @Description:TODO 
 * @author:Jiangxb
 * @date:2019��3��25�� ����4:55:12
 *
 */
public interface Map<K,V> {
	
	void add(K key,V value);
	V remove(K key);
	boolean contains(K key);
	V get(K key);
	void set(K key,V newValue);
	int getSize();
	boolean isEmpty();
	
}
