package pl.gdynia.amw.lab6.response;

public class ExchangeSuccess extends Response {
    class Data {
        public String from;
        public String to;
        public float rate;

        public Data(String currencyFrom, String currencyTo, float rate) {
            this.from = currencyFrom;
            this.to = currencyTo;
            this.rate = rate;
        }
    }

    private Data data;

    public ExchangeSuccess(String currencyFrom, String currencyTo, float rate) {
        super(200, Type.SUCCESS);

        this.data = new Data(currencyFrom, currencyTo, rate);
    }

    public Data getData() {
        return data;
    }
}
