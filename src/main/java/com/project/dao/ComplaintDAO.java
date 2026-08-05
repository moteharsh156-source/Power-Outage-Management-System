package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

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
}
