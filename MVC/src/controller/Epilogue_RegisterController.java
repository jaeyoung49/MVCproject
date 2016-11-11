package controller;

import java.io.File;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.ArticleDTO;
import model.EpilogueDTO;
import model.MemberDTO;
import model.MvcService;

public class Epilogue_RegisterController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// String homePath = System.getProperty("user.home");
		// System.out.println("홈패스: " + homePath);

		String image_path = "C:\\java-kosta\\ajax-workspace\\MVC\\WebContent\\img\\";
		String path = request.getRealPath("img");
		int sizeLimit = 5 * 1024 * 1024; // 5메가까지 제한 넘어서면 예외발생
		MultipartRequest multi = new MultipartRequest(request, path, sizeLimit, "UTF-8", new DefaultFileRenamePolicy());
		Enumeration formNames = multi.getFileNames(); // 폼의 이름 반환
		File file = multi.getFile("upfile");
		String formName = null;
		// 자료가 많을 경우엔 while문을 사용
		// 파일의 이름 얻기
		String fileName = null;
		// 파일 이름 자르기
		int lastIndex = 0;
		String file_name = null;
		String file_ext = null;
		if (file != null) {

			formName = (String) formNames.nextElement();
			// 자료가 많을 경우엔 while문을 사용
			// 파일의 이름 얻기
			fileName = multi.getFilesystemName(formName);
			// 파일 이름 자르기
			lastIndex = fileName.lastIndexOf('.');
			file_name = fileName.substring(0, lastIndex);
			file_ext = fileName.substring(lastIndex + 1);
		}
		// 글 제목 받아오기
		String a_title = multi.getParameter("title");

		// 세션에서 id 받아오기
		HttpSession session = request.getSession(false);
		MemberDTO Mdto = (MemberDTO) session.getAttribute("dto");
		String a_id = Mdto.getId();

		// 글 내용 받아오기
		String a_content = multi.getParameter("content");

		// 카테고리 받아오기
		int c_c_no = Integer.parseInt(multi.getParameter("category"));

		EpilogueDTO dto = new EpilogueDTO();
		dto.setArticleDTO(new ArticleDTO(a_title, a_id, a_content, 1));
		dto.setC_c_no(c_c_no);
		dto.setImage_path(image_path);
		dto.setFile_name(file_name);
		dto.setFile_ext(file_ext);
		MvcService.getInstance().epilogueReg(dto);
		return new ModelAndView("redirect:DispatcherServlet?command=EpwritetoEpDetails&a_no="+dto.getArticleDTO().getA_no());
		// return new
		// ModelAndView("DispatcherServlet?command=epilogue_register");
	}
}