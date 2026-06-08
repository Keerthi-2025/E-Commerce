import { useEffect, useState } from "react";
import axiosInstance from "../utils/axiosInstance";

const Cart = () => {
  const [cartItems, setCartItems] = useState([]);

  useEffect(() => {
    fetchCartItems();
  }, []);

  const fetchCartItems = async () => {
    try {
      const res = await axiosInstance.get(
        "/CartItems/v1/getAllCartItems"
      );

      setCartItems(res.data);
    } catch (err) {
      console.log(err);
    }
  };

  return (
    <div className="p-6">
      <h1 className="text-2xl font-bold mb-6">
        🛒 Your Cart
      </h1>

      {cartItems.length === 0 ? (
        <p>No items in cart</p>
      ) : (
        <div className="space-y-4">
          {cartItems.map((item) => (
            <div
              key={item.cartItm_id}
              className="border p-4 rounded shadow"
            >
              <p>
                <b>Cart Item ID:</b> {item.cartItm_id}
              </p>

              <p>
                <b>Quantity:</b> {item.car_qty}
              </p>

              <p>
                <b>Product ID:</b> {item.pro_id}
              </p>
            </div>
          ))}
        </div>
      )}
    </div>
  );
};

export default Cart;