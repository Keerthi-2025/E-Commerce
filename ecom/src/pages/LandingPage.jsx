import land from "../assets/landing.jpg";

export default function LandingPage() {
  return (
    <div className="110% pr-16"
      style={{
        height: "100vh",
        backgroundImage: `url(${land})`,
        backgroundSize: "cover",
        backgroundRepeat: "no-repeat",
        backgroundPosition: "center",
      }}
    />
  );
}