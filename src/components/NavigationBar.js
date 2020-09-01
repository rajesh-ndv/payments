import React from 'react';

import {Navbar, Nav} from 'react-bootstrap';
import {Link} from 'react-router-dom';

export default function NavigationBar() {
    return (
        <Navbar bg="dark" variant="dark">
            <Link to={""} className="navbar-brand">
                <img src="https://upload.wikimedia.org/wikipedia/commons/b/ba/Book_icon_1.png" width="25" height="25" alt="brand"/> Payments
            </Link>
            <Nav className="mr-auto">
                <Link to={"add"} className="nav-link">Local</Link>
                <Link to={"list"} className="nav-link">Cross</Link>
                <Link to={"users"} className="nav-link">Transaction</Link>
            </Nav>
        </Navbar>
    );
}