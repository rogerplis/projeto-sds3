import BarChart from "components/BarCharts";
import DataTable from "components/DataTable";
import DonutChart from "components/DonutChart";
import Footer from "components/Footer";
import NavBar from "components/NavBar";

function App() {
  return (
    <>
      <NavBar />
      <div className="App">
        <h1 className="text-primary py-3">DashBoard de Vendas</h1>
        <div className="row px-3">
          <div className="col-sm-6">
            <h5>Taxa de retorno</h5>
            <BarChart/>
          </div>
          <div className="col-sm-6">
            <h5>Taxa de retorno</h5>
            <DonutChart/>
          </div>
        </div>
    <div className="py-3">
      <h3 className="text-secondary" >Todas Vendas</h3>
    </div>
        <DataTable />
      </div>
      <Footer />
    </>
  );
}

export default App;
