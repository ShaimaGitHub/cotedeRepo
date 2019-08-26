package com.cotede.MOI.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList; 
import java.util.List;

import com.cotede.MOI.bo.AdminsBean;
import com.cotede.MOI.bo.ChildUnder16;
import com.cotede.MOI.bo.Couple;
import com.cotede.MOI.bo.HawiyaForm;
import com.cotede.MOI.bo.ParentForm;

 
public class ConnectionDB {

	
	//public static final String STRING_CONNECTION = "jdbc:mysql://localhost:3306/users?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	//  private static Connection conn = null;
	
	  // JDBC driver name and database URL 
	 static final String JDBC_DRIVER = "org.h2.Driver";   
	   static final String DB_URL = "jdbc:h2:./DATABASE/MOI-PROJ;DB_CLOSE_ON_EXIT=TRUE;FILE_LOCK=NO";  
	   static private Connection conn = null; 
	   static private Statement stmt = null;
	   //  Database credentials 
	   static final String USER = "sa"; 
	   static final String PASS = ""; 
	
	   
	public static Connection getConnections() {
 
	      try { 
	         // STEP 1: Register JDBC driver 
	         Class.forName(JDBC_DRIVER); 
	             
	       //STEP 2: Open a connection 
	         System.out.println("Connecting to database..."); 
	         conn = DriverManager.getConnection(DB_URL,USER,PASS);  
	         
	         //STEP 3: Execute a query 
	         //System.out.println("Creating table in given database..."); 
	         stmt = conn.createStatement(); 
	         String sql =  "select C_USER_NAME,C_PASSWORD from ACOUNT";  
	        ResultSet result = stmt.executeQuery(sql);
	        while(result.next()) {
	         System.out.println(result.getString(1)+" "+ result.getString(2)); 
	         }
	         
	         // STEP 4: Clean-up environment 
	          
	      } catch(SQLException se) { 
	         //Handle errors for JDBC 
	         se.printStackTrace(); 
	      } catch(Exception e) { 
	         //Handle errors for Class.forName 
	         e.printStackTrace(); }
	   
		return conn;
	}

	public static List<AdminsBean> adminsList() throws SQLException {
		List<AdminsBean> lists = new ArrayList<AdminsBean>();
		Connection conn = ConnectionDB.getConnections();
		try (PreparedStatement stat = conn.prepareStatement("Select C_USER_NAME,C_PASSWORD from ACOUNT;");
				ResultSet result = stat.executeQuery();) {

			while (result.next()) {
				AdminsBean s = new AdminsBean();
				s.setUserName(result.getString(1));
				s.setPassword(result.getString(2));
				lists.add(s);
			}
		} catch (SQLException e) {
			System.out.print("failed" + e.getMessage());
		} 
		finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return lists;
	}
		
