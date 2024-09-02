import React from 'react';
import DashboardIcon from '@mui/icons-material/Dashboard';
import AccountCircleIcon from '@mui/icons-material/AccountCircle';
import InboxIcon from '@mui/icons-material/Inbox';
import ShoppingCartIcon from '@mui/icons-material/ShoppingCart';
import ReceiptIcon from '@mui/icons-material/Receipt';
import AssessmentIcon from '@mui/icons-material/Assessment';
import SettingsIcon from '@mui/icons-material/Settings';
import PaymentIcon from '@mui/icons-material/Payment';
import SupervisorAccountIcon from '@mui/icons-material/SupervisorAccount';
import LogoutIcon from '@mui/icons-material/Logout';

const Sidebar = ({ onMenuItemClick }) => {
    return (
        <div style={{
            backgroundColor: '#0F1013',
            width: '16rem',
            height: '100vh',
            padding: '2rem 1rem',
            color: '#FFFFFF',
            fontFamily: 'Arial, sans-serif',
            position: 'fixed',
            top: 0,
            left: 0,
            overflowY: 'auto'
        }}>
            <div style={{
                display: 'flex',
                alignItems: 'center',
                marginBottom: '2rem'
            }}>
                <img src="../assets/Logo.png" alt="Logo" style={{ width: '40px', height: '40px', marginRight: '0.75rem' }} />
                <h2 style={{ fontSize: '1.25rem', fontWeight: 'bold', letterSpacing: '0.05rem' }}>BILLING SYSTEM</h2>
            </div>

            <ul style={{ listStyleType: 'none', padding: 0 }}>
                <li style={{
                    marginBottom: '1.5rem',
                    backgroundColor: '#FF6B1B',
                    borderRadius: '0.5rem',
                    overflow: 'hidden'
                }}>
                    <a href="#" onClick={() => onMenuItemClick('dashboard')} style={{
                        display: 'flex',
                        alignItems: 'center',
                        padding: '1rem',
                        color: '#FFFFFF',
                        textDecoration: 'none'
                    }}>
                        <DashboardIcon style={{ marginRight: '1rem' }} />
                        <span>Dashboard</span>
                    </a>
                </li>
                <li style={{ marginBottom: '1.5rem' }}>
                    <a href="#" onClick={() => onMenuItemClick('profile')} style={{
                        display: 'flex',
                        alignItems: 'center',
                        padding: '1rem',
                        color: '#FFFFFF',
                        textDecoration: 'none'
                    }}>
                        <AccountCircleIcon style={{ marginRight: '1rem' }} />
                        <span>User Profile</span>
                    </a>
                </li>
                <li style={{ marginBottom: '1.5rem' }}>
                    <a href="#" onClick={() => onMenuItemClick('invoice')} style={{
                        display: 'flex',
                        alignItems: 'center',
                        padding: '1rem',
                        color: '#FFFFFF',
                        textDecoration: 'none'
                    }}>
                        <InboxIcon style={{ marginRight: '1rem' }} />
                        <span>Invoice</span>
                    </a>
                </li>
                <li style={{ marginBottom: '1.5rem' }}>
                    <a href="#" onClick={() => onMenuItemClick('payment')} style={{
                        display: 'flex',
                        alignItems: 'center',
                        padding: '1rem',
                        color: '#FFFFFF',
                        textDecoration: 'none'
                    }}>
                        <ShoppingCartIcon style={{ marginRight: '1rem' }} />
                        <span>Payment</span>
                    </a>
                </li>
                {/* Other menu items */}
            </ul>
        </div>
    );
};

export default Sidebar;
