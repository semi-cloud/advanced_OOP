package OOP.week10;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//들어오는 D는 반드시 DBData를 구현하고 있어함을 어떻게 강제? => D에 제한 걸기
//DBData를 구현했거나 상속받은 자식 클래스만 DAOImpl에 넣을 수 잇음(extends)
public abstract class DAOImpl<D extends DBData<K>, K> implements DAO<D,K> {
	String dbTableName;
	public abstract String getInsertValueStr(D data);    //추상 함수로 자식에게 위임
	public abstract Statement getStatement();
	public abstract D getNewData(ResultSet rs);         //일종의 factory
	public abstract String getKeyColumnName();
	public abstract String getUpdateValueStr(D data);

	
	//mySql은 db_name이니 파일이 필요  x
	public DAOImpl(String dbTableName) { 
		this.dbTableName = dbTableName;	
	}
	
	@Override
	public void insert(D data) {		
		try {
	        String fmt = "INSERT INTO %s VALUES(%s)";
	        String q = String.format(fmt, dbTableName, getInsertValueStr(data));
	        
	        getStatement().execute(q);
	      }
	      catch (SQLException e) { e.printStackTrace(); }	
	      
	}

	@Override
	public List<D> findAll() {
		ArrayList<D> dataList = new ArrayList<D>();
		ResultSet rs;
	      try {
	        rs = getStatement().executeQuery("SELECT * FROM " + dbTableName);
	        while (rs.next()) {
	          dataList.add(getNewData(rs));
	        }
	      }
	      catch (SQLException e) { e.printStackTrace(); }
	      return dataList;      
	}

	@Override
	public D findByKey(K key) {	
		  D data  = null;
		  ResultSet rs;
	      try {
	        String fmt = "SELECT * FROM %s WHERE %s = '%s' ";  //url = '%s', id = %d
	        String q = String.format(fmt, dbTableName, getKeyColumnName() ,key.toString());
	        rs = getStatement().executeQuery(q);

	        if (rs.next()) {
	          data = getNewData(rs);
	        }
	      }
	      catch (SQLException e) { e.printStackTrace(); }
	      return data;
	}

	@Override
	public void update(K key, D data) {		
		 D data2= findByKey(key);	      
	     if (data2 != null) {
	        try {
	          String fmt = "UPDATE %s SET %s WHERE %s = '%s'";
	          String q = String.format(fmt, dbTableName,
	        		  getUpdateValueStr(data),
	        		  getKeyColumnName(), key.toString());
	          getStatement().execute(q);
	        }
	        catch (SQLException e) { e.printStackTrace(); }
	     }	
	     
	}

	@Override
	public void deleteByKey(K key) {
		
		 try {
		        String fmt = "DELETE FROM %s WHERE %s = '%s'";
		        String q = String.format(fmt, dbTableName,
		        		getKeyColumnName(), key.toString());
		        getStatement().execute(q);
		 }
		 catch (SQLException e) { e.printStackTrace();} 	
		 
	}

	@Override
	public void delete(D data) {
		deleteByKey(data.getKey());    //어떻게 D 가 getKey를 가지게 하는가?=> interface 생성해서 구현하게 강제
	}

}
