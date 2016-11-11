package org.kosta.mvcproject.model;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO extends AbstractDAO {
	
	// 조회수 증가
	public void updateHit(ArticleVO articleVO){
		template.update("board.updateHit", articleVO);
	}
	
	// 공지 전체글 갯수
	public PagingBean noticeTotalContents() {
		return template.selectOne("board.getNoticeTotalContents");
	}
	
	// 상위표시 공지 리스트
	public List<NoticeVO> getPriorityNoticeList() {
		return template.selectList("board.getPriorityNoticeList");
	}
	
	// 일반 공지 리스트
	public List<NoticeVO> getNoticeList(PagingBean pagingBean) {
		return template.selectList("board.getNoticeList", pagingBean);
	}
	
	// 공통부분 글 등록
	public void articleRegister(ArticleVO articleVO) {
		template.insert("board.articleRegister", articleVO);
	}
	
	// 공지 글 등록
	public void noticeRegister(NoticeVO noticeVO) {
		template.insert("board.noticeRegister", noticeVO);
	}
	
	// 공지 글 조회 
	public NoticeVO noticeDetail(NoticeVO noticeVO) {
		return template.selectOne("board.noticeDetail", noticeVO);
	}
	
	// 공통부분 글 수정
	public void articleUpdate(ArticleVO articleVO) {
		template.update("board.articleUpdate", articleVO);
	}
	
	// 공지 글 수정
	public void noticeUpdate(NoticeVO noticeVO) {
		template.update("board.noticeUpdate", noticeVO);
	}
	
	// 공통 글 삭제
	public void articleDelete(ArticleVO articleVO) {
		template.delete("board.articleDelete", articleVO);
	}
	
	// 공통 글 삭제시 관련 댓글 삭제
	public void relatedReplyDelete(ArticleVO articleVO) {
		template.delete("board.relatedReplyDelete", articleVO);
	}
	
	// 공지 글 삭제
	public void noticeDelete(NoticeVO noticeVO) {
		template.delete("board.noticeDelete", noticeVO);
	}

	// 답글 작성시 게시판 정렬
	public void lineUpBoard(ArticleVO articleVO) {
		template.update("board.lineUpBoard", articleVO);
	}
		
	// 공통부분 답글 등록
	public void articleResponse(ArticleVO articleVO) {
		template.insert("board.articleResponse", articleVO);
	}
	
	
	
	// QnA 전체글 갯수
	public PagingBean qnaTotalContents() {
		return template.selectOne("board.qnaTotalContents");
	}
	
	// QnA 리스트
	public List<ArticleVO> getQnaList(PagingBean pagingBean) {
		return template.selectList("board.getQnaList", pagingBean);
	}
	
	// QnA 글 조회
	public ArticleVO qnaDetail(ArticleVO articleVO) {
		return template.selectOne("board.qnaDetail", articleVO);
	}
	
	
	
	// 글 조회시 replyTotalContent 
	public PagingBean replyTotalContents(int articleNo) {
		return template.selectOne("board.replyTotalContents", articleNo);
	}
	
	// 글 조회시 replyList
	public List<ReplyVO> getReplyList(PagingBean pagingBean) {
		return template.selectList("board.getReplyList", pagingBean);
	}
	
	// reply 등록
	public void replyRegister(ReplyVO replyVO) {
		template.insert("board.replyRegister", replyVO);
	}
	
	// reply 답글 등록시 reply 정렬
	public void lineUpReply(ReplyVO replyVO) {
		template.update("board.lineUpReply", replyVO);
	}
	


	
		


	
	
}
