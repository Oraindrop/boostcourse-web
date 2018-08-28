package io.github.oraindrop.jdbcexam;

import io.github.oraindrop.dao.RoleDao;
import io.github.oraindrop.dto.Role;

public class JDBCExam1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RoleDao dao = new RoleDao();
		Role role = dao.getRole(100);
		System.out.println(role);
	}

}
