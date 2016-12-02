import axios from 'axios'

import {CLEAR_ACTUAL_ORDER, FETCH_ORDERS, CREATE_ORDER,
  GET_ORDER, UPDATE_ORDER, DELETE_ORDER, ADD_ITEM_TEMP_ORDER,
  ERROR, ROOT_URL, errorDispatch} from './'

export const ORDERS_URL = 'orders'

export function fetchOrders() {
  return dispatch => {
    axios.get(`${ROOT_URL}/${ORDERS_URL}`).then(response => {
      dispatch({
        type : FETCH_ORDERS,
        payload : response.data
      })
    }).catch(errorDispatch)
  }
}

export function createOrder(order) {
  console.log('order::::', order);
  return dispatch => {
    axios.post(`${ROOT_URL}/${ORDERS_URL}`, order).then( response => {
      dispatch({
        type : CREATE_ORDER,
        payload : response.data
      })
    }).catch(errorDispatch)
  }
}

export function getOrder(id) {
  return dispatch => {
    axios.get(`${ROOT_URL}/${ORDERS_URL}/${id}`).then( response => {
      dispatch({
        type :  GET_ORDER,
        payload : response.data
      })
    }).catch(errorDispatch)
  }
}

export function updateOrder(order) {
  return dispatch => {
    axios.put(`${ROOT_URL}/${ORDERS_URL}`, order)
    .then( response => {
      dispatch({
        type :  UPDATE_ORDER,
        payload : response.data
      })
    }).catch(errorDispatch)
  }
}


export function deleteOrder(order) {
  return dispatch => {
    axios.delete(`${ROOT_URL}/${ORDERS_URL}/${order.id}`)
    .then( response => {
      dispatch({
        type :  DELETE_ORDER,
        payload : order
      })
    }).catch(errorDispatch)
  }
}

export function clearActualOrder() {
  return dispatch => {
    return dispatch({
      type : CLEAR_ACTUAL_ORDER
    })
  }
}

export function addItemToList(item) {
  return dispatch => {
    return dispatch({
      type: ADD_ITEM_TEMP_ORDER,
      payload: item
    })
  };
}

export function filterOrder(searchString) {
  return dispatch => {
    axios.get(`${ROOT_URL}/${ORDERS_URL}`).then(response => {
      console.log(response);
      dispatch({
        type : FETCH_ORDERS,
        payload : response.data.filter((order) => {
          return order.id == searchString
          || order.accessKey.indexOf(searchString) != -1
          || order.appointment.date.indexOf(searchString) != -1
          || order.appointment.pet.name.indexOf(searchString) != -1
          || order.appointment.pet.customer.name.indexOf(searchString) != -1
          || order.appointment.pet.customer.cpf.indexOf(searchString) != -1//TODO: mover filtro para consulta no servidor 'FindLike'.
        })
      })
    }).catch(errorDispatch)
  }
}
