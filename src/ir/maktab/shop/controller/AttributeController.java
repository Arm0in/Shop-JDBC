package ir.maktab.shop.controller;

import ir.maktab.shop.base.ConnectionInitializer;
import ir.maktab.shop.domain.Attribute;
import ir.maktab.shop.repository.impl.AttributeRepositoryImpl;
import ir.maktab.shop.service.AttributeService;
import ir.maktab.shop.service.impl.AttributeServiceImpl;

public class AttributeController {
    private static AttributeService service = new AttributeServiceImpl(new AttributeRepositoryImpl(ConnectionInitializer.connect()));

    public static void viewProductAttributes(Integer productId) {
        for (Attribute a :
                service.findProductAttributesById(productId)) {
            System.out.println(a);
        }
    }
}
