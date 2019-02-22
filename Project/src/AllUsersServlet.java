

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class AllUsersServlet
 */
@WebServlet("/AllUsersServlet")
public class AllUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllUsersServlet() {
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


		// TODO Auto-generated method stub
		UserDao userdao = new UserDao();
		List<UserBeans> userList = userdao.findAll();

		request.setAttribute("userList", userList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/AllUsers.jsp");
		dispatcher.forward(request, response);


	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

		String loginID = request.getParameter("loginID");
		String name = request.getParameter("name");
		String dateofbirthabove = request.getParameter("dateofbirthabove");
		String dateofbirthbelow = request.getParameter("dateofbirthbelow");

		UserDao userDao = new UserDao();
		List<UserBeans> userList = userDao.findSearch(loginID,name,dateofbirthabove,dateofbirthbelow);

		request.setAttribute("userList", userList);


		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/AllUsers.jsp");
		dispatcher.forward(request, response);


	}
}
