import { useEffect, useState } from "react";
import axios from "../api/axios";

const Services = () => {
  const [services, setServices] = useState([]);
  const [detailsVisible, setDetailsVisible] = useState({});

  useEffect(() => {
    const fetchServices = async () => {
      try {
        const response = await axios.get("/Admin/BillingServices/All");
        setServices(response.data);
      } catch (error) {
        console.error("Error fetching services:", error);
        alert("Failed to fetch services. Please try again later.");
      }
    };

    fetchServices();
  }, []);

  const toggleDetails = (index) => {
    setDetailsVisible((prevDetailsVisible) => ({
      ...prevDetailsVisible,
      [index]: !prevDetailsVisible[index],
    }));
  };

  return (
    <div className="p-10 bg-neutral-900 shadow-md">
      <h1 className="text-3xl font-bold mb-4 text-white">Services</h1>
      <p className="text-white mb-4">List of services provided by the system.</p>
      <ul className="space-y-4">
        {services.map((service, index) => (
          <li key={index} className="p-4 bg-neutral-800 rounded-lg shadow-sm">
            <div className="flex justify-between items-center">
              <h2 className="text-xl font-semibold text-white ">
                {index + 1}. {service.serviceName}
              </h2>
              <button
                onClick={() => toggleDetails(index)}
                className="text-green-500 hover:text-green-300"
              >
                {detailsVisible[index] ? "Hide Details" : "View Details"}
              </button>
            </div>
            {detailsVisible[index] && (
              <div className="mt-2">
                <p className="pl-6 text-gray-300">Unit Price: {service.unitPrice}</p>
                <p className="pl-6 text-gray-300">Unit of Measure: {service.unitOfMeasure}</p>
              </div>
            )}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default Services;
