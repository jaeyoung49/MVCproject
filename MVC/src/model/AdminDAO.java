package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

public class AdminDAO {
	private static AdminDAO dao = new AdminDAO();
	private DataSource dataSource;

	private AdminDAO() {
		dataSource = DataSourceManager.getInstance().getDataSource();
	}

	public static AdminDAO getInstance() {
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

	// 메인 동영상 시퀀스
	// 글 게시시 시퀀스 번호 반환
	public int seq_number() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int a_no = 0;
		try {
			con = getConnection();
			pstmt = con.prepareStatement("select videourl_seq.nextval from dual");
			rs = pstmt.executeQuery();
			if (rs.next())
				a_no = rs.getInt(1);
		} finally {
			closeAll(rs, pstmt, con);
		}
		return a_no;
	}

	// 메인 동영상 등록하기
	public void sa_VideoUrlUpLoad(VideoDTO dto) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			String sql = "insert into videourl(no,title,url_info,url_link,regdate) values(?,?,?,?,sysdate)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dto.getNo());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getUrl_info());
			pstmt.setString(4, dto.getUrl_link());
			pstmt.executeUpdate();
		} finally {
			closeAll(pstmt, con);
		}
	}

	// 동영상 리스트
	public ArrayList<VideoDTO> sa_VideoUrlList() throws SQLException {
		ArrayList<VideoDTO> arr = new ArrayList<VideoDTO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String sql = "select	no,title,url_info,url_link,to_char(regdate,'yyyy-mm-dd') from videourl order by regdate desc";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				arr.add(new VideoDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
			}
		} finally {
			closeAll(pstmt, con);
		}
		return arr;
	}

	// 공지글 리스트 조회
	public ListDTO noticeList(String nowPage) throws SQLException {
		ListDTO ldto = new ListDTO();
		int page = 1;
		PagingBean pb = null;
		int totalContents = BoardDAO.getInstance().noticeTotalContents();
		if (nowPage != null) {
			page = Integer.parseInt(nowPage);
			pb = new PagingBean(totalContents, page);
		} else {
			pb = new PagingBean(totalContents);
		}
		ArrayList<ArrayList<NoticeDTO>> nlist = new ArrayList<ArrayList<NoticeDTO>>();
		nlist.add(BoardDAO.getInstance().noticeList(pb));
		nlist.add(BoardDAO.getInstance().noticePriorityList());
		ldto.setNlist(nlist);
		ldto.setPagingBean(pb);
		return ldto;
	}

	public void sa_noticeDelete(int a_no) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			String sql = "delete from notice where a_no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, a_no);
			pstmt.executeQuery();
			pstmt.close();
			sql = "delete from article where a_no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, a_no);
			pstmt.executeQuery();

		} finally {
			closeAll(pstmt, con);
		}
	}

	// 후기글 정보 삭제
	public void sa_epilogueDelete(int a_no) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			String sql = "delete from epilogue where a_no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, a_no);
			pstmt.executeQuery();
			pstmt.close();
			sql = "delete from article where a_no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, a_no);
			pstmt.executeQuery();

		} finally {
			closeAll(pstmt, con);
		}
	}

	// 회원 등급 변경
	public void sa_memberGradeChange(int m_gradeno, String id) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			String sql = "update member set m_gradeno=? where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, m_gradeno);
			pstmt.setString(2, id);
			pstmt.executeUpdate();
		} finally {
			closeAll(pstmt, con);
		}
	}

	// 회원탈퇴
	public void sa_memberDelete(String id) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			String sql = "delete from member where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} finally {
			closeAll(pstmt, con);
		}
	}

	// 후기글 리스트 조회(SA)
	public ArrayList<EpilogueDTO> sa_epilogueList() throws SQLException {
		ArrayList<EpilogueDTO> arr = new ArrayList<EpilogueDTO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String sql = "select a.a_no,a.a_title,m.nickname,to_char(a.a_regdate,'yyyy-mm-dd'),a.hit from article a, member m where a.id=m.id and a_c_no=1 order by a_no desc";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				arr.add(new EpilogueDTO(new MemberDTO(rs.getString(3)),
						new ArticleDTO(rs.getInt(1), rs.getString(2), rs.getString(4), rs.getInt(5))));
			}
		} finally {
			closeAll(pstmt, con);
		}
		return arr;
	}

	// 회원 totalCount
	public int memberTotalContents() throws SQLException {
		int memberTotalCount = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String sql = "select count(*) from member";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				memberTotalCount = rs.getInt(1);
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		return memberTotalCount;
	}

	// 회원 리스트
	public ArrayList<MemberDTO> sa_memberList(PagingBean pb) throws SQLException {
		ArrayList<MemberDTO> arr = new ArrayList<MemberDTO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String sql = "select m.id, m.m_name, m.sex, m.email, m.nickname, to_char(m.m_regdate, 'yyyy-mm-dd') as \"date\", "
					+ "m.a_count, m.r_count, m.m_gradeno, g.m_grade_name " + "from member m, m_grade g "
					+ "where m.m_gradeno=g.m_gradeno";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next())
				arr.add(new MemberDTO(rs.getString("id"), rs.getString("m_name"), rs.getString("sex"),
						rs.getString("email"), rs.getString("nickname"), rs.getString("date"), rs.getInt("a_count"),
						rs.getInt("r_count"), rs.getInt("m_gradeno"), rs.getString("m_grade_name")));
		} finally {
			closeAll(rs, pstmt, con);
		}
		return arr;
	}
}
