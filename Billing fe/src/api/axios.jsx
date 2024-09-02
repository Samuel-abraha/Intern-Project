// src/api/axios.js

import axios from 'axios';

// No need to set a base URL if you're using a proxy in Vite
const instance = axios.create({
  baseURL: '/api',
  timeout: 1000,  // Optional timeout for requests
  headers: { 'Content-Type': 'application/json' }, // Default headers
});

export default instance;
