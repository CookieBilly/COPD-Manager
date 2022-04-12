package ws.billy.app.Code.New.Chat;

public class Message {

    private String text;
    private String sender;

    public Message() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public Message(String text, String sender) {
        this.text = text;
        this.sender = sender;
    }
}
