
const Invoice = () => {
   
    return (

            <div>
        <div className="invoice p-4 bg-white rounded-lg shadow-md w-90 ml-10 mt-5">
          <h1 className="text-2xl font-bold text-center mb-4">Invoice</h1>
          <div className="flex justify-between">
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
          <table className=" mt-4 w-full">
            <thead>
              <tr>
                <th className="text-left py-2 px-4 border-b">Item</th>
                <th className="text-right py-2 px-4 border-b">Quantity</th>
                <th className="text-right py-2 px-4 border-b">Price</th>
                <th className="text-right py-2 px-4 border-b">Total</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td className="text-left py-2 px-4 border-b">Product 1</td>
                <td className="text-right py-2 px-4 border-b">2</td>
                <td className="text-right py-2 px-4 border-b">$10.00</td>
                <td className="text-right py-2 px-4 border-b">$20.00</td>
              </tr>
              {/* Add more rows as needed */}
            </tbody>
          </table>
          <div className="flex justify-end mt-4">
            <p className="text-right font-bold">Total:</p>
            <p className="text-right font-bold">$100.00</p>
          </div>
        </div>
        </div>
        );
}

export default Invoice;