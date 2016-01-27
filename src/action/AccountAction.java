package action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ModelDriven;

import pojo.Customers;
import pojo.FavoriteList;
import pojo.Rating;

public class AccountAction extends BaseAction implements ModelDriven {
	
	private String id;
	private String pw;
	private String repw;
	private String error;
	private Customers customers;
	private List<FavoriteList> favoriteLists;
	private int gameId;
	private int favoriteListId;
	private List<Rating> ratings;
	private String rating;
	private String comment;
	private int ratingId;

	public void setRatingId(int ratingId) {
		this.ratingId = ratingId;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	@Override
	public Object getModel() {
       if(customers == null){
    	   customers = new Customers();
       }
       return customers;
    }
	
	public void setId(String id) {
		this.id = id;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}
	
	public void setRepw(String repw) {
		this.repw = repw;
	}

	public String getError() {
		return error;
	}

	public Customers getCustomers() {
		return customers;
	}

	public void setCustomers(Customers customers) {
		this.customers = customers;
	}

	public List<FavoriteList> getFavoriteLists() {
		return favoriteLists;
	}
	
	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	public void setFavoriteListId(int favoriteListId) {
		this.favoriteListId = favoriteListId;
	}

	public String login() {
		try {
			if (ServletActionContext.getRequest().getMethod().equals("POST")) {
				boolean success = serviceManager.getAccountService().login(id, pw);
				if (success) {
					error = "login success !";
					HttpSession session = request.getSession();
					session.setAttribute("id", id);
					session.setMaxInactiveInterval(3 * 60);
					return "shop";
				}
				else {
					error = "login fail ! please check your id and password";
					return "login";
				}
			}
			return "login";
		} catch(Exception e) {
			error = "login fail ! please check your id and password";
			return "login";
		}
	}
	
	public String register() {
		if (ServletActionContext.getRequest().getMethod().equals("POST")) {
			try {
				if (pw.equals(repw) && !serviceManager.getAccountService().checkId(id)) {
					error = "register success !";
					serviceManager.getAccountService().register(id, pw, customers);
					return "login";
				}
			} catch(Exception e) {
				error = "please check your enter";
				return "register";
			}
			error = "please check your enter";
			return "register";
		}
		else
			return "register";
	}

	public String favoriteAdd() {
		HttpSession session = request.getSession();
		if (gameId > 0 && (String)session.getAttribute("id") != null) {
			serviceManager.getShopService().addToFavorite(gameId, (String)session.getAttribute("id"));
			return "shop";
		}
		else {
			return "login";
		}
	}
	
	public String favoriteDelete() {
		HttpSession session = request.getSession();
		if (favoriteListId > 0 && (String)session.getAttribute("id") != null) {
			serviceManager.getShopService().deleteFavorite(favoriteListId);
			return "favoriteList";
		}
		else {
			return "login";
		}
	}
	
	public String favoriteList() {
		HttpSession session = request.getSession();
		if ((String)session.getAttribute("id") != null) {
			favoriteLists = serviceManager.getShopService().getFavoriteList((String)session.getAttribute("id"));
			return "favoriteList";
		}
		else {
			return "login";
		}
	}
	
	public String myGame() {
		HttpSession session = request.getSession();
		if ((String)session.getAttribute("id") != null) {
			ratings = serviceManager.getShopService().getRating((String)session.getAttribute("id"));
			return "game";
		}
		else {
			return "login";
		}
	}
	
	public String rating() {
		HttpSession session = request.getSession();
		if ((String)session.getAttribute("id") != null) {
			try {
				serviceManager.getShopService().rating(ratingId, rating, comment);
			} catch(Exception ex) {
			}
			return "game";
		}
		else {
			return "login";
		}
	}
	
}
