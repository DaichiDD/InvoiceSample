package sample.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sample.dao.InvoiceDao;
import sample.dto.InvoiceDto;

/**
 * Servlet implementation class EditAction
 */
@WebServlet("/EditAction")
public class EditAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private InvoiceDao dao;

    /**
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @see HttpServlet#HttpServlet()
     */
    public EditAction() throws InstantiationException, IllegalAccessException {
        super();
        // TODO Auto-generated constructor stub
        dao = new InvoiceDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int invoiceId = Integer.parseInt(request.getParameter("invoiceId"));
		InvoiceDto invoice = dao.selectById(invoiceId);
		request.setAttribute("invoice", invoice);
		RequestDispatcher view = request.getRequestDispatcher("edit.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
