package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class Controller {
    private Game game;
    public Button btnNewGame;
    public Button btnRestartGame;
    public Button btnEndGame;
    public Button btn0, btn1, btn2, btn3;
    public Button btn4, btn5, btn6, btn7;
    public Button btn8, btn9, btn10, btn11;
    public Button btn12, btn13, btn14, btn15;

    public Controller() {
        game = new Game();
    }

    public void clickBtn(ActionEvent actionEvent) {
        System.out.println(((Button)actionEvent.getSource()).getId());
        String temp = ((Button)actionEvent.getSource()).getId().substring(3);
        int value = Integer.parseInt(temp);
        game.nextMove(value);
        rePaint();
    }

    private void rePaint() {
        Tile[][] arr = game.getField().getArr();


        btn0.setText(arr[0][0].isValue()?"M":"O");
        btn1.setText(arr[1][0].isValue()?"M":"O");
        btn2.setText(arr[2][0].isValue()?"M":"O");
        btn3.setText(arr[3][0].isValue()?"M":"O");

        btn4.setText(arr[0][1].isValue()?"M":"O");
        btn5.setText(arr[1][1].isValue()?"M":"O");
        btn6.setText(arr[2][1].isValue()?"M":"O");
        btn7.setText(arr[3][1].isValue()?"M":"O");

        btn8.setText(arr[0][2].isValue()?"M":"O");
        btn9.setText(arr[1][2].isValue()?"M":"O");
        btn10.setText(arr[2][2].isValue()?"M":"O");
        btn11.setText(arr[3][2].isValue()?"M":"O");

        btn12.setText(arr[0][3].isValue()?"M":"O");
        btn13.setText(arr[1][3].isValue()?"M":"O");
        btn14.setText(arr[2][3].isValue()?"M":"O");
        btn15.setText(arr[3][3].isValue()?"M":"O");
    }

    public void clickNewGame(ActionEvent actionEvent) {
        game.start();
        btnNewGame.setDisable(true);
        btnEndGame.setDisable(false);
        btnRestartGame.setDisable(false);

    }

    public void clickRestartGame(ActionEvent actionEvent) {
    }

    public void clickEndGame(ActionEvent actionEvent) {
    }
}
