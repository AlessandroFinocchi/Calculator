/**
 * Sample Skeleton for 'hello-view.fxml' Controller Class
 */
package com.example.calculator;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

public class HelloController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;
    @FXML
    private ImageView CloseBtn; // Value injected by FXMLLoader

    @FXML
    private ImageView MinimizeBtn; // Value injected by FXMLLoader

    @FXML
    private Label ResultLbl; // Value injected by FXMLLoader

    @FXML // fx:id="titlePane"
    private Pane titlePane; // Value injected by FXMLLoader
    private double x, y;

    private String defaultValue = "";

    ScriptEngineManager mgr = new ScriptEngineManager();
    private ScriptEngine engine = null;

    public void init(Stage stage) {
        assert CloseBtn != null : "fx:id=\"CloseBtn\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert MinimizeBtn != null : "fx:id=\"MinimizeBtn\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert titlePane != null : "fx:id=\"titlePane\" was not injected: check your FXML file 'hello-view.fxml'.";

        titlePane.setOnMouseDragged(mouseEvent -> {
            stage.setX(mouseEvent.getScreenX() - x);
            stage.setY(mouseEvent.getScreenY() - y);
        });

        titlePane.setOnMousePressed(mouseEvent -> {
            x = mouseEvent.getSceneX();
            y = mouseEvent.getSceneY();
        });

        CloseBtn.setOnMouseClicked(mouseEvent -> stage.close());

        MinimizeBtn.setOnMouseClicked(mouseEvent -> stage.setIconified(true));

        ResultLbl.setText(defaultValue);

        engine = mgr.getEngineByName("rhino");

        System.out.println("ciao");
    }

    @FXML
    void OnCancClicked(MouseEvent event) {
        ResultLbl.setText(defaultValue);
    }

    @FXML
    void OnEqualClicked(MouseEvent event) throws ScriptException {
        /*try{
            ResultLbl.setText(engine.eval(ResultLbl.getText()).toString());
        }
        catch(ScriptException ex){
            System.out.println("AAAAAAAAAAAAAAAAAA" + ex.getMessage());
        }*/
        String foo = "40 + 9";
        System.out.println(engine.eval(foo));
    }

    @FXML
    void OnNumberClicked(MouseEvent event) {
        int value = Integer.parseInt(((Label)event.getSource()).getText());
        ResultLbl.setText(ResultLbl.getText() + value);
    }

    @FXML
    void OnSymbolClicked(MouseEvent event) {
        String symbol = ((Label)event.getSource()).getText();
        ResultLbl.setText(ResultLbl.getText() + symbol);
    }
}
