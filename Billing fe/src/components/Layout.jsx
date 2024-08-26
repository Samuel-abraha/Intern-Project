import { Link, useLocation } from "react-router-dom";


import Dashboard from "../pages/Dashboard";
import Customers from "../pages/Customers";
import Invoices from "../pages/Invoices";
import Services from "../pages/Services";

const Layout = () => {
  const location = useLocation();

  let Content;
  switch (location.pathname) {
    case "/customers":
      Content = Customers;
      break;
    case "/invoices":
      Content = Invoices;
      break;
    case "/services":
      Content = Services;
      break;
    default:
      Content = Dashboard;
  }

  return (
    <div className="min-h-screen bg-black">
      <nav className="bg-black p-4 shadow-md flex items-center justify-between">
        {/* Title on the left */}
        <div>
          <h1 className="text-2xl font-bold text-white cursor-pointer">Billing System</h1>
        </div>
        {/* Links aligned to the right with hover effect */}
        <div className="flex space-x-4">
          <Link 
            to="/" 
            className=" text-white hover:bg-white hover:text-black px-4 py-2 rounded transition duration-300"
          >
            Dashboard
          </Link>
          <Link 
            to="/customers" 
            className=" text-white hover:bg-white hover:text-black px-4 py-2 rounded transition duration-300"
          >
            Customers
          </Link>
          <Link 
            to="/invoices" 
            className="text-white hover:bg-white hover:text-black px-4 py-2 rounded transition duration-300"
          >
            Invoices
          </Link>
          <Link 
            to="/services" 
            className="text-white hover:bg-white hover:text-black px-4 py-2 rounded transition duration-300"
          >
            Services
          </Link>
          <button className="text-black bg-white px-4 py-2 rounded transition duration-300">
            Login
          </button>
        </div>
      </nav>
      <div className="p-6 ">
        {/* Render the selected page component */}
        <Content />
      </div>
    </div>
  );
};

export default Layout;
