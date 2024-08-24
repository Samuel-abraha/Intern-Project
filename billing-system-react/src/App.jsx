import { BrowserRouter as Router, Route, Routes } from "react-router-dom";


import Layout from "./components/Layout";
import SignIn from "./pages/SignIn";

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/SignIn" element={<SignIn />} />
        <Route path="*" element={<Layout />} />
      </Routes>
    </Router>
  );
}

export default App;
