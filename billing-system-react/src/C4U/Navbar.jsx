

const Navbar = () => {
   
    return (
       

  <div className="navbar flex justify-between items-center p-4 border-b border-gray-200 ml-80">
    <h1 className="text-2xl font-bold">Dashboard</h1>
    <div className="search">
      <input type="text" placeholder="Search" className="p-2 border border-gray-300 rounded" />
    </div>
    <span>Notfication</span>
    <div className="profile flex items-center">
      <img src="profile.jpg" alt="Profile" className="w-10 h-10 rounded-full mr-2" />
      <span>Sami</span>
    </div>
  </div>

     
    );
}

export default Navbar;