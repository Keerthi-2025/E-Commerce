import { useEffect, useState } from "react";
import axiosInstance from "../utils/axiosInstance";

const Cart = () => {
  const [cartItems, setCartItems] = useState([]);

  useEffect(() => {
    fetchCartItems();
  }, []);

  // 🔥 FETCH CART ITEMS
  const fetchCartItems = async () => {
    try {
      const res = await axiosInstance.get("/CartItems/v1/getAllCartItems");
      setCartItems(res.data);
    } catch (err) {
      console.log(err);
    }
  };

  // 🗑️ REMOVE SINGLE ITEM
  const removeItem = async (cartItm_id) => {
    try {
      await axiosInstance.delete(
        `/CartItems/v1/deleteOrderItems?orderItems_Id=${cartItm_id}`
      );

      // refresh cart after delete
      fetchCartItems();

    } catch (err) {
      console.log(err);
    }
  };

  return (
    <div className="min-h-screen bg-gray-100 p-6 flex justify-center">

      <div className="w-full max-w-3xl">

        {/* HEADER */}
        <h1 className="text-3xl font-bold mb-6 text-gray-800">
          🛒 Your Cart
        </h1>

        {/* EMPTY STATE */}
        {cartItems.length === 0 ? (
          <div className="bg-white p-6 rounded shadow text-gray-600">
            Your cart is empty 😕
          </div>
        ) : (
          <>
            {/* SCROLLABLE CART AREA */}
            <div className="bg-white rounded-lg shadow">

              <div className="max-h-[420px] overflow-y-auto p-4 space-y-4">

                {cartItems.map((item) => (
                  <div
                    key={item.cartItm_id}
                    className="flex justify-between items-center border rounded-lg p-4 hover:shadow-md transition"
                  >

                    {/* LEFT SIDE */}
                    <div>
                      <h2 className="font-semibold text-gray-800">
                        🧾 Item #{item.cartItm_id}
                      </h2>

                      <p className="text-gray-600">
                        Quantity:{" "}
                        <span className="font-medium">
                          {item.car_qty}
                        </span>
                      </p>

                      <p className="text-sm text-gray-500">
                        Product ID: {item.pro_id}
                      </p>
                    </div>

                    {/* RIGHT SIDE */}
                    <div className="text-right">
                      <button
                        onClick={() => removeItem(item.cartItm_id)}
                        className="bg-red-500 hover:bg-red-600 text-white px-4 py-2 rounded"
                      >
                        Remove
                      </button>
                    </div>

                  </div>
                ))}

              </div>

              {/* FOOTER */}
              <div className="border-t p-4 flex justify-between items-center bg-gray-50">
                <span className="font-semibold">
                  Total Items: {cartItems.length}
                </span>

                <button className="bg-green-600 hover:bg-green-700 text-white px-6 py-2 rounded">
                  Checkout
                </button>
              </div>

            </div>
          </>
        )}

      </div>
    </div>
  );
};

export default Cart;