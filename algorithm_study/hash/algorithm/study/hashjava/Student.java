package algorithm.study.hashjava;
/**
 * �������� ��дhashCode()
 * @Package:algorithm.study.hash
 * @ClassName:Student
 * @Description:TODO 
 * @author:Jiangxb
 * @date:2019��4��16�� ����3:29:01
 *	�뽫����� ��Ϊ hash���еļ����д洢�Ļ�����Ҫ�������ת��Ϊhash����
 */
public class Student {
	int grade;	// �꼶
	int cls;	// �༶
	String firstName;
	String lastName;
	
	Student(int grade, int cls, String firstName, String lastName){
        this.grade = grade;
        this.cls = cls;
        this.firstName = firstName;
        this.lastName = lastName;
    }
	
	/**
	 * �����ﲻȥ���ǵ�ʱ�򣬻����Object���hashCode()����
	 * 	Object���hashCode()���Ǹ���ÿһ������ĵ�ַӳ���һ�����͡�
	 */
	@Override
	public int hashCode() {
		// hash(date) = (((Date.year % M) * B + Date.month) % M * B + Date.day) % M
		
		int B = 31;
		int hash = 0;
		
		hash = hash * B + ((Integer)grade).hashCode();		// Ϊ�˷�ֹ
		hash = hash * B + ((Integer)cls).hashCode();
		hash = hash * B + firstName.toLowerCase().hashCode();	// �����ִ�Сд��BOBO / bobo ͬһ����
		hash = hash * B + lastName.toLowerCase().hashCode();
		
		return hash;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj)	// ͬһ������
            return true;

        if(obj == null)
            return false;

        if(getClass() != obj.getClass())
            return false;

        // ������Ƚ���ĸ�������ֵ�Ƿ���ͬ
        Student another = (Student)obj;
        return this.grade == another.grade &&
                this.cls == another.cls &&
                this.firstName.toLowerCase().equals(another.firstName.toLowerCase()) &&
                this.lastName.toLowerCase().equals(another.lastName.toLowerCase());
	}
	
}
