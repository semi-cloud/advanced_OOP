package OOP.week14;

public class AgeSorter extends BubbleSorter{
	
	@Override
	public int compareTo(Person a, Person b) {
		return a.getAge() - b.getAge();
	}

	//방법 1
	/*
	@Override
	public int compareTo(Object p1, Object p2) {
		Person data1 = (Person)p1;
		Person data2 = (Person)p2;
		
		if(data1.getAge() - data2.getAge() > 0) {
			return 1;
		}
		return 0;
		//return data1.getAge() - data2.getAge();  
	}
	*/

	
	//방법 2(main코드 수정 필요 => bubbleSorter 객체 생성 해줘야함)
	/*
	 public class AgeSorter extends BubbleSorter implements BubbleSorterComparable{
	 	BubbleSorter sorter;
	 	
	 	public AgeSorter(BubbleSorter sorter){
	 		this.sorter = sorter;
	 	}
	 	
	 	public void bubbleSort(Person[] data){
	 		sorter.sort(data, this);
	 	}
	    ...	 
	 }
	 */
	
	//방법 3 : static 키워드 붙혀서 코드 줄이기(main코드 수정 필요 X)
	/*
	 *  public class AgeSorter extends BubbleSorter implements BubbleSorterComparable{
	 	
	 	public void bubbleSort(Person[] data){
	 		Bubblesorter.sort(data, this);
	 	}
	    ...	 
	 }
	 */
	

}
