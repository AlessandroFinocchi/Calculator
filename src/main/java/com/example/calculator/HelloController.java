/**
 * Sample Skeleton for 'hello-view.fxml' Controller Class
 */
package com.example.calculator;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.script.ScriptException;
import com.fathzer.soft.javaluator.DoubleEvaluator;

public class HelloController {
    @FXML
    private ImageView closeBtn; // Value injected by FXMLLoader

    @FXML
    private ImageView minimizeBtn; // Value injected by FXMLLoader

    @FXML
    private Label resultLbl; // Value injected by FXMLLoader

    @FXML // fx:id="titlePane"
    private Pane titlePane; // Value injected by FXMLLoader
    private double x;
    private double y;
    private DoubleEvaluator evaluator;

    private String defaultValue = "";


    public void init(Stage stage) {

        assert closeBtn != null : "fx:id=\"CloseBtn\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert minimizeBtn != null : "fx:id=\"MinimizeBtn\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert titlePane != null : "fx:id=\"titlePane\" was not injected: check your FXML file 'hello-view.fxml'.";

        titlePane.setOnMouseDragged(mouseEvent -> {
            stage.setX(mouseEvent.getScreenX() - x);
            stage.setY(mouseEvent.getScreenY() - y);
        });

        titlePane.setOnMousePressed(mouseEvent -> {
            x = mouseEvent.getSceneX();
            y = mouseEvent.getSceneY();
        });

        closeBtn.setOnMouseClicked(mouseEvent -> stage.close());

        minimizeBtn.setOnMouseClicked(mouseEvent -> stage.setIconified(true));

        resultLbl.setText(defaultValue);

        evaluator = new DoubleEvaluator();
    }

    @FXML
    void onCancelClicked(MouseEvent event) {
        resultLbl.setText(defaultValue);
    }

    @FXML
    void onEqualClicked(MouseEvent event) {
            Double result = evaluator.evaluate(resultLbl.getText());
            resultLbl.setText(result.toString());
    }

    @FXML
    void onNumberClicked(MouseEvent event) {
        int value = Integer.parseInt(((Label)event.getSource()).getText());
        resultLbl.setText(resultLbl.getText() + value);
    }

    @FXML
    void onSymbolClicked(MouseEvent event) {
        String symbol = ((Label)event.getSource()).getText();
        resultLbl.setText(resultLbl.getText() + symbol);
    }
}
