package pojo;

/**
 * FavoriteList entity. @author MyEclipse Persistence Tools
 */

public class FavoriteList implements java.io.Serializable {

	// Fields

	private Integer favoriteListId;
	private String userId;
	private Integer gameId;

	// Constructors

	/** default constructor */
	public FavoriteList() {
	}

	/** full constructor */
	public FavoriteList(String userId, Integer gameId) {
		this.userId = userId;
		this.gameId = gameId;
	}

	// Property accessors

	public Integer getFavoriteListId() {
		return this.favoriteListId;
	}

	public void setFavoriteListId(Integer favoriteListId) {
		this.favoriteListId = favoriteListId;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getGameId() {
		return this.gameId;
	}

	public void setGameId(Integer gameId) {
		this.gameId = gameId;
	}

}