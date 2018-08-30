package springboot.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * https://github.com/licslan
 * @author licslan
 *
 */
@Repository
public class OrderDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Order> findAll() {
		List<Order> list = new ArrayList<>();
		String sql = " select * from t_order ";
		SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, new Object[] {});
		while (rows.next()) {
			Order order = new Order();
			list.add(order);
			order.id = rows.getString("order_id");
			order.no = rows.getString("order_no");
			order.date = rows.getDate("order_date");
			order.quantity = rows.getInt("quantity");
		}
		return list;
	}

	public Order get(String id) {
		Order order = null;
		String sql = " select * from t_order where order_id = ? ";
		SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, new Object[] { id });
		while (rows.next()) {
			order = new Order();
			order.id = rows.getString("order_id");
			order.no = rows.getString("order_no");
			order.date = rows.getDate("order_date");
			order.quantity = rows.getInt("quantity");
		}
		return order;
	}

	public String insert(Order order) {
		String id = UUID.randomUUID().toString();
		String sql = " insert into t_order ( order_id , order_no , order_date , quantity ) values (?,?,?,?) ";
		jdbcTemplate.update(sql,
				new Object[] { id, order.no, new java.sql.Date(order.date.getTime()), order.quantity });
		return id;
	}

	public void update(Order order) {
		String sql = " update t_order set order_no = ? , order_date = ? , quantity = ? where order_id = ? ";
		jdbcTemplate.update(sql,
				new Object[] { order.no, new java.sql.Date(order.date.getTime()), order.quantity, order.id });
	}

	public void delete(String id) {
		String sql = " delete from t_order where order_id = ? ";
		jdbcTemplate.update(sql, new Object[] { id });
	}
}
