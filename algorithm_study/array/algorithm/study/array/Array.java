package algorithm.study.array;
/**
 * 制作属于自己的数组类(静态数组)
 * @Package:algorithm.study.array
 * @ClassName:Array
 * @Description:TODO 
 * @author:Jiangxb
 * @date:2019年3月12日 上午9:37:15
 *  利用泛型：Array<E>
 */
public class Array<E> {
	/**
	 * 数组变量；capacity(容量)=data数组的长度
	 */
	private E[] data;
	/**
	 * 描述data数组中有效的元素个数
	 */
	private int size;
	
	/**
	 * 构造函数，传入数组的容量capacity构造Array
	 * @Title:Array
	 * @param capacity 
	 */
	public Array(int capacity){
//		data = new E[capacity];	// java 不支持直接利用泛型声明数组，应该采用下面的方法进行“绕一下”
		data = (E[]) new Object[capacity];
		size = 0;	// 初始元素个数为0
	}
	
	/**
	 * 无参构造函数，默认数组的容量capacity=10
	 * @Title:Array
	 */
	public Array(){
		this(10);
	}
	
	/**
	 * @Title:getSize
	 * @Description:TODO 获取数组中的元素个数
	 * @return:int
	 * @author:Jiangxb
	 * @date: 2019年3月12日 上午9:51:48
	 */
	public int getSize(){
		return size;
	}
	
	/**
	 * @Title:getCapacity
	 * @Description:TODO 获取数组的容量
	 * @return:int
	 * @author:Jiangxb
	 * @date: 2019年3月12日 上午9:53:11
	 */
	public int getCapacity(){
		return data.length;
	}
	
	/**
	 * @Title:isEmpty
	 * @Description:TODO 返回数组是否为空
	 * @return:boolean
	 * @author:Jiangxb
	 * @date: 2019年3月12日 上午9:55:25
	 */
	public boolean isEmpty(){
		return size == 0;
	}
	
	/**
	 * @Title:addList
	 * @Description:TODO 向所有元素之后添加元素
	 * @return:void
	 * @author:Jiangxb
	 * @date: 2019年3月12日 上午9:58:27
	 */
	public void addLast(E e){
		/*
		// 添加前需要判断容量是否够
		if(size == data.length){
			// 当实际大小 = 数组容量，抛出异常
			throw new IllegalArgumentException("AddLast failed,Array is full");
		}
		// data[size++] = e; 写法一致
		data[size] = e;
		size ++;
		*/
		// 可简化为👇
		add(size,e);
	}
	
	/**
	 * @Title:addFirst
	 * @Description:TODO 在所有元素前添加一个新元素
	 * @return:void
	 * @author:Jiangxb
	 * @date: 2019年3月12日 上午10:21:32
	 */
	public void addFirst(E e){
		add(0,e);
	}
	
	/**
	 * @Title:add
	 * @Description:TODO 在第index个位置插入一个新元素e
	 * @return:void
	 * @author:Jiangxb
	 * @date: 2019年3月12日 上午10:06:05
	 */
	public void add(int index,E e){
		// 判断容量是否够
		if(size == data.length){
			// 当实际大小 = 数组容量，抛出异常(add 失败，Array是满的)
			throw new IllegalArgumentException("Add failed,Array is full");
		}
		
		// 索引必须>=0，<=size(数组实际的大小)
		if(index < 0 || index > size){
			throw new IllegalArgumentException("Add failed,Require index >= 0 and index <= size");
		}
		
		// 将数组元素（从index）依次往后挪一个位置
		for(int i = size -1 ; i >= index ; i--){
			data[i+1] = data[i];
		}
		
		// 说明：这里不代表index位置上面没有元素，因为它已经存在于index+1的位置上，所以可直接替换。
		data[index] = e;
		// 维护size，有效个数+1
		size ++;
	}
	
	/**
	 * @Title:get
	 * @Description:TODO 获取index索引位置的元素
	 * @return:int
	 * @author:Jiangxb
	 * @date: 2019年3月12日 上午10:58:43
	 */
	public E get(int index){
		// 判断索引是否合法
		if(index < 0 || index >= size){
			throw new IllegalArgumentException("Get failed,Index is illegal");
		}
		return data[index];
	}
	
