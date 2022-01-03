package OOP.week10;

import java.util.List;

public interface DAO<D, K> {
	public void insert(D data);
	public List<D> findAll();
	public D findByKey(K key);
	public void update(K key, D p);
	public void deleteByKey(K key);
	public void delete(D data);
	//K key , D data는 보기에 다르지만 실제 타입이 같을 수도 있어서 오버로딩에 문제 발생
}
