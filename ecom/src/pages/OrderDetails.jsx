import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import axiosInstance from "../utils/axiosInstance";

const OrderDetails = () => {
  const { orderId } = useParams();
  const [items, setItems] = useState([]);

  useEffect(() => {
    fetchOrderItems();
  }, []);

  const fetchOrderItems = async () => {
    try {
      const res = await axiosInstance.get(
        `/OrderItems/v1/getByOrderId?orderId=${orderId}`
      );
      setItems(res.data);
    } catch (err) {
      console.log(err);
    }
  };

  return (
    <div className="p-6">
      <h1 className="text-2xl font-bold mb-4">
        📦 Order Details #{orderId}
      </h1>

      {items.length === 0 ? (
        <p>No items found</p>
      ) : (
        <div className="space-y-4">
          {items.map((item) => (
            <div
              key={item.orderItms_Id}
              className="border p-4 rounded shadow bg-white"
            >
              <h2 className="font-semibold">
                Product ID: {item.product?.pro_id}
              </h2>

              <p>Quantity: {item.ord_qty}</p>

              <p>Price: ₹{item.product?.price}</p>

              <p className="text-sm text-gray-500">
                Product Name: {item.product?.name}
              </p>
            </div>
          ))}
        </div>
      )}
    </div>
  );
};

export default OrderDetails;