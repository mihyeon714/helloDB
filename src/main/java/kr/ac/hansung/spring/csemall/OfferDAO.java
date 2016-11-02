package kr.ac.hansung.spring.csemall;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class OfferDAO {
	// jdbcTemplate를 활용하자
	private JdbcTemplate jdbcTemplateObject;
	//private DataSource dataSource; //DI했으니 필요없엉

	//세터를 통한 DI
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject=new JdbcTemplate(dataSource);
	}
	
	//외부에서 사용가능한 메소드
	public int getRowCount(){
		String sqlStatement = "select count(*) from offers"; //쿼리에 문제가 있으면 오류가 나는것을 주의!@
		 return jdbcTemplateObject.queryForObject(sqlStatement, Integer.class);//쿼리를 수행하고 하나의 오브젝트로 결과를 받는데 그 타입이 integer다.	
	}
	
	//여러가지 기능들에 대한 메소드를 쭉 추가할 수 있다
}