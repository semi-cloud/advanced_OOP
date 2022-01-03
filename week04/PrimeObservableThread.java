package OOP.week04;

import java.util.ArrayList;
import java.util.List;

public class PrimeObservableThread implements Runnable, Subject{   //Subject(정보 변경을 알려줘야함)
	    private static final int SLEEPTIME = 500;

	    private int primeNumber;
	    private int numCount;
	    private boolean first = true;
	    private boolean stopRunning = false;
	    private List<Observer> observerList;

	    public PrimeObservableThread() {
	    	observerList = new ArrayList<>(); 	
	    }

	    public int getPrimeNumber() {
	        return primeNumber;
	    }

	    public void stopRunning() {
	        stopRunning = true;
	    }

	    public void startRunning() {
	        stopRunning = false;
	        run();
	    }

	    private void generatePrimeNumber() {
	        while (stopRunning == false) {
	            if (first) {
	                first = false;
	                primeNumber = 2;      
	                notifyObservers();  
	                numCount = 1; 
	            } else {
	                numCount += 2; 
	                if (isPrimeNumber(numCount)) {
	                    primeNumber = numCount;
	                    notifyObservers();   //여기서 update를 시켜줌
	                }
	            }
	            try {
	                Thread.sleep(SLEEPTIME); 
	            }
	            catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	    }

	    private boolean isPrimeNumber(int n) {
	        for (int i = 2; i * i <= n; i++) {
	            if (n % i == 0) {
	                return false;
	            }
	        }
	        return true;
	    }

	    @Override
	    public void run() {
	        generatePrimeNumber();
	    }

		@Override
		public void addObserver(Observer observer) {
			
			if(!observerList.contains(observer)) {
				observerList.add(observer);
			}

		}

		@Override
		public void removeObserver(Observer observer) {
			int idx = observerList.indexOf(observer);
			
			if(idx >= 0) {
				observerList.remove(idx);
			}
		}

		@Override
		public void notifyObservers() {
			for(Observer ob: observerList) {
				ob.update(getPrimeNumber());      
			}
		}

}
