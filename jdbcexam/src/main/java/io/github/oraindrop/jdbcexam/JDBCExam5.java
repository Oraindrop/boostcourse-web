package io.github.oraindrop.jdbcexam;

import io.github.oraindrop.dao.RoleDao;
import io.github.oraindrop.dto.Role;

public class JDBCExam5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RoleDao dao = new RoleDao();
		
		System.out.println(dao.getRole(200));
		
		Role role = new Role(200, "CEO");
		int cnt = dao.UpdateRole(role);
		System.out.println(cnt);
		
		System.out.println(dao.getRole(200));
	
	}

}
