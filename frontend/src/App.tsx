import DataTable from 'components/DataTable';
import Footer from 'components/Footer';
import NavBar from 'components/NavBar';
import React from 'react';
import logo from './logo.svg';


function App() {
  return (
    <>
    <NavBar/>
    <div className="App">
      <h1 className="text-primary"  >Ola Mundo</h1>   
      <DataTable/>  
        </div>
        <Footer/>        
    </>
  );
}

export default App;
