import { useEffect, useState } from 'react';
import axios from 'axios';
import React from 'react';
import ChartComponent from '../C4U/ChartComponent ';

const Body = () => {
  const [balance, setBalance] = useState(0);

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

  return (
    <main className="flex-1 p-4 border-left border-gray-200 grid grid-cols-1 sm:grid-cols-2 md:grid-cols-4 gap-4 grid-flow-row border-t border-b border-gray-200">
      <div className="bg-green-300 p-4 rounded-lg">
          Balance: ${balance}
      </div>
      <div className="bg-gray-100 p-4 rounded-lg">
        {"Balance"}
      </div>
      <div className="bg-gray-100 p-4 rounded-lg">
        {"Balance"}
      </div>
      <div className="bg-gray-100 p-4 rounded-lg">
        {"Balance"}
      </div>

      {/* Add the ChartComponent */}
      <div className="col-span-1 md:col-span-2 lg:col-span-4">
        <ChartComponent />
      </div>
    </main>
  );
};

export default Body;
