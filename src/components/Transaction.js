import React from 'react';
import {stat} from './Functions';
class Transaction extends React.Component{

    constructor() {
        super()
        this.state = {
          acc:'',
          tid:''
        }
    
        this.onChange = this.onChange.bind(this)
        this.onSubmit = this.onSubmit.bind(this)
      }

      onChange(e) {
        this.setState({ [e.target.name]: e.target.value })
      }
      onSubmit(e) {
        e.preventDefault()
        console.log("Here")
        const obj = {
          acc: this.state.acc,
          tid: this.state.tid
        };
    
        stat(obj).then(res => {
          if (res) {
            this.props.history.push(`/status`)
          }
        })
      }
    render(){
        return(
            <div className="container">
            <div className="row">
              <div className="col-md-6 mt-5 mx-auto">
                <form noValidate onSubmit={this.onSubmit}>
                  <h1 className="h3 mb-3 font-weight-normal text-white">Transaction Summary</h1>
                  <div className="form-group text-white">
                    <label htmlFor="number">Enter Your Account Number</label>
                    <input
                      type="number"
                      className="form-control"
                      name="acc"
                      placeholder="Account"
                      value={this.state.src}
                    />
                  </div>
                  <div className="form-group text-white">
                    <label htmlFor="number">Enter Transaction ID</label>
                    <input
                      type="number"
                      className="form-control"
                      name="tid"
                      placeholder="Transaction"
                      value={this.state.tid}
                    />
                  </div>
                  <button
                    type="submit"
                    className="btn btn-lg btn-primary btn-block"
                  >
                   Get Report
                  </button>
                </form>
              </div>
            </div>
          </div>
        )
    }
}
export default Transaction;