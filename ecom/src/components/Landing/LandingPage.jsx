
import land from "../../assets/landing.jpg";

import Navbar from "../Navbar/Navbar";

export default function LandingPage() {
  return (

    <div>
         <Navbar isLoggedIn={false} />

   
    <div className="110% pr-16"
      style={{
        height: "100vh",
        backgroundImage: `url(${land})`,
        backgroundSize: "cover",
        backgroundRepeat: "no-repeat",
        backgroundPosition: "center",
      }}

      
    />
     </div>
  );
}