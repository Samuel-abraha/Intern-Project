import { BarChart, Bar, LineChart, Line, PieChart, Pie, Cell, XAxis, YAxis, CartesianGrid, Tooltip, Legend, ResponsiveContainer } from 'recharts';

const Dashboard = () => {
  const barChartData = [
    { name: 'January', Customers: 400, Invoices: 240, Services: 240 },
    { name: 'February', Customers: 300, Invoices: 139, Services: 221 },
    { name: 'March', Customers: 200, Invoices: 980, Services: 229 },
    { name: 'April', Customers: 278, Invoices: 390, Services: 200 },
    { name: 'May', Customers: 189, Invoices: 480, Services: 218 },
    { name: 'June', Customers: 239, Invoices: 380, Services: 250 },
    { name: 'July', Customers: 349, Invoices: 430, Services: 210 },
  ];

  const lineChartData = [
    { name: 'Week 1', Customers: 400, Invoices: 240 },
    { name: 'Week 2', Customers: 300, Invoices: 456 },
    { name: 'Week 3', Customers: 200, Invoices: 139 },
    { name: 'Week 4', Customers: 278, Invoices: 390 },
  ];

  const pieChartData = [
    { name: 'Electricity', value: 400 },
    { name: 'Water', value: 300 },
    { name: 'Internet', value: 300 },
  ];

  const COLORS = ['#0088FE', '#00C49F', '#FFBB28'];

  return (
    <div className="p-6 bg-neutral-900 shadow-md rounded-lg m-10">
      <h1 className="text-3xl font-bold mb-4 text-white">Dashboard</h1>
      <p className="text-white mb-4">Welcome aboard, Admin</p>
      
      
      {/* Card like widgets */}
      <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6 mb-20"> {/*for responsiveness md:768px and above , lg:1024px and above*/}
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
      
      
      {/* Bar chart */}
      <div className="bg-gray-850 p-4 rounded-lg shadow-md mb-10">
        <h2 className="text-white text-lg mb-4">Monthly Summary</h2>
        <ResponsiveContainer width="90%" height={300}>
          <BarChart data={barChartData}>
            <CartesianGrid strokeDasharray="3 3" />
            <XAxis dataKey="name" />
            <YAxis />
            <Tooltip />
            <Legend />
            <Bar dataKey="Customers" fill="#8884d8" />
            <Bar dataKey="Invoices" fill="#82ca9d" />
            <Bar dataKey="Services" fill="#ffc658" />
          </BarChart>
        </ResponsiveContainer>
      </div>

      {/* Line chart */}
      <div className="bg-gray-850 p-4 rounded-lg shadow-md mb-10">
        <h2 className="text-white text-lg mb-4">Weekly Trends</h2>
        <ResponsiveContainer width="90%" height={300}>
          <LineChart data={lineChartData}>
            <CartesianGrid strokeDasharray="3 3" />
            <XAxis dataKey="name" />
            <YAxis />
            <Tooltip />
            <Legend />
            <Line type="monotone" dataKey="Customers" stroke="#8884d8" />
            <Line type="monotone" dataKey="Invoices" stroke="#82ca9d" />
          </LineChart>
        </ResponsiveContainer>
      </div>

      {/* Pie chart */}
      <div className="bg-gray-850 p-4 rounded-lg shadow-md mb-10">
        <h2 className="text-white text-lg mb-4">Service Distribution</h2>
        <ResponsiveContainer width="50%" height={300}>
          <PieChart>
            <Pie data={pieChartData} dataKey="value" nameKey="name" cx="50%" cy="50%" outerRadius={80} fill="#8884d8">
              {pieChartData.map((entry, index) => (
                <Cell key={`cell-${index}`} fill={COLORS[index % COLORS.length]} />
              ))}
            </Pie>
            <Tooltip />
            <Legend />
          </PieChart>
        </ResponsiveContainer>
      </div>

      
    </div>
  );
};

export default Dashboard;
