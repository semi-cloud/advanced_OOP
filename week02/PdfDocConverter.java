package OOP.week02;

public class PdfDocConverter extends DocConverter {
	
	public PdfDocConverter() {
		super("pdf");
	}

	@Override
	public void save(String fileName) {
		System.out.println(fileName + "." + super.getExtension() + "�� ��ȯ�ؼ� �����մϴ�.");
		
	}

}
