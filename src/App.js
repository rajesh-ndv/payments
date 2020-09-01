import React from 'react';
import './App.css';

import {Container, Row, Col} from 'react-bootstrap';
import {BrowserRouter as Router, Switch, Route} from 'react-router-dom';

import NavigationBar from './components/NavigationBar';
import Welcome from './components/Welcome';
import Local from './components/Local';
import Cross from './components/Cross';
import Transaction from './components/Transaction';
import Footer from './components/Footer';
import Status from './components/Status';
import Function from './components/Functions';
export default function App() {
  return (
    <Router>
        <NavigationBar/>
        <Container>
            <Row>
                <Col lg={12} className={"margin-top"}>
                    <Switch>
                        <Route path="/" exact component={Welcome}/>
                        <Route path="/add" exact component={Local}/>
                        <Route path="/list" exact component={Cross}/>
                        <Route path="/users" exact component={Transaction}/>
                        <Route path="/status" exact component={Status}/>
                    </Switch>
                </Col>
            </Row>
        </Container>
        <Footer/>
    </Router>
  );
}