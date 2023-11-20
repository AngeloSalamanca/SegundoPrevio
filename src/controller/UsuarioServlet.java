package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BillDao;
import dao.UsuarioDAO;
import model.Bill;



/**
 * Servlet implementation class ProductoServlet
 */
@WebServlet("/")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioDAO userDao;
	private BillDao billDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() {
    	this.userDao = new UsuarioDAO();
    	this.billDao = new BillDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getServletPath();
		System.out.println(action);
		try {
			switch (action) {
				case "/new":
			        nuevo(request, response);
			        break;
			    case "/insert":
			        insert(request, response);
			        break;
			    case "/delete":
			        delete(request, response);
			        break;
			    case "/list":
			        list(request, response);
			        break;
			    default:
			    	index(request, response);
			    	break;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

    private void nuevo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		    dispatcher.forward(request, response);
	}

    private void insert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		    dispatcher.forward(request, response);
	}

    private void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		    dispatcher.forward(request, response);
	}

    private void index(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		    dispatcher.forward(request, response);
	}

    private void list(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {
		        List <Bill> listBill = billDao.selectAll();
		        request.setAttribute("listBill", listBill);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("html/movimientos.jsp");
		        dispatcher.forward(request, response);
	}
}