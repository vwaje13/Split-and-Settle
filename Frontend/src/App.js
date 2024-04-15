import React from 'react';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import NavigationBar from './components/Shared/NavigationBar';
import Footer from './components/Shared/Footer';

// Other component imports...

const App = () => {
  return (
    <Router>
      <NavigationBar />
      <Switch>
        {/* Define your routes using the Route component */}
        <Route exact path="/" component={Home} />
        <Route path="/about" component={About} />
        {/* Add more routes as needed */}
      </Switch>
      <Footer />
    </Router>
  );
};

export default App;
