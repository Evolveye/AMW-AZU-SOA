package pl.gdynia.amw.lab6.response.success;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

public class ExchangeRateCalcSuccess extends ResponseSuccess {
    public static class Data {
        public String from;
        public String to;
        public BigDecimal rate;
        public String date;

        public Data(String currencyFrom, String currencyTo, BigDecimal rate, Date date) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);

            this.from = currencyFrom;
            this.to = currencyTo;
            this.rate = rate;
            this.date = ""
                    + String.format("%1$" + 4 + "s", calendar.get(Calendar.YEAR)).replace(' ', '0')
                    + "-"
                    + String.format("%1$" + 2 + "s", calendar.get(Calendar.MONTH) + 1).replace(' ', '0')
                    + "-"
                    + String.format("%1$" + 2 + "s", calendar.get(Calendar.DAY_OF_MONTH)).replace(' ', '0');
        }
    }

    static public ExchangeRateCalcSuccess newSuccess(String currencyFrom, String currencyTo, BigDecimal rate, Date date) {
        Data data = new Data(currencyFrom, currencyTo, rate, date);

        return new ExchangeRateCalcSuccess(200, data);
    }

    private ExchangeRateCalcSuccess(int code, Data data) {
        super(code, data);
    }
}
