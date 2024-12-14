import React, { useState, useEffect } from 'react';
import './App.css';
import './styles_1.css';
const App = () => {
  //Use state hooks for values
  const [banks, setBanks] = useState([]);
  //stores variables for new bank
  const [newBankName, setNewBankName] = useState('');
  const [newBankYear, setNewBankYear] = useState('');
  const [newBankEmp, setNewBankEmp] = useState('');
  const [newBankAddress, setNewBankAddress] = useState('');
  const [newBankBranches, setNewBankBranches] = useState('');
  const [newBankATMs, setNewBankATMs] = useState('');

  //stores variables for updating
  const [selectedBankID, setSelectedBankID] = useState('');
  const [selectedBankName, setSelectedBankName] = useState('');
  const [selectedBankYear, setSelectedBankYear] = useState('');
  const [selectedBankEmp, setSelectedBankEmp] = useState('');
  const [selectedBankAddress, setSelectedBankAddress] = useState('');
  const [selectedBankBranches, setSelectedBankBranches] = useState('');
  const [selectedBankATMs, setSelectedBankATMs] = useState('');

  const [errorMessage, setErrorMessage] = useState('');
  const [updateMessage, setUpdateMessage] = useState('');
  //stores name of bank for search
  const [searchBankName, setSearchBankName] = useState('');
  //stores id of bank to be deleted
  const [deleteBankID, setDeleteBankID] = useState('');
  //display information on banks
  const [showBanks, setShowBanks] = useState(false);
  const [searchResults, setSearchResults] = useState([]);

  // Fetch all banks (get)
  const fetchAllBanks = async () => {
    try {
      const response = await fetch('http://localhost:8083/banks');
      const data = await response.json();
      setBanks(data);
    } catch (error) {
      console.error('Error fetching banks:', error);
    }
  };

  // Add a new bank with validation (post)
  const handleAddBank = async () => {
    if (
      !newBankName ||
      !newBankYear ||
      !newBankEmp ||
      !newBankAddress ||
      !newBankBranches ||
      !newBankATMs
    ) {
      setErrorMessage('All fields are required.');
      return;
    }

    if (newBankYear < 1800) {
      setErrorMessage('Year must be after 1800');
      return;
    }

    if (newBankEmp < 1) {
      setErrorMessage('Number of employees must be at least 1');
      return;
    }

    if (newBankBranches < 1) {
      setErrorMessage('Number of branches must be at least 1');
      return;
    }

    if (newBankATMs < 1) {
      setErrorMessage('Number of ATMs must be at least 1');
      return;
    }

    const bank = {
      bankName: newBankName,
      bankYear: parseInt(newBankYear),
      bankEmp: parseInt(newBankEmp),
      bankAddress: newBankAddress,
      bankBranches: parseInt(newBankBranches),
      bankATMs: parseInt(newBankATMs),
    };

    try {
      const response = await fetch('http://localhost:8083/banks', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(bank),
      });

      if (response.ok) {
        setErrorMessage('');
        setNewBankName('');
        setNewBankYear('');
        setNewBankEmp('');
        setNewBankAddress('');
        setNewBankBranches('');
        setNewBankATMs('');
        fetchAllBanks();
      } else {
        setErrorMessage('Failed to add bank. Please try again.');
      }
    } catch (error) {
      console.error('Error adding bank:', error);
      setErrorMessage('Error adding bank. Please try again.');
    }
  };

  // Delete a bank by ID (delete)
  const handleDeleteBank = async () => {
    if (!deleteBankID) {
      setErrorMessage('Please enter a valid bank ID to delete.');
      return;
    }

    try {
      const response = await fetch(`http://localhost:8083/banks/${deleteBankID}`, {
        method: 'DELETE',
      });
      if (response.ok) {
        fetchAllBanks();
        setDeleteBankID('');
      }
    } catch (error) {
      console.error('Error deleting bank:', error);
    }
  };

  // Update a bank by ID (put)
  const handleUpdateBank = async () => {
    if (
      !selectedBankName ||
      !selectedBankYear ||
      !selectedBankEmp ||
      !selectedBankAddress ||
      !selectedBankBranches ||
      !selectedBankATMs
    ) {
      setErrorMessage('All fields are required.');
      return;
    }

    if (selectedBankYear < 1800) {
      setErrorMessage('Year must be after 1800');
      return;
    }

    if (selectedBankEmp < 1) {
      setErrorMessage('Number of employees must be at least 1');
      return;
    }

    if (selectedBankBranches < 1) {
      setErrorMessage('Number of branches must be at least 1');
      return;
    }

    if (selectedBankATMs < 1) {
      setErrorMessage('Number of ATMs must be at least 1');
      return;
    }

    const updatedBank = {
      bankName: selectedBankName,
      bankYear: parseInt(selectedBankYear),
      bankEmp: parseInt(selectedBankEmp),
      bankAddress: selectedBankAddress,
      bankBranches: parseInt(selectedBankBranches),
      bankATMs: parseInt(selectedBankATMs),
    };

    try {
      const response = await fetch(
        `http://localhost:8083/banks/${selectedBankID}`,
        {
          method: 'PUT',
          headers: { 'Content-Type': 'application/json' },
          body: JSON.stringify(updatedBank),
        }
      );

      if (response.ok) {
        setUpdateMessage('Bank updated successfully!');
        setSelectedBankID('');
        setSelectedBankName('');
        setSelectedBankYear('');
        setSelectedBankEmp('');
        setSelectedBankAddress('');
        setSelectedBankBranches('');
        setSelectedBankATMs('');
        fetchAllBanks();
      } else {
        setErrorMessage('Failed to update bank. Please try again.');
      }
    } catch (error) {
      console.error('Error updating bank:', error);
      setErrorMessage('Error updating bank. Please try again.');
    }
  };

  // Search banks by name (get)
  const handleSearchBanks = () => {
    const filteredBanks = banks.filter((bank) =>
      bank.bankName.toLowerCase().includes(searchBankName.toLowerCase())
    );
    setSearchResults(filteredBanks);
  };

  // Toggle bank list visibility
  const toggleBanksVisibility = () => {
    setShowBanks(!showBanks);
  };

  // Fetch banks on component mount
  useEffect(() => {
    fetchAllBanks();
  }, []);


  //Actual display of the webpage
  return (
    <div className="App">
      <h1>Bank Management System</h1>

      {/* Add New Bank Form */}
      <div>
        <h2>Add New Bank</h2>
        <input
          type="text"
          value={newBankName}
          onChange={(e) => setNewBankName(e.target.value)}
          placeholder="Bank Name"
        />
        <input
          type="number"
          value={newBankYear}
          onChange={(e) => setNewBankYear(e.target.value)}
          placeholder="Bank Year"
        />
        <input
          type="number"
          value={newBankEmp}
          onChange={(e) => setNewBankEmp(e.target.value)}
          placeholder="Number of Employees"
        />
        <input
          type="text"
          value={newBankAddress}
          onChange={(e) => setNewBankAddress(e.target.value)}
          placeholder="Bank Address"
        />
        <input
          type="number"
          value={newBankBranches}
          onChange={(e) => setNewBankBranches(e.target.value)}
          placeholder="Number of Branches"
        />
        <input
          type="number"
          value={newBankATMs}
          onChange={(e) => setNewBankATMs(e.target.value)}
          placeholder="Number of ATMs"
        />
        <button onClick={handleAddBank}>Add Bank</button>
        {errorMessage && <p style={{ color: 'red' }}>{errorMessage}</p>}
      </div>

      {/* Search Bank Form */}
      <div>
        <h2>Search Bank</h2>
        <input
          type="text"
          value={searchBankName}
          onChange={(e) => setSearchBankName(e.target.value)}
          placeholder="Enter Bank Name"
        />
        <button onClick={handleSearchBanks}>Search</button>
      </div>

      {/* Display Search Results */}
      <div>
        <h2>Search Results</h2>
        <ul>
          {searchResults.length === 0 ? (
            <li>No banks found</li>
          ) : (
            searchResults.map((bank) => (
              <li key={bank.bankID}>
                {bank.bankName} (ID: {bank.bankID}) - Year: {bank.bankYear} - Employees: {bank.bankEmp} - Branches: {bank.bankBranches} - ATMs: {bank.bankATMs}
              </li>
            ))
          )}
        </ul>
      </div>

      {/* Delete Bank Form */}
      <div>
        <h2>Delete Bank</h2>
        <input
          type="text"
          value={deleteBankID}
          onChange={(e) => setDeleteBankID(e.target.value)}
          placeholder="Enter Bank ID to Delete"
        />
        <button onClick={handleDeleteBank}>Delete Bank</button>
      </div>

     

      {/* Update Bank Forms */}
      <div>
        <h2>Update Bank</h2>
        <input
          type="text"
          value={selectedBankID}
          onChange={(e) => setSelectedBankID(e.target.value)}
          placeholder="Enter Bank ID to Edit"
        />
        <input
          type="text"
          value={selectedBankName}
          onChange={(e) => setSelectedBankName(e.target.value)}
          placeholder="Bank Name"
        />
        <input
          type="number"
          value={selectedBankYear}
          onChange={(e) => setSelectedBankYear(e.target.value)}
          placeholder="Bank Year"
        />
        <input
          type="number"
          value={selectedBankEmp}
          onChange={(e) => setSelectedBankEmp(e.target.value)}
          placeholder="Number of Employees"
        />
        <input
          type="text"
          value={selectedBankAddress}
          onChange={(e) => setSelectedBankAddress(e.target.value)}
          placeholder="Bank Address"
        />
        <input
          type="number"
          value={selectedBankBranches}
          onChange={(e) => setSelectedBankBranches(e.target.value)}
          placeholder="Number of Branches"
        />
        <input
          type="number"
          value={selectedBankATMs}
          onChange={(e) => setSelectedBankATMs(e.target.value)}
          placeholder="Number of ATMs"
        />
        <button onClick={handleUpdateBank}>Update Bank</button>
        {updateMessage && <p style={{ color: 'green' }}>{updateMessage}</p>}
      </div>


       {/* Toggle Banks List Section */}
       <button onClick={toggleBanksVisibility}>
        {showBanks ? 'Hide Banks' : 'Show Banks'}
      </button>
          <br></br>
      {/* Full Bank List Section */}
      {showBanks && (
        <div>
          <h2>All Banks</h2>
          <ul>
            {banks.map((bank) => (
              <li key={bank.bankID}>
                {bank.bankName} (ID: {bank.bankID}) - Year: {bank.bankYear} - Employees: {bank.bankEmp} - Branches: {bank.bankBranches} - ATMs: {bank.bankATMs}
              </li>
            ))}
          </ul>
        </div>
      )}
    </div>
  );
};

export default App;
