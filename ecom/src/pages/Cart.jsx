// import { useEffect, useState } from "react";
// import axiosInstance from "../utils/axiosInstance";

// const Cart = () => {
//   const [cartItems, setCartItems] = useState([]);

//   useEffect(() => {
//     fetchCartItems();
//   }, []);

//   // 🔥 FETCH CART ITEMS
//   const fetchCartItems = async () => {
//     try {
//       const res = await axiosInstance.get("/CartItems/v1/getAllCartItems");
//       setCartItems(res.data || []);
//     } catch (err) {
//       console.log(err);
//       setCartItems([]);
//     }
//   };

//   // 🗑️ REMOVE ITEM (FRONTEND ONLY)
//   const removeItem = (cartItm_id) => {
//     const updatedCart = cartItems.filter(
//       (item) => item.cartItm_id !== cartItm_id
//     );

//     setCartItems(updatedCart);
//   };

//   // 🧮 TOTAL ITEMS
//   const totalItems = cartItems.length;

//   return (
//     <div className="min-h-screen bg-gray-100 p-6 flex justify-center">

//       <div className="w-full max-w-3xl">

//         <h1 className="text-3xl font-bold mb-6 text-gray-800">
//           🛒 Your Cart
//         </h1>

//         {cartItems.length === 0 ? (
//           <div className="bg-white p-6 rounded shadow text-gray-600">
//             Your cart is empty 😕
//           </div>
//         ) : (
//           <div className="bg-white rounded-lg shadow">

//             <div className="max-h-[420px] overflow-y-auto p-4 space-y-4">

//               {cartItems.map((item) => (
//                 <div
//                   key={item.cartItm_id}
//                   className="flex justify-between items-center border rounded-lg p-4 hover:shadow-md transition"
//                 >
//                   <div>
//                     <h2 className="font-semibold text-gray-800">
//                       🧾 Item #{item.cartItm_id}
//                     </h2>

//                     <p className="text-gray-600">
//                       Quantity:{" "}
//                       <span className="font-medium">
//                         {item.car_qty}
//                       </span>
//                     </p>

//                     <p className="text-sm text-gray-500">
//                       Product ID: {item.pro_id}
//                     </p>
//                   </div>

//                   <button
//                     onClick={() => removeItem(item.cartItm_id)}
//                     className="bg-red-500 hover:bg-red-600 text-white px-4 py-2 rounded"
//                   >
//                     Remove
//                   </button>
//                 </div>
//               ))}

//             </div>

//             {/* FOOTER */}
//             <div className="border-t p-4 flex justify-between items-center bg-gray-50">
//               <span className="font-semibold">
//                 Total Items: {totalItems}
//               </span>

//               <button className="bg-green-600 hover:bg-green-700 text-white px-6 py-2 rounded">
//                 Checkout
//               </button>
//             </div>
            

//           </div>
//         )}
//       </div>
//     </div>
//   );
// };

// export default Cart;


import { useEffect, useState } from "react";
import axiosInstance from "../utils/axiosInstance";
import { useNavigate } from "react-router-dom";

const Cart = () => {
  const [cartItems, setCartItems] = useState([]);
  const navigate = useNavigate();

  const userId = localStorage.getItem("userId"); // IMPORTANT FIX

  useEffect(() => {
    fetchCartItems();
  }, []);

  // GET CART ITEMS
  const fetchCartItems = async () => {
    try {
      const res = await axiosInstance.get(
        "/CartItems/v1/getAllCartItems"
      );
      setCartItems(res.data || []);
    } catch (err) {
      console.log(err);
      setCartItems([]);
    }
  };

  // REMOVE ITEM (FRONTEND ONLY)
  const removeItem = (cartItm_id) => {
    setCartItems((prev) =>
      prev.filter((item) => item.cartItm_id !== cartItm_id)
    );
  };

  // CHECKOUT FIXED
  const checkout = async () => {
    try {
      if (!userId) {
        alert("User not logged in ❌");
        navigate("/login");
        return;
      }

      const res = await axiosInstance.post(
        `/Orders/v1/checkout?userId=${userId}`
      );

      alert("Order placed successfully ✅");

      setCartItems([]);

      navigate("/orders");
    } catch (err) {
      console.log(err);
      alert(
        err?.response?.data?.message ||
          "Checkout failed ❌"
      );
    }
  };

  return (
    <div className="min-h-screen bg-gray-100 p-6 flex justify-center">
      <div className="w-full max-w-3xl">

        <h1 className="text-3xl font-bold mb-6">
          🛒 Your Cart
        </h1>

        {cartItems.length === 0 ? (
          <div className="bg-white p-6 rounded shadow">
            Cart is empty
          </div>
        ) : (
          <div className="bg-white rounded shadow">

            <div className="p-4 space-y-4 max-h-[420px] overflow-y-auto">

              {cartItems.map((item) => (
                <div
                  key={item.cartItm_id}
                  className="flex justify-between border p-3 rounded"
                >
                  <div>
                    <p>ID: {item.cartItm_id}</p>
                    <p>Qty: {item.car_qty}</p>
                    <p>Product: {item.pro_id}</p>
                  </div>

                  <button
                    onClick={() =>
                      removeItem(item.cartItm_id)
                    }
                    className="bg-red-500 text-white px-3 py-1 rounded"
                  >
                    Remove
                  </button>
                </div>
              ))}
            </div>

            <div className="border-t p-4 flex justify-between">
              <p>Total: {cartItems.length}</p>

              <button
                onClick={checkout}
                className="bg-green-600 text-white px-4 py-2 rounded"
              >
                Checkout
              </button>
            </div>

          </div>
        )}

      </div>
    </div>
  );
};

export default Cart;