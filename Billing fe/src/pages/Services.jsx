import { useEffect, useState } from "react";
// import axios from "../api/axios";

const Services = () => {
  const [services, setServices] = useState([]);

  useEffect(() => {
    const fetchServices = async () => {
      try {
        const response = await axios.get("/services");
        setServices(response.data);
      } catch (error) {
        console.error("Error fetching services:", error);
      }
    };

    fetchServices();
  }, []);

  return (
    <div className="p-6 bg-gray-800 shadow-md rounded-lg">
      <h1 className="text-3xl font-bold mb-4 text-white">Services</h1>
      <p className="text-white mb-4">List of services provided by the system.</p>
      <ul className="space-y-4">
        {services.map(service => (
          <li key={service.id} className="p-4 bg-gray-50 rounded-lg shadow-sm">
            <h2 className="text-xl font-semibold text-gray-800">{service.name}</h2>
            <p className="text-gray-600">{service.description}</p>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default Services;
