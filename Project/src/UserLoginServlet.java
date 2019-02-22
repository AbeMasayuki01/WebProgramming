

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao_kadai.UserBeans;
import dao_kadai.UserDao;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("userInfo")!=null) {
			response.sendRedirect("AllUsersServlet");
			return;
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/User.Login.jsp");
        dispatcher.forward(request, response);




	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();



		request.setCharacterEncoding("UTF-8");

		String loginId = request.getParameter("login_id");
		String password = request.getParameter("password");

		UserDao userdao = new UserDao();
		UserBeans userbeans = userdao.findByLoginInfo(loginId, password);

		if (userbeans == null) {
			request.setAttribute("errMsg", "ログインIDまたはパスワードが異なります");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/User.Login.jsp");

	        dispatcher.forward(request, response);
	        return;
		}


		session.setAttribute("userInfo", userbeans);

		response.sendRedirect("AllUsersServlet");

	}

}
