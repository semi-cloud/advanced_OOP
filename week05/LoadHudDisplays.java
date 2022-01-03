package OOP.week05;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

//실제 파일 정보 읽어오는 구현체
public class LoadHudDisplays implements LoadDisplayInterface{

	private String fileName;
	private ArrayList<String> fileContentList;
	
	public LoadHudDisplays() {};
	
	public LoadHudDisplays(String fileName) {  
		this.fileName = fileName;
		fileContentList = new ArrayList<>();
	}
	
	@Override
	public ArrayList<String> load() {
		try {
			BufferedReader read = new BufferedReader(new FileReader(fileName));			
			while(true) {
				String content = read.readLine();
				if(content == null) {break;}
				
				fileContentList.add(content);	
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return fileContentList;		
		
		/*
		ArrayList<String> alist = new ArrayList<String>();
		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();
			while(line != null) {
				alist.add(line);
				line = br.readLine();
			}
			
		}catch(FileNotFoundException e){
			System.out.println(fileName + " does not exist");
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		return alist;
		*/
		
	}
	

}
