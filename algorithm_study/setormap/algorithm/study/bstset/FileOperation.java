package algorithm.study.bstset;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

/**
 * �ļ���ز���
 * @Package:algorithm.study.set
 * @ClassName:FileOperation
 * @Description:TODO 
 * @author:Jiangxb
 * @date:2019��3��24�� ����4:02:27
 */
public class FileOperation {
	/**
	 * @Title:readFile
	 * @Description:TODO ��ȡ�ļ�����Ϊfilename�е����ݣ��������а��������д���Ž�words��
	 * @return:boolean
	 * @author:Jiangxb
	 * @date: 2019��3��24�� ����4:04:47
	 * 	filename:��Ҫ��ȡ���Ǹ��ı���Ӧ���ļ���
	 */
	public static boolean readFile(String filename,ArrayList<String> words){
		if(filename == null || words == null){
			System.out.println("filename is null or words is null");
			return false;
		}
		
		// �ļ���ȡ
		Scanner scanner;
		try {
			File file = new File(filename);
			if(file.exists()){
				FileInputStream fis = new FileInputStream(file);
				scanner = new Scanner(new BufferedInputStream(fis),"UTF-8");
				scanner.useLocale(Locale.ENGLISH);	// Ӣ�ĵ��ı�
			}else{
				return false;
			}
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println("Cannot open " + filename);
			return false;
		}
		
		/**
		 * �򵥷ִ�
		 * 	����ִʷ�ʽ��Լ�ª��û�п��Ǻܶ��ı������е���������
		 * 	����ֻ��demoչʾ��
		 */
		if(scanner.hasNextLine()){
			String contents = scanner.useDelimiter("\\A").next();
			
			int start = firstCharacterIndex(contents, 0);
            for (int i = start + 1; i <= contents.length(); ){
                if (i == contents.length() || !Character.isLetter(contents.charAt(i))) {
                    String word = contents.substring(start, i).toLowerCase();
                    words.add(word);
                    start = firstCharacterIndex(contents, i);
                    i = start + 1;
                } else{
                    i++;
                }
            }
		}
		return true;
	}
	
	/**
	 * Ѱ���ַ���s�У���start��λ�ÿ�ʼ�ĵ�һ����ĸ�ַ���λ��
	 * @Title:firstCharacterIndex
	 * @Description:TODO 
	 * @return:int
	 * @author:Jiangxb
	 * @date: 2019��3��24�� ����4:15:12
	 */
    private static int firstCharacterIndex(String s, int start){

        for( int i = start ; i < s.length() ; i ++ )
            if( Character.isLetter(s.charAt(i)) )
                return i;
        return s.length();
    }
}
