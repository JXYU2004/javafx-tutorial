import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class DialogBox extends HBox {

    private Label text;
    private ImageView displayPicture;

    public DialogBox(String s, Image i) {
        text = new Label(s);
        displayPicture = new ImageView(i);
        text.setWrapText(true);
        displayPicture.setFitWidth(100.0);
        displayPicture.setFitHeight(100.0);
        this.setAlignment(Pos.TOP_RIGHT);
        this.getChildren().addAll(text, displayPicture);
    }

    /**
     * Flips the dialog box such that the ImageView is on the left and text is
     * on the right.
     */
    private void flip() {
        this.setAlignment(Pos.TOP_LEFT);
        ObservableList<Node> tmp = FXCollections.observableArrayList(this.getChildren());
        FXCollections.reverse(tmp);
        this.getChildren().setAll(tmp);
    }

    /**
     * Creates a dialog box for user input.
     *
     * @param s the dialog text
     * @param i the user's image
     * @return the user's dialog box
     */
    public static DialogBox getUserDialog(String s, Image i) {
        return new DialogBox(s, i);
    }

    /**
     * Creates a dialog box for Duke's response and flips its layout.
     *
     * @param s Duke's dialog text
     * @param i Duke's image
     * @return Duke's dialog box
     */
    public static DialogBox getDukeDialog(String s, Image i) {
        var db = new DialogBox(s, i);
        db.flip();
        return db;
    }
}
