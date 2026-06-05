package com.Ecom.E_commerce.Dto.Request;



//public record CreateOrdersDto(Integer order_id, String user_id, String total_amt, List<Integer> orderItems ) {

//}



public record CreateOrdersDto(
        Integer order_id,
        String user_id,
        String total_amt
) {
}
