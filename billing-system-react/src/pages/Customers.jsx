import { useEffect, useState } from 'react';
import axios from '../api/axios'; // Ensure axios is imported correctly

const Customers = () => {
  const [customers, setCustomers] = useState([]);
  const [selectedCustomer, setSelectedCustomer] = useState(null); // State to store selected customer
  const [isModalOpen, setIsModalOpen] = useState(false); // State to handle modal visibility

  useEffect(() => {
    const fetchCustomers = async () => {
      try {
        const response = await axios.get("/Admin/Customers/All");
        // Ensure response data is an array
        const data = response.data; // Adjust if needed
        setCustomers(Array.isArray(data) ? data : []);
      } catch (error) {
        console.error("Error fetching customers:", error);
      }
    };

    fetchCustomers();
  }, []);

  const openModal = (customer) => {
    setSelectedCustomer(customer);
    setIsModalOpen(true);
  };

  const closeModal = () => {
    setIsModalOpen(false);
    setSelectedCustomer(null);
  };

  return (
    <div className="p-10 bg-neutral-900 shadow-md">
      <h1 className="text-3xl font-bold mb-4 text-white">Customers</h1>
      <p className="text-white mb-4">List of customers with their details.</p>
      {Array.isArray(customers) && customers.length > 0 ? (
        <ul className="divide-y divide-gray-200">
          {customers.map((customer) => (
            <li
              key={customer.username}
              className="py-4 flex flex-col sm:flex-row items-center justify-between"
            >
              <div className="flex items-center">
                <div className="w-12 h-12 bg-gray-200 rounded-full flex items-center justify-center">
                  <span className="text-xl font-semibold">
                    {customer.fullname.charAt(0)}
                  </span>
                </div>
                <div className="ml-4">
                  <p className="text-lg font-semibold text-white">
                    {customer.fullname}
                  </p>
                </div>
              </div>
              <button
                onClick={() => openModal(customer)}
                className="bg-green-600 text-white hover:bg-green-500 px-2 py-2 rounded-lg mt-2 sm:mt-0"
              >
                View Details
              </button>
            </li>
          ))}
        </ul>
      ) : (
        <p className="text-white">No customers found.</p>
      )}
      {/* Modal */}
      {isModalOpen && selectedCustomer && (
        <div className="fixed inset-0 flex items-center justify-center z-50 bg-black bg-opacity-75">
          <div className="bg-white rounded-lg p-6 shadow-lg max-w-sm w-full">
            <h2 className="text-xl font-bold mb-4">
              {selectedCustomer.fullname}
            </h2>
            <p className="text-gray-600 mb-2">
              <strong>Phone Number:</strong> {selectedCustomer.phonenumber}
            </p>
            <p className="text-gray-600 mb-2">
              <strong>Email:</strong> {selectedCustomer.email}
            </p>
            <p className="text-gray-600 mb-2">
              <strong>Username:</strong> {selectedCustomer.username}
            </p>
            <button
              onClick={closeModal}
              className="mt-4 bg-red-500 text-white hover:bg-red-400 px-4 py-2 rounded-lg"
            >
              Close
            </button>
          </div>
        </div>
      )}
    </div>
  );
};

export default Customers;
