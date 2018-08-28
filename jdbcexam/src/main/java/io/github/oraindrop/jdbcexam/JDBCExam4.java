package io.github.oraindrop.jdbcexam;

import io.github.oraindrop.dao.RoleDao;

public class JDBCExam4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RoleDao dao = new RoleDao();
		int cnt = dao.deleteRole(200);
		System.out.println(cnt);
		
	}

}
