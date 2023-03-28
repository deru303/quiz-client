package com.github.danrog303.quizclient;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.Socket;

public class QuizClientViewController {
    private final int SERVER_PORT = 2138;

    public @FXML TextField inputNick;
    public @FXML TextField inputAnswer;

    public @FXML void onSendAnswer(ActionEvent actionEvent) {
        try (Socket socket = new Socket("localhost", SERVER_PORT)) {
            String socketOutput = "%s|%s".formatted(inputNick.getText(), inputAnswer.getText());
            socket.getOutputStream().write(socketOutput.getBytes());
        } catch(IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Could not connect to quiz server");
            alert.showAndWait();
        }
    }
}