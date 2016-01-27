package pojo;

/**
 * GameOrder entity. @author MyEclipse Persistence Tools
 */

public class GameOrder implements java.io.Serializable {

	// Fields

	private Integer orderId;
	private Integer quantity;
	private Integer gameId;
	private String userId;

	// Constructors

	/** default constructor */
	public GameOrder() {
	}

	/** full constructor */
	public GameOrder(Integer quantity, Integer gameId, String userId) {
		this.quantity = quantity;
		this.gameId = gameId;
		this.userId = userId;
	}

	// Property accessors

	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getGameId() {
		return this.gameId;
	}

	public void setGameId(Integer gameId) {
		this.gameId = gameId;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}