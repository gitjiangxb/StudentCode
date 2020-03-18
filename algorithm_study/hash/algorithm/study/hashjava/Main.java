package algorithm.study.hashjava;

import java.util.HashMap;
import java.util.HashSet;

/**
 * ���� hashCodeֵ
 * @Package:algorithm.study.hash
 * @ClassName:Main
 * @Description:TODO 
 * @author:Jiangxb
 * @date:2019��4��16�� ����3:29:41
 *
 */
public class Main {
	public static void main(String[] args){
		/**
		 * ���һ��
		 * 	С��Χ������ֱ��ʹ��
		 */
		int a = 42;
		System.out.println(((Integer) a).hashCode());
		
		/**
		 * �������
		 * 	
		 */
		int b = -42;
		System.out.println(((Integer) b).hashCode());
		
		/**
		 * �������
		 * 	�����ͣ�Double���ڲ��߼�����ת��Ϊ������
		 */
		double c = 3.1415926;
        System.out.println(((Double)c).hashCode());
        
        /**
         * ����ģ�
         * 	�ַ�����String���ڲ��߼�����ת��Ϊ������
         */
        String d = "imooc";
        System.out.println(d.hashCode());
        
        /**
         * ����壺
         * 	�������ͣ��Զ�������
         */
        Student student = new Student(3, 2, "bobo", "Liu");
        System.out.println(student.hashCode());
        /**
         * ���ԣ�
         * 	��ע�͵�Student������д��hashCode()���������лᷢ��student��student2��hashCodeֵ��һ����
         * 		������Ϊ��Ĭ�ϵ���Object���hashCode()����Object���hashCode()�Ǹ���ÿһ������ĵ�ַӳ���һ�����͡�
         * 	
         * �ٷſ�Student������д��hashCode()���������лᷢ��student��student2��hashCodeֵ��һ���ġ�
         * ��ʱ������hash��ͻ������ͬ��������Ҫ�Ƚ�������ͬ�Ķ�������֮���Ƿ�����ȵģ����Ƕ�Ӧ��hash������ֵ����Ȼ��ȣ���ʱ�����˳�ͻ��
         * 	Ϊ�˱��������Ĳ�ͬ��������Ҫ�ж����������Ƿ���ȡ�
         * 	�ص㣺����Զ�����Ҫ��Ϊhash��ļ��Ļ�������ֻ����һ��hashCode()�ǲ����ģ����ǻ���Ҫ����equals(Object obj)���ж����������Ƿ���ȡ�
         */
        Student student2 = new Student(3, 2, "bobo", "Liu");
        System.out.println(student2.hashCode());
        
        /**
         * ����java�ṩ�ĺ�hash����ص����ݽṹ��HashSet / HashMap
         * 	����studentʱ���ھ���Ĵ洢�ϻ��Զ�����Student.hashCode(),Ȼ������һ������ֵ����ŵ���Ӧ��λ���С�
         */
        HashSet<Student> set = new HashSet<>();
        set.add(student);

        HashMap<Student, Integer> scores = new HashMap<>();
        scores.put(student, 100);
        
	}
}
