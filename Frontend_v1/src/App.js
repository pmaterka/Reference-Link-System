import React from 'react';
import './App.css';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';
import TreeComponent from "./components/TreeComponent";
import HeaderComponent from "./components/HeaderComponent";
import FooterComponent from "./components/FooterComponent";
import CreateTreeComponent from "./components/CreateTreeComponent";


function App() {
  return (
    <div className="App">
        <Router>
            <HeaderComponent/>
            <div className="container">
                <Switch>
                    <Route path="/" exact component={TreeComponent}></Route>
                    <Route path="/add/:id" component={CreateTreeComponent}></Route>
                </Switch>
            </div>
            <FooterComponent/>
        </Router>
    </div>
  );
}

export default App;
