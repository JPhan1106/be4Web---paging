package coding.mentor.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import coding.mentor.entity.Book;
import coding.mentor.entity.Category;
import coding.mentor.service.BookService;
import coding.mentor.service.CategoryService;


/**
 * Servlet implementation class BookSearchServlet
 */
@WebServlet("/search")
public class BookSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			CategoryService categoryService = new CategoryService();
			List<Category> categoryList = categoryService.getAllCategories();
			
			BookService bookService = new BookService();
		
			String bookName = request.getParameter("bookName");
			List<Book> bookList = bookService.getBooksByName(bookName);
				
			RequestDispatcher rd = request.getRequestDispatcher("bookSearch.jsp");
			request.setAttribute("categoryList", categoryList);
			request.setAttribute("bookList", bookList);
			rd.forward(request, response);

		}
		
		catch (SQLException e) {
			e.printStackTrace();
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
