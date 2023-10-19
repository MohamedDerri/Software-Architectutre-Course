package esb;

public class DomesticOrderRouter {
    public String route(Order order) {
        if(order.getAmount() > 175)
                return "nextDayShippingChannel";
        return "normalShippingChannel";
    }
}
