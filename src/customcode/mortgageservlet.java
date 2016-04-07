package customcode;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class mortgageservlet
 */
@WebServlet("/mortgageservlet")
public class mortgageservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public mortgageservlet() {
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

		doPost(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// HttpSession session = request.getSession();

		double p = 0;
		double r = 0;
		double t = 0;
		String test;

		test = request.getParameter("principal");

		if ((test != null) && !test.isEmpty()) {
			p = Double.parseDouble(request.getParameter("principal"));
		}

		test = request.getParameter("rate");
		if ((test != null) && !test.isEmpty()) {
			r = Double.parseDouble(request.getParameter("rate"));

		}

		test = request.getParameter("term");
		if ((test != null) && !test.isEmpty()) {
			t = Double.parseDouble(request.getParameter("term"));

		}

		MortgageCalc mc = new MortgageCalc(p, r, t);

		double payment = mc.getMonthlyPayment();

		String payString = MoneyFormat.getDollarString(payment);

		request.setAttribute("payment", payString);
		request.setAttribute("principal", Double.toString(p));
		request.setAttribute("rate", Double.toString(r));
		request.setAttribute("term", Double.toString(t));

		request.setAttribute("calculated", "yes");
		request.getRequestDispatcher("/index.jsp").forward(request, response);

	}

}
