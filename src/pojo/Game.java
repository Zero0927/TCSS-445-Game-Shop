package pojo;

/**
 * Game entity. @author MyEclipse Persistence Tools
 */

public class Game implements java.io.Serializable {

	// Fields

	private Integer gameId;
	private String gameName;
	private String gameDescription;
	private String gameCompany;
	private String gameCategory;
	private Integer gamePrice;
	private Integer gameUnitsInStock;

	// Constructors

	/** default constructor */
	public Game() {
	}

	/** full constructor */
	public Game(String gameName, String gameDescription, String gameCompany,
			String gameCategory, Integer gamePrice, Integer gameUnitsInStock) {
		this.gameName = gameName;
		this.gameDescription = gameDescription;
		this.gameCompany = gameCompany;
		this.gameCategory = gameCategory;
		this.gamePrice = gamePrice;
		this.gameUnitsInStock = gameUnitsInStock;
	}

	// Property accessors

	public Integer getGameId() {
		return this.gameId;
	}

	public void setGameId(Integer gameId) {
		this.gameId = gameId;
	}

	public String getGameName() {
		return this.gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public String getGameDescription() {
		return this.gameDescription;
	}

	public void setGameDescription(String gameDescription) {
		this.gameDescription = gameDescription;
	}

	public String getGameCompany() {
		return this.gameCompany;
	}

	public void setGameCompany(String gameCompany) {
		this.gameCompany = gameCompany;
	}

	public String getGameCategory() {
		return this.gameCategory;
	}

	public void setGameCategory(String gameCategory) {
		this.gameCategory = gameCategory;
	}

	public Integer getGamePrice() {
		return this.gamePrice;
	}

	public void setGamePrice(Integer gamePrice) {
		this.gamePrice = gamePrice;
	}

	public Integer getGameUnitsInStock() {
		return this.gameUnitsInStock;
	}

	public void setGameUnitsInStock(Integer gameUnitsInStock) {
		this.gameUnitsInStock = gameUnitsInStock;
	}

}