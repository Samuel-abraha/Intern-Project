import { useEffect, useState } from 'react';
import axios from 'axios';
import Invoice from "./c4p/Invoice";

const PaymentBody = () => {
  const [balance, setBalance] = useState(0);
  const [showInvoice, setShowInvoice] = useState(false);
  const [paymentData, setPaymentData] = useState({
    accountNumber: "",
    amount: "",
    description: "",
  });

  useEffect(() => {
    const fetchBalance = async () => {
      const id = 152;
      try {
        console.log("Fetching balance...");
        const response = await axios.get(`/api/balance/${id}`);
        console.log("Response received:", response);
        setBalance(response.data);
      } catch (error) {
        console.error("Error fetching balance:", error);
      }
    };

    fetchBalance();
  }, []);

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setPaymentData((prevData) => ({
      ...prevData,
      [name]: value,
    }));
  };

  const handlePayment = () => {
    const { accountNumber, amount, description } = paymentData;

    // Check if all fields are filled
    if (!accountNumber || !amount || !description) {
      alert("Please fill out all fields before proceeding.");
      return; // Exit the function without showing the invoice
    }
    setShowInvoice(true); // Show the invoice after successful payment
  };

  return (
    <div >
      <div className="bg-green-300 p-4 mt-5 mb-2 rounded-lg inline-block">
      Balance: ${balance}
        </div>
      
      <div className="container flex mt-1">
      <div className="payment-panel p-4 bg-white rounded-lg shadow-md w-64 h-auto">
        <h3 className="text-lg font-bold mb-4">Payment Information</h3>
        <div className="flex flex-col space-y-4">
          <div>
            <label htmlFor="account-number" className="block text-gray-700 font-semibold mb-2">
              Account Number
            </label>
            <input
              type="text"
              name="accountNumber"
              value={paymentData.accountNumber}
              onChange={handleInputChange}
              className="w-full px-3 py-2 border rounded-md sm:w-3/4"
              placeholder="Enter account number"
              required
            />
          </div>

          <div className="flex space-x-4">
            <div className="w-1/2 sm:w-full">
              <label htmlFor="amount" className="block text-gray-700 font-semibold mb-2">
                Amount $
              </label>
              <input
                type="number"
                name="amount"
                value={paymentData.amount}
                onChange={handleInputChange}
                className="w-full px-3 py-2 border rounded-md"
                min="1"
                placeholder="Enter Amount"
                required
              />
            </div>
          </div>

          <div>
            <label htmlFor="description" className="block text-gray-700 font-semibold mb-2">
              Description
            </label>
            <input
              type="text"
              name="description"
              value={paymentData.description}
              onChange={handleInputChange}
              className="w-full px-3 py-2 border rounded-md"
              placeholder="Enter Reason"
              required
            />
          </div>

          <button
            type="button"
            className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded inline-block"
            onClick={handlePayment}
          >
            Next
          </button>
        </div>
      </div>

      {showInvoice && <Invoice accountNumber={paymentData.accountNumber} amount={paymentData.amount} />}
    </div>
    </div>
  );
};

export default PaymentBody;
