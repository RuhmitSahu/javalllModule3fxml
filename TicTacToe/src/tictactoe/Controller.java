package tictactoe;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;

public class Controller {

	@FXML
	Button button1;
	@FXML
	Button button2;
	@FXML
	Button button3;
	@FXML
	Button button4;
	@FXML
	Button button5;
	@FXML
	Button button6;
	@FXML
	Button button7;
	@FXML
	Button button8;
	@FXML
	Button button9;

	@FXML
	GridPane gameBoard;

	private boolean isFirstPlayer = true;

	public void buttonClickHandler(ActionEvent evt) {

		Button clickedButton = (Button) evt.getTarget();
		String buttonLabel = clickedButton.getText();

		if ("".equals(buttonLabel) && isFirstPlayer) {
			clickedButton.setText("X");
			isFirstPlayer = false;
		} else if ("".equals(buttonLabel) && !isFirstPlayer) {
			clickedButton.setText("O");
			isFirstPlayer = true;
		}

		find3InARow();
	}

	private boolean find3InARow() {

		if ("" != button1.getText() && button1.getText() == button2.getText()
				&& button2.getText() == button3.getText()) {
			highlightWinningCombo(button1, button2, button3);
			return true;
		}

		if ("" != button4.getText() && button4.getText() == button5.getText()
				&& button5.getText() == button6.getText()) {
			highlightWinningCombo(button4, button5, button6);
			return true;
		}

		if ("" != button7.getText() && button7.getText() == button8.getText()
				&& button8.getText() == button9.getText()) {
			highlightWinningCombo(button7, button8, button9);
			return true;
		}

		if ("" != button1.getText() && button1.getText() == button4.getText()
				&& button4.getText() == button7.getText()) {
			highlightWinningCombo(button1, button4, button7);
			return true;
		}

		if ("" != button2.getText() && button2.getText() == button5.getText()
				&& button5.getText() == button8.getText()) {
			highlightWinningCombo(button2, button5, button8);
			return true;
		}

		if ("" != button3.getText() && button3.getText() == button6.getText()
				&& button6.getText() == button9.getText()) {
			highlightWinningCombo(button3, button6, button9);
			return true;
		}

		if ("" != button1.getText() && button1.getText() == button5.getText()
				&& button5.getText() == button9.getText()) {
			highlightWinningCombo(button1, button5, button9);
			return true;
		}

		if ("" != button3.getText() && button3.getText() == button5.getText()
				&& button5.getText() == button7.getText()) {
			highlightWinningCombo(button3, button5, button7);
			return true;
		}
		return false;
	}

	private void highlightWinningCombo(Button first, Button second, Button third) {
		first.getStyleClass().add("winning-button");
		second.getStyleClass().add("winning-button");
		third.getStyleClass().add("winning-button");
		
	}

	public void menuClickHandler(ActionEvent evt) {
		MenuItem clickedMenu = (MenuItem) evt.getTarget();
		String menuLabel = clickedMenu.getText();

		if ("Quit".equals(menuLabel)) {
			System.exit(0);
		}
		if ("How to play".equals(menuLabel)) {
			JOptionPane.showMessageDialog(null,
					"1st Player is 'x' and 2nd Player is 'o' first to make 3 in a row win if no one make a three in a row, draw. ");
		}
		if ("About".equals(menuLabel)) {
			JOptionPane.showMessageDialog(null,
					"Its TicTacToe.");
		}
	}

}
