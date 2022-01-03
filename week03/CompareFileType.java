package OOP.week03;

public class CompareFileType implements Comparable {

	@Override
	public int compareTo(Object o1, Object o2) {
		
		FileInfo fileInfo1 = (FileInfo)o1;
		FileInfo fileInfo2 = (FileInfo)o2;
		
		return fileInfo1.getType().compareTo(fileInfo2.getType());
	}

}
