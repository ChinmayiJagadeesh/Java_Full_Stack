// Parent Class

class BankAccount {

    #balance;
    #pin;
    transactionHistory = [];

    constructor(name, balance, pin) {
        this.name = name;
        this.#balance = balance;
        this.#pin = pin;
    }

    checkPIN(pin) {
        return this.#pin === pin;
    }

    deposit(amount) {

        if (amount > 0) {
            this.#balance += amount;

            this.transactionHistory.push(
                "Deposited ₹" + amount
            );

            console.log("Deposited:", amount);
        }
    }

    withdraw(amount) {

        if (amount <= 0) {
            console.log("Invalid Amount");
        }

        else if (amount > this.#balance) {
            console.log("Insufficient Balance");
        }

        else {
            this.#balance -= amount;

            this.transactionHistory.push(
                "Withdraw ₹" + amount
            );

            console.log("Withdrawn:", amount);
        }
    }

    showBalance() {
        console.log("Balance:", this.#balance);
    }

    showHistory() {
        console.log("Transaction History:");
        this.transactionHistory.forEach(t => console.log(t));
    }
}


// Savings Account

class SavingsAccount extends BankAccount {

    calculateInterest(rate) {

        console.log(
            "Interest Added:", rate + "%"
        );
    }
}


// Current Account

class CurrentAccount extends BankAccount {

    accountType() {
        console.log("Current Account");
    }
}


// ------------------ TEST ------------------

let user1 = new SavingsAccount(
    "John",
    5000,
    1234
);

if (user1.checkPIN(1234)) {

    user1.deposit(1000);

    user1.withdraw(2000);

    user1.showBalance();

    user1.calculateInterest(5);

    user1.showHistory();
}
else {
    console.log("Wrong PIN");
}