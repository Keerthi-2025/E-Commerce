import { useEffect, useState } from "react";
import axiosInstance from "../utils/axiosInstance";
import { useNavigate } from "react-router-dom";

const Products = () => {
  const [products, setProducts] = useState([]);

  const navigate = useNavigate();

  useEffect(() => {
    fetchProducts();
  }, []);

  // ✅ FETCH PRODUCTS
  const fetchProducts = async () => {
    try {
      const res = await axiosInstance.get(
        "/Product/v1/getAllProducts"
      );

      console.log("API:", res.data);

      const data = Array.isArray(res.data) ? res.data : [];
      setProducts(data);

    } catch (err) {
      console.log(err);
      setProducts([]);
    }
  };

  // ✅ ADD TO CART (MUST BE HERE)
  const addToCart = async (productId) => {
    try {
      const payload = {
        cartItm_id: Date.now(),
        car_qty: 1,
        cart_id: 1,
        pro_id: productId,
      };

      const res = await axiosInstance.post(
        "/CartItems/add",
        payload
      );

      alert("Added to cart ✅");
      console.log(res.data);

       navigate("/cart");

    } catch (error) {
      console.log(error);
      alert("Failed to add to cart ❌");
    }
  };

  return (
    <div className="p-6">

      <h1 className="text-2xl font-bold mb-6">
        🛍️ Products
      </h1>

      <div className="grid grid-cols-1 md:grid-cols-3 gap-6">

        {products.map((p) => (
          <div
            key={p.pro_id}
            className="border p-4 rounded shadow hover:shadow-lg"
          >
            <h2 className="font-semibold text-lg">
              {p.name}
            </h2>

            <p className="text-gray-600">
              {p.description}
            </p>

            <p className="font-bold mt-2">
              ₹ {p.price}
            </p>

            <p className="text-sm text-gray-500">
              Stock: {p.stock}
            </p>

            <button
              onClick={() => addToCart(p.pro_id)}
              className="mt-3 bg-blue-500 text-white px-3 py-1 rounded"
            >
              Add to Cart
            </button>

          </div>
        ))}

      </div>
    </div>
  );
};

export default Products;