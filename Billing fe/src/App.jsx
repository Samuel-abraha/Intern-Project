import { BrowserRouter as Router, Route, Routes } from "react-router-dom";


import Layout from "./components/Layout";
import User from "./components/User";
import SignIn from "./components/SignIn";



function App() {
  return (
    <Router>
      <Routes>
        
        <Route path="*" element={<SignIn />} />
        <Route path="/user" element={<User />} />
        <Route path="/Admin" element={<Layout />} />

      </Routes>
    </Router>
  );
}

export default App;
