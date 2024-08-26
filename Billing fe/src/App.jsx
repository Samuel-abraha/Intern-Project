import { BrowserRouter as Router, Route, Routes } from "react-router-dom";


import Layout from "./components/Layout";
import User from "./components/User";
import SignIn from "./components/SignIn";



function App() {
  return (
    <Router>
      <Routes>
        <Route path="*" element={<Layout />} />
        <Route path="/SignIn" element={<SignIn />} />
        <Route path="/user" element={<User />} />
        
      </Routes>
    </Router>
  );
}

export default App;
