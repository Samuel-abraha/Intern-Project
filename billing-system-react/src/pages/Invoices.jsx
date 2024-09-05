import { useEffect, useState } from "react";
import axios from "../api/axios";

const Invoices = () => {
  const [invoices, setInvoices] = useState([]);

  useEffect(() => {
    const fetchInvoices = async () => {
      try {
        const response = await axios.get("/invoices/All");
        setInvoices(response.data);
      } catch (error) {
        console.error("Error fetching invoices:", error);
      }
    };

    fetchInvoices();
  }, []);

  return (
    <div className="p-6 bg-neutral-900 shadow-md rounded-lg">
      <h1 className="text-3xl font-bold mb-4 text-white">Invoices</h1>
      <p className="text-white mb-4">List of invoices with their details.</p>
      <table className="w-full bg-neutral-900 rounded-lg overflow-hidden">
        <thead className="bg-gray-800 text-white">
          <tr>
            <th className="p-4 text-left">customerFullName</th>
            <th className="p-4 text-left">phoneNumber</th>
            <th className="p-4 text-left">invoiceDate</th>
            <th className="p-4 text-left">billingPeriod</th>
            <th className="p-4 text-left">serviceName</th>
            <th className="p-4 text-left">totalAmount</th>
            <th className="p-4 text-left">Paid</th>
          </tr>
      
        </thead>
        <tbody>
          {invoices.map(invoice => (
            <tr key={invoice.id} className="bg-neutral-500 border-b border-gray-200">
              <td className="p-4">{invoice.customerFullName}</td>
              <td className="p-4">{invoice.phoneNumber}</td>
              <td className="p-4">{invoice.invoiceDate}</td>
              <td className="p-4">{invoice.billingPeriod}</td>
              <td className="p-4">{invoice.serviceName}</td>
              <td className="p-4">{invoice.totalAmount}</td>
              <td className="p-4">
                <span className={`inline-block px-2 py-1 rounded-full text-white ${invoice.status === 'Paid' ? 'bg-green-500' : 'bg-red-500'}`}>
                  {invoice.status}
                </span>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default Invoices;
