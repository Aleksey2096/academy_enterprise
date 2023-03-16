package by.academy.pharmacy.controller.extractor.impl;

import by.academy.pharmacy.controller.extractor.Extractor;
import by.academy.pharmacy.entity.OrderObject;
import by.academy.pharmacy.service.util.RequestDataUtil;

import javax.servlet.http.HttpServletRequest;

public class OrderObjectExtractor implements Extractor<OrderObject> {
    private final RequestDataUtil requestDataUtil
            = RequestDataUtil.getInstance();

    @Override
    public OrderObject extract(final HttpServletRequest request) {
        OrderObject orderObject = new OrderObject();
        orderObject.setOrderField(requestDataUtil.getOrderField(request));
        orderObject.setOrderType(requestDataUtil.getOrderType(request));
        return orderObject;
    }
}
