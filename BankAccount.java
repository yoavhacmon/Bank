package OOP.constructor.Bank;

public class BankAccount {
    protected int id;
    protected double lineOfCredit, moneyInTheBank, debt;
    protected String owner;
    protected double fee;

    //building new account
    public BankAccount(int id, double lineOfCredit, String owner) {
        this.id = id;
        this.lineOfCredit = lineOfCredit;
        this.owner = owner;
        this.moneyInTheBank = 0;
        this.debt = 0;
        if (this instanceof Private) {
            fee = 0.05;
        }
        if (this instanceof Business) {
            fee = 0.03;
        }
        if (this instanceof Soldier) {
            fee = 0.01;
        }
        if (this instanceof Young) {
            fee = 0.0;
        }
    }

    //first money in the bank
    public void setMoneyInTheBank(double moneyInTheBank) {
        if (this.moneyInTheBank==0) {
            this.moneyInTheBank = moneyInTheBank;
        } else {
            System.out.println("you You can not perform the operation");
        }
    }

    //change the fee
    public void setFee(double fee) {
        this.fee = fee;
    }

    //Deposit money in the account
    public void Deposit(double money) {
        this.moneyInTheBank += money - (money * this.fee);
    }

    //Withdrawing cash from the account
    public void cashWithrawal(double money) {
        if (this instanceof Business){
            if ((this.moneyInTheBank-(money + money * this.fee))>(-40_000)){
                this.moneyInTheBank -= (money + money * this.fee);
            }else{
                System.out.println("You can not perform the operation - you do not have enough money in the account");
            }
        }
        if (this instanceof Private){
            if ((this.moneyInTheBank-(money + money * this.fee))>(-10_000)){
                this.moneyInTheBank -= (money + money * this.fee);
            }else{
                System.out.println("You can not perform the operation - you do not have enough money in the account");
            }
        }
        if (this instanceof Soldier){
            if ((this.moneyInTheBank-(money + money * this.fee))>(-1_000)){
                this.moneyInTheBank -= (money + money * this.fee);
            }else{
                System.out.println("You can not perform the operation - you do not have enough money in the account");
            }
        }
        if (this instanceof Young){
            if ((this.moneyInTheBank-(money + money * this.fee))>0){
                this.moneyInTheBank -= (money + money * this.fee);
            }else{
                System.out.println("You can not perform the operation - you do not have enough money in the account");
            }
        }
    }

    //Taking out a loan
    public void takingOutALoan(double loan) {
        if (this instanceof Private || this instanceof Business) {
            moneyInTheBank += loan - (loan * this.fee);
            this.debt += loan;
        }
        else {
            System.out.println("only private and business account can take out a loan");
        }
    }

    //Loan repayment
    public void loanRepayment(double repayment) {
        if (this instanceof Business){
            if ((this.moneyInTheBank-(repayment + repayment + this.fee))>(-40_000)){
                this.moneyInTheBank -= (repayment + repayment + this.fee);
                this.debt -= (repayment + repayment + this.fee);
            }else{
                System.out.println("You can not perform the operation - you do not have enough money in the account");
            }
        }
        else if (this instanceof Private){
            if ((this.moneyInTheBank-(repayment + repayment + this.fee))>(-10_000)){
                this.moneyInTheBank -= (repayment + repayment + this.fee);
                this.debt -= (repayment + repayment + this.fee);
            }else{
                System.out.println("You can not perform the operation - you do not have enough money in the account");
            }
        }
        else {
            System.out.println("only private and business account can take out a loan");
        }
    }

    @Override
    public String toString() {
        return "BankAccount: " +
                "owner: " + owner +
                ", id: " + id +
                ", lineOfCredit: " + lineOfCredit +
                ", moneyInTheBank: " + moneyInTheBank +
                ", debt: " + debt +
                ", fee: " + fee;
    }
}