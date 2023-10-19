package esb;

public class InitialOrderRouter {
    public String route(Order order){
        if(order.getOrderType().equalsIgnoreCase("INTERNATIONAL"))
            return "internationalShippingChannel";
        return "domesticShippingChannel";
    }
}

