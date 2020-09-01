import React from 'react';
import {pay} from './Functions'

class Local extends React.Component{

    constructor() {
        super()
        this.state = {
          src: '',
          dstn: '',
          amt:'',
          errors: {}
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
          src: this.state.src,
          dstn: this.state.dstn,
          amt:this.state.amt
        };
    
        pay(obj).then(res => {
          if (res) {
            this.props.history.push(`/status`)
          }
        })
      }
    render() {
        return (
          <div className="container">
            <div className="row">
              <div className="col-md-6 mt-5 mx-auto">
                <form noValidate onSubmit={this.onSubmit}>
                  <h1 className="h3 mb-3 font-weight-normal text-white">Local Account Transfer</h1>
                  <div className="form-group text-white">
                    <label htmlFor="number">Enter Your Account Number</label>
                    <input
                      type="number"
                      className="form-control"
                      name="src"
                      placeholder="Source"
                      value={this.state.src}
                      onChange={this.onChange}
                    />
                  </div>
                  <div className="form-group text-white">
                    <label htmlFor="number">Enter Receipents Account Number</label>
                    <input
                      type="number"
                      className="form-control"
                      name="dstn"
                      placeholder="Destination"
                      value={this.state.dstn}
                      onChange={this.onChange}
                    />
                  </div>
                  <div className="form-group text-white">
                    <label htmlFor="number">Enter Total Ammount</label>
                    <input
                      type="number"
                      className="form-control"
                      name="amt"
                      placeholder="Ammount"
                      value={this.state.amt}
                      onChange={this.onChange}
                    />
                  </div>


                  <button
                    type="submit"
                    className="btn btn-lg btn-primary btn-block"
                  >
                    Transfer
                  </button>
                </form>
              </div>
            </div>
          </div>
        )
      }
    }
export default Local;