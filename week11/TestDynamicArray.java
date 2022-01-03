package OOP.week11;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestDynamicArray {
    public static void main(String[] args) {

    	ArrayList<String> list = new ArrayList<String>();      //list 생성
    	DataCollection<String> arr = new DataCollectionAdapter<String>(list);     //adapter와 연결
    
        arr.put("Seoul");
        arr.put("Busan");
        arr.put("Gwangju");
        arr.put("Daejeon");
        arr.put("Cheonan");
        arr.put("Ulsan");
        arr.put("Daegu");
        arr.put("Incheon");

        System.out.println("index");
        for (int i = 0; i < arr.length(); i++) {
            String s = (String) arr.elemAt(i);
            System.out.println(s);
        }

        System.out.println("iterator");
        for (Iterator iter = arr.createIterator(); iter.hasNext(); ) {
            String s = (String) iter.next();
            System.out.println(s);
        }
    }
}
