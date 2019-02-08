public class MySabbath {
    String sender;
    String message;
    String image;

    public MySabbath(String displayName, String sabbath, String img) {
    }

    public MySabbath( String message, String image) {

        this.message = message;
        this.image = image;
    }



    public String getMessage() {
        return message;
    }

    public String getImage() {
        return image;
    }



    public void setMessage(String message) {
        this.message = message;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
