package algorithm.study.hashsolution;
/**
 * leetcode387. �ַ����еĵ�һ��Ψһ�ַ�
 * @Package:algorithm.study.hashsolution
 * @ClassName:Solution
 * @Description:TODO 
 * @author:Jiangxb
 * @date:2019��4��13�� ����10:44:12
 *	ע����������Լٶ����ַ���ֻ����Сд��ĸ��
 */
public class Solution {
	public static int firstUniqChar(String s) {
        int[] freq = new int[26];
        /**
         * ˵����
         * 	��Ϊ��Ŀ˵���ˣ�ֻ����26��Сд��ĸ��������������˳���Ϊ26�����顣
         * 	s.charAt(i) - 'a'�ǵõ���ǰ��ĸ���ڵ�����ֵ��
         * 		�統ǰ��ĸΪb,��ôb - 'a' = 1,���freq[1]����ľ���b�����ĸ���ֵĴ���
         * 
         * a ��ASCII = 97
         */
        for (int i = 0; i < s.length(); i++) {
        	// ������д��
//        	freq[s.charAt(i) - 'a'] = freq[s.charAt(i) - 'a'] + 1;
			freq[s.charAt(i) - 'a'] ++;
		}
        
        /**
         * ���ղ����ַ�����ĸ˳��ȥһһ�Աȣ�������ĸ����λ���ϵ�ֵΪ1�����ʾ��һ��Ψһ�ַ�
         */
        for (int i = 0; i < s.length(); i++) {
			if(freq[s.charAt(i) - 'a'] == 1){
				return i;
			}
		}
        return -1;
    }
	
	public static void main(String[] args){
		Solution solution = new Solution();
		String str = "leetcode";
		System.out.println(solution.firstUniqChar(str));
	}
}
