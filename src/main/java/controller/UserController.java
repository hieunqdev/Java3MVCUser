package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

import java.io.IOException;
import java.util.List;

import dao.UserDAO;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserDAO ud = new UserDAO();
		List<User> userList = ud.findAll();
		// Đặt danh sách người dùng vào request
		request.setAttribute("userList", userList);
		// Chuyển tiếp đến user.jsp
		request.getRequestDispatcher("views/user.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub	
		String action = request.getParameter("action");
		System.out.println(action);
		switch (action) {
	        case "Create":
	            createUser(request, response);
	            break;
	        case "Update":
	        	createUser(request, response);
	            break;
	        case "Delete":
	        	createUser(request, response);
	            break;
	        default:
	            break;
	    }
	}
	
	// Phương thức xử lý tạo người dùng
    private void createUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        String fullname = request.getParameter("fullname");
        String email = request.getParameter("email");
        String role = request.getParameter("role");

        User user = new User(id, password, email, fullname, "admin".equals(role));

        UserDAO userDAO = new UserDAO();
        userDAO.create(user);

        // Sau khi tạo người dùng, chuyển hướng lại trang danh sách
        response.sendRedirect("UserController");
    }
}
