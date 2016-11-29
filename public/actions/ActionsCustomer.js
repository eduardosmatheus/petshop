import axios from 'axios'

import {CLEAR_ACTUAL_CUSTOMER, FETCH_CUSTOMERS, CREATE_CUSTOMER,
  GET_CUSTOMER, UPDATE_CUSTOMER, DELETE_CUSTOMER,
  ERROR, ROOT_URL, errorDispatch} from './'

export const CUSTOMERS_URL = 'customers'

export function fetchCustomers() {
  return dispatch => {
    axios.get(`${ROOT_URL}/${CUSTOMERS_URL}`).then(response => {
      dispatch({
        type : FETCH_CUSTOMERS,
        payload : response.data
      })
    }).catch(errorDispatch)
  }
}

export function createCustomer(customer) {
  return dispatch => {
    axios.post(`${ROOT_URL}/${CUSTOMERS_URL}`, customer).then( response => {
      dispatch({
        type : CREATE_CUSTOMER,
        payload : response.data
      })
    }).catch(errorDispatch)
  }
}

export function getCustomer(id) {
  return dispatch => {
    axios.get(`${ROOT_URL}/${CUSTOMERS_URL}/${id}`).then( response => {
      dispatch({
        type :  GET_CUSTOMER,
        payload : response.data
      })
    }).catch(errorDispatch)
  }
}

export function updateCustomer(customer) {
  return dispatch => {
    axios.put(`${ROOT_URL}/${CUSTOMERS_URL}`, customer)
    .then( response => {
      dispatch({
        type :  UPDATE_CUSTOMER,
        payload : response.data
      })
    }).catch(errorDispatch)
  }
}


export function deleteCustomer(customer) {
  return dispatch => {
    axios.delete(`${ROOT_URL}/${CUSTOMERS_URL}/${customer.id}`)
    .then( response => {
      dispatch({
        type :  DELETE_CUSTOMER,
        payload : customer
      })
    }).catch(errorDispatch)
  }
}

export function clearActualCustomer() {
  return dispatch => {
    return dispatch({
      type : CLEAR_ACTUAL_CUSTOMER
    })
  }
}

export function filterCustomer(searchString) {
  return dispatch => {
    axios.get(`${ROOT_URL}/${CUSTOMERS_URL}`).then(response => {
      dispatch({
        type : FETCH_CUSTOMERS,
        payload : response.data.filter((customer) => {
          return customer.id == searchString || customer.name.indexOf(searchString) != -1 //TODO: mover filtro para consulta no servidor 'FindLike'.
        })
      })
    }).catch(errorDispatch)
  }
}
