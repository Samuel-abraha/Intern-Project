import { useState } from 'react';
import Body from "../C4U/Body";
import PayemntBody from "../C4U/C4B/PayemntBody";
import InvoiceBody from "../C4U/C4B/c4I/InvoiceBody";
import Footer from "../C4U/Footer";
import Navbar from "../C4U/Navbar";
import Sidebar from "../C4U/Sidebar";

const User = () => {
    const [activeComponent, setActiveComponent] = useState('dashboard'); // Default component

    const handleMenuItemClick = (component) => {
        setActiveComponent(component);
    };

    let content;
    if (activeComponent === 'dashboard') {
        content = <Body />;
    } else if (activeComponent === 'profile') {
        content = <div>User Profile Component</div>;
    } else if (activeComponent === 'invoice') {
        content = <InvoiceBody />;
    } else if (activeComponent === 'payment') {
        content = <PayemntBody />;
    }

    return (
        <div className="container ">
            <Sidebar onMenuItemClick={handleMenuItemClick} />
            <Navbar />
            <div className='ml-80'> {/* Adjust content margin to accommodate sidebar */}
                {content}
            </div>
            <Footer />
        </div>
    );
}

export default User;
