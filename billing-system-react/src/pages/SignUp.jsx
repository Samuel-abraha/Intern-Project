import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

const SignUp = () => {
  const [fullname, setFullname] = useState('');
  const [email, setEmail] = useState('');
  const [phonenumber, setPhonenumber] = useState('');
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [error, setError] = useState('');
  const [success, setSuccess] = useState('');
  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();
  
    // Frontend validation
    if (fullname.trim() === '' || email.trim() === '' || phonenumber.trim() === '' || username.trim() === '' || password.trim() === '') {
      setError('All fields are required');
      return;
    }
  
    if (password.length <= 8) {
      setError('Password must be longer than 8 characters');
      return;
    }
  
    const customerDto = {
      fullname,
      email,
      phonenumber,
      userDto: { username, password }
    };
  
    try {
      const response = await axios.post('/api/Customers/add', customerDto);
  
      if (response.status === 200 && response.data === 'Successfully Registered') {
        setSuccess('Signup successful! Redirecting to SignIn...');
        setTimeout(() => {
          navigate('/SignIn');
        }, 2000); // Redirect after 2 seconds
      } else {
        setError(response.data || 'Signup failed. Please try again.');
      }
    } catch (err) {
      if (err.response && err.response.status === 400 && err.response.data) {
        setError(err.response.data); // Display the specific error from the backend
      } else {
        setError('An error occurred during signup. Please try again.');
      }
    }
  };
  

  return (
    <div className="flex min-h-screen bg-black flex-col justify-center px-6 py-12 lg:px-8">
      <div className="sm:mx-auto sm:w-full sm:max-w-sm">
        <h2 className="mt-10 text-center text-2xl font-bold leading-9 tracking-tight text-white">
          Create Your Account
        </h2>
      </div>

      <div className="mt-10 sm:mx-auto sm:w-full sm:max-w-sm">
        <form onSubmit={handleSubmit} className="space-y-6">
          {/* Fullname */}
          <div>
            <label htmlFor="fullname" className="block text-sm font-medium leading-6 text-white">
              Full Name
            </label>
            <div className="mt-2">
              <input
                id="fullname"
                name="fullname"
                type="text"
                required
                value={fullname}
                onChange={(e) => setFullname(e.target.value)}
                className="block w-full rounded-md border-0 py-1.5 text-black p-4 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-white focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
              />
            </div>
          </div>

          {/* Email */}
          <div>
            <label htmlFor="email" className="block text-sm font-medium leading-6 text-white">
              Email
            </label>
            <div className="mt-2">
              <input
                id="email"
                name="email"
                type="email"
                required
                value={email}
                onChange={(e) => setEmail(e.target.value)}
                className="block w-full rounded-md border-0 py-1.5 text-black p-4 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-white focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
              />
            </div>
          </div>

          {/* Phone Number */}
          <div>
            <label htmlFor="phonenumber" className="block text-sm font-medium leading-6 text-white">
              Phone Number
            </label>
            <div className="mt-2">
              <input
                id="phonenumber"
                name="phonenumber"
                type="text"
                required
                value={phonenumber}
                onChange={(e) => setPhonenumber(e.target.value)}
                className="block w-full rounded-md border-0 py-1.5 text-black p-4 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-white focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
              />
            </div>
          </div>

          {/* Username */}
          <div>
            <label htmlFor="username" className="block text-sm font-medium leading-6 text-white">
              Username
            </label>
            <div className="mt-2">
              <input
                id="username"
                name="username"
                type="text"
                required
                value={username}
                onChange={(e) => setUsername(e.target.value)}
                className="block w-full rounded-md border-0 py-1.5 text-black p-4 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-white focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
              />
            </div>
          </div>

          {/* Password */}
          <div>
            <label htmlFor="password" className="block text-sm font-medium leading-6 text-white">
              Password
            </label>
            <div className="mt-2">
              <input
                id="password"
                name="password"
                type="password"
                required
                value={password}
                onChange={(e) => setPassword(e.target.value)}
                className="block w-full rounded-md border-0 py-1.5 text-black p-4 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
              />
            </div>
          </div>

          {/* Error or Success Message */}
          {error && <div className="text-red-500">{error}</div>}
          {success && <div className="text-green-500">{success}</div>}

          {/* Sign Up Button */}
          <div>
            <button
              type="submit"
              className="flex w-full justify-center rounded-md bg-green-700 px-3 py-1.5 text-sm font-semibold leading-6 text-white shadow-sm hover:bg-green-500 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-600"
            >
              Sign Up
            </button>
          </div>
        </form>
      </div>
    </div>
  );
};

export default SignUp;
