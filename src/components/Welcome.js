import React from 'react';
import {Container,Row,Jumbotron,Col} from 'react-bootstrap';
class Welcome extends React.Component{
    render(){
        return(
            <Jumbotron className="bg-dark text-white">
              <h1>Virtusa Payment Services</h1>
            </Jumbotron>
        )
    }
}
export default Welcome