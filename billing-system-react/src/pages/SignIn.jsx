import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate, Link } from 'react-router-dom';

const SignIn = () => {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [error, setError] = useState('');
  const [isLoading, setIsLoading] = useState(false);
  const [isErrorVisible, setIsErrorVisible] = useState(false);
  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();
    
    // Frontend validation
    if (username.trim() === '' || password.trim() === '') {
      setError('Username and password cannot be empty');
      setIsErrorVisible(true);
      return;
    }
    
    if (password.length <= 8) {
      setError('Password must be longer than 8 characters');
      setIsErrorVisible(true);
      return;
    }
  
    try {
      setIsLoading(true);
      setIsErrorVisible(false); // Hide any previous error

      const response = await axios.post('/api/User/userLogin', { username, password });
      
      setTimeout(() => {
        setIsLoading(false);
        const { data } = response;

        if (response.status === 200) {
          localStorage.setItem('username', username); // Save username in local storage
          
          if (data.includes('Admin')) {
            navigate('/dashboard'); // Navigate to admin dashboard
          } else if (data.includes('Customer')) {
            navigate(''); // Navigate to customer dashboard
          }
        } else {
          setError(data);
          setIsErrorVisible(true);
        }
      }, 2000);

    } catch (err) {
      setTimeout(() => {
        setIsLoading(false);
        setError('Sorry, looks like that’s the wrong username or password.');
        setIsErrorVisible(true);
      }, 2000);
    }
  };

  return (
    <div className="flex min-h-screen bg-black flex-col justify-center px-6 py-12 lg:px-8">
      <div className="sm:mx-auto sm:w-full sm:max-w-sm">
        <h2 className="mt-10 text-center text-2xl font-bold leading-9 tracking-tight text-white">
          Welcome Back!
        </h2>
        <h2 className="mt-10 text-center text-2xl font-bold leading-9 tracking-tight text-white">
          Sign in to your account
        </h2>
      </div>

      <div className="mt-10 sm:mx-auto sm:w-full sm:max-w-sm">
        <form onSubmit={handleSubmit} className="space-y-6">
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

          {/* Loading animation */}
          {isLoading && (
            <div className="flex justify-center items-center mt-6">
              <div className="animate-spin rounded-full h-8 w-8 border-t-2 border-b-2 border-green-500"></div>
              <p className="ml-3 text-white">Loading...</p>
            </div>
          )}
          
          {/* Error animation */}
          {isErrorVisible && error && (
            <div className="text-red-500 text-center mt-4">
              {error}
            </div>
          )}

          <div>
            <button
              type="submit"
              className="flex w-full justify-center rounded-md bg-green-700 px-3 py-1.5 text-sm font-semibold leading-6 text-white shadow-sm hover:bg-green-500 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-600"
            >
              Sign in
            </button>
          </div>
        </form>
        
        {/* Sign Up Link */}
        <div className="mt-6 text-center">
          <p className="text-sm text-white">
            Don't have an account?{' '}
            <Link to="/SignUp" className="font-semibold text-green-500 hover:text-green-700">
              Sign up
            </Link>
          </p>
        </div>
      </div>
    </div>
  );
};

export default SignIn;
