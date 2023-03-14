package example1230.service;

import java.security.interfaces.RSAKey;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

import example1230.dbconn.Dbconn;
import example1230.domain.BoardVo;

public class BoardDao {

	
	Connection conn;
	
	public BoardDao() {
		Dbconn dbconn = new Dbconn();
	conn=	dbconn.getConnection();
		
	}
	
	public ArrayList<BoardVo>boardSelectAll(){
		ArrayList<BoardVo> blist = new ArrayList<BoardVo>();
		
		
		String sql ="select * from board1230 where delyn='n' order by bidx desc";
		PreparedStatement pstmt=null;
		ResultSet rs= null;
		try {
			pstmt=conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
			BoardVo bv = new BoardVo();	
			bv.setBidx(rs.getInt("bidx"));
			bv.setSubject(rs.getString("subject"));
			bv.setWriter(rs.getString("writer"));
			bv.setWriteday(rs.getNString("writeday"));
			blist.add(bv);
			}
			
			}catch (SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					rs.close();
					pstmt.close();
					conn.close();
					
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		return blist;
	}
	
	
}
