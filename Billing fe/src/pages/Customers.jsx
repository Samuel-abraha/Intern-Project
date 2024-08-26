import { useEffect, useState } from "react";
// import axios from "../api/axios";

const Customers = () => {
  const [customers, setCustomers] = useState([]);

  useEffect(() => {
    const fetchCustomers = async () => {
      try {
        const response = await axios.get("/customers");
        setCustomers(response.data);
      } catch (error) {
        console.error("Error fetching customers:", error);
      }
    };

    fetchCustomers();
  }, []);

  return (
    <div className="p-6 bg-gray-800 shadow-md rounded-lg">
      <h1 className="text-3xl font-bold mb-4 text-white">Customers</h1>
      <p className="text-white mb-4">List of customers with their details.</p>
      <ul className="divide-y divide-gray-200">
        {customers.map(customer => (
          <li key={customer.id} className="py-4 flex items-center justify-between">
            <div className="flex items-center">
              <div className="w-12 h-12 bg-gray-200 rounded-full flex items-center justify-center">
                <span className="text-xl font-semibold">{customer.fullname.charAt(0)}</span>
              </div>
              <div className="ml-4">
                <p className="text-lg font-semibold text-gray-800">{customer.fullname}</p>
                <p className="text-gray-600">{customer.email}</p>
              </div>
            </div>
            <button className="bg-blue-500 text-white px-4 py-2 rounded-lg">View Details</button>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default Customers;
