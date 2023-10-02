package com.trendyol.shipment;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Basket {

    private List<Product> products;
    private Map<ShipmentSize,Long> getProductCountbyShipmentSize() {

        return products.stream().collect(Collectors.groupingBy(e -> e.getSize(), Collectors.counting()));
    }

    private Map.Entry<ShipmentSize, Long> getMaxItemSizeinBasket(Map<ShipmentSize,Long> ProductCountbyShipmentSize) {
    //Map<ShipmentSize,Long> ProductCountbyShipmentSize = getProductCountbyShipmentSize();

    return ProductCountbyShipmentSize.entrySet().stream().max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get();
    }
    private  ShipmentSize getLargestItemSizeinBasket( Map<ShipmentSize,Long> ProductCountbyShipmentSize) {
        //Map<ShipmentSize,Long> ProductCountbyShipmentSize = getProductCountbyShipmentSize();
        return  ProductCountbyShipmentSize.entrySet().stream()
                .max(Map.Entry.comparingByKey()).get().getKey();
    }



    public ShipmentSize getShipmentSize() {
        Map<ShipmentSize,Long> productCountbyShipmentSize=  getProductCountbyShipmentSize();
        Map.Entry<ShipmentSize, Long> MaxItemSizeinBasket = getMaxItemSizeinBasket(productCountbyShipmentSize);
        if(MaxItemSizeinBasket.getValue()>=3){
            return MaxItemSizeinBasket.getKey().nextSize();
        }
        return getLargestItemSizeinBasket(productCountbyShipmentSize);
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
//2 Small _> Medium
//2 Medium --> Large
