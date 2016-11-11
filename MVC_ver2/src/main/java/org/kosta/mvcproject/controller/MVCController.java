package org.kosta.mvcproject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.kosta.mvcproject.model.ArticleVO;
import org.kosta.mvcproject.model.ListVO;
import org.kosta.mvcproject.model.MemberVO;
import org.kosta.mvcproject.model.NoticeVO;
import org.kosta.mvcproject.model.ReplyVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MVCController extends AbstractController{
	
	// 로그인
	@RequestMapping("login.do")
	public String login(MemberVO memberVO, HttpSession session){
		if(session.getAttribute("memberVO")!=null)
			return "redirect:index.jsp";
		session.setAttribute("memberVO", mvcService.login(memberVO));
		return "redirect:index.jsp";
	}
	
	// 로그아웃
	@RequestMapping("logout.do")
	public String logout(MemberVO memberVO, HttpSession session){
		if(session.getAttribute("memberVO")!=null)
			session.invalidate();
		return "redirect:index.jsp";
	}
	
	// 회원 가입
	@RequestMapping(method=RequestMethod.POST, value="join.do")
	public String join(MemberVO memberVO, HttpServletRequest request){
		mvcService.join(memberVO);
		HttpSession session = request.getSession(false);
		session.setAttribute("memberVO", mvcService.login(memberVO));
		return "redirect:index.jsp";
	}
	
	// 회원정보조회
	@RequestMapping("myInfo.do")
	public ModelAndView myInfo(HttpSession session){
		if(session.getAttribute("memberVO")==null)
			return new ModelAndView("index", "page", "loginPage");
		return new ModelAndView("index", "page", "myInfo");
	}
	
	// 회원정보조회Ajax
	@RequestMapping("findMyInfoAjax.do")
	@ResponseBody
	public MemberVO findMyInfoAjax(String id){
		return mvcService.findMemberById(id);
	}
	
	// 회원정보변경
	@RequestMapping("changeMyInfo.do")
	public String changeMyInfo(MemberVO memberVO){
		mvcService.changeMyInfo(memberVO);
		return "redirect:index.jsp";
	}
	
	// 아이디 중복체크
	@RequestMapping(method=RequestMethod.POST, value="duplicateIdCheck.do")
	@ResponseBody
	public String duplicateIdCheck(String id){
		MemberVO memberVO = mvcService.findMemberById(id);
		if(memberVO == null)
			return "ok";
		else
			return "fail";
	}
	
	
	// 공지글 리스트
	@RequestMapping("noticeList.do")
	public ModelAndView noticeList(String noticeNowPage, String qnaNowPage){
		ListVO noticeListVO = mvcService.noticeList(noticeNowPage);
		ListVO qnaListVO = mvcService.qnaList(qnaNowPage);
		
		ModelAndView mv = new ModelAndView("index", "noticeListVO", noticeListVO);
		mv.getModelMap().put("qnaListVO", qnaListVO);
		mv.getModelMap().put("page", "noticeList");
		
		return mv;
	}
	
	// 공지글 작성 페이지
	@RequestMapping("noticeWritePage.do")
	public ModelAndView noticeWritePage(HttpSession session){
		if(session.getAttribute("memberVO")==null)
			return new ModelAndView("index", "page", "loginPage");
		return new ModelAndView("index", "page", "noticeWrite");
	}
	
	// 공지글 등록
	@RequestMapping("noticeRegister.do")
	@ResponseBody
	public int noticeRegister(NoticeVO noticeVO){
		mvcService.noticeRegister(noticeVO);
		return noticeVO.getArticleVO().getArticleNo();
	}
	
	// 공지 글조회
	@RequestMapping("noticeDetail.do")
	public ModelAndView noticeDetail(NoticeVO noticeVO, ReplyVO replyVO, String replyNowPage){
		ModelAndView mv = new ModelAndView("index", "noticeVO", mvcService.noticeDetail(noticeVO));
		ListVO replyListVO = mvcService.replyList(noticeVO.getArticleVO().getArticleNo(), replyNowPage);
		mv.getModelMap().put("replyListVO", replyListVO);
		mv.getModelMap().put("page", "noticeDetail");
		return mv;
	}
	
	// 공지 글조회(조회수증가X)
	@RequestMapping("noticeDetailNoHit.do")
	public ModelAndView noticeDetailNoHit(NoticeVO noticeVO, ReplyVO replyVO, String replyNowPage){
		ModelAndView mv = new ModelAndView("index", "noticeVO", mvcService.noticeDetailNoHit(noticeVO));
		ListVO replyListVO = mvcService.replyList(noticeVO.getArticleVO().getArticleNo(), replyNowPage);
		mv.getModelMap().put("replyListVO", replyListVO);
		mv.getModelMap().put("page", "noticeDetail");
		return mv;
	}
	
	
	// 공지글 수정 페이지
	@RequestMapping("noticeUpdatePage.do")
	public ModelAndView noticeUpdatePage(NoticeVO noticeVO, HttpSession session){
		MemberVO memberVO = (MemberVO) session.getAttribute("memberVO");
		if(memberVO==null)
			return new ModelAndView("index", "page", "loginPage");
		ModelAndView mv = new ModelAndView("index", "noticeVO", mvcService.noticeDetailNoHit(noticeVO));
		mv.getModelMap().put("page", "noticeUpdate");
		return mv;
	}
	
	// 공지글 수정
	@RequestMapping("noticeUpdate.do")
	@ResponseBody
	public String noticeUpdate(NoticeVO noticeVO){
		mvcService.noticeUpdate(noticeVO);
		return "ok";
	}
	
	// 공지글 삭제
	@RequestMapping("noticeDelete.do")
	@ResponseBody
	public String noticeDelete(NoticeVO noticeVO){
		mvcService.noticeDelete(noticeVO);
		return "ok";
	}
	
	// 공지글 답글 작성 페이지
	@RequestMapping("noticeResponsePage.do")
	public ModelAndView noticeResponsePage(HttpSession session, NoticeVO noticeVO){
		if(session.getAttribute("memberVO")==null)
			return new ModelAndView("index", "page", "loginPage");
		ModelAndView mv = new ModelAndView("index", "noticeVO", mvcService.noticeDetailNoHit(noticeVO));
		mv.getModelMap().put("page", "noticeResponse");
		return mv;
	}
	
	// 공지 답글 등록
	@RequestMapping("noticeResponse.do")
	@ResponseBody
	public int noticeResponse(NoticeVO noticeVO){
		mvcService.noticeResponse(noticeVO);
		return noticeVO.getArticleVO().getArticleNo();
	}
	
	
	
	
	// QnA 작성 페이지
	@RequestMapping("qnaWritePage.do")
	public ModelAndView qnaWritePage(HttpSession session){
		if(session.getAttribute("memberVO")==null)
			return new ModelAndView("index", "page", "loginPage");
		return new ModelAndView("index", "page", "qnaWrite");
	}
	
	// QnA 글 등록
	@RequestMapping("qnaRegister.do")
	@ResponseBody
	public int qnaRegister(ArticleVO qnaVO){
		mvcService.qnaRegister(qnaVO);
		return qnaVO.getArticleNo();
	}
	
	// QnA 글 조회
	@RequestMapping("qnaDetail.do")
	public ModelAndView qnaDetail(ArticleVO qnaVO, ReplyVO replyVO, String replyNowPage){
		ModelAndView mv = new ModelAndView("index", "qnaVO", mvcService.qnaDetail(qnaVO));
		ListVO replyListVO = mvcService.replyList(qnaVO.getArticleNo(), replyNowPage);
		mv.getModelMap().put("replyListVO", replyListVO);
		mv.getModelMap().put("page", "qnaDetail");
		return mv;
	}
	
	// QnA 글 조회(조회수 증가X)
	@RequestMapping("qnaDetailNoHit.do")
	public ModelAndView qnaDetailNoHit(ArticleVO qnaVO, ReplyVO replyVO, String replyNowPage){
		ModelAndView mv = new ModelAndView("index", "qnaVO", mvcService.qnaDetailNoHit(qnaVO));
		ListVO replyListVO = mvcService.replyList(qnaVO.getArticleNo(), replyNowPage);
		mv.getModelMap().put("replyListVO", replyListVO);
		mv.getModelMap().put("page", "qnaDetail");
		return mv;
	}
	
	// QnA 수정 페이지
	@RequestMapping("qnaUpdatePage.do")
	public ModelAndView qnaUpdatePage(ArticleVO qnaVO, HttpSession session){
		MemberVO memberVO = (MemberVO) session.getAttribute("memberVO");
		if(memberVO==null)
			return new ModelAndView("index", "page", "loginPage");
		ModelAndView mv = new ModelAndView("index", "qnaVO", mvcService.qnaDetailNoHit(qnaVO));
		mv.getModelMap().put("page", "qnaUpdate");
		return mv;
	}
	
	// QnA글 수정
	@RequestMapping("qnaUpdate.do")
	@ResponseBody
	public String qnaUpdate(ArticleVO qnaVO){
		mvcService.qnaUpdate(qnaVO);
		return "ok";
	}
	
	// QnA글 삭제
	@RequestMapping("qnaDelete.do")
	@ResponseBody
	public String qnaDelete(ArticleVO qnaVO){
		mvcService.qnaDelete(qnaVO);
		return "ok";
	}
	
	// QnA글 답글 작성 페이지
	@RequestMapping("qnaResponsePage.do")
	public ModelAndView qnaResponsePage(HttpSession session, ArticleVO qnaVO){
		if(session.getAttribute("memberVO")==null)
			return new ModelAndView("index", "page", "loginPage");
		ModelAndView mv = new ModelAndView("index", "qnaVO", mvcService.qnaDetailNoHit(qnaVO));
		mv.getModelMap().put("page", "qnaResponse");
		return mv;
	}
	
	// QnA 답글 등록
	@RequestMapping("qnaResponse.do")
	@ResponseBody
	public int qnaResponse(ArticleVO qnaVO){
		mvcService.qnaResponse(qnaVO);
		return qnaVO.getArticleNo();
	}
	
	// reply 등록
	@RequestMapping("replyRegister.do")
	@ResponseBody
	public String replyRegister(ReplyVO replyVO) {
		mvcService.replyRegister(replyVO);
		return "ok";
	}
	
	// reply 답글 등록
	@RequestMapping("replyResponseRegister.do")
	@ResponseBody
	public String replyResponseRegister(ReplyVO replyVO) {
		mvcService.replyResponseRegister(replyVO);
		return "ok";
	}
}


