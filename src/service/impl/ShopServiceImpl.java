package service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import pojo.FavoriteList;
import pojo.Game;
import pojo.GameOrder;
import pojo.Invoice;
import pojo.Rating;
import service.ShopService;
import dao.FavoriteListDAO;
import dao.GameDAO;
import dao.GameOrderDAO;
import dao.InvoiceDAO;
import dao.RatingDAO;

public class ShopServiceImpl implements ShopService {
	
	private FavoriteListDAO favoriteListDAO;
	private GameDAO gameDAO;
	private GameOrderDAO gameOrderDAO;
	private InvoiceDAO invoiceDAO;
	private RatingDAO ratingDAO;

	public ShopServiceImpl(FavoriteListDAO favoriteListDAO,
			GameDAO gameDAO, GameOrderDAO gameOrderDAO,
			InvoiceDAO invoiceDAO, RatingDAO ratingDAO) {
		this.favoriteListDAO = favoriteListDAO;
		this.gameDAO = gameDAO;
		this.gameOrderDAO = gameOrderDAO;
		this.invoiceDAO = invoiceDAO;
		this.ratingDAO = ratingDAO;
	}

	@Override
	public List<Game> getGames() {
		return (List<Game>) gameDAO.getAll("Game");
	}

	@Override
	public boolean addToFavorite(int gameId, String userId) {
		int num = favoriteListDAO.findByParam(
				"from FavoriteList where userId=:userId and gameId=:gameId",
				new String[]{"userId", "gameId"},
				new Object[]{userId, gameId});
		if (num > 0)
			return false;
		else {
			FavoriteList fl = new FavoriteList();
			fl.setGameId(gameId);
			fl.setUserId(userId);
			favoriteListDAO.add(fl);
			return true;
		}
	}

	@Override
	public boolean addToBuyCar(int gameId, int quantity, String userId) {
		Game g = ((List<Game>) gameDAO.getByParam(
				"from Game where gameId=:gameId",
				new String[]{"gameId"},
				new Object[]{gameId})).get(0);
		g.setGameUnitsInStock(g.getGameUnitsInStock() - quantity);
		gameDAO.update(g);
		
		List<GameOrder> gos = (List<GameOrder>) gameOrderDAO.getByParam(
				"from GameOrder where userId=:userId and gameId=:gameId",
				new String[]{"userId", "gameId"},
				new Object[]{userId, gameId});
		
		boolean b = false;
		int index = -1;
		if (gos != null && gos.size() > 0) {
			for (int i = 0; i < gos.size(); i++) {
				List<Invoice> invoices =  (List<Invoice>) invoiceDAO.getByParam(
						"from Invoice where orderId=:orderId",
						new String[]{"orderId"},
						new Object[]{gos.get(i).getOrderId()});
				if (invoices == null || invoices.size() <= 0) {
					b = true;
					index = i;
					break;
				}
			}
			
		}
		if (b) {
			GameOrder go = gos.get(index);
			go.setQuantity(go.getQuantity() + quantity);
			gameOrderDAO.update(go);
			return true;
		}
		else {
			GameOrder go = new GameOrder();
			go.setGameId(gameId);
			go.setQuantity(quantity);
			go.setUserId(userId);
			gameOrderDAO.add(go);
			return true;
		}
	}

	@Override
	public List<GameOrder> getGameOrder(String userId) {
		List<GameOrder> gos =  (List<GameOrder>) gameOrderDAO.getByParam(
				"from GameOrder where userId=:userId",
				new String[]{"userId"},
				new Object[]{userId});
		List<GameOrder> _gos = new ArrayList<GameOrder>();
		for (int i = 0; i < gos.size(); i++) {
			int num =  invoiceDAO.findByParam(
					"from Invoice where orderId=:orderId",
					new String[]{"orderId"},
					new Object[]{gos.get(i).getOrderId()});
			if (num <= 0)
				_gos.add(gos.get(i));
		}
		return _gos;
	}

	@Override
	public List<FavoriteList> getFavoriteList(String userId) {
		return (List<FavoriteList>) favoriteListDAO.getByParam(
				"from FavoriteList where userId=:userId",
				new String[]{"userId"},
				new Object[]{userId});
	}

	@Override
	public boolean deleteFavorite(int favoriteListId) {
		favoriteListDAO.deleteByParam("delete from FavoriteList where favoriteListId=?", new Object[]{favoriteListId});
		return true;
	}

	@Override
	public boolean deleteBuyCar(int orderId) {
		GameOrder go =  ((List<GameOrder>) gameOrderDAO.getByParam(
			"from GameOrder where orderId=:orderId",
			new String[]{"orderId"},
			new Object[]{orderId})).get(0);
		Game g = ((List<Game>) gameDAO.getByParam(
				"from Game where gameId=:gameId",
				new String[]{"gameId"},
				new Object[]{go.getGameId()})).get(0);
		g.setGameUnitsInStock(g.getGameUnitsInStock() + go.getQuantity());
		gameDAO.update(g);
		gameOrderDAO.deleteByEntity(go);
		return true;
	}

	@Override
	public double getTotalPrice(String userId) {
		List<GameOrder> gos =  getGameOrder(userId);
		double sum = 0;
		for (GameOrder go : gos) {
			Game g = ((List<Game>) gameDAO.getByParam(
					"from Game where gameId=:gameId",
					new String[]{"gameId"},
					new Object[]{go.getGameId()})).get(0);
			sum += (g.getGamePrice() * go.getQuantity());
		}
		return sum;
	}

	@Override
	public List<Invoice> pay(String userId, String paymentMethod) {
		List<Invoice> invoices = new ArrayList<Invoice>();
		List<GameOrder> gos = getGameOrder(userId);
		List<Rating> ratings = new ArrayList<Rating>();
		for (GameOrder go : gos) {
			Game g = ((List<Game>) gameDAO.getByParam(
					"from Game where gameId=:gameId",
					new String[]{"gameId"},
					new Object[]{go.getGameId()})).get(0);
			double sum = g.getGamePrice() * go.getQuantity();
			Invoice i = new Invoice();
			i.setInvoicePaydate(new Date());
			i.setOrderId(go.getOrderId());
			i.setPaymentMethod(paymentMethod);
			i.setTotalPrice(sum);
			invoices.add(i);
			
			Rating rating = new Rating();
			rating.setGameId(g.getGameId());
			rating.setUserId(userId);
			ratings.add(rating);
		}
		invoiceDAO.addAll(invoices);
		ratingDAO.addAll(ratings);
		return invoices;
	}

	@Override
	public List<Invoice> getInvoice(String userId) {
		List<GameOrder> gos =  (List<GameOrder>) gameOrderDAO.getByParam(
				"from GameOrder where userId=:userId",
				new String[]{"userId"},
				new Object[]{userId});
		List<Invoice> invoice = new ArrayList<Invoice>();
		for (int i = 0; i < gos.size(); i++) {
			List<Invoice> _invoice =  (List<Invoice>) invoiceDAO.getByParam(
					"from Invoice where orderId=:orderId",
					new String[]{"orderId"},
					new Object[]{gos.get(i).getOrderId()});
			invoice.addAll(_invoice);
		}
		return invoice;
	}

	@Override
	public List<Rating> getRating(String userId) {
		return (List<Rating>) ratingDAO.getByParam(
				"from Rating where userId=:userId",
				new String[]{"userId"},
				new Object[]{userId});
	}

	@Override
	public boolean rating(int ratingId, String rating, String comment) {
		Rating r = ((List<Rating>) ratingDAO.getByParam(
				"from Rating where ratingId=:ratingId",
				new String[]{"ratingId"},
				new Object[]{ratingId})).get(0);
		r.setRating(rating);
		r.setComment(comment);
		ratingDAO.update(r);
		return true;
	}

}
