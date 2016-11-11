package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

public class BoardDAO {
	private static BoardDAO dao = new BoardDAO();
	private DataSource dataSource;

	private BoardDAO() {
		dataSource = DataSourceManager.getInstance().getDataSource();
	}

	public static BoardDAO getInstance() {
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

	// 글 게시시 시퀀스 번호 반환
	public int seq_number() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int a_no = 0;
		try {
			con = getConnection();
			pstmt = con.prepareStatement("select seq_article.nextval from dual");
			rs = pstmt.executeQuery();
			if (rs.next())
				a_no = rs.getInt(1);

		} finally {
			closeAll(rs, pstmt, con);
		}
		return a_no;
	}

	// 글 게시시 공통부분 등록글
	public void articleReg(EpilogueDTO dto) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String sql = "insert into article(a_no,a_title,id,a_content,a_regdate,a_c_no) values(?,?,?,?,sysdate,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dto.getArticleDTO().getA_no());
			pstmt.setString(2, dto.getArticleDTO().getA_title());
			pstmt.setString(3, dto.getArticleDTO().getId());
			pstmt.setString(4, dto.getArticleDTO().getA_content());
			pstmt.setInt(5, dto.getArticleDTO().getA_c_no());
			pstmt.executeUpdate();
		} finally {
			closeAll(rs, pstmt, con);
		}
	}

	// 후기글의 별도의 저장정보
	public void epilogueReg(EpilogueDTO dto) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			String sql = "insert into Epilogue(a_no, c_c_no,image_path, file_name,file_ext) values(?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dto.getArticleDTO().getA_no());
			pstmt.setInt(2, dto.getC_c_no());
			pstmt.setString(3, dto.getImage_path());
			pstmt.setString(4, dto.getFile_name());
			pstmt.setString(5, dto.getFile_ext());
			pstmt.executeUpdate();
		} finally {
			closeAll(pstmt, con);
		}
	}

	// 리스트 조회시 글넘버 제목 닉네임 작성일 조회수
	public ArrayList<EpilogueDTO> epilogueList() throws SQLException {
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

	// 리스트 조회시 카테고리로 검색
	public ArrayList<EpilogueDTO> epilogueListByCategory(int c_c_no) throws SQLException {
		ArrayList<EpilogueDTO> arr = new ArrayList<EpilogueDTO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		System.out.println(c_c_no);
		try {
			con = getConnection();
			String sql = "select a.a_no, a.a_title, m.nickname, to_char(a.a_regdate,'yyyy-mm-dd'), a.hit, c.c_c_name from member m, article a, epilogue e, c_category c where m.id=a.id and a.a_no=e.a_no and e.c_c_no=c.c_c_no and a.a_c_no=1 and e.c_c_no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, c_c_no);
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

	// 후기 게시글 삭제
	public void epilogueDel(int a_no) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		con = getConnection();
		try {
			pstmt = con.prepareStatement("delete epilogue where a_no=?");
			pstmt.setInt(1, a_no);
			pstmt.executeQuery();
			pstmt.close();
			String sql = "delete article where a_no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, a_no);
			pstmt.executeQuery();
		} finally {
			closeAll(pstmt, con);
		}
	}

	// 후기 게시글 수정
	public void epilogueUpdate(EpilogueDTO EpDto) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		con = getConnection();
		try {
			pstmt = con.prepareStatement("update epilogue set c_c_no=?, file_name=?, file_ext=? where a_no=?");
			pstmt.setInt(1, EpDto.getC_c_no());
			pstmt.setString(2, EpDto.getFile_name());
			pstmt.setString(3, EpDto.getFile_ext());
			pstmt.setInt(4, EpDto.getArticleDTO().getA_no());
			pstmt.executeQuery();
			pstmt.close();
			String sql = "update article set a_title=?, a_content=? where a_no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, EpDto.getArticleDTO().getA_title());
			pstmt.setString(2, EpDto.getArticleDTO().getA_content());
			pstmt.setInt(3, EpDto.getArticleDTO().getA_no());
			pstmt.executeQuery();
		} finally {
			closeAll(pstmt, con);
		}
	}

	// 글 번호로 화장품 카테고리명 출력 cosmetic_category
	public String findCategoryNameByA_no(int a_no) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String name = null;
		try {
			con = getConnection();
			String sql = "select c_c_name from c_category where c_c_no=(select c_c_no from EPILOGUE where a_no = ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, a_no);
			rs = pstmt.executeQuery();
			if (rs.next())
				name = rs.getString("c_c_name");
		} finally {
			closeAll(rs, pstmt, con);
		}
		return name;
	}

	// 글 번호로 후기글 상세 정보
	public ArrayList<EpilogueDTO> epilogueDetail(int a_no) throws SQLException {
		ArrayList<EpilogueDTO> aList = new ArrayList<EpilogueDTO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String sql = "select m.nickname, a.a_title, a.id, a.a_content, to_char(a.a_regdate, 'yyyy.mm.dd hh24:mi:ss') as \"date\", "
					+ "a.hit, c.c_c_no, e.image_path, e.file_name, e.file_ext "
					+ "from member m, article a, epilogue e ,c_category c "
					+ "where m.id=a.id and a.a_no=e.a_no and e.c_c_no=c.c_c_no and a.a_no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, a_no);
			rs = pstmt.executeQuery();
			if (rs.next())
				aList.add(new EpilogueDTO(new MemberDTO(rs.getString("nickname")),
						new ArticleDTO(rs.getString("a_title"), rs.getString("id"), rs.getString("a_content"),
								rs.getInt("hit"), rs.getString("date")),
						rs.getInt("c_c_no"), rs.getString("image_path"), rs.getString("file_name"),
						rs.getString("file_ext")));
		} finally {
			closeAll(rs, pstmt, con);
		}
		return aList;
	}

	// 공지 글 totalContents
	public int noticeTotalContents() throws SQLException {
		int noticeTotalContents = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String sql = "select count(*) from ARTICLE where a_c_no=2";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				noticeTotalContents = rs.getInt(1);
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		return noticeTotalContents;
	}

	// 공지 게시글 리스트
	public ArrayList<NoticeDTO> noticeList(PagingBean pb) throws SQLException {
		ArrayList<NoticeDTO> arr = new ArrayList<NoticeDTO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String sql = "select rnum, no, title, a_date, hit, priority " + "from("
					+ "select row_number() over(order by a.a_no desc) as rnum, a.a_no as no, a.a_title as title, "
					+ "to_char(a.a_regdate,'yyyy-mm-dd') as a_date, a.hit as hit, n.priority as priority "
					+ "from article a, notice n " + "where a.a_no=n.a_no and a_c_no=2) " + "where rnum between ? and ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pb.getStartRowNumber());
			pstmt.setInt(2, pb.getEndRowNumber());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				arr.add(new NoticeDTO(new ArticleDTO(rs.getInt("no"), rs.getString("title"), rs.getString("a_date"),
						rs.getInt("hit")), rs.getInt("priority")));
			}
		} finally {
			closeAll(pstmt, con);
		}
		return arr;
	}

	// 상위 공지 글 리스트
	public ArrayList<NoticeDTO> noticePriorityList() throws SQLException {
		ArrayList<NoticeDTO> arr = new ArrayList<NoticeDTO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String sql = "select rnum, no, title, a_date, hit, priority " + "from("
					+ "select row_number() over(order by a.a_no desc) as rnum, a.a_no as no, a.a_title as title, "
					+ "to_char(a.a_regdate,'yyyy-mm-dd') as a_date, a.hit as hit, n.priority as priority "
					+ "from article a, notice n " + "where a.a_no=n.a_no and a_c_no=2) " + "where priority=1";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				arr.add(new NoticeDTO(new ArticleDTO(rs.getInt("no"), rs.getString("title"), rs.getString("a_date"),
						rs.getInt("hit")), rs.getInt("priority")));
			}
		} finally {
			closeAll(pstmt, con);
		}
		return arr;
	}

	// 글 번호로 공지글 상세 정보
	public NoticeDTO noticeDetail(int a_no) throws SQLException {
		NoticeDTO nDto = new NoticeDTO();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String sql = "select m.nickname as nickname, a.a_title as title, a.id as id, a.a_content as content, "
					+ "to_char(a.a_regdate, 'yyyy.mm.dd hh24:mi:ss') as \"date\", a.hit as hit, n.priority as priority "
					+ "from member m, article a, notice n " + "where m.id=a.id and a.a_no=n.a_no and a.a_no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, a_no);
			rs = pstmt.executeQuery();
			if (rs.next())
				nDto = new NoticeDTO(
						new MemberDTO(rs.getString("nickname")), new ArticleDTO(rs.getString("title"),
								rs.getString("id"), rs.getString("content"), rs.getInt("hit"), rs.getString("date")),
						rs.getInt("priority"));
		} finally {
			closeAll(rs, pstmt, con);
		}
		return nDto;
	}

	// 글 번호로 공지글 삭제
	// 후기 게시글 삭제
	public void noticeDel(int a_no) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		con = getConnection();
		try {
			pstmt = con.prepareStatement("delete notice where a_no=?");
			pstmt.setInt(1, a_no);
			pstmt.executeQuery();
			pstmt.close();
			String sql = "delete article where a_no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, a_no);
			pstmt.executeQuery();
		} finally {
			closeAll(pstmt, con);
		}
	}

	// 글 게시시 공통부분 등록글
	public void articleReg(NoticeDTO dto) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String sql = "insert into article(a_no,a_title,id,a_content,a_regdate,a_c_no) values(?,?,?,?,sysdate,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dto.getArticleDTO().getA_no());
			pstmt.setString(2, dto.getArticleDTO().getA_title());
			pstmt.setString(3, dto.getArticleDTO().getId());
			pstmt.setString(4, dto.getArticleDTO().getA_content());
			pstmt.setInt(5, dto.getArticleDTO().getA_c_no());
			pstmt.executeUpdate();
		} finally {
			closeAll(rs, pstmt, con);
		}
	}

	// 공지글의 별도의 저장정보
	public void noticeReg(NoticeDTO dto) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			String sql = "insert into Notice(a_no, priority) values(?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dto.getArticleDTO().getA_no());
			pstmt.setInt(2, dto.getPriority());
			pstmt.executeUpdate();
		} finally {
			closeAll(pstmt, con);
		}
	}

	// 글 수정시 공통부분 수정
	public void articleUpdate(NoticeDTO dto) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String sql = "update article set a_title=?, id=?, a_content=?, a_regdate=sysdate where a_no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getArticleDTO().getA_title());
			pstmt.setString(2, dto.getArticleDTO().getId());
			pstmt.setString(3, dto.getArticleDTO().getA_content());
			pstmt.setInt(4, dto.getArticleDTO().getA_no());
			pstmt.executeUpdate();
		} finally {
			closeAll(rs, pstmt, con);
		}
	}

	// 공지글의 별도의 저장정보 수정
	public void noticeUpdate(NoticeDTO dto) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			String sql = "update Notice set priority=? where a_no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dto.getPriority());
			pstmt.setInt(2, dto.getArticleDTO().getA_no());
			pstmt.executeUpdate();
		} finally {
			closeAll(pstmt, con);
		}
	}

	// 뷰티 카테고리 번호 및 이름 반환(후기글 작성시)
	public ArrayList<C_Category> c_Category() throws SQLException {
		ArrayList<C_Category> list = new ArrayList<C_Category>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		con = getConnection();
		try {
			String sql = "select c_c_no,c_c_name from c_category";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next())
				list.add(new C_Category(rs.getInt(1), rs.getString(2)));
		} finally {
			closeAll(rs, pstmt, con);
		}
		return list;
	}

	// 후기글 검색하기
	// select a.a_no, a.a_title, m.nickname, to_char(a.a_regdate,'yyyy-mm-dd')
	// as "date", a.hit, c.c_c_name from member m, article a, epilogue e,
	// c_category c
	// where m.id=a.id and a.a_no=e.a_no and e.c_c_no=c.c_c_no and a.a_c_no=1
	// and (a.a_content LIKE '%?%')
	public ArrayList<EpilogueDTO> epilogueListByKeyWord(String option, String KeyWord) throws SQLException {
		ArrayList<EpilogueDTO> arr = new ArrayList<EpilogueDTO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		System.out.println(option);
		if (option.equals("1")) {
			option = "a.a_title";
		} else if (option.equals("2")) {
			option = "a.a_content";
		} else if (option.equals("3")) {
			option = "a.a_no";
		} else {
			option = "m.nickname";
		}
		System.out.println(option);
		try {
			con = getConnection();
			String sql = "select a.a_no, a.a_title, m.nickname, to_char(a.a_regdate,'yyyy-mm-dd'), a.hit, c.c_c_name from member m, article a, epilogue e, c_category c where m.id=a.id and a.a_no=e.a_no and e.c_c_no=c.c_c_no and a.a_c_no=1 and ("
					+ option + " LIKE '%" + KeyWord + "%')";
			System.out.println(sql);
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

	// 조회수 1증가 메서드
	public void updateHit(int a_no) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement("update article set hit=hit+1 where a_no=?");
			pstmt.setInt(1, a_no);
			pstmt.executeUpdate();
		} finally {
			closeAll(pstmt, con);
		}
	}

	// 조회수 1증가 메서드
	public void memberA_Count(String id) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement("update member set a_count=a_count+1 where id=?");
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} finally {
			closeAll(pstmt, con);
		}
	}
	
	// QnA 글 totalContents
		public int qnaTotalContents() throws SQLException {
			int qnaTotalContents = 0;
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = getConnection();
				String sql = "select count(*) from ARTICLE where a_c_no=3";
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					qnaTotalContents = rs.getInt(1);
				}
			} finally {
				closeAll(rs, pstmt, con);
			}
			return qnaTotalContents;
		}

		
		
		
		
		
		// QnA 게시글 리스트
		public ArrayList<QnADTO> qnaList(PagingBean pb) throws SQLException {
			ArrayList<QnADTO> arr = new ArrayList<QnADTO>();
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = getConnection();
				String sql = "select rnum, a_no, a_title, a_date, hit, id "
						+ "from("
						+ "select row_number() over(order by a_no desc) as rnum, a_no, a_title, id, "
						+ "to_char(a_regdate,'yyyy-mm-dd') as a_date, hit "
						+ "from article "
						+ "where a_c_no=3) "
						+ "where rnum between ? and ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, pb.getStartRowNumber());
				pstmt.setInt(2, pb.getEndRowNumber());
				rs = pstmt.executeQuery();
				while (rs.next()) {
					ArticleDTO adto = new ArticleDTO(rs.getInt("a_no"), rs.getString("a_title"), rs.getString("a_date"),
							rs.getInt("hit"));
					adto.setId(rs.getString("id"));
					arr.add(new QnADTO(adto));
				}
			} finally {
				closeAll(pstmt, con);
			}
			return arr;
		}
		
		
		// 글 번호로 QnA 상세 정보
		public QnADTO qnaDetail(int a_no) throws SQLException {
			QnADTO qDto = new QnADTO();
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = getConnection();
				String sql = "select m.nickname as nickname, a.a_title as title, a.id as id, a.a_content as content, "
						+ "to_char(a.a_regdate, 'yyyy.mm.dd hh24:mi:ss') as \"date\", a.hit as hit "
						+ "from member m, article a "
						+ "where m.id=a.id and a.a_no=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, a_no);
				rs = pstmt.executeQuery();
				if (rs.next())
					qDto =new QnADTO(new MemberDTO(rs.getString("nickname")),
							new ArticleDTO(rs.getString("title"), rs.getString("id"), rs.getString("content"),
									rs.getString("date"), rs.getInt("hit")));
			} finally {
				closeAll(rs, pstmt, con);
			}
			return qDto;
		}
		
		

		// 글 번호로 QnA 삭제
		// QnA 게시글 삭제
		public void qnaDel(int a_no) throws SQLException {
			Connection con = null;
			PreparedStatement pstmt = null;
			con = getConnection();
			try {
				pstmt = con.prepareStatement("delete article where a_no=?");
				pstmt.setInt(1, a_no);
				pstmt.executeQuery();
			} finally {
				closeAll(pstmt, con);
			}
		}
		
		
		// 글 게시시 공통부분 등록글
		public void articleReg(QnADTO dto) throws SQLException {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = getConnection();
				String sql = "insert into article(a_no,a_title,id,a_content,a_regdate,a_c_no) values(?,?,?,?,sysdate,?)";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, dto.getArticleDTO().getA_no());
				pstmt.setString(2, dto.getArticleDTO().getA_title());
				pstmt.setString(3, dto.getArticleDTO().getId());
				pstmt.setString(4, dto.getArticleDTO().getA_content());
				pstmt.setInt(5, dto.getArticleDTO().getA_c_no());
				pstmt.executeUpdate();
			} finally {
				closeAll(rs, pstmt, con);
			}
		}
		
		// 글 수정시 공통부분 수정
		public void articleUpdate(QnADTO dto) throws SQLException {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = getConnection();
				String sql = "update article set a_title=?, id=?, a_content=?, a_regdate=sysdate where a_no=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, dto.getArticleDTO().getA_title());
				pstmt.setString(2, dto.getArticleDTO().getId());
				pstmt.setString(3, dto.getArticleDTO().getA_content());
				pstmt.setInt(4, dto.getArticleDTO().getA_no());
				pstmt.executeUpdate();
			} finally {
				closeAll(rs, pstmt, con);
			}
		}
		
		
		// 해당글 댓글 totalContents
			public int replyTotalContents(int a_no) throws SQLException {
				int replyTotalContents = 0;
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				try {
					con = getConnection();
					String sql = "select count(*) from reply where a_no=?";
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, a_no);
					rs = pstmt.executeQuery();
					if (rs.next()) {
						replyTotalContents = rs.getInt(1);
					}
				} finally {
					closeAll(rs, pstmt, con);
				}
				return replyTotalContents;
			}
		
		
		// 댓글 리스트
		public ArrayList<ReplyDTO> replyList(int a_no, PagingBean pb) throws SQLException {
			ArrayList<ReplyDTO> arr = new ArrayList<ReplyDTO>();
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = getConnection();
				String sql = "select rnum, id, r_no, r_content, a_date "
						+ "from("
						+ "select row_number() over(order by a_no desc) as rnum, id, r_no, r_content, "
						+ "to_char(r_regdate,'yyyy-mm-dd') as a_date "
						+ "from reply "
						+ "where a_no=?) "
						+ "where rnum between ? and ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, a_no);
				pstmt.setInt(2, pb.getStartRowNumber());
				pstmt.setInt(3, pb.getEndRowNumber());
				rs = pstmt.executeQuery();
				while (rs.next()) {
					MemberDTO mdto = new MemberDTO();
					mdto.setId(rs.getString("id"));
					ReplyDTO rdto = new ReplyDTO(rs.getInt("r_no"), a_no, rs.getString("a_date"), rs.getString("r_content"), mdto);
					arr.add(rdto);
				}
			} finally {
				closeAll(pstmt, con);
			}
			return arr;
		}
		
		// 글 게시시 시퀀스 번호 반환
			public int seq_number_reply() throws SQLException {
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				int a_no = 0;
				try {
					con = getConnection();
					pstmt = con.prepareStatement("select seq_reply.nextval from dual");
					rs = pstmt.executeQuery();
					if (rs.next())
						a_no = rs.getInt(1);

				} finally {
					closeAll(rs, pstmt, con);
				}
				return a_no;
			}
			
		// 댓글 등록
		public void replyReg(ReplyDTO dto) throws SQLException{
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = getConnection();
				String sql = "insert into reply(a_no, r_regdate, r_content, id, r_no) values(?, sysdate, ?, ?, ?)";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, dto.getA_no());
				pstmt.setString(2, dto.getR_content());
				pstmt.setString(3, dto.getMemberDTO().getId());
				pstmt.setInt(4, dto.getR_no());
				pstmt.executeUpdate();
			} finally {
				closeAll(rs, pstmt, con);
			}
		}
}
