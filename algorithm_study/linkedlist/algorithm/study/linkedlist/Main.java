package algorithm.study.linkedlist;

/**
 * �����Զ�������
 * @Package:algorithm.study.linkedlist
 * @ClassName:Main
 * @Description:TODO 
 * @author:Jiangxb
 * @date:2019��3��14�� ����3:50:42
 *
 */
public class Main {
	public static void main(String[] args) {
		LinkedList<Integer> linkedList = new LinkedList<>();
		for (int i = 0; i < 5; i++) {
			linkedList.addFirst(i);
			System.out.println(linkedList);
		}
		
		linkedList.add(2, 666);
		System.out.println(linkedList);
		
		linkedList.remove(2);
		System.out.println(linkedList);
		
		linkedList.removeFrist();
		System.out.println(linkedList);
		
		linkedList.removeLast();
		System.out.println(linkedList);
	}
}
