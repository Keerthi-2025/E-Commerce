// import { useEffect, useState } from "react";
// import { useParams } from "react-router-dom";
// import axiosInstance from "../utils/axiosInstance";

// const OrderDetails = () => {
//   const { orderId } = useParams();

//   const [order, setOrder] = useState(null);
//   const [orderItems, setOrderItems] = useState([]);

//   useEffect(() => {
//     if (orderId) {
//       fetchOrderDetails();
//       fetchOrderItems();
//     }
//   }, [orderId]);

//   const fetchOrderDetails = async () => {
//     try {
//       const res = await axiosInstance.get(
//         `/Orders/v1/getOrderById?order_id=${orderId}`
//       );
//       setOrder(res.data);
//     } catch (err) {
//       console.log(err);
//       setOrder(null);
//     }
//   };

//   const fetchOrderItems = async () => {
//     try {
//       const res = await axiosInstance.get(
//         `/OrderItems/v1/getByOrderId?orderId=${orderId}`
//       );
//       setOrderItems(res.data || []);
//     } catch (err) {
//       console.log(err);
//       setOrderItems([]);
//     }
//   };

// //   // ✅ SAFE RETURN (IMPORTANT FIX)
// //   if (!order) {
// //     return <p className="p-6">Loading order details...</p>;
// //   }

//   return (
//     <div className="p-6">

//       {/* ORDER SUMMARY */}
//       <div className="border p-4 rounded shadow bg-white mb-6">
//         <h2 className="text-xl font-bold">
//           Order ID: {order?.order_id}
//         </h2>

//         <p className="mt-2">
//           Total: ₹{order?.total_amt}
//         </p>

//         <p className="text-gray-500">
//           User: {order?.user?.userName}
//         </p>
//       </div>

//       {/* ORDER ITEMS */}
//       <div>
//         <h3 className="text-lg font-semibold mb-3">Items</h3>

//         {orderItems.length === 0 ? (
//           <p>No items found</p>
//         ) : (
//           <div className="space-y-3">
//             {orderItems.map((item) => (
//               <div
//                 key={item.orderItms_Id}
//                 className="border p-3 rounded bg-gray-50"
//               >
//                 <p>Product: {item.product?.pro_name}</p>
//                 <p>Quantity: {item.ord_qty}</p>
//               </div>
//             ))}
//           </div>
//         )}
//       </div>

//     </div>
//   );
// };

// export default OrderDetails;


import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import axiosInstance from "../utils/axiosInstance";

const OrderDetails = () => {
  const { orderId } = useParams();

  const [order, setOrder] = useState(null);
  const [items, setItems] = useState([]);

  useEffect(() => {
    if (orderId) {
      fetchOrder();
      fetchItems();
    }
  }, [orderId]);

  const fetchOrder = async () => {
    try {
      const res = await axiosInstance.get(
        `/Orders/v1/getOrderById?order_id=${orderId}`
      );
      setOrder(res.data || null);
    } catch (err) {
      console.log(err);
      setOrder(null);
    }
  };

  const fetchItems = async () => {
    try {
      const res = await axiosInstance.get(
        `/OrderItems/v1/getByOrderId?orderId=${orderId}`
      );
      setItems(res.data || []);
    } catch (err) {
      console.log(err);
      setItems([]);
    }
  };

  if (!order) {
    return <p className="p-6">Loading order...</p>;
  }

  return (
    <div className="p-6">

      {/* ORDER INFO */}
      <div className="border p-4 rounded bg-white mb-6">
        <h2 className="text-xl font-bold">
          Order ID: {order.order_id}
        </h2>

        <p>Total: ₹{order.total_amt}</p>

        <p>User: {order.user?.userName}</p>
      </div>

      {/* ITEMS */}
      <div>
        <h3 className="font-semibold mb-3">Items</h3>

        {items.length === 0 ? (
          <p>No items found</p>
        ) : (
          items.map((item) => (
            <div
              key={item.orderItms_Id}
              className="border p-3 rounded mb-2"
            >
              <p>Product: {item.product?.pro_name}</p>
              <p>Quantity: {item.ord_qty}</p>
            </div>
          ))
        )}

      </div>

    </div>
  );
};

export default OrderDetails;