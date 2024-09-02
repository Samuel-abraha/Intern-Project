import React, { useState } from "react";
import axios from "axios";

const Invoice = ({ accountNumber, amount }) => {
  const [paymentResponse, setPaymentResponse] = useState(null);
  const id = 152;
  const paid_amount = amount;

  

  const handlePayment = async () => {
        
    try {
      const data = {
        id,
        paid_amount,
      };

      const response = await axios.post("/api/payment/paymentservice", data);

      if (response.status === 200) {
        setPaymentResponse(response.data);
        alert("Payment successfully submitted!");
      } else {
        alert("Something went wrong. Please try again.");
      }
    } catch (error) {
      console.error("There was an error submitting the payment:", error);
      alert("There was an error submitting the payment. Please try again." + error);
    }
  };

  const handleClose = () => {
    setPaymentResponse(null); // Close the invoice box by resetting the payment response
    window.location.reload();
  };

  return (
    <div>
      <div className="invoice p-4 bg-white rounded-lg shadow-md w-80 ml-20 ">
        <h1 className="text-2xl font-bold text-center mb-4">Invoice</h1>
        <div className="flex justify-between">
          <div>
            <h2 className="text-lg font-semibold mb-2">Bill To:</h2>
            <p>John Doe</p>
            <p>123 Main Street</p>
            <p>City, State, ZIP</p>
          </div>
          <div>
            <h2 className="text-lg font-semibold mb-2">Invoice Date:</h2>
            <p>January 1, 2024</p>
            <h2 className="text-lg font-semibold mb-2">Invoice Number:</h2>
            <p>INV-001</p>
          </div>
        </div>
        <table className="mt-4 w-full">
          <thead>
            <tr>
              <th className="text-right py-2 px-4 border-b">Account</th>
              <th className="text-right py-2 px-4 border-b">Price</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td className="text-left py-2 px-4 border-b">{accountNumber}</td>
              <td className="text-right py-2 px-4 border-b">{amount}</td>
            </tr>
          </tbody>
        </table>
        <div className="flex justify-end mt-4">
          <p className="text-right font-bold">Total:</p>
          <p className="text-right font-bold">{amount}</p>
        </div>
        <button
          className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded inline-block"
          onClick={handlePayment}
        >
          Pay now
        </button>
      </div>

      {/* Conditionally render the server response in a centered invoice box */}
      {paymentResponse && (
        <div className="fixed inset-0 flex items-center justify-center z-50 w-90 bg-gray-900 bg-opacity-75">
          <div className="bg-white p-8 rounded-lg shadow-lg w-11/12 md:w-1/2 lg:w-1/3 relative w-90">
          
            <button
              className="absolute top-2 right-2 text-gray-600 hover:text-gray-900"
              onClick={handleClose}
            >
              &times;
            </button>
            
          
            <h2 className="text-xl font-bold mb-4 text-center">Payment Response</h2>
            <div className="flex justify-between">
          <div>
            <h2 className="text-lg font-semibold mb-2">Bill To:</h2>
            <p>John Doe</p>
            <p>123 Main Street</p>
            <p>City, State, ZIP</p>
          </div>
          <div>
            <h2 className="text-lg font-semibold mb-2">Invoice Date:</h2>
            <p>January 1, 2024</p>
            <h2 className="text-lg font-semibold mb-2">Invoice Number:</h2>
            <p>INV-001</p>
          </div>
          </div>
            <div className="overflow-auto">
            <table className="mt-4 w-full">
          <thead>
            <tr>
              <th className="text-right py-2 px-4 border-b">Account</th>
              <th className="text-right py-2 px-4 border-b">Price</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td className="text-right py-2 px-4 border-b">{accountNumber}</td>
              <td className="text-right py-2 px-4 border-b">{amount}</td>
            </tr>
          </tbody>
        </table>
              {/* <pre className="bg-red-500 bg-opacity-70 p-4 rounded-lg">
                {JSON.stringify(paymentResponse, null, 2)}
              </pre> */}
              
            
              <p>Transaction_Id:{paymentResponse.Transaction_Id}</p>
              <p className="bg-green-500 text-center">{paymentResponse.message}</p>

            

            </div>
          </div>
        </div>
      )}
    </div>
  );
};

export default Invoice;
