package OOP.week02;

public class OdtDocConverter extends DocConverter {

	public OdtDocConverter( ) {
		super("odt");
	}

	@Override
	public void save(String fileName) {
		System.out.println(fileName + "." + super.getExtension() + "�� ��ȯ�ؼ� �����մϴ�.");
	}

}
