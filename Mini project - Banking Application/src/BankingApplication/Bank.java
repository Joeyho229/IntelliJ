package BankingApplication;

public class Bank {

    private String bankAddress;

    private String bankName;

    public Bank(String name){
        this.bankName = name;
    }

    public String getBankName(){
        return this.bankName;
    }

    protected void setBankName(String name){
        this.bankName = name;
    }

    public String getBankAddress(){
        return this.bankAddress;
    }

    protected void setBankAddress(String name){
        this.bankAddress = name;
    }
}
