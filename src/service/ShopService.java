package service;

import java.util.List;

import pojo.FavoriteList;
import pojo.Game;
import pojo.GameOrder;
import pojo.Invoice;
import pojo.Rating;

public interface ShopService {
	public List<Game> getGames();
	public boolean addToFavorite(int gameId, String userId);
	public boolean addToBuyCar(int gameId, int quantity, String userId);
	public boolean deleteFavorite(int favoriteListId);
	public boolean deleteBuyCar(int orderId);
	public List<GameOrder> getGameOrder(String userId);
	public List<FavoriteList> getFavoriteList(String userId);
	public double getTotalPrice(String userId);
	public List<Invoice> pay(String userId, String paymentMethod);
	public List<Invoice> getInvoice(String userId);
	public List<Rating> getRating(String userId);
	public boolean rating(int ratingId, String rating, String comment);
}
