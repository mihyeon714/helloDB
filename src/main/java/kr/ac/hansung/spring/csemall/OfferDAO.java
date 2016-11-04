package kr.ac.hansung.spring.csemall;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

//이 에노테이션은 bean.xml에서 bean을 등록해주는 것이 아닌 
//이 클래스를 바로 빈으로 등록해주는것
//id는 활용할 필요가 있을때 작성한다
//@Component("offerDAO")
@Component
public class OfferDAO {
	// jdbcTemplate를 활용하자
	private JdbcTemplate jdbcTemplateObject;
	// private DataSource dataSource; //DI했으니 필요없엉

	// 세터를 통한 DI
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	// 외부에서 사용가능한 메소드
	public int getRowCount() {
		String sqlStatement = "select count(*) from offers"; // 쿼리에 문제가 있으면 오류가
																// 나는것을 주의!@
		return jdbcTemplateObject.queryForObject(sqlStatement, Integer.class);
		// 쿼리를 수행하고 하나의 오브젝트로 결과를 받는데 그 타입이 integer다.
	}

	// 여러가지 기능들에 대한 메소드를 쭉 추가할 수 있다

	// querying and returning a single object
	public Offer getOffer(String name) {
		String sqlStatement = "select * from offers where name=?;";

		return jdbcTemplateObject.queryForObject(sqlStatement, new Object[] { name }, new RowMapper<Offer>() {

			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Offer offer = new Offer();

				offer.setId(rs.getInt("id"));
				offer.setName(rs.getString("name"));
				offer.setEmail(rs.getString("email"));
				offer.setText(rs.getString("text"));

				return offer;
			}

		});

	}

	// querying and returning multiple objects
	public List<Offer> getOffers() {
		String sqlStatement = "select * from offers;";

		return jdbcTemplateObject.query(sqlStatement, new RowMapper<Offer>() {
			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {

				Offer offer = new Offer();

				offer.setId(rs.getInt("id"));
				offer.setName(rs.getString("name"));
				offer.setEmail(rs.getString("email"));
				offer.setText(rs.getString("text"));

				return offer;
			}

		});

	}
}
