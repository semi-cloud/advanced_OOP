package OOP.week14;
public class NameSorter extends BubbleSorter{

	@Override
	public int compareTo(Person p1, Person p2) {
		return p1.getName().compareTo(p2.getName());
	}

}
