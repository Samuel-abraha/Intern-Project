import { Link, useLocation, useNavigate } from "react-router-dom";
import { useState, useEffect } from "react";
import Dashboard from "../pages/Dashboard";
import Customers from "../pages/Customers";
import Invoices from "../pages/Invoices";
import Services from "../pages/Services";
import Profile from "../pages/Profile";
import SignIn from "../pages/SignIn";

const Layout = () => {
  const location = useLocation();
  const navigate = useNavigate();
  const [username, setUsername] = useState(null);
  const [dropdownOpen, setDropdownOpen] = useState(false);

  useEffect(() => {
    // Fetch the username from localStorage after sign-in
    const savedUsername = localStorage.getItem("username");
    if (savedUsername) {
      setUsername(savedUsername);
    }
  }, []);

  const handleLogout = () => {
    // Clear username from localStorage
    localStorage.removeItem("username");
    setUsername(null);
    setDropdownOpen(false);
    // Redirect to the dashboard
    navigate('/');
  };

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
      case "/profile":
        Content = Profile;
        break;
    case "/SignIn":
      Content = SignIn;
      break;
      
    default:
      Content = Dashboard;
  }

  return (
    <div className="min-h-screen flex flex-col bg-neutral-800">
      <div className="flex">
        {/* Sidebar */}
        <nav className="bg-black w-64 h-screen p-4 flex flex-col justify-between fixed text-lg">
          {/* Title on top of the sidebar */}
          <div>
            <h1 className="text-2xl font-bold text-white cursor-pointer mb-6">
              Billing System
            </h1>


            {/* Links in the sidebar */}
            <div className="flex flex-col space-y-4">
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
              
              
            </div>
          </div>

          
          {/* Username and dropdown at the bottom */}
          <div className="relative mt-auto">
            {username ? (
              <div className="relative flex flex-col">
                <div
                  className="flex items-center space-x-2 cursor-pointer mb-4"
                  onClick={() => setDropdownOpen(!dropdownOpen)}
                >
                  {/* Profile icon and username */}
                  <svg
                    xmlns="http://www.w3.org/2000/svg"
                    className="h-6 w-6 text-white"
                    fill="none"
                    viewBox="0 0 24 24"
                    stroke="currentColor"
                    strokeWidth={2}
                  >
                    <path
                      strokeLinecap="round"
                      strokeLinejoin="round"
                      d="M12 12c2.21 0 4-1.79 4-4s-1.79-4-4-4-4 1.79-4 4 1.79 4 4 4zm0 2c-3.31 0-6 2.69-6 6v1h12v-1c0-3.31-2.69-6-6-6z"
                    />
                  </svg>
                  <span className="text-white text-sm">{username}</span>
                </div>
                {dropdownOpen && (
                  <div className="w-full bg-black rounded-md shadow-lg py-2 z-20 mb-8">
                    <Link
                      to="/profile"
                      className="block px-4 py-2 text-sm text-white hover:bg-white hover:text-black rounded"
                    >
                      Profile
                    </Link>
                    <button
                      onClick={handleLogout}
                      className="block w-full text-left px-4 py-2 text-sm text-white hover:bg-white hover:text-black rounded"
                    >
                      Log Out
                    </button>
                  </div>
                )}
              </div>
            ) : (
              <Link
                to="/SignIn"
                className="text-black text-base bg-green-400 px-3 py-1 mb-10 rounded transition duration-300 "
              >
                Sign In
              </Link>
            )}
          </div>

          
        </nav>

        {/* Main content */}
        <div className="flex-auto ml-64">
          {/* Render the selected page component */}
          <Content />
        </div>
      </div>

      {/* Footer at the bottom */}
      <footer className="bg-neutral-800 text-white p-4 text-center mt-auto">
        <p>&copy; {new Date().getFullYear()} Billing System. All rights reserved.</p>
        <p>
          <a href="#" className="hover:text-gray-400">Privacy Policy</a> | <a href="#" className="hover:text-gray-400">Terms of Service</a>
        </p>
      </footer>
    </div>
  );
};

export default Layout;
