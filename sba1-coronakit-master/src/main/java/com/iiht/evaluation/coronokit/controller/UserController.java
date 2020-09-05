package com.iiht.evaluation.coronokit.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iiht.evaluation.coronokit.dao.KitDao;
import com.iiht.evaluation.coronokit.dao.ProductMasterDao;
import com.iiht.evaluation.coronokit.model.KitDetail;
import com.iiht.evaluation.coronokit.model.ProductMaster;

@WebServlet("/user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private KitDao kitDAO;
	
	public void setKitDAO(KitDao kitDAO) {
		this.kitDAO = kitDAO;
	}


	public void init(ServletConfig config) {
		String jdbcURL = config.getServletContext().getInitParameter("jdbcUrl");
		String jdbcUsername = config.getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = config. getServletContext().getInitParameter("jdbcPassword");
		
		this.kitDAO = new KitDao(jdbcURL, jdbcUsername, jdbcPassword);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		
		String viewName = "";
		try {
			switch (action) {
			case "newuser":
				viewName = showNewUserForm(request, response);
				break;
			case "insertuser":
				viewName = insertNewUser(request, response);
				break;
			case "showproducts":
				viewName = showAllProducts(request, response);
				break;	
			case "addnewitem":
				viewName = addNewItemToKit(request, response);
				break;
			case "deleteitem":
				viewName = deleteItemFromKit(request, response);
				break;
			case "showkit":
				viewName = showKitDetails(request, response);
				break;
			case "placeorder":
				viewName = showPlaceOrderForm(request, response);
				break;
			case "saveorder":
				viewName = saveOrderForDelivery(request, response);
				break;	
			case "ordersummary":
				viewName = showOrderSummary(request, response);
				break;	
			default : viewName = "notfound.jsp"; break;	
			}
		} catch (Exception ex) {
			
			throw new ServletException(ex.getMessage());
		}
			RequestDispatcher dispatch = 
					request.getRequestDispatcher(viewName);
			dispatch.forward(request, response);
	
	}

	private String showOrderSummary(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException {
		String address = request.getParameter("address");
		request.getSession().setAttribute("address", address);
		
		List<KitDetail> kitDetailList = this.kitDAO.getOrderSummary();
		request.setAttribute("kitDetailList", kitDetailList);
		return "ordersummary.jsp";
	}

	private String saveOrderForDelivery(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		List<KitDetail> checkingCart = this.kitDAO.getKitDetail();
			if(checkingCart.contains(request.getParameter("id")) && checkingCart.contains(request.getParameter("id"))) {
				return "user?action=showproducts";
			}
			else {
				String id = request.getParameter("id");
				this.kitDAO.addCart(id);
				return "user?action=showproducts";
			}
		
	
	}

	private String showPlaceOrderForm(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "placeorder.jsp";
	}

	private String showKitDetails(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		List<KitDetail> kitDetailList = this.kitDAO.getKitDetail();
		request.setAttribute("kitDetailList", kitDetailList);
		return "showkit.jsp";
		}

	private String deleteItemFromKit(HttpServletRequest request, HttpServletResponse response) {
	
		return "";
	}

	private String addNewItemToKit(HttpServletRequest request, HttpServletResponse response) {
	
		return "user?action=showproducts";
	}

	
	private String showAllProducts(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException {
		
		List<ProductMaster> productMasterList = this.kitDAO.getProductRecords();
		request.setAttribute("productMasterList", productMasterList);
		return "showproductstoadd.jsp";
	}

	private String insertNewUser(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException {
		
		String pname =  request.getParameter("pname");
		String pemail =  request.getParameter("pemail");
		String pcontact =  request.getParameter("pcontact");
		HttpSession htsession = request.getSession();
		htsession.setAttribute("pname", pname);
		htsession.setAttribute("pemail", pemail);
		htsession.setAttribute("pcontact", pcontact);
		return "user?action=showproducts";
		
	}

	private String showNewUserForm(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException {
	
		this.kitDAO.deleteCart();
		return "newuser.jsp";
	}


	public void setProductMasterDao(ProductMasterDao productMasterDao) {
		// TODO Auto-generated method stub
		
	}
}