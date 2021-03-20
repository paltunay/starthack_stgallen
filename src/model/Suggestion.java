package model;

public class Suggestion implements Comparable<Suggestion> {
    private int upvoteCount;
    private int downvoteCount;
    private int descriptionLength;
    private String name;
    private String description;
    private String issuerName;

    public Suggestion(String name, String description, String issuerName) {
        this.name = name;
        this.description = description;
        this.descriptionLength = description.length();
        this.upvoteCount = 0;
        this.downvoteCount = 0;
        this.issuerName = issuerName;
    }

    public Suggestion(String name, String description, int descriptionLength, String issuerName) {
        this.name = name;
        this.description = description;
        this.descriptionLength = descriptionLength;
        this.upvoteCount = 0;
        this.downvoteCount = 0;
        this.issuerName = issuerName;
    }

    public Suggestion(String name, String description, int descriptionLength, int upvoteCount, 
    		int downvoteCount, String issuerName) {
        this.name = name;
        this.description = description;
        this.descriptionLength = descriptionLength;
        this.upvoteCount = upvoteCount;
        this.downvoteCount = downvoteCount;
        this.issuerName = issuerName;
    }

    //getter methods
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getDescriptionLength() {
        return descriptionLength;
    }

    public int getUpvoteCount() {
        return upvoteCount;
    }

    public int getDownvoteCount() {
        return downvoteCount;
    }

    public int getVotes() {
        return upvoteCount - downvoteCount;
    }
    
    public String getIssuer() {
    	return issuerName;
    }

    //setter methods
    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDescriptionLength(int length) {
        descriptionLength = length;
    }

    public void setUpvoteCount(int count) {
        upvoteCount = count;
    }

    public void setDownvoteCount(int count) {
        downvoteCount = count;
    }
    
    // returns positive number if and only if this suggestion is more popular than other suggestion
    public int compareTo(Suggestion other) {
    	return (this.getUpvoteCount() - this.getDownvoteCount()) - 
    			(other.getUpvoteCount() - other.getDownvoteCount());
    }






}
