package model;

import java.sql.SQLException;
import java.util.ArrayList;

public class MvcService {
	private static MvcService ms = new MvcService();

	public static MvcService getInstance() {
		return ms;
	}

	public void join(MemberDTO dto) throws SQLException {
		MemberDAO.getInstance().join(dto);
	}

	// 후기글 작성
	public void epilogueReg(EpilogueDTO dto) throws SQLException {
		int a_no = BoardDAO.getInstance().seq_number();
		dto.getArticleDTO().setA_no(a_no);
		BoardDAO.getInstance().articleReg(dto);
		BoardDAO.getInstance().memberA_Count(dto.getArticleDTO().getId());
		BoardDAO.getInstance().epilogueReg(dto);
	}

	// 로그인 서비스
	public MemberDTO login(String id, String pw) throws SQLException {
		MemberDTO dto = null;
		dto = MemberDAO.getInstance().login(id, pw);
		return dto;
	}

	// 후기글 조회
	public ArrayList<EpilogueDTO> EpilogueList() throws SQLException {
		ArrayList<EpilogueDTO> arr = new ArrayList<EpilogueDTO>();
		arr = BoardDAO.getInstance().epilogueList();
		return arr;
	}

	// 후기글 상세 + 조회수 증가 O
	public ArrayList<EpilogueDTO> epilogueDetail(int a_no) throws SQLException {
		ArrayList<EpilogueDTO> arr = new ArrayList<EpilogueDTO>();
		BoardDAO.getInstance().updateHit(a_no);
		arr = BoardDAO.getInstance().epilogueDetail(a_no);
		return arr;
	}

	// 후기글 상세 + 조회수 증가 X
	public ArrayList<EpilogueDTO> epilogueDetailNoHit(int a_no) throws SQLException {
		ArrayList<EpilogueDTO> arr = new ArrayList<EpilogueDTO>();
		arr = BoardDAO.getInstance().epilogueDetail(a_no);
		return arr;
	}

	// 후기글 삭제
	public void epilogueDel(int a_no) throws SQLException {
		BoardDAO.getInstance().epilogueDel(a_no);
	}

	// 후기글 수정
	public void epilogueUpdate(EpilogueDTO EpDto) throws SQLException {
		BoardDAO.getInstance().epilogueUpdate(EpDto);
	}

	// 화장품 카테고리 명 정보
	public String findCategoryNameByA_no(int a_no) throws SQLException {
		String c_c_name = BoardDAO.getInstance().findCategoryNameByA_no(a_no);
		return c_c_name;
	}

	// 공지글 리스트
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

	// 공지글 상세
	public NoticeDTO noticeDetail(int a_no) throws SQLException {
		NoticeDTO nDto = new NoticeDTO();
		BoardDAO.getInstance().updateHit(a_no);
		nDto = BoardDAO.getInstance().noticeDetail(a_no);
		nDto.getArticleDTO().setA_no(a_no);
		return nDto;
	}

	// 공지글 상세 ( 조회X)
	public NoticeDTO noticeDetailNoHit(int a_no) throws SQLException {
		NoticeDTO nDto = new NoticeDTO();
		nDto = BoardDAO.getInstance().noticeDetail(a_no);
		nDto.getArticleDTO().setA_no(a_no);
		return nDto;
	}

	// 공지글 삭제
	public void noticeDelete(int a_no) throws SQLException {
		BoardDAO.getInstance().noticeDel(a_no);
	}

	// 공지글 작성
	public void noticeReg(NoticeDTO dto) throws SQLException {
		int a_no = BoardDAO.getInstance().seq_number();
		dto.getArticleDTO().setA_no(a_no);
		BoardDAO.getInstance().articleReg(dto);
		BoardDAO.getInstance().noticeReg(dto);
	}

	// 공지글 수정
	public void noticeUpdate(NoticeDTO dto) throws SQLException {
		BoardDAO.getInstance().articleUpdate(dto);
		BoardDAO.getInstance().noticeUpdate(dto);
	}
	// 뷰티 카테고리 번호 및 이름 반환(후기글 작성시)

	// 후기글 카테고리로 리스트 재검색
	public ArrayList<EpilogueDTO> epilogueListByCategory(int c_c_no) throws SQLException {
		ArrayList<EpilogueDTO> arr = new ArrayList<EpilogueDTO>();
		arr = BoardDAO.getInstance().epilogueListByCategory(c_c_no);
		return arr;
	}

	// 검색어로 검색하기
	public ArrayList<EpilogueDTO> epilogueListByKeyWord(String option, String KeyWord) throws SQLException {
		ArrayList<EpilogueDTO> arr = new ArrayList<EpilogueDTO>();
		arr = BoardDAO.getInstance().epilogueListByKeyWord(option, KeyWord);
		return arr;
	}
	
	// QnA 리스트
		public ListDTO qnaList(String nowPageQnA) throws SQLException {
			ListDTO qdto = new ListDTO();
			int page = 1;
			PagingBean pb = null;
			int totalContents = BoardDAO.getInstance().qnaTotalContents();
			if(nowPageQnA != null){
				page = Integer.parseInt(nowPageQnA);
				pb = new PagingBean(totalContents, page);
			} else {
				pb = new PagingBean(totalContents);
			}
			ArrayList<QnADTO> qlist = BoardDAO.getInstance().qnaList(pb);
			qdto.setQlist(qlist);
			qdto.setPagingBean(pb);
			return qdto;
		}
		
		// QnA 상세
		public QnADTO qnaDetail(int a_no) throws SQLException {
			QnADTO qDto = new QnADTO();
			qDto = BoardDAO.getInstance().qnaDetail(a_no);
			qDto.getArticleDTO().setA_no(a_no);
			return qDto;
		}
		
		
		// QnA 삭제
		public void qnaDelete(int a_no) throws SQLException {
			BoardDAO.getInstance().qnaDel(a_no);
		}
		
		
		// QnA 작성
		public void qnaReg(QnADTO dto) throws SQLException {
			int a_no = BoardDAO.getInstance().seq_number();
			dto.getArticleDTO().setA_no(a_no);
			BoardDAO.getInstance().articleReg(dto);
		}
		
		
		
		// QnA 수정
		public void qnaUpdate(QnADTO dto) throws SQLException {
			BoardDAO.getInstance().articleUpdate(dto);
		}
		
		// Reply 리스트
		public ListDTO replyList(String nowPage, int a_no) throws SQLException {
			ListDTO rdto = new ListDTO();
			int page = 1;
			PagingBean pb = null;
			int totalContents = BoardDAO.getInstance().replyTotalContents(a_no);
			if(nowPage != null){
				page = Integer.parseInt(nowPage);
				pb = new PagingBean(totalContents, page);
			} else {
				pb = new PagingBean(totalContents);
			}
			ArrayList<ReplyDTO> rlist = BoardDAO.getInstance().replyList(a_no, pb);
			rdto.setRlist(rlist);
			rdto.setPagingBean(pb);
			return rdto;
		}
		
		// Reply 작성
			public void replyReg(ReplyDTO dto) throws SQLException {
				int a_no = BoardDAO.getInstance().seq_number_reply();
				dto.setR_no(a_no);
				BoardDAO.getInstance().replyReg(dto);
			}
			
}
