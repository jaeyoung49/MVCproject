package controller;

import java.io.File;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.ArticleDTO;
import model.EpilogueDTO;
import model.MvcService;

public class EpUpdateController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int a_no = Integer.parseInt(request.getParameter("a_no"));
		System.out.println("글 번호: " + a_no);

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

		// 제목 받아오기
		String title = multi.getParameter("title");
		System.out.println("제목: " + title);

		// 내용 받아오기
		String content = multi.getParameter("content");
		System.out.println("내용: " + content);

		// 카테고리 번호 받아오기
		int c_c_no = Integer.parseInt(multi.getParameter("category"));

		ArticleDTO ArtDto = new ArticleDTO(a_no, title, content);
		EpilogueDTO EpDto = new EpilogueDTO(ArtDto, c_c_no, file_name, file_ext);
		MvcService.getInstance().epilogueUpdate(EpDto);
		return new ModelAndView("DispatcherServlet?command=Eplist");
	}
}
