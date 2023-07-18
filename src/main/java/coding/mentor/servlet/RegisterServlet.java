package coding.mentor.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import coding.mentor.entity.Account;
import coding.mentor.service.AccountService;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
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
//			read account info form View (register.jsp)
			String username = request.getParameter("username");
			String email = request.getParameter("email");
			String password = request.getParameter("password");

//			create new accountService object to use Model
			AccountService accountService = new AccountService();

// 			check if input email is available to use and input information is valid
			boolean isEmailAvailable = accountService.isEmailAvailable(email);
			boolean isValidInput = accountService.isValidInput(username, email, password);

			if (isEmailAvailable && isValidInput) {
//	 			create a new account object and add new account to database
				Account account = new Account(username, email, password);
				accountService.addNewAccount(account);

				// successfully registered, go to View (register-success.jsp)
				RequestDispatcher rd = request.getRequestDispatcher("register-success.jsp");
				rd.forward(request, response);
			} else if (isEmailAvailable == false) {

				request.setAttribute("errorMessageEmail", "Email is already registered. Please use a different email!");
				RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
				rd.forward(request, response);
			}

			else {
				request.setAttribute("errorMessageEmpty", "Please answer all questions!");
				RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
				rd.forward(request, response);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
