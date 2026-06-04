//package com.Ecom.E_commerce.Dto.Request;
//
//import com.Ecom.E_commerce.models.OrderItems;
//
//import java.util.List;
//
//public record CreateOrdersDto(Integer order_id, String user_id, String total_amt, List<Integer> orderItems ) {
//
//}

package com.Ecom.E_commerce.Dto.Request;

import java.util.List;

public record CreateOrdersDto(
        Integer order_id,
        String user_id,
        String total_amt
) {
}
