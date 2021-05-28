package pl.gdynia.amw.lab6.response.success;

public class ExchangeRateCalcSuccess extends ResponseSuccess {
    public static class Data {
        public String from;
        public String to;
        public float rate;

        public Data(String currencyFrom, String currencyTo, float rate) {
            this.from = currencyFrom;
            this.to = currencyTo;
            this.rate = rate;
        }
    }

    static public ExchangeRateCalcSuccess newSuccess(String currencyFrom, String currencyTo, float rate) {
        Data data = new Data(currencyFrom, currencyTo, rate);

        return new ExchangeRateCalcSuccess(200, data);
    }

    private ExchangeRateCalcSuccess(int code, Data data) {
        super(code, data);
    }
}
