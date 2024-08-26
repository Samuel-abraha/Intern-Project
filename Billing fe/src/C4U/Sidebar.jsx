 
const Sidebar = () => {  
    return (  
        <div className="sidebar fixed top-0 left-0 w-64 h-full p-4 bg-gray-900 border-r-2 border-gray-300 transition-colors duration-300">
  <h1 className="text-center text-white text-2xl mb-4 ">Billing System</h1>
  <hr className="border-gray-400 h-px" />
  <ul className="mt-4">
    <li className="text-center text-white hover:text-orange-300">
      <a href="#">Dashboard</a>
    </li>
    <li className="text-center text-white hover:text-orange-300">
      <a href="#">User Profile</a>
    </li>
    <li className="text-center text-white hover:text-orange-300">
      <a href="#">Inbox</a>
    </li>
    <li className="text-center text-white hover:text-orange-300">
      <a href="#">Products</a>
    </li>
    <br />
    <li className=" text-white hover:text-gray-200">
      <h3 className="text-lg ml-5">Billing Services</h3>
      <hr className="border-gray-400 h-px ml-2" />
      <ul className="mt-2">
        <li className="text-center text-white hover:text-orange-300">
          <a href="#">Transactions</a>
        </li>
        <li className="text-center text-white hover:text-orange-300">
          <a href="#">Invoices</a>
        </li>
        <li className="text-center text-white hover:text-orange-300">
          <a href="#">Reports</a>
        </li>
      </ul>
    </li>
    <br />
    <li className=" text-white hover:text-gray-200">
      <h3 className="text-lg ml-5">Settings</h3>
      <hr className="border-gray-400 h-px ml-2" />
      <ul className="mt-2">
        <li className="text-center text-white hover:text-orange-300">
          <a href="#">Account Settings</a>
        </li>
        <li className="text-center text-white hover:text-orange-300">
          <a href="#">Payment Settings</a>
        </li>
        <li className="text-center text-white hover:text-orange-300">
          <a href="#">Bill Detail</a>
        </li>
      </ul>
    </li>
  </ul>
</div>
    );  
};  

export default Sidebar;