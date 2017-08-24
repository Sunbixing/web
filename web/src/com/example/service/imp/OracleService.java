package com.example.service.imp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.domin.Cele;
import com.example.domin.Good;
import com.example.domin.Person;
import com.example.domin.Result;
import com.example.service.OraclePerson;
import com.example.service.OracleResult;

public class OracleService implements OraclePerson, OracleResult {
	private static String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
	private static String user = "SCOTT";
	private static String password = "Sbx54380567";
	private static String driver = "oracle.jdbc.driver.OracleDriver";
	public static Connection conn;
	PreparedStatement pre;
	Statement st;
	ResultSet result;

	public static Connection getConnection() throws Exception {
		Class.forName(driver);
		conn = DriverManager.getConnection(url, user, password);
		if (conn == null) {
			System.out.println("连接失败");
		} else {
			System.out.println("连接成功");
		}
		return conn;
	}

	public void save(String name, String pwd) throws Exception {
		String sql = "insert into person values(?,?,?)";
		String sqlnum = "select count(*) from person";
		conn = OracleService.getConnection();
		pre = conn.prepareStatement(sqlnum);
		int count = 0;
		result = pre.executeQuery();
		while (result.next()) {
			count = result.getInt(1) + 1;
		}
		pre = conn.prepareStatement(sql);
		pre.setInt(1, count);
		pre.setString(2, name);
		pre.setString(3, pwd);
		pre.executeUpdate();
		if (result != null) {
			result.close();
		}
		if (pre != null) {
			pre.close();
		}
		if (conn != null) {
			conn.close();
		}

	}

	public List<Person> find() throws Exception {
		List<Person> persons = new ArrayList<Person>();
		String sql = "select * from person order by id asc";
		conn = OracleService.getConnection();
		pre = conn.prepareStatement(sql);
		result = pre.executeQuery();
		while (result.next()) {
			int id = result.getInt("id");
			String nameString = result.getString("name");
			System.out.println(nameString);
			String pwdString = result.getString("pwd");
			System.out.println(pwdString);
			Person person = new Person(id, nameString, pwdString);
			persons.add(person);
		}
		if (result != null) {
			result.close();
		}
		if (pre != null) {
			pre.close();
		}
		if (conn != null) {
			conn.close();
		}
		return persons;
	}

	public List<Result> findResult() throws Exception {
		List<Result> results = new ArrayList<Result>();
		String sql = "select * from result_person order by id asc";
		conn = OracleService.getConnection();
		pre = conn.prepareStatement(sql);
		result = pre.executeQuery();
		while (result.next()) {
			int id = result.getInt("id");
			String titleString = result.getString("title");
			System.out.println(titleString);
			String contentString = result.getString("content");
			System.out.println(contentString);
			String commentsString = result.getString("comments");
			System.out.println(commentsString);
			Result result = new Result(id, titleString, contentString, commentsString);
			results.add(result);
		}
		if (result != null) {
			result.close();
		}
		if (pre != null) {
			pre.close();
		}
		if (conn != null) {
			conn.close();
		}
		return results;
	}

	public List<Cele> findCele() throws Exception {
		List<Cele> results = new ArrayList<Cele>();
		String sql = "select * from CELEBRITY order by id asc";
		conn = OracleService.getConnection();
		pre = conn.prepareStatement(sql);
		result = pre.executeQuery();
		while (result.next()) {
			int id = result.getInt("id");
			String titleString = result.getString("title");
			System.out.println(titleString);
			String contentString = result.getString("content");
			System.out.println(contentString);
			String commentsString = result.getString("comments");
			System.out.println(commentsString);
			Cele result = new Cele(id, titleString, contentString, commentsString);
			results.add(result);
		}
		if (result != null) {
			result.close();
		}
		if (pre != null) {
			pre.close();
		}
		if (conn != null) {
			conn.close();
		}
		return results;
	}

	@Override
	public void delete(String id) throws Exception {
		String sql = "delete from result_person where id=?";
		conn = OracleService.getConnection();
		pre = conn.prepareStatement(sql);
		pre.setInt(1, Integer.valueOf(id));
		pre.executeUpdate();
		if (pre != null) {
			pre.close();
		}
		if (conn != null) {
			conn.close();
		}

	}

	@Override
	public void update(String id, String title, String content, String comment) throws Exception {
		String sql = "update result_person set title=?,content=?,comments=? where id=?";
		conn = OracleService.getConnection();
		pre = conn.prepareStatement(sql);
		pre.setString(1, title);
		pre.setString(2, content);
		pre.setString(3, comment);
		pre.setInt(4, Integer.valueOf(id));
		pre.executeUpdate();
		if (pre != null) {
			pre.close();
		}
		if (conn != null) {
			conn.close();
		}

	}

	@Override
	public List<Good> findGood() throws Exception {
		List<Good> goods = new ArrayList<Good>();
		String sql = "select * from goods order by id asc";
		conn = OracleService.getConnection();
		pre = conn.prepareStatement(sql);
		result = pre.executeQuery();
		while (result.next()) {
			int id = result.getInt("id");
			String nameString = result.getString("name");
			int univalent = result.getInt("univalent");
			int quantity = result.getInt("quantity");
			Good good = new Good(id, nameString, univalent, quantity);
			goods.add(good);
		}
		if (result != null) {
			result.close();
		}
		if (pre != null) {
			pre.close();
		}
		if (conn != null) {
			conn.close();
		}
		return goods;
	}

}
