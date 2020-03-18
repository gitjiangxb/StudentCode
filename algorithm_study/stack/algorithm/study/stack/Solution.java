package algorithm.study.stack;

/**
 * ���leetcode������20��ŵ���Ŀ������ƥ��
 * @Package:algorithm.study.stack
 * @ClassName:Solution
 * @Description:TODO 
 * @author:Jiangxb
 * @date:2019��3��13�� ����11:23:45
 *	����һ��ֻ����'(',')','{','}','[',']'���ַ������ж��ַ����Ƿ���Ч
 *		�磺��[]�� ��Ч����(]�� ��Ч
 */
public class Solution {
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		String str = "({{})";
		System.out.println(solution.isValid(str));
	}
	
	public boolean isValid(String s){
		// ����ջ(JDK����)
//		Stack<Character> stack = new Stack<>();
		// ʹ���Լ������Ļ�������ʵ�ֵ�ջ
		ArrayStack<Character> stack = new ArrayStack<>();
		// �����ַ����Ƚ���ѭ��
		for (int i = 0; i < s.length(); i++) {
			// ȡ���ַ�(��ǰ�Ƚ��ַ�)
			char c = s.charAt(i);
			if(c == '(' || c == '{' || c == '['){
				stack.push(c);
			}else{
				// ���ջΪ�գ�����false
				if(stack.isEmpty()){
					return false;
				}
				// ��ջ�ַ�(ջ��)
				char topChar = stack.pop();
				
				if(topChar != '(' && c == ')')
					return false;
				if(topChar != '[' && c == ']')
					return false;
				if(topChar != '{' && c == '}')
					return false;
			}
		}
		
		// ��Ϊ��ʱ�����ǲ�ƥ�䣬˵��ջ���ַ�û��ƥ��
		return stack.isEmpty();
	}
}
