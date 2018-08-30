package springboot.test;

import java.util.Date;

/**
 * https://github.com/licslan
 * @author licslan
 *
 */
public class Order {

	public String id;

	public String no;

	public Date date;

	public int quantity;

	/**
	 *  get set
	 */
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
