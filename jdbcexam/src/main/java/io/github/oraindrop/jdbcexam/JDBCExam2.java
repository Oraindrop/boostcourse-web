package io.github.oraindrop.jdbcexam;

import io.github.oraindrop.dao.RoleDao;
import io.github.oraindrop.dto.Role;

public class JDBCExam2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RoleDao dao = new RoleDao();
		Role role = new Role(200, "CEO");
		int cnt = dao.addRole(role);
		System.out.println(cnt);
	}

}
