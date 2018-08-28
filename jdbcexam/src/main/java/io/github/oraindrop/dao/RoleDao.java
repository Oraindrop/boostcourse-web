package io.github.oraindrop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import io.github.oraindrop.dto.Role;

public class RoleDao {
	private static String dburl = "jdbc:mysql://localhost:3306/connectdb";
	private static String dbUser = "connectuser";
	private static String dbpasswd = "connect123!@#";
	
	public Role getRole(int roleID) {
		Role role = null;
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
			String sql = "SELECT role_id, description FROM role WHERE role_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, roleID);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				int id = rs.getInt(1);
				String desc = rs.getString(2);
				role = new Role(id, desc);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();	
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			if(ps != null) {
				try {
					ps.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}	
		}		
		return role;		
	}
	
	public int addRole(Role role) {
		int count = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String sql = "INSERT INTO role (role_id, description) VALUES (? , ?)";
		
		//try-with resource
		try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
			PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setInt(1, role.getRoleId());
			ps.setString(2, role.getDescription());
			
			count = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
	public List<Role> getRoles(){
		List<Role> roleList = new ArrayList<>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String sql = "SELECT role_id, description FROM role";
		
		try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
			PreparedStatement ps = conn.prepareStatement(sql)){
			try(ResultSet rs = ps.executeQuery();) {
				while(rs.next()) {
					int roleId = rs.getInt(1);
					String roleDesc = rs.getString(2);
					roleList.add(new Role(roleId, roleDesc));					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		
		return roleList;		
	}
	
	public int deleteRole(int roleId) {
		int count = 0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String sql = "DELETE FROM role WHERE role_id = ?";
		
		try(Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
			PreparedStatement ps = conn.prepareStatement(sql)
			){
			ps.setInt(1, roleId);
			count = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return count;
	}
	
}
