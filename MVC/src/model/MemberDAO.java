package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class MemberDAO {
	private static MemberDAO dao = new MemberDAO();
	private DataSource dataSource;

	private MemberDAO() {
		dataSource = DataSourceManager.getInstance().getDataSource();
	}

	public static MemberDAO getInstance() {
		return dao;
	}

	public Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}

	public void closeAll(PreparedStatement pstmt, Connection con) throws SQLException {
		if (pstmt != null)
			pstmt.close();
		if (con != null)
			con.close();
	}

	public void closeAll(ResultSet rs, PreparedStatement pstmt, Connection con) throws SQLException {
		if (rs != null)
			rs.close();
		closeAll(pstmt, con);
	}

	// 회원가입
	public void join(MemberDTO dto) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "insert into member(id,pw,m_name,sex,email,nickname,birthday,m_regdate) values(?,?,?,?,?,?,?,sysdate)";
		try {
			con = MemberDAO.getInstance().getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getM_name());
			pstmt.setString(4, dto.getSex());
			pstmt.setString(5, dto.getEmail());
			pstmt.setString(6, dto.getNickname());
			pstmt.setString(7, dto.getBirthday());
			pstmt.executeQuery();
		} finally {
			closeAll(pstmt, con);
		}
	}

	// 로그인
	public MemberDTO login(String id, String pw) throws SQLException {
		MemberDTO dto = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select m.m_name,m.nickname,g.m_grade_name from m_grade g,member m where id=? and pw=? and g.m_gradeno=m.m_gradeno";
		try {
			con = MemberDAO.getInstance().getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			if (rs.next())
				dto = new MemberDTO(id, rs.getString(1), rs.getString(2), rs.getString(3));
			System.out.println(dto);
		} finally {
			closeAll(rs, pstmt, con);
		}
		return dto;
	}

	// 회원가입시 중복 아이디 찾기
	public MemberDTO findById(String id) throws SQLException {
		MemberDTO dto = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String sql = "select id, nickname from member where id =?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto = new MemberDTO(id, rs.getString(2));
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		System.out.println(dto);
		return dto;
	}

	// 개인정보 수정시 정보 불러오기
	public MemberDTO findMyInfo(String id) throws SQLException {
		MemberDTO dto = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String sql = "select id,pw,m_name,sex,email,nickname,birthday from member where id =?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto = new MemberDTO(id, rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7));
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		System.out.println("개인정보수정 :" + dto);
		return dto;
	}

	// 개인정보 수정
	public void changeMyInfo(MemberDTO dto) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			String sql = "update member set nickname=? ,email=?,birthday=? where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getNickname());
			pstmt.setString(2, dto.getEmail());
			pstmt.setString(3, dto.getBirthday());
			pstmt.setString(4, dto.getId());
			pstmt.executeUpdate();
		} finally {
			closeAll(pstmt, con);
		}
	}
}
