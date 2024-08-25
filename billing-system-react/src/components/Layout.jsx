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
    case "/SignIn":
      Content = SignUp;
      break;
    default:
      Content = Dashboard;
  }

  return (
    <div className="min-h-screen bg-black flex flex-col justify-between">
      <nav className="bg-black p-4 shadow-md flex items-center justify-between">
        {/* Title on the left */}
        <div>
          <h1 className="text-2xl font-bold text-white cursor-pointer">Billing System</h1>
        </div>
        {/* Links aligned to the right with hover effect */}
        <div className="flex space-x-4">
          <Link 
            to="/" 
            className="text-white hover:bg-white hover:text-black px-4 py-2 rounded transition duration-300"
          >
            Dashboard
          </Link>
          <Link 
            to="/customers" 
            className="text-white hover:bg-white hover:text-black px-4 py-2 rounded transition duration-300"
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
          <Link 
            to="/SignIn"
            className="text-black bg-white px-4 py-2 rounded transition duration-300"
            >
            Sign up
          </Link>
          {/* <button className="text-black bg-white px-4 py-2 rounded transition duration-300">
            Sign up
          </button> */}
        </div>
      </nav>

      <div className="p-6 flex-grow">
        {/* Render the selected page component */}
        <Content />
      </div>

      <footer className="bg-black text-white p-4 text-center">
        <p>&copy; {new Date().getFullYear()} Billing System. All rights reserved.</p>
        <p>
          <a href="#" className="hover:text-gray-400">Privacy Policy</a> | <a href="#" className="hover:text-gray-400">Terms of Service</a>
        </p>
      </footer>
    </div>
  );
};

export default Layout; //making it available for import in other files
