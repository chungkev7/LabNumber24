package co.grandcircus.LabNumber24.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import co.grandcircus.LabNumber24.model.Products;
import co.grandcircus.LabNumber24.model.User;

@Repository
public class UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<User> findAllUser() {
		return jdbcTemplate.query("SELECT * FROM users", new BeanPropertyRowMapper<User>(User.class));
	}

	public List<Products> findAllProducts(){
		return jdbcTemplate.query("select * from products", new BeanPropertyRowMapper<Products>(Products.class));
	}
	
	public int addUser(String name) {
		String addQuery = "insert into users(name) values (?)";
		return jdbcTemplate.update(addQuery, name);
	}
	
	public List<Products> searchByName(String name){
		String searchQuery = "select * from products where name = '?'";
		return jdbcTemplate.query(searchQuery, new BeanPropertyRowMapper<Products>(Products.class));
	}
	
}
