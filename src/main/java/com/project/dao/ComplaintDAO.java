package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.project.model.Complaints;
import com.project.util.DBConnection;

public class ComplaintDAO {

	public boolean report(Complaints cmp) throws Exception {
		
		boolean status = false;
		
		Connection conn = DBConnection.establishConnection();
		
		String query = "Insert into complaints(user_id ,zone_type , sub_type , location , exact_address , description) values (?,?,?,?,?,?)";
		
		PreparedStatement ps =   conn.prepareStatement(query);
		
		ps.setInt(1, cmp.getUser_id());
		ps.setString(2, cmp.getZone_type());
		ps.setString(3, cmp.getSub_type());
		ps.setString(4, cmp.getLoaction());
		ps.setString(5, cmp.getExact_address());
		ps.setString(6, cmp.getDescription());
		
		int row = ps.executeUpdate();
		
		if(row>0) {
			status = true;
		}
		ps.close();
		return status;
		
		
	}
	
	public List<Complaints> mycomplaints(int user_id) throws Exception{
		
		List<Complaints> list = new ArrayList<Complaints>();
		
		Connection conn = DBConnection.establishConnection();
		
		String query = "select * from complaints where user_id = ? ";
		
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setInt(1, user_id);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			
			Complaints cmp = new Complaints();
			
			cmp.setComplaint_id(rs.getInt("complaint_id"));
			cmp.setUser_id(rs.getInt("user_id"));
			cmp.setZone_type(rs.getString("zone_type"));
			cmp.setSub_type(rs.getString("sub_type"));
			cmp.setLoaction(rs.getString("location"));
			cmp.setExact_address(rs.getString("exact_address"));
			cmp.setDescription(rs.getString("description"));
			cmp.setStatus(rs.getString("status"));
			cmp.setCreated_at(rs.getTimestamp("created_at"));
			
			list.add(cmp);
		}
				
		
		return list;
		}
	
}
