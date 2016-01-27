package action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import pojo.Game;
import pojo.GameOrder;
import pojo.Invoice;


public class ShopAction extends BaseAction {
	
	private List<Game> games;
	private int gameId;
	private int orderId;
	private List<GameOrder> shoppingCarts;
	private String paymentMethod;
	private double totalPrice;
	private String result;
	private List<Invoice> invoices;

	public List<Invoice> getInvoices() {
		return invoices;
	}

	public String getResult() {
		return result;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public List<Game> getGames() {
		return games;
	}
	
	public void setGameId(int gameId) {
		this.gameId = gameId;
	}
	
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String shop() {
		games = serviceManager.getShopService().getGames();
		return "shop";
	}
	
	public List<GameOrder> getShoppingCarts() {
		return shoppingCarts;
	}
	
	public String buyCarAdd() {
		HttpSession session = request.getSession();
		if (gameId > 0 && (String)session.getAttribute("id") != null) {
			serviceManager.getShopService().addToBuyCar(gameId, 1, (String)session.getAttribute("id"));
			return "shop";
		}
		else {
			return "login";
		}
	}
	
	public String buyCarDelete() {
		HttpSession session = request.getSession();
		if (orderId > 0 && (String)session.getAttribute("id") != null) {
			serviceManager.getShopService().deleteBuyCar(orderId);
			return "shoppingCart";
		}
		else {
			return "login";
		}
	}
	
	public String shoppingCart() {
		HttpSession session = request.getSession();
		if ((String)session.getAttribute("id") != null) {
			shoppingCarts = serviceManager.getShopService().getGameOrder((String)session.getAttribute("id"));
			return "shoppingCart";
		}
		else {
			return "login";
		}
	}
	
	public String pay() {
		HttpSession session = request.getSession();
		if ((String)session.getAttribute("id") != null) {
			if (ServletActionContext.getRequest().getMethod().equals("POST") && paymentMethod != null) {
				invoices = serviceManager.getShopService().pay((String)session.getAttribute("id"), paymentMethod);
				result = "pay success !";
				return "invoice";
			}
			else {
				shoppingCarts = serviceManager.getShopService().getGameOrder((String)session.getAttribute("id"));
				totalPrice = serviceManager.getShopService().getTotalPrice((String)session.getAttribute("id"));
				return "pay";
			}
		}
		else {
			return "login";
		}
	}
	
	public String invoice() {
		HttpSession session = request.getSession();
		if ((String)session.getAttribute("id") != null) {
			invoices = serviceManager.getShopService().getInvoice((String)session.getAttribute("id"));
			return "invoice";
		}
		else
			return "login";
	}
}
