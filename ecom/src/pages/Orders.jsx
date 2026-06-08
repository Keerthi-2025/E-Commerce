import { useEffect, useState } from "react";
import axiosInstance from "../utils/axiosInstance";
import { useNavigate } from "react-router-dom";

const Orders = () => {
  const [orders, setOrders] = useState([]);
  const navigate = useNavigate(); // ✅ FIXED HERE

  useEffect(() => {
    fetchOrders();
  }, []);

  const fetchOrders = async () => {
    try {
      const res = await axiosInstance.get("/Orders/v1/getAllOrders");
      setOrders(res.data);
    } catch (err) {
      console.log(err);
    }
  };

  return (
    <div className="p-6">
      <h1 className="text-2xl font-bold mb-6">📦 My Orders</h1>

      {orders.length === 0 ? (
        <p>No orders yet</p>
      ) : (
        <div className="space-y-4">
          {orders.map((order) => (
            <div
              key={order.order_id}
              onClick={() => navigate(`/orders/${order.order_id}`)} // ✅ CLICK NAVIGATION
              className="border p-4 rounded shadow bg-white cursor-pointer hover:shadow-lg"
            >
              <h2 className="font-semibold">
                Order ID: {order.order_id}
              </h2>

              <p>Total: ₹{order.total_amt}</p>

              <p className="text-sm text-gray-500">
                User: {order.user?.userName}
              </p>
            </div>
          ))}
        </div>
      )}
    </div>
  );
};

export default Orders;