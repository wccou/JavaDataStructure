package me.hitwcc.learn;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestIO2 {
	public static void main(String[] args) {
		FileInputStream fis=null;
		
		try {
			fis=new FileInputStream("f:/a.txt");
			StringBuilder sb=new StringBuilder();
			int temp=0;
			try {
				while((temp=fis.read())!=-1){
					sb.append((char)temp);
				}
				System.out.println(sb);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(fis!=null){
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	

}