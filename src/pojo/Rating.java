package pojo;

/**
 * Rating entity. @author MyEclipse Persistence Tools
 */

public class Rating implements java.io.Serializable {

	// Fields

	private Integer ratingId;
	private String comment;
	private String rating;
	private Integer gameId;
	private String userId;

	// Constructors

	/** default constructor */
	public Rating() {
	}

	/** minimal constructor */
	public Rating(Integer gameId, String userId) {
		this.gameId = gameId;
		this.userId = userId;
	}

	/** full constructor */
	public Rating(String comment, String rating, Integer gameId, String userId) {
		this.comment = comment;
		this.rating = rating;
		this.gameId = gameId;
		this.userId = userId;
	}

	// Property accessors

	public Integer getRatingId() {
		return this.ratingId;
	}

	public void setRatingId(Integer ratingId) {
		this.ratingId = ratingId;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getRating() {
		return this.rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
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