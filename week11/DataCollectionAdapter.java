package OOP.week11;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//Adaptee : arrayList, Target : DataCollection, specificRequest: List<T>의 함수들
public class DataCollectionAdapter<T> implements DataCollection<T>{    //어댑터 클래스, DataCollection의 기능 요청
	private List<T> list;   
	
	public DataCollectionAdapter(ArrayList<T> list) {
		this.list = list;
	}

	@Override
	public boolean put(Object t) {
		if(t != null) {
			list.add((T)t);
		}
		return true;
	}

	@Override
	public T elemAt(int index) {
		if(index >= 0 && index < list.size()) {    //범위 체크
			return list.get(index);
		}
		return null;
	}

	@Override
	public int length() {
		return list.size();
	}

	@Override
	public Iterator createIterator() {
		return list.iterator();
	}    
	

}
