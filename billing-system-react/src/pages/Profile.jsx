import React, { useState, useEffect } from 'react';
import axios from 'axios';

const Profile = () => {
    const [user, setUser] = useState({
        username: '',
        password: '',
    });

    useEffect(() => {
        const fetchAdminProfile = async () => {
            try {
                // Assume that the username is stored in localStorage after login
                const savedUsername = localStorage.getItem("username");
                
                if (savedUsername) {
                    const response = await axios.get(`/api/User/Admin/${savedUsername}`);
                    setUser(response.data);
                } else {
                    console.error("Username not found in localStorage");
                }
            } catch (error) {
                console.error("Error fetching admin profile:", error);
            }
        };

        fetchAdminProfile();
    }, []);

    return (
        <div className="flex flex-col items-center justify-center min-h-screen bg-gray-100">
            <div className="bg-white p-6 rounded-lg shadow-md w-full max-w-md">
                <h2 className="text-2xl font-semibold text-gray-800 mb-4">Profile</h2>
                <div className="mb-4">
                    <label className="block text-gray-700">Username:</label>
                    <input
                        type="text"
                        value={user.username}
                        className="w-full p-2 border border-gray-300 rounded mt-1"
                        readOnly
                    />
                </div>
                <div className="mb-4">
                    <label className="block text-gray-700">Password:</label>
                    <input
                        type="password"
                        value={user.password}
                        className="w-full p-2 border border-gray-300 rounded mt-1"
                        readOnly
                    />
                </div>
                <button className="w-full bg-blue-500 text-white p-2 rounded mt-4 hover:bg-blue-600">
                    Edit Profile
                </button>
            </div>
        </div>
    );
};

export default Profile;
