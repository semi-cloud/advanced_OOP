package OOP.week14;

public abstract class BubbleSorter implements BubbleSorterComparable {
	
	//1번째 방법
	public void bubbleSort(Person[] data) {    //알고리즘(템플릿)
		  for (int i = 0; i < data.length - 1; i++) {
	            for (int j = 0; j < data.length - 1; j++) {
	            	if(compareTo(data[j], data[j+1]) > 0) {
	            		Person temp = data[j];
	                    data[j] = data[j + 1];
	                    data[j + 1] = temp;
	            	}
	            }
	        }
		
	}
	public abstract int compareTo(Person p1, Person p2);   //위임(비교하는 부분 알고리즘만)
	
	
	//2번째 방법(Static 키워드 붇히기)
	/*
	 public class BubbleSorter{
	 * public static void bubbleSort(Person[] data, BubbleSorterComparable comparable) {    //알고리즘(템플릿)
		  for (int i = 0; i < data.length - 1; i++) {
	            for (int j = 0; j < data.length - 1; j++) {
	            	if(comparable.compareTo(data[j], data[j+1]) > 0) {
	            		Person temp = data[j];
	                    data[j] = data[j + 1];
	                    data[j + 1] = temp;
	            	}
	            }
	        }
		
		}
	}
	 */
	
}
