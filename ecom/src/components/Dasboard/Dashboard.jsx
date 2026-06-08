// import { useNavigate } from "react-router-dom";

// const Dashboard = () => {
//   const navigate = useNavigate();

//   const handleLogout = () => {
//     localStorage.removeItem("token");
//     navigate("/login");
//   };

//   return (
//     <div className="min-h-screen bg-gray-100 flex flex-col">

//       {/* Header */}
//       <div className="flex justify-between items-center bg-white shadow px-6 py-4">
//         <h1 className="text-xl font-bold">Dashboard</h1>

//         <button
//           onClick={handleLogout}
//           className="bg-red-500 text-white px-4 py-2 rounded"
//         >
//           Logout
//         </button>
//       </div>

//       {/* Content */}
//       <div className="p-6">
//         <h2 className="text-2xl font-semibold">
//           Welcome to your Dashboard 
//         </h2>

//         <p className="mt-2 text-gray-600">
//           You are successfully logged in.
//         </p>

//         {/* Example cards */}
//         <div className="grid grid-cols-1 md:grid-cols-3 gap-4 mt-6">

//           <div className="bg-white p-4 shadow rounded">
//             <h3 className="font-bold">Users</h3>
//             <p>Manage users here</p>
//           </div>

//           <div className="bg-white p-4 shadow rounded">
//             <h3 className="font-bold">Orders</h3>
//             <p>View orders</p>
//           </div>

//           <div className="bg-white p-4 shadow rounded">
//             <h3 className="font-bold">Settings</h3>
//             <p>Manage system settings</p>
//           </div>

//         </div>
//       </div>
//     </div>
//   );
// };

// export default Dashboard;