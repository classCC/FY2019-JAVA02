package com.wz.service;

import com.wz.common.ServerResponse;
import com.wz.pojo.Shipping;
import com.wz.common.ServerResponse;
import com.wz.pojo.Shipping;

public interface IShippingService {

    public ServerResponse add(Shipping shipping);

    public ServerResponse findShippingById(Integer shippingid);
}