	/**
	 * @Title:set
	 * @Description:TODO 修改index索引位置的元素为e
	 * @return:void
	 * @author:Jiangxb
	 * @date: 2019年3月12日 上午11:00:58
	 */
	public void set(int index,E e){
		// 判断索引是否合法
		if(index < 0 || index >= size){
			throw new IllegalArgumentException("Set failed,Index is illegal");
		}
		data[index] = e;
	}
	
	/**
	 * @Title:contains
	 * @Description:TODO 检查数组中是否包含元素e
	 * @return:boolean
	 * @author:Jiangxb
	 * @date: 2019年3月12日 上午11:21:36
	 */
	public boolean contains(E e){
		for(int i = 0 ; i<size ; i++){
//			 if(data[i] == e){
			// 都是类对象了，值的比较使用equals
			 if(data[i].equals(e)){
				 return true;
			 }
		}
		return false;
	}
	
	/**
	 * @Title:find
	 * @Description:TODO 查找数组中元素e所在的索引位置；若不存在则返回-1
	 * @return:int
	 * @author:Jiangxb
	 * @date: 2019年3月12日 上午11:23:29
	 */
	public int find(E e){
		for(int i = 0 ; i<size ; i++){
			 if(data[i].equals(e)){
				 return i;
			 }
		}
		return -1;
	}
	
	/**
	 * @Title:remove
	 * @Description:TODO 从数组中删除index位置的元素，并返回删除的元素
	 * @return:int
	 * @author:Jiangxb
	 * @date: 2019年3月12日 上午11:34:32
	 */
	public E remove(int index){
		// 索引必须>=0，<size(数组实际的大小)
		if(index < 0 || index >= size){
			throw new IllegalArgumentException("Remove failed,Index is illegal");
		}
		
		// 删除的元素
		E ret = data[index];
		
		// 将数组元素（从index）依次往前挪一个位置 
		for(int i=index + 1 ; i < size ;i++){
			data[i-1] = data[i];		
		}
		// 维护size，有效个数减1
		size --;
		// 往前挪位置时，最后一个位置还是有引用(类对象)的存在，因此赋值为null，触发GC
		data[size] = null; // loitering objects != memory leak
		
		return ret;
	}
	
	/**
	 * @Title:removeFirst
	 * @Description:TODO 从数组中删除第一个元素，并返回删除的元素
	 * @return:int
	 * @author:Jiangxb
	 * @date: 2019年3月12日 上午11:38:53
	 */
	public E removeFirst(){
		return remove(0);
	}
	
	/**
	 * @Title:removeLast
	 * @Description:TODO 从数组中删除最后一个元素，并返回删除的元素
	 * @return:int
	 * @author:Jiangxb
	 * @date: 2019年3月12日 上午11:39:54
	 */
	public E removeLast(){
		return remove(size - 1);
	}
	
	/**
	 * @Title:removeElement
	 * @Description:TODO 从数组中删除元素e(只能删除第一个元素，因为当前数组允许重复元素)
	 * @return:void
	 * @author:Jiangxb
	 * @date: 2019年3月12日 下午1:48:06
	 */
	public void removeElement(E e){
		int index = find(e);
		if(index != -1){
			remove(index);
		}
	}
	
	/**
	 * @Title:removeAllElement
	 * @Description:TODO 从数组中删除所有的元素e(因为当前数组允许重复元素)
	 * @return:void
	 * @author:Jiangxb
	 * @date: 2019年3月12日 下午1:53:34
	 */
	public void removeAllElement(E e){
		boolean isTrue = true;
		while(isTrue){
			int index = find(e);
			if(index != -1){
				remove(index);
			}else{
				isTrue = false;
			}
		}
	}
	
	/**
	 * 复写父类(Object)的方法
	 */
	@Override
	public String toString(){
		StringBuilder res = new StringBuilder();
		res.append(String.format("Array:size = %d,capatity=%d\n", size,data.length));
		res.append('[');
		// 循环遍历
		for(int i = 0; i < size ;i++){
			res.append(data[i]);
			// 判断i是否是最后一个元素
			if(i != size-1){
				res.append(", ");
			}
		}
		res.append(']');
		return res.toString();
	}
	
}
