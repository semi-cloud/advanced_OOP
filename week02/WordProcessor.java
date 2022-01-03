package OOP.week02;

import java.util.Map;
import java.util.HashMap;

public class WordProcessor {
	
	private ISpellChecker spellChecker;
	
	private Map<String, DocConverter> docConverts;

	private String fileName;
	
	public WordProcessor(String fileName) {
		this.fileName = fileName;
		docConverts = new HashMap<>();
	}
		
	public void addDocConverter(DocConverter converter) {
		docConverts.put(converter.getExtension(), converter);
	}

	public void convertDocTo(String ext) { 
		if(docConverts.containsKey(ext)) {
			docConverts.get(ext).save(fileName);	
		}else {
			System.out.println(ext + "���� ������ �����ϴ� DocConverter�� �����ϴ�");
		}	
	}
	
	public void setSpellChecker(ISpellChecker spellChecker) {
		this.spellChecker = spellChecker;		
	}
	
	public void checkSpelling() {
		if(spellChecker != null) {
			spellChecker.check();
		}
	}

}
