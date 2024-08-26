const Dashboard = () => {
  return (
    <div className="p-6 bg-gray-800 shadow-md rounded-lg">
      <h1 className="text-3xl font-bold mb-4 text-white">Dashboard</h1>
      <p className="text-white mb-4">Overview of the system's metrics and key performance indicators.</p>
      <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
        {/* Add widgets for metrics */}
        <div className="bg-blue-300 p-4 rounded-lg shadow-md">
          <h2 className="text-xl font-semibold text-blue-800">Total Customers</h2>
          <p className="text-2xl font-bold text-blue-600">1,245</p>
        </div>
        <div className="bg-red-200 p-4 rounded-lg shadow-md">
          <h2 className="text-xl font-semibold text-green-800">Total Invoices</h2>
          <p className="text-2xl font-bold text-green-600">789</p>
        </div>
        <div className="bg-yellow-100 p-4 rounded-lg shadow-md">
          <h2 className="text-xl font-semibold text-yellow-800">Total Services</h2>
          <p className="text-2xl font-bold text-yellow-600">56</p>
        </div>
      </div>
    </div>
  );
};

export default Dashboard;
