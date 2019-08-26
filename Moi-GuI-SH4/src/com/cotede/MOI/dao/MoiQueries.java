//package com.cotede.MOI.dao;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
//import com.cotede.MOI.bo.ChildUnder16;
//import com.cotede.MOI.connection.ConnectionDB;
//
//public class MoiQueries {
//
//public static int saveNewChildInfo(ChildUnder16 cu) {
//		
//		int st4 = 0;
//	 
//		try {
//		 
//			String sql4 = "insert into childunder16 (hawiaNO,firstName ," 
//					+ " gender, BOD"
//					+ " ) "
//					+ " values(?,?,?,?)";
//		 
//			Connection conn = ConnectionDB.getConnections();
//			 
//			PreparedStatement ps4= conn.prepareStatement(sql4);
//		 		
//			ps4.setInt(1, cu.getHawiaNo());
//			ps4.setString(2, cu.getFirstName());		 
//			ps4.setString(3, cu.getGender());
//			ps4.setString(4, cu.getBOD());
//				
//			st4 = ps4.executeUpdate();
//		 
//			conn.close();
//			ps4.close();
//		 			
//		}catch(SQLException e) {
//			System.out.print("Faild query");
//		} finally {
//			if (conn != null) {
//				try {
//					conn.close();
//				}catch (SQLException e) {
//					
//					e.printStackTrace();
//				}
//			}
//		}		
//		return st4 ;
//		}
//	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
//
//}
