
const Invoice = () => {
   
  





    return (
        <div className="container  mt-5" >
        
        
        <div className="flex space-x-2">
  <div className="bg-gray-100 p-4 rounded-lg flex-1 border-2 border-orange-500 text-center">
    <p>23 overdue</p>
    <p>price 500ETB</p>
    <p className="text-orange-500">view invoices</p> 
  </div>
  <div className="bg-gray-100 p-4 rounded-lg flex-1 border-2 border-orange-500  text-center">
    <p>1 unpaid</p>
    <p>price 500ETB</p>
    <p className="text-orange-500">view invoices</p> 
  </div>
  <div className="bg-gray-100 p-4 rounded-lg flex-1 border-2 border-orange-500  text-center">
    <p>1 unsent</p>
    <p>price 500ETB</p>
    <p className="text-orange-500">view invoices</p> 
  </div>
</div>

        <div class="flex">
    
    <div class="flex-1 border-2 border-orange-500 m-2 p-5 box-border">
        <div class="bg-green-100 p-4 m-1" > 
        <p>Invoice #3 was partially paid by nexxt sp xoo with the following unspecified</p>
        <p className="text-orange-500">Today - Payment PLN 352.00</p>
        </div>
        {/* <button class="bg-orange-500">show invoice</button> */}

        <div class="bg-green-100 p-4 m-1" > 
        <p>Invoice #3 was partially paid by nexxt sp xoo with the following unspecified</p>
        <p className="text-orange-500">Today - Payment PLN 352.00</p>
        {/* <p className="bg-orange-500">show</p> */}
        </div>
        {/* <p className="text-orange-500 inline m-1 border-2 border-orange-500">view invoice</p> */}
        
        <div class="bg-green-100 p-4 m-1" > 
        <p>Invoice #3 was partially paid by nexxt sp xoo with the following unspecified</p>
        <p className="text-orange-500">Today - Payment PLN 352.00</p>
        </div>
        <div class="bg-green-100 p-4 m-1" > 
        <p>Invoice #3 was partially paid by nexxt sp xoo with the following unspecified</p>
        <p className="text-orange-500">Today - Payment PLN 352.00</p>
        </div>
        <div class="bg-green-100 p-4 m-1" > 
        <p>Invoice #3 was partially paid by nexxt sp xoo with the following unspecified</p>
        <p className="text-orange-500">Today - Payment PLN 352.00</p>
        </div>
        <div class="bg-green-100 p-4 m-1" > 
        <p>Invoice #3 was partially paid by nexxt sp xoo with the following unspecified</p>
        <p className="text-orange-500">Today - Payment PLN 352.00</p>
        </div>
    </div>

    
    <div class="w-1/4 border-2 border-blue-500 m-2 p-5 box-border">
        
        <div className="bg-white p-8 rounded-lg shadow-lg w-50">
          <button
            className="absolute top-2 right-2 text-gray-600 hover:text-gray-900"
          >
            &times;
          </button>

          <h2 className="text-xl font-bold mb-4 text-center">Payment Response</h2>

          <div className="flex justify-between mb-4">
            <div>
              <h2 className="text-lg font-semibold mb-2">Bill To:</h2>
              <p>John Doe</p>
              <p>123 Main Street</p>
              <p>City, State, ZIP</p>
            </div>
            <div>
              <h2 className="text-lg font-semibold mb-2">Invoice Date:</h2>
              <p>January 1, 2024</p>
              <h2 className="text-lg font-semibold mb-2">Invoice Number:</h2>
              <p>INV-001</p>
            </div>
          </div>

          <div className="overflow-auto">
            <table className="mt-4 w-full">
              <thead>
                <tr>
                  <th className="text-right py-2 px-4 border-b">Account</th>
                  <th className="text-right py-2 px-4 border-b">Price</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td className="text-right py-2 px-4 border-b">{"accountNumber"}</td>
                  <td className="text-right py-2 px-4 border-b">{"amount"}</td>
                </tr>
              </tbody>
            </table>
          </div>

          <p className="mt-4">Transaction_Id: {"paymentResponse.Transaction_Id"}</p>
          <p className="bg-green-500 text-center mt-2 p-2 rounded">
            {"paymentResponse.message"}
          </p>
        </div>
     


    </div>

    
  
</div>


        </div>
    );
}

export default Invoice;