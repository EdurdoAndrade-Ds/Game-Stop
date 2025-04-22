public class Response {
    private Category category;
    private String answer;
    private boolean isValid;
    private boolean isDuplicate;

    public Response(Category category, String answer) {
        this.category = category;
        this.answer = answer;
        this.isValid = false;
    }

    public Category getCategory() {
        return category;
    }

    public String getAnswer() {
        return answer;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        this.isValid = valid;
    }

    public boolean isDuplicate() {
        return isDuplicate;
    }

    public void setDuplicate(boolean duplicate) {
        this.isDuplicate = duplicate;
    }
}
