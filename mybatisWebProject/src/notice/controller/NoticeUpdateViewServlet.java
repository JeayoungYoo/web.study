package notice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.model.service.NoticeService;
import notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeUpdateViewServlet
 */
@WebServlet("/nupview")
public class NoticeUpdateViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeUpdateViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 공지글 수정페이지 출력용 컨트롤러
		response.setContentType("text/html; charset=utf-8");
		
		int noticeNo = Integer.parseInt(request.getParameter("no"));
		
		Notice notice = new NoticeService().selectOne(noticeNo);
		
		if(notice != null){
			RequestDispatcher view = 
				request.getRequestDispatcher("views/notice/noticeUpdateView.jsp");
			request.setAttribute("notice", notice);
			view.forward(request, response);
		}else{
			response.sendRedirect("/testm/views/notice/noticeError.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
