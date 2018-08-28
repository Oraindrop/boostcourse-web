package io.github.oraindrop.jdbcexam;

import java.util.ArrayList;
import java.util.List;

import io.github.oraindrop.dao.RoleDao;
import io.github.oraindrop.dto.Role;

public class JDBCExam3 {
	public static void main(String[] args) {
		List<Role> list = new ArrayList<>();
		RoleDao dao = new RoleDao();
		list = dao.getRoles();
		System.out.println(list);
	}
}
