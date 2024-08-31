import { BrowserRouter as Router, Route, Routes } from "react-router-dom";


import Layout from "./components/Layout";
import SignIn from "./pages/SignIn";
import SignUp from "./pages/SignUp";

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/SignIn" element={<SignIn />} />
        <Route path="/SignUp" element={<SignUp />} />
        <Route path="*" element={<Layout />} />
      </Routes>
    </Router>
  );
}

export default App;
