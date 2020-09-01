import axios from 'axios'

export const pay = obj=> {
  console.log("I was called");
  console.log(obj);
    return axios
      .post('http://localhost:8542/payments/make', {
        src: obj.src,
        dstn: obj.dstn,
        amt: obj.amt
      })
      .then(response => {
        //if(localStorage.getItem('usertoken')!=null) localStorage.removeItem('usertoken')
        localStorage.setItem('usertoken', response.data)
        console.log(response);
        return response.data
      })
      .catch(err => {
        console.log(err)
      })
  }

  export const stat = obj=> {
    console.log("I was called");
    console.log(obj);
      return axios
        .post('http://localhost:8542/status/get', {
          acc: obj.acc,
          tid: obj.tid
        })
        .then(response => {
          //if(localStorage.getItem('usertoken')!=null) localStorage.removeItem('usertoken')
          localStorage.setItem('usertoken', response.data)
          console.log(response);
          return response.data
        })
        .catch(err => {
          console.log(err)
        })
    }


    export const forex = obj=> {
      console.log("I was called");
      console.log(obj);
        return axios
          .post('http://localhost:8542/forex/cross', {
            src: obj.src,
            dstn: obj.dstn,
            amt: obj.amt
          })
          .then(response => {
            //if(localStorage.getItem('usertoken')!=null) localStorage.removeItem('usertoken')
            localStorage.setItem('usertoken', response.data)
            console.log(response);
            return response.data
          })
          .catch(err => {
            console.log(err)
          })
      }