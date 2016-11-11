package model;

import java.sql.SQLException;
import java.util.ArrayList;

public class sa_MvcService {
	private static sa_MvcService ms = new sa_MvcService();

	public static sa_MvcService getInstance() {
		return ms;
	}

	public void sa_VideoUrlUpLoad(VideoDTO dto) throws SQLException {
		int no = AdminDAO.getInstance().seq_number();
		dto.setNo(no);
		AdminDAO.getInstance().sa_VideoUrlUpLoad(dto);
	}

	public ArrayList<VideoDTO> sa_VideoUrlList() throws SQLException {
		ArrayList<VideoDTO> list = new ArrayList<VideoDTO>();
		list = AdminDAO.getInstance().sa_VideoUrlList();
		return list;
	}

	public MemberDTO login(String id, String pw) throws SQLException {
		MemberDTO dto = null;
		dto = MemberDAO.getInstance().login(id, pw);
		return dto;
	}

	public void sa_noticeDelete(int a_no) throws SQLException {
		AdminDAO.getInstance().sa_noticeDelete(a_no);
	}

	// 관리자 페이지 후기 게시글 삭제
	public void sa_epilogueDelete(int a_no) throws SQLException {
		AdminDAO.getInstance().sa_epilogueDelete(a_no);
	}

	// 관리자 페이지 후기글 조회
	public ArrayList<EpilogueDTO> sa_epilogueList() throws SQLException {
		ArrayList<EpilogueDTO> list = new ArrayList<EpilogueDTO>();
		list = AdminDAO.getInstance().sa_epilogueList();
		return list;
	}

	// 관리자 멤버 리스트
	public ListDTO sa_MemberList(String nowPage) throws SQLException {
		ListDTO ldto = new ListDTO();
		int page = 1;
		PagingBean pb = null;
		int totalContents = AdminDAO.getInstance().memberTotalContents();
		if (nowPage != null) {
			page = Integer.parseInt(nowPage);
			pb = new PagingBean(totalContents, page);
		} else {
			pb = new PagingBean(totalContents);
		}
		ArrayList<MemberDTO> mlist = new ArrayList<MemberDTO>();
		mlist = AdminDAO.getInstance().sa_memberList(pb);
		ldto.setMlist(mlist);
		ldto.setPagingBean(pb);
		return ldto;
	}

	public void sa_memberDelete(String id) throws SQLException {
		AdminDAO.getInstance().sa_memberDelete(id);
	}

	public void sa_memberGradeChange(int m_gradeno, String id) throws SQLException {
		AdminDAO.getInstance().sa_memberGradeChange(m_gradeno, id);
	}
}