	public static int saveHawiaInfo(ParentForm pf, ChildUnder16 cu, Couple c) {
		
		int st = 0;
		int st2 = 0;
		int st3 = 0;
		try {
			String sql = "insert into hawiaForm (C_HAW_TYPE,C_BOD ,C_FATH_NAME,C_MOTH_NAME,I_PINX_O," 
		            + "I_HAW_NO,"
					+ "I_CELL_PHONE,C_CURRENT_ADDRESS,C_FAM_NAME,C_GRAND_FATH_NAME,C_FIRST_NMAE,C_PREV_FAM_NAME,I_TEL_NO,C_REGIN,C_PLACE_OF_BIRTH,"
					+ "C_SOCIAL_STATUS,C_GENDER, C_FORM_TYPE" 
					+ " ) "
					+ " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,'هوية')";
			
			String sql2 = "insert into CHILDUNDER16 (I_HAWIA_NO,C_FIRST_NAME," 
					+ " C_GENDER,C_BOD"
					+ " ) "
					+ " values(?,?,?,?)";
	 
			String sql3 = "insert into COUPLES (I_C_HAWIA_NO,I_TAS_NO ,I_PASS_NO," 
					+ " C_PASS_TYPE, C_PREV_FAM_NO, C_FULL_NAME"
					+ " ) "
					+ " values(?,?,?,?,?,?)";
			
			Connection conn = ConnectionDB.getConnections();
			PreparedStatement ps= conn.prepareStatement(sql);
			PreparedStatement ps2= conn.prepareStatement(sql2);
			PreparedStatement ps3= conn.prepareStatement(sql3);
			
			ps3.setInt(1, c.getcHawiaNO());
			ps3.setInt(2, c.getTasrehNumber());
			ps3.setInt(3, c.getPassportNumber());
			ps3.setString(4, c.getPassportType());
			ps3.setString(5, c.getPrevFamilyName());
			ps3.setString(6, c.getFullName());
			
			ps2.setInt(1, cu.getChHawiaNO());
			ps2.setString(2, cu.getFirstName());		 
			ps2.setString(3, cu.getGender());
			ps2.setString(4, cu.getBOD());
			
			ps.setString(1, pf.getHawiaType());
			ps.setString(2, pf.getBod());
			ps.setString(3, pf.getGrandFatherName());
			ps.setString(4,pf.getMotherName());
			ps.setString(5, pf.getPinxNo());
			ps.setInt(6, pf.getHawiaNo());
			//ps.setInt(7, pf.getFormId());
			ps.setInt(7, pf.getCellPhone());
			ps.setString(8, pf.getCurrentAddress());
			ps.setString(9, pf.getFamilyName());
			ps.setString(10, pf.getFatherName());
			ps.setString(11, pf.getFirstName());
			ps.setString(12, pf.getPervFamilyName());
			ps.setInt(13, pf.getTelephoneNumber());
			ps.setString(14, pf.getReligion());
			ps.setString(15, pf.getPlaceOfBirth());
			ps.setString(16, pf.getSocialStatus());
			ps.setString(17, pf.getGender());
			
			st = ps.executeUpdate();
			st2 = ps2.executeUpdate();
			st3 = ps3.executeUpdate();
			conn.close();
			ps.close();
			ps2.close();
			ps3.close();
			
		}catch(SQLException e) {
			System.out.print("Faild query");
		} finally {
			if (conn != null) {
				try {
					conn.close();
				}catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
		}		
		return st2+st+st3;
		}
	
public static int updateHawiaInfo(ParentForm pf,int hawiaNo ) {
		
		int st = 0;
		int st2 = 0;
		int st3 = 0;
		try {
			String sql = "UPDATE hawiaForm SET C_HAW_TYPE=? ,C_BOD=? ,C_FATH_NAME=?,C_MOTH_NAME=?,I_PINX_O=?," 
		            + "I_HAW_NO=?,"
					+ "I_CELL_PHONE=?,C_CURRENT_ADDRESS=?,C_FAM_NAME=?,C_GRAND_FATH_NAME=?,C_FIRST_NMAE=?,C_PREV_FAM_NAME=?,I_TEL_NO=?,C_REGIN=?,C_PLACE_OF_BIRTH=?,"
					+ "C_SOCIAL_STATUS=?,C_GENDER=? where I_HAW_NO=?" ;
					 
					 
			
//			String sql2 = "UPDATE CHILDUNDER16  set I_HAWIA_NO=?,C_FIRST_NAME=?," 
//					+ " C_GENDER=?,C_BOD=? where I_HAW_NO=?";
//					 
//	 
//			String sql3 = "UPDATE COUPLES set I_C_HAWIA_NO=?,I_TAS_NO=? ,I_PASS_NO=?," 
//					+ " C_PASS_TYPE=?, C_PREV_FAM_NO=?, C_FULL_NAME=? where I_HAW_NO=?";
					 
			
			Connection conn = ConnectionDB.getConnections();
			PreparedStatement ps= conn.prepareStatement(sql);
//			PreparedStatement ps2= conn.prepareStatement(sql2);
//			PreparedStatement ps3= conn.prepareStatement(sql3);
			
		 	ps.setInt(18, hawiaNo);
		//	ResultSet result = ps.executeQuery();
			
//			ps3.setInt(1, c.getcHawiaNO());
//			ps3.setInt(2, c.getTasrehNumber());
//			ps3.setInt(3, c.getPassportNumber());
//			ps3.setString(4, c.getPassportType());
//			ps3.setString(5, c.getPrevFamilyName());
//			ps3.setString(6, c.getFullName());
//			
//			ps2.setInt(1, cu.getChHawiaNO());
//			ps2.setString(2, cu.getFirstName());		 
//			ps2.setString(3, cu.getGender());
//			ps2.setString(4, cu.getBOD());
			
			ps.setString(1, pf.getHawiaType());
			ps.setString(2, pf.getBod());
			ps.setString(3, pf.getGrandFatherName());
			ps.setString(4,pf.getMotherName());
			ps.setString(5, pf.getPinxNo());
			ps.setInt(6, pf.getHawiaNo());
			//ps.setInt(7, pf.getFormId());
			ps.setInt(7, pf.getCellPhone());
			ps.setString(8, pf.getCurrentAddress());
			ps.setString(9, pf.getFamilyName());
			ps.setString(10, pf.getFatherName());
			ps.setString(11, pf.getFirstName());
			ps.setString(12, pf.getPervFamilyName());
			ps.setInt(13, pf.getTelephoneNumber());
			ps.setString(14, pf.getReligion());
			ps.setString(15, pf.getPlaceOfBirth());
			ps.setString(16, pf.getSocialStatus());
			ps.setString(17, pf.getGender());
			
			st = ps.executeUpdate();
//			st2 = ps2.executeUpdate();
//			st3 = ps3.executeUpdate();
			conn.close();
			ps.close();
//			ps2.close();
//			ps3.close();
			
		}catch(SQLException e) {
			System.out.print("Faild query");
		} finally {
			if (conn != null) {
				try {
					conn.close();
				}catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
		}		
		return st2+st+st3;
		}
	
public static int getHawiaNo(int hawiaNo) {
	Connection conn = ConnectionDB.getConnections();
	int count = 0;
	ParentForm pf = new ParentForm();
	try {PreparedStatement stat = conn.prepareStatement("Select C_BOD,I_CELL_PHONE,C_CURRENT_ADDRESS,C_FAM_NAME,C_FATH_NAME,C_FIRST_NMAE,"
			+ "C_GENDER,I_HAW_NO,C_MOTH_NAME, C_HAW_TYPE,C_PREV_FAM_NAME,I_PINX_O,C_PLACE_OF_BIRTH ,C_REGIN,"
			+ "C_SOCIAL_STATUS,I_TEL_NO,C_GRAND_FATH_NAME from hawiaForm where I_HAW_NO=?;");
			stat.setInt(1, hawiaNo);
			
			ResultSet result = stat.executeQuery();
			while(result.next()) { count++; }
			 
	}catch (SQLException e) {
		System.out.print("failed query" + e.getMessage());
	} 
	
			return count; 
			}
	
public static int delHawiaNo(int hawiaNo) {
	Connection conn = ConnectionDB.getConnections();
	int count = 0;
//	ParentForm pf = new ParentForm();
	try {PreparedStatement stat = conn.prepareStatement("DELETE FROM hawiaForm where I_HAW_NO=?;");
			stat.setInt(1, hawiaNo);
			count++;
			  stat.executeUpdate();
			//while(result.next()) {  }
			 
	}catch (SQLException e) {
		System.out.print("failed query" + e.getMessage());
	} 
	
			return count; 
			}
	
	public static ParentForm getInfoByHawiaNo(int hawiaNo) {
		Connection conn = ConnectionDB.getConnections();
		ParentForm pf = new ParentForm();
		Couple c = new Couple();
		try {PreparedStatement stat = conn.prepareStatement("Select C_BOD,I_CELL_PHONE,C_CURRENT_ADDRESS,C_FAM_NAME,C_FATH_NAME,C_FIRST_NMAE,"
				+ "C_GENDER,I_HAW_NO,C_MOTH_NAME, C_HAW_TYPE,C_PREV_FAM_NAME,I_PINX_O,C_PLACE_OF_BIRTH ,C_REGIN,"
				+ "C_SOCIAL_STATUS,I_TEL_NO,C_GRAND_FATH_NAME from hawiaForm where I_HAW_NO=?;");
				stat.setInt(1, hawiaNo);
				ResultSet result = stat.executeQuery();   
			
			while (result.next()) {
					 
				 pf.setBod(result.getString(1));
				 pf.setCellPhone(result.getInt(2));
				 pf.setCurrentAddress(result.getString(3));
				 pf.setFamilyName(result.getString(4));
				 pf.setFatherName(result.getString(5));
				 pf.setFirstName(result.getString(6));
				 pf.setGender(result.getString(7));
				 pf.setHawiaNo(result.getInt(8));
				 pf.setMotherName(result.getString(9));
				 pf.setHawiaType(result.getString(10));
				 pf.setPervFamilyName(result.getString(11));
				 pf.setPinxNo(result.getString(12));
				 pf.setPlaceOfBirth(result.getString(13));
				 pf.setReligion(result.getString(14));
				 pf.setSocialStatus(result.getString(15));
				 pf.setTelephoneNumber(result.getInt(16));
				 pf.setGrandFatherName(result.getString(17));
				 
			}
		} catch (SQLException e) {
			System.out.print("failed query" + e.getMessage());
		} 
		finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
			
		return pf;
	}
	
	
//	public static ParentForm getAllHawiaNos() {
//		
//		ParentForm pf = new ParentForm();
//		Connection conn = ConnectionDB.getConnections();
//		
//		String sql = "Select C_CURRENT_ADDRESS,C_FAM_NAME,I_CELL_PHONE,C_FATH_NAME,C_FIRST_NMAE from hawiaForm";
//		
//		try {
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ResultSet result = ps.executeQuery();
//			
//			while(result.next()) {
//				 pf = new ParentForm();
//				 
//				 pf.setCurrentAddress(result.getString(1));
//				 pf.setFamilyName(result.getString(2));
//				 pf.setCellPhone(result.getInt(3));
//				 pf.setFatherName(result.getString(4));
//				 pf.setFirstName(result.getString(5));
//				 
//				 System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getInt(3)+" "+result.getString(4)+" "+result.getString(5));
//				 
//			//	data.add(new ParentForm(result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getInt(5)));
//				 
//			}
//			conn.close();
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//				
//		return pf; 
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static int saveNewChildInfo(ChildUnder16 cu) {
		
		int st4 = 0;
	 
		try {
		 
			String sql4 = "insert into childunder16 (hawiaNO,firstName ," 
					+ " gender, BOD"
					+ " ) "
					+ " values(?,?,?,?)";
		 
			Connection conn = ConnectionDB.getConnections();
			 
			PreparedStatement ps4= conn.prepareStatement(sql4);
		 		
			ps4.setInt(1, cu.getHawiaNo());
			ps4.setString(2, cu.getFirstName());		 
			ps4.setString(3, cu.getGender());
			ps4.setString(4, cu.getBOD());
				
			st4 = ps4.executeUpdate();
		 
			conn.close();
			ps4.close();
		 			
		}catch(SQLException e) {
			System.out.print("Faild query");
		} finally {
			if (conn != null) {
				try {
					conn.close();
				}catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
		}		
		return st4 ;
		}
	
	
public static int saveNewCoupleInfo(Couple c) {
		
		int st5 = 0;
	 
		try {
		 
			String sql5 = "insert into couples (cHawiaNO,tasrehNumber ,passportNumber," 
					+ " passportType, prevFamilyName, fullName"
					+ " ) "
					+ " values(?,?,?,?,?,?)";
		 
			Connection conn = ConnectionDB.getConnections();
			 
			PreparedStatement ps5= conn.prepareStatement(sql5);
		 		
			ps5.setInt(1, c.getHawiaNo());
			ps5.setInt(2, c.getTasrehNumber());
			ps5.setInt(3, c.getPassportNumber());
			ps5.setString(4, c.getPassportType());
			ps5.setString(5, c.getPrevFamilyName());
			ps5.setString(6, c.getFullName());
				
			st5 = ps5.executeUpdate();
		 
			conn.close();
			ps5.close();
		 			
		}catch(SQLException e) {
			System.out.print("Faild query");
		} finally {
			if (conn != null) {
				try {
					conn.close();
				}catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
		}		
		return st5 ;
		}
	
}
