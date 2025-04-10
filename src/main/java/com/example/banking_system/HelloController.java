package com.example.banking_system;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.util.UUID;

public class HelloController {

    @FXML private TextField accountNameField;
    @FXML private TextField initialDepositField;
    @FXML private ComboBox<String> accountTypeComboBox;
    @FXML private TextArea accountInfoArea;

    private SavingsAccount savingsAccount;
    private CurrentAccount currentAccount;
    private FixedDeposit fixedDeposit;

    @FXML
    public void handleCreateAccount() {
        String accountName = accountNameField.getText();
        double initialDeposit = Double.parseDouble(initialDepositField.getText());
        String accountType = accountTypeComboBox.getValue();

        String accountNumber = UUID.randomUUID().toString().substring(0, 8);

        if ("Savings Account".equals(accountType)) {
            savingsAccount = new SavingsAccount(accountNumber, accountName, initialDeposit);
            accountInfoArea.setText("Savings Account Created\n" + savingsAccount.showInfo());
        } else if ("Current Account".equals(accountType)) {
            currentAccount = new CurrentAccount(accountNumber, accountName, initialDeposit);
            accountInfoArea.setText("Current Account Created\n" + currentAccount.showInfo());
        } else if ("Fixed Deposit Account".equals(accountType)) {
            int interestRate = 25;
            int maturityMonths = 120;
            fixedDeposit = new FixedDeposit(accountNumber, accountName, initialDeposit, interestRate, maturityMonths);
            accountInfoArea.setText("Fixed Deposit Account Created\n" + fixedDeposit.showInfo());
        }
    }

    @FXML
    public void handleWithdrawMoney() {
        if (savingsAccount != null) {
            double amount = Double.parseDouble(initialDepositField.getText());
            savingsAccount.withdrawal(amount);
            accountInfoArea.setText("Withdrawal Successful\n" + savingsAccount.showInfo());
        } else if (currentAccount != null) {
            double amount = Double.parseDouble(initialDepositField.getText());
            currentAccount.withdrawal(amount);
            accountInfoArea.setText("Withdrawal Successful\n" + currentAccount.showInfo());
        }
    }

    @FXML
    public void handleShowInfo() {
        if (savingsAccount != null) {
            accountInfoArea.setText(savingsAccount.showInfo());
        } else if (currentAccount != null) {
            accountInfoArea.setText(currentAccount.showInfo());
        } else if (fixedDeposit != null) {
            accountInfoArea.setText(fixedDeposit.showInfo());
        }
    }
}
