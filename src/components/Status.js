import React, { Component } from 'react'
import jwt_decode from 'jwt-decode'
class Status extends Component {
  constructor() {
    super()
    this.state = {
      transaction_id: '',
      account_from: '',
      account_to: '',
      closing: '',
      opening: '',
      trans_status: '',
      ldt: '',
      status: '',
      errors: {}
    }
  }

  componentDidMount() {
    const token = localStorage.usertoken
    this.setState({
        transaction_id: token.transaction_id,
        account_from: token.account_from,
        account_to: token.account_to,
        closing: token.closing,
        opening: token.opening,
        trans_status: token.trans_status,
        ldt: token.ldt,
        status: token.status,
    })
  }

  render() {
    return (
      <div className="container">
        <div className="jumbotron mt-5">
          <div className="col-sm-8 mx-auto">
            <h1 className="text-center">Transaction Summary</h1>
          </div>
          <table className="table col-md-6 mx-auto">
            <tbody>
              <tr>
                <td>Transaction Id</td>
                <td>{this.state.transaction_id}</td>
              </tr>
              <tr>
                <td>From Account</td>
                <td>{this.state.account_from}</td>
              </tr>
              <tr>
                <td>To Account</td>
                <td>{this.state.account_to}</td>
              </tr>
              <tr>
                <td>Closing</td>
                <td>{this.state.closing}</td>
              </tr>
              <tr>
                <td>Opening</td>
                <td>{this.state.opening}</td>
              </tr>
              <tr>
                <td>Transaction Message</td>
                <td>{this.state.trans_status}</td>
              </tr>
              <tr>
                <td>Timestamp</td>
                <td>{this.state.ldt}</td>
              </tr>
              <tr>
                <td>Status</td>
                <td>{this.state.status}</td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    )
  }
}

export default Status