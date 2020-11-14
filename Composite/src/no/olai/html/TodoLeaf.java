package no.olai.html;

// Leaf
public class TodoLeaf implements TodoComponent {

    private String text;

    public TodoLeaf(String text) {
        this.text = text;
    }

    @Override
    public String getHtml() {
        return  this.text + "<input type=\"checkbox\">";
    }


    @Override
    public String toString() {
        return "Todo{" +
                "text='" + text + '\'' +
                '}';
    }
}
