package controller;

public class HandlerMapping {
	private static HandlerMapping instance = new HandlerMapping();

	private HandlerMapping() {
	}

	public static HandlerMapping getInstance() {
		return instance;
	}

	public Controller create(String command) {
		Controller c = null;
		System.out.println("HandlerMapping: " + command);
		if (command.equals("main")) {
			c = new MainController();
		} else if (command.equals("Join")) {
			c = new JoinController();
		} else if (command.equals("Login")) {
			c = new LoginController();
		} else if (command.equals("Eplist")) {
			c = new EplistController();
		} else if (command.equals("Logout")) {
			c = new LogoutController();
		} else if (command.equals("DuplicateIdCheck")) {
			c = new DuplicateIdCheckController();
		} else if (command.equals("Epdetails")) {
			c = new EpDetailsController();
		} else if (command.equals("EpwritetoEpDetails")) { // 글 작성시 조회수 X
			c = new EpwritetoEpDetailsController();
		} else if (command.equals("Epwrite")) {
			c = new EpWriteController();
		} else if (command.equals("Epdelete")) {
			c = new EpDeleteController();
		} else if (command.equals("Epupdatewrite")) {
			c = new EpUpdateWriteController();
		} else if (command.equals("Epupdate")) {
			c = new EpUpdateController();
		} else if (command.equals("Epilogue_register")) {
			c = new Epilogue_RegisterController();
		} else if (command.equals("Notice")) { // NoticeList로 수정??
			c = new NoticeController();
		} else if (command.equals("NoticeDetail")) {
			c = new NoticeDetailController();
		} else if (command.equals("Notice_Delete")) {
			c = new Notice_DeleteController();
		} else if (command.equals("Notice_Register")) {
			c = new Notice_RegisterController();
		} else if (command.equals("Notice_RegistertoDetail")) { // 공지 작성시 조회수 X
			c = new Notice_RegistertoDetailController();
		} else if (command.equals("NoticeUpdateForm")) {
			c = new NoticeUpdateFormController();
		} else if (command.equals("NoticeUpdate")) {
			c = new NoticeUpdateController();
		} else if (command.equals("QnADetail")) {
			c = new QnADetailController();
		} else if (command.equals("QnA_Delete")) {
			c = new QnA_DeleteController();
		} else if (command.equals("QnA_Register")) {
			c = new QnA_RegisterController();
		} else if (command.equals("QnAUpdate")) {
			c = new QnAUpdateController();
		} else if (command.equals("QnAUpdateForm")) {
			c = new QnAUpdateFormController();
		} else if (command.equals("Reply_Register")) {
			c = new Reply_RegisterController();
		}
		// 개인정보수정
		else if (command.equals("findMyInfoAjax")) {
			c = new findMyInfoAjaxController();
		} else if (command.equals("changeMyInfo")) {
			c = new changeMyInfoController();
		}

		// 관리자 모드
		else if (command.equals("sa_VideoUrlUpLoad")) {
			c = new sa_VideoUrlUpLoadController();
		} else if (command.equals("sa_VideoUrlList")) {
			c = new sa_VideoUrlListController();
		} else if (command.equals("sa_Login")) {
			c = new sa_LoginController();
		}
		// 메인 동영상 불러오기
		else if (command.equals("AjaxVideo")) {
			c = new AjaxVideoController();
		}
		// 글작성 카테고리 불러오기
		else if (command.equals("c_categoryAjax")) {
			c = new c_categoryAjaxController();
		}
		// 카테고리 선택시 리스트 변경
		else if (command.equals("epilogueListByCategory")) {
			c = new epilogueListByCategoryController();
		} else if (command.equals("sa_epilogueListByCategory")) {
			c = new sa_epilogueListByCategoryController();
		}
		// 검색어로 후기 검색하기
		else if (command.equals("epilogueListByKeyWord")) {
			c = new epilogueListByKeyWordController();
		} else if (command.equals("sa_pilogueListByKeyWord")) {
			c = new sa_epilogueListByKeyWordController();
		} else if (command.equals("sa_NoticeDeleteAjax")) {
			c = new sa_NoticeDeleteAjaxController();
		} else if (command.equals("sa_EpilogueDeleteAjax")) {
			c = new sa_EpilogueDeleteAjaxController();
		} else if (command.equals("sa_noticeList")) {
			c = new sa_NoticeListController();
		} else if (command.equals("sa_epilogueList")) {
			c = new sa_EpilogueListController();
		} else if (command.equals("sa_memberManagement")) {
			c = new sa_MemberListController();
		} else if (command.equals("sa_MemberDeleteAjax")) {
			c = new sa_MemberDeleteAjaxController();
		} else if (command.equals("sa_memberGradeChangeAjax")) {
			c = new sa_memberGradeChangeAjaxController();
		}
		return c;
	}
}
