

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao_kadai.UserDao;

/**
 * Servlet implementation class NewRegistrationServlet
 */
@WebServlet("/NewRegistrationServlet")
public class NewRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewRegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("userInfo")==null) {
			response.sendRedirect("UserLoginServlet");
			return;
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/NewRegistration.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        request.setCharacterEncoding("UTF-8");

        String loginId = request.getParameter("loginId");
		String password = request.getParameter("password");
		String username = request.getParameter("username");
		String dateofbirth = request.getParameter("dateofbirth");
		String re_password = request.getParameter("re_password");

		UserDao userDao = new UserDao();


		if (!password.equals(re_password)){

			request.setAttribute("errMsg", "パスワードが一致しません");
			//入力したデータを登録失敗しても残っている状態にする。
			request.setAttribute("loginId", loginId);
			request.setAttribute("username", username);
			request.setAttribute("dateofbirth", dateofbirth);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/NewRegistration.jsp");
	        dispatcher.forward(request, response);
	        return;
		}

		if (loginId.isEmpty() || username.isEmpty() || dateofbirth.isEmpty()){

			request.setAttribute("errMsg", "未入力の項目があります");
			//入力したデータを登録失敗しても残っている状態にする。
			request.setAttribute("loginId", loginId);
			request.setAttribute("username", username);
			request.setAttribute("dateofbirth", dateofbirth);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/NewRegistration.jsp");
	        dispatcher.forward(request, response);
	        return;
		}
		try {
			userDao.newregi(loginId, password, username, dateofbirth);
			response.sendRedirect("AllUsersServlet");
			return;

		} catch (SQLException e) {
			//実行した際にコンソールにエラー内容が表示されるから書いた方が良い
			e.printStackTrace();

			// TODO 自動生成された catch ブロック
			request.setAttribute("errMsg", "すでに同じIDが存在しています");
			//入力したデータを登録失敗しても残っている状態にする。
			request.setAttribute("loginId", loginId);
			request.setAttribute("username", username);
			request.setAttribute("dateofbirth", dateofbirth);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/NewRegistration.jsp");
	        dispatcher.forward(request, response);

		}


	}
}
