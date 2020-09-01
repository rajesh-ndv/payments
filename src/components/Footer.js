import React from 'react'
import { Container,Row,Col } from 'react-bootstrap'
import {Navbar,Nav} from 'react-bootstrap'
class Footer extends React.Component{
    render(){
        return(
            <Navbar fixed ="bottom" bg="dark" variant="dark">
                <Container>
                    <Col lg={12} className="text-center text-muted">
                        All Rights Reserved-Rajesh
                    </Col>
                </Container>
            </Navbar>
        )
    }
}

export default Footer