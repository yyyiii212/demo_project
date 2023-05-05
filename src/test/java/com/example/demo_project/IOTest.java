package com.example.demo_project;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.jupiter.api.Test;

public class IOTest {

	@Test
	public void fileOutputStreamTest() throws IOException {//創建檔案
//		FileOutputStream fos = new FileOutputStream("test-1.txt");
//		try {
//			fos.write(70);//輸入英文
//			System.out.println("檔案寫入成功");
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} finally {
//			fos.close();
//		}
		
		try(FileOutputStream foos = new FileOutputStream("test-1.txt", true)) {
//			foos.write(70);
			String str = "嗨";
			foos.write('\n');//寫入檔案(斷行)
			foos.write(str.getBytes());
			System.out.println("檔案寫入成功");
		} catch (Exception e) {
//			e.printStackTrace();
		} 
	}
	@Test
	public void fileInputStream() {//讀取檔案
		
		try(FileInputStream fis = new FileInputStream("test-1.txt")) {
			int b = fis.read();
			System.out.println(b);
			System.out.println((char)b);
			System.out.println("檔案寫入成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void fileInputStream1() {
		try(FileInputStream fis = new FileInputStream("123.jpg")) {
			FileOutputStream fos = new FileOutputStream("222.jpg");
			System.out.println("檔案大小 : "+fis.available());
			byte[] b  = new byte[fis.available()];
			System.out.println(b);
			fos.write(b);
			System.out.println("檔案寫入成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void bufferFileOutputStream()throws IOException {//緩衝區(速度比較快)
		
		try(FileOutputStream fos = new FileOutputStream("text-1.txt"); 
			BufferedOutputStream bfos = new BufferedOutputStream(fos)){
			String str = "ASDF";
			bfos.write(str.getBytes());
			bfos.flush();
			bfos.close();
			System.out.println("successful");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	@Test
	public void bufferFileInputStream()throws IOException {//緩衝區(速度比較快)
		
		try(FileInputStream fis = new FileInputStream("text-1.txt"); 
			BufferedInputStream bfos = new BufferedInputStream(fis)){
			int b = fis.read();
			System.out.println(b);
			System.out.println((char)b);
			System.out.println("檔案寫入成功");
			System.out.println("successful");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
