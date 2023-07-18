package coding.mentor.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import coding.mentor.entity.Account;
import coding.mentor.service.AccountService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String username = request.getParameter("username");
			String password = request.getParameter("password");

			AccountService accountService = new AccountService();
			Account account = new Account();
			account = accountService.getAccountByUsernameAndPassword(username, password);

			if (account == null) {
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				request.setAttribute("errorMessage", "Login details are incorrect, please try again!");
				rd.forward(request, response);

			} else {
				HttpSession session = request.getSession(false);
				session.setAttribute("username", username);
				session.setAttribute("accountId", account.getId());
				System.out.println("Account ID Attribute: " + session.getAttribute("accountId"));

				RequestDispatcher rd = request.getRequestDispatcher("home");
				rd.forward(request, response);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
