package model;

public class Suggestion {
    private int upvoteCount;
    private int downvoteCount;
    private int descriptionLength;
    private String name;
    private String description;

    public Suggestion(String name, String description) {
        this.name = name;
        this.description = description;
        this.descriptionLength = description.length();
    }

    public Suggestion(String name, String description, int descriptionLength) {
        this.name = name;
        this.description = description;
        this.descriptionLength = descriptionLength;
    }

    public Suggestion(String name, String description, int descriptionLength, int upvoteCount, int downvoteCount) {
        this.name = name;
        this.description = description;
        this.descriptionLength = descriptionLength;
        this.upvoteCount = upvoteCount;
        this.downvoteCount = downvoteCount;
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






}
