package org.kosta.mvcproject.model;

import org.springframework.stereotype.Service;

@Service
public class MVCService extends AbstractService {
	// memberDAO
	// 회원 가입
	public void join(MemberVO memberVO) {
		memberDAO.join(memberVO);
	}
	
	// 로그인
	public Object login(MemberVO memberVO) {
		return memberDAO.login(memberVO);
	}
	
	// 아이디로 회원 검색
	public MemberVO findMemberById(String id) {
		return memberDAO.findMemberById(id);
	}

	// 회원정보 수정 
	public void changeMyInfo(MemberVO memberVO) {
		memberDAO.changeMyInfo(memberVO);
	}
	
	
	
	
	
	// boardDAO
	// 공지 리스트
	public ListVO noticeList(String noticeNowPage) {
		ListVO noticeListVO = new ListVO();
		PagingBean pagingBean = boardDAO.noticeTotalContents();
		
		if(noticeNowPage != null)
			pagingBean.setNowPage(Integer.parseInt(noticeNowPage));
		else
			pagingBean.setNowPage(1);
		
		noticeListVO.setPagingBean(pagingBean);
		noticeListVO.setPriorityNoticeList(boardDAO.getPriorityNoticeList());
		noticeListVO.setNoticeList(boardDAO.getNoticeList(pagingBean));
		return noticeListVO;
	}
	
	// 공지 글등록
	public void noticeRegister(NoticeVO noticeVO) {
		noticeVO.getArticleVO().setArticleCategoryVO(new ArticleCategoryVO());
		noticeVO.getArticleVO().getArticleCategoryVO().setArticleCategoryNo(2);
		boardDAO.articleRegister(noticeVO.getArticleVO());
		boardDAO.noticeRegister(noticeVO);
		memberDAO.updateMemberArticleCount(noticeVO.getArticleVO().getMemberVO());
	}

	// 공지 글조회
	public NoticeVO noticeDetail(NoticeVO noticeVO) {
		boardDAO.updateHit(noticeVO.getArticleVO());
		return boardDAO.noticeDetail(noticeVO);
	}
	
	// 공지 글조회(조회수증가X)
	public NoticeVO noticeDetailNoHit(NoticeVO noticeVO) {
		return boardDAO.noticeDetail(noticeVO);
	}

	// 공지글 수정
	public void noticeUpdate(NoticeVO noticeVO) {
		boardDAO.articleUpdate(noticeVO.getArticleVO());
		boardDAO.noticeUpdate(noticeVO);
	}
	
	// 공지글 삭제
	public void noticeDelete(NoticeVO noticeVO) {
		boardDAO.noticeDelete(noticeVO);
		boardDAO.relatedReplyDelete(noticeVO.getArticleVO());
		boardDAO.articleDelete(noticeVO.getArticleVO());
	}
	
	// 공지글 답글 등록
	public void noticeResponse(NoticeVO noticeVO) {
		noticeVO.getArticleVO().setArticleCategoryVO(new ArticleCategoryVO());
		noticeVO.getArticleVO().getArticleCategoryVO().setArticleCategoryNo(2);
		boardDAO.lineUpBoard(noticeVO.getArticleVO());
		boardDAO.articleResponse(noticeVO.getArticleVO());
		boardDAO.noticeRegister(noticeVO);
		memberDAO.updateMemberArticleCount(noticeVO.getArticleVO().getMemberVO());
	}
	
	
	// QnA 리스트
	public ListVO qnaList(String qnaNowPage) {
		ListVO qnaListVO = new ListVO();
		PagingBean pagingBean = boardDAO.qnaTotalContents();
		
		if(qnaNowPage != null)
			pagingBean.setNowPage(Integer.parseInt(qnaNowPage));
		else
			pagingBean.setNowPage(1);
		
		qnaListVO.setPagingBean(pagingBean);
		qnaListVO.setQnaList(boardDAO.getQnaList(pagingBean));
		return qnaListVO;
	}
	
	
	// QnA 글등록
	public void qnaRegister(ArticleVO qnaVO) {
		qnaVO.setArticleCategoryVO(new ArticleCategoryVO());
		qnaVO.getArticleCategoryVO().setArticleCategoryNo(3);
		boardDAO.articleRegister(qnaVO);
		memberDAO.updateMemberArticleCount(qnaVO.getMemberVO());
	}
	
	// QnA 글조회
	public ArticleVO qnaDetail(ArticleVO articleVO) {
		boardDAO.updateHit(articleVO);
		return boardDAO.qnaDetail(articleVO);
	}
	
	// QnA 글조회 (조회수 증가X)
	public Object qnaDetailNoHit(ArticleVO articleVO) {
		return boardDAO.qnaDetail(articleVO);
	}
	
	// QnA 글 수정
	public void qnaUpdate(ArticleVO qnaVO) {
		boardDAO.articleUpdate(qnaVO);
	}
	
	// QnA 글 삭제
	public void qnaDelete(ArticleVO qnaVO) {
		boardDAO.relatedReplyDelete(qnaVO);
		boardDAO.articleDelete(qnaVO);
	}
	
	// QnA 답글 등록
	public void qnaResponse(ArticleVO qnaVO) {
		qnaVO.setArticleCategoryVO(new ArticleCategoryVO());
		qnaVO.getArticleCategoryVO().setArticleCategoryNo(3);
		boardDAO.lineUpBoard(qnaVO);
		boardDAO.articleResponse(qnaVO);
		memberDAO.updateMemberArticleCount(qnaVO.getMemberVO());
	}

	
	
	// Reply 리스트
	public ListVO replyList(int articleNo, String replyNowPage) {
		ListVO replyListVO = new ListVO();
		PagingBean pagingBean = boardDAO.replyTotalContents(articleNo);
		pagingBean.setArticleNo(articleNo);
		
		if(replyNowPage != null)
			pagingBean.setNowPage(Integer.parseInt(replyNowPage));
		else
			pagingBean.setNowPage(1);

		replyListVO.setPagingBean(pagingBean);
		replyListVO.setReplyList(boardDAO.getReplyList(pagingBean));
		return replyListVO;
	}
	
	// reply 등록
	public void replyRegister(ReplyVO replyVO) {
		boardDAO.replyRegister(replyVO);
	}
	
	// reply 답글 등록
	public void replyResponseRegister(ReplyVO replyVO) {
		boardDAO.lineUpReply(replyVO);
		boardDAO.replyRegister(replyVO);
	}
	
}
