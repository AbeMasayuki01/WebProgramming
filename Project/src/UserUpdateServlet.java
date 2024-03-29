
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
 * Servlet implementation class UserUpdateServlet
 */
@WebServlet("/UserUpdateServlet")
public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserUpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("userInfo")==null) {
			response.sendRedirect("UserLoginServlet");
			return;
		}
		String id = request.getParameter("id");

		UserDao userdao = new UserDao();
		UserBeans userupdate = userdao.findById(id);

		request.setAttribute("userUpdate", userupdate);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/User.Update.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String birth_Date = request.getParameter("birth_Date");
		String password = request.getParameter("password");
		String re_password = request.getParameter("re_password");

		UserDao userdao = new UserDao();

		if (password.equals(re_password) && !name.isEmpty() && !birth_Date.isEmpty()) {

			if (password.equals("")) {
				userdao.updateById(id, name, birth_Date);
//メソッドのオーバーライド
			} else {
				userdao.updateById(id, password, name, birth_Date);
			}

			response.sendRedirect("AllUsersServlet");

		} else {
			request.setAttribute("errMsg", "入力された内容は正しくありません");
//dogetしないでリダイレクトすると上のdogetで入れた初期値などが消える。そのため、ここでdoGetし直す。
			doGet(request, response);
//			以下と同様
//			UserDao userdao = new UserDao();
//			UserBeans userupdate = userdao.findById(id);
//
//			request.setAttribute("userUpdate", userupdate);
//
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/User.Update.jsp");
//			dispatcher.forward(request, response);
		}
	}
}
