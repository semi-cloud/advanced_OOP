package OOP.week10;

public class Main {
	public static void main(String[] args) {

		PasswordInfo p;	
		DAO<PasswordInfo, String> passwordDao = new PasswordDaoImpl("userinfos");
		
		System.out.println("--- inserting...");
		p = new PasswordInfo("https://www.smu.ac.kr", "smu", "abcde");
		passwordDao.insert(p);
		p = new PasswordInfo("https://www.smu2.ac.kr", "smu2", "abcde");
		passwordDao.insert(p);

		System.out.println("--- finding all...");
		
		for (PasswordInfo pw : passwordDao.findAll()) {
			System.out.println("reading... " + pw);
		}

		System.out.println("--- updating...");
		p = passwordDao.findAll().get(1);
		p.setId("smu1");
		passwordDao.update(p.getKey(), p);
		
		System.out.println("--- see if updated...");
		p = passwordDao.findByKey("https://www.smu2.ac.kr");
		if (p != null) {
			System.out.println(p);
		}
		
		System.out.println("--- deleting...");
		passwordDao.deleteByKey("https://www.smu2.ac.kr"); 
		
		System.out.println("--- finding all after deleting...");
		for (PasswordInfo pw : passwordDao.findAll()) {
			System.out.println("reading... " + pw);
		}
		
	}

}
