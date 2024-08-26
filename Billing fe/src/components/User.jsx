import Body from "../C4U/Body";
import PaymentBody from "../C4U/C4B/PayemntBody";
import Footer from "../C4U/Footer";
import Navbar from "../C4U/Navbar";
import Sidebar from "../C4U/Sidebar";
const User = () => {
    
    return (
        <div className="container">
            <Sidebar></Sidebar>
            <Navbar></Navbar>
            <PaymentBody></PaymentBody>
            <Footer></Footer>
        </div>
    );
}

export default User;