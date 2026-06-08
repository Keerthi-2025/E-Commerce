import { useState } from "react";
import { useNavigate } from "react-router-dom";

export default function Navbar({ isLoggedIn = false }) {
  const [menuOpen, setMenuOpen] = useState(false);
  const navigate = useNavigate();

  const handleLogout = () => {
    localStorage.removeItem("user"); // if you store login
    navigate("/login");
  };

  return (
    <nav
      style={{
        height: "60px",
        display: "flex",
        justifyContent: "space-between",
        alignItems: "center",
        padding: "0 20px",
        backgroundColor: "#111",
        color: "white",
        position: "sticky",
        top: 0,
        zIndex: 1000,
      }}
    >
      {/* Logo */}
      <h2 style={{ cursor: "pointer" }} onClick={() => navigate("/")}>
        EasyShop 🛒
      </h2>

      {/* Search Bar */}
      <input
        type="text"
        placeholder="Search products..."
        style={{
          padding: "8px",
          width: "300px",
          borderRadius: "6px",
          border: "none",
          outline: "none",
        }}
      />

      {/* Desktop Menu */}
      <div style={{ display: "flex", gap: "15px", alignItems: "center" }}>
        {!isLoggedIn ? (
          <>
            <button onClick={() => navigate("/login")}>Login</button>
            <button onClick={() => navigate("/signup")}>Signup</button>
          </>
        ) : (
          <>
            <button onClick={() => navigate("/cart")}>Cart 🛒</button>

            <button onClick={() => navigate("/orders")}>
              Orders
            </button>

            <button onClick={() => navigate("/profile")}>
              Profile 👤
            </button>

            <button onClick={handleLogout}>Logout</button>
          </>
        )}
      </div>

      {/* Mobile Menu Button */}
      <button
        onClick={() => setMenuOpen(!menuOpen)}
        style={{
          background: "transparent",
          color: "white",
          fontSize: "20px",
        }}
      >
        ☰
      </button>

      {/* Mobile Dropdown */}
      {menuOpen && (
        <div
          style={{
            position: "absolute",
            top: "60px",
            right: "10px",
            background: "#222",
            padding: "10px",
            borderRadius: "8px",
            display: "flex",
            flexDirection: "column",
            gap: "10px",
          }}
        >
          {!isLoggedIn ? (
            <>
              <button onClick={() => navigate("/login")}>Login</button>
              <button onClick={() => navigate("/signup")}>Signup</button>
            </>
          ) : (
            <>
              <button onClick={() => navigate("/cart")}>Cart 🛒</button>
              <button onClick={() => navigate("/orders")}>Orders</button>
              <button onClick={() => navigate("/profile")}>
                Profile 👤
              </button>
              <button onClick={handleLogout}>Logout</button>
            </>
          )}
        </div>
      )}
    </nav>
  );
}