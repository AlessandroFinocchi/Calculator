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
    private ImageView CloseBtn; // Value injected by FXMLLoader

    @FXML
    private ImageView MinimizeBtn; // Value injected by FXMLLoader

    @FXML
    private Label ResultLbl; // Value injected by FXMLLoader

    @FXML // fx:id="titlePane"
    private Pane titlePane; // Value injected by FXMLLoader
    private double x;
    private double y;
    private DoubleEvaluator evaluator;

    private String defaultValue = "";


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

        System.out.println("ciao");

        evaluator = new DoubleEvaluator();
    }

    @FXML
    void OnCancClicked(MouseEvent event) {
        ResultLbl.setText(defaultValue);
    }

    @FXML
    void OnEqualClicked(MouseEvent event) throws ScriptException {
            Double result = evaluator.evaluate(ResultLbl.getText());
            ResultLbl.setText(result.toString());
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
