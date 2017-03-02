package com.ittx.spring002.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.ittx.spring002.dao.UserDao;
import com.ittx.spring002.model.User;
import com.ittx.spring002.utils.MyHibernateDaoSupport;
import com.ittx.spring002.utils.Pager;

@Repository("userDao")
public class UserDaoImpl extends MyHibernateDaoSupport implements UserDao {
	@Override
	public void addUser(User user) {
		getHibernateTemplate().save(user);
	}

	@Override
	public List<User> getUserLists() {
		List<User> lists = getHibernateTemplate().execute(new HibernateCallback<List<User>>() {
			@Override
			public List<User> doInHibernate(Session s) throws HibernateException {
				SQLQuery q = s.createSQLQuery("select * from spring_user").addEntity(User.class);
				// Query q = s.createQuery("From User");
				List<User> users = q.list();
				return users;
			}
		});

		return lists;
	}

	@Override
	public void deleteUser(User user) {
		getHibernateTemplate().delete(user);

	}

	@Override
	public User getUserById(int id) {
		return getHibernateTemplate().get(User.class, id);
	}

	@Override
	public List<User> getPageUserLists(Pager pager) {

		List<User> lists = getHibernateTemplate().execute(new HibernateCallback<List<User>>() {
			@Override
			public List<User> doInHibernate(Session session) throws HibernateException {

				Query q = session.createQuery("From User").setFirstResult(pager.getIStart())
						.setMaxResults(pager.getIStep());
				List<User> lists = q.list();

				return lists;
			}
		});

		return lists;
	}

	@Override
	public int getTotalCount() {
		/*
		 * int count = 0; List<User> lists = (List<User>)
		 * getHibernateTemplate().find("from User"); if(lists != null &&
		 * lists.size() > 0){ count = lists.size(); } return count;
		 */

		long count = getHibernateTemplate().execute(new HibernateCallback<Long>() {
			@Override
			public Long doInHibernate(Session session) throws HibernateException {
				Long count = (Long) session.createQuery("SELECT count(*) from User").uniqueResult();
				return count;
			}
		});
		return (int) count;

	}

	public static void main(String args[]) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao userDao = (UserDao) ctx.getBean("userDao");

		// Pager pager = new Pager();
		// pager.setICount(26);
		// pager.setCurPage(1);
		// pager.setUrl("http://localhost:8080/SpringWeb02_struts2_spring_jdbcTemplate/user/list.do");
		//
		// List<User> lists = userDao.getPageUserLists(pager);
		// for(User user : lists){
		// System.out.println(user);
		// }

		System.out.println(userDao.getTotalCount());

	}

	@Override
	public List<User> getPageUtilsUserLists(int first, int max) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		String url = "jdbc:mysql://localhost:3306/scxh";
		String user = "root";
		String password = "a123";
		
		List<User> lists = new ArrayList<User>();
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = DriverManager.getConnection(url, user, password);
			ps = connection.prepareStatement("select * from spring_user limit ?,?");
			ps.setInt(1, first);
			ps.setInt(2, max);
			ResultSet rs = ps.executeQuery();

			
			while (rs.next()) {
				User u = new User();
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				u.setNumber(rs.getInt("number"));

				lists.add(u);
			}

			return lists;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		
		return lists;

	}

}
