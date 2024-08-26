import Invoice from "./c4p/invoice";

const PaymentBody = () => {

    const btn=0;
    const invoice = ()=>{
            btn ++;
    }
    
   
    return (   <div className="container flex">
        <div className="payment-panel p-4 bg-white rounded-lg shadow-md w-64 h-auto ml-80 mt-5">
          <h3 className="text-lg font-bold mb-4">Payment Information</h3>
          <form className="flex flex-col space-y-4">
            <div>
              <label htmlFor="card-number" className="block text-gray-700 font-semibold mb-2">
                {/* Enter account Number */}Account Number
              </label>
              <input
                type="text"
                id="card-number"
                className="w-full px-3 py-2 border rounded-md sm:w-3/4"
                placeholder="Enter card number"
              />
            </div>
      
            <div className="flex space-x-4">
              <div className="w-1/2 sm:w-full">
                <label htmlFor="card-cvv" className="block text-gray-700 font-semibold mb-2">
                  CVV
                </label>
                <input
                  type="text"
                  id="card-cvv"
                  className="w-full px-3 py-2 border rounded-md"
                  placeholder="CVV"
                />
              </div>
            </div>
      
            <div>
              <label htmlFor="cardholder-name" className="block text-gray-700 font-semibold mb-2">
                Amount $
              </label>
              <input
                type="number"
                id="cardholder-name"
                className="w-full px-3 py-2 border rounded-md"
                placeholder="Enter Amount"
              />
            </div>
      
            <button type="submit" className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded inline-block" onClick={invoice} >
              Pay Now
            </button>
          </form>
        </div>  
            <Invoice></Invoice>
      </div>
    );
}

export default PaymentBody;