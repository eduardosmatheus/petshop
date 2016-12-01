import axios from 'axios'

import {CLEAR_ACTUAL_EMPLOYEER, FETCH_EMPLOYEERS, CREATE_EMPLOYEER,
  GET_EMPLOYEER, UPDATE_EMPLOYEER, DELETE_EMPLOYEER,
  ERROR, ROOT_URL, errorDispatch} from './'

export const EMPLOYEERS_URL = 'employeers'

export function fetchEmployeers() {
  return dispatch => {
    axios.get(`${ROOT_URL}/${EMPLOYEERS_URL}`).then(response => {
      dispatch({
        type : FETCH_EMPLOYEERS,
        payload : response.data
      })
    }).catch(errorDispatch)
  }
}

export function createEmployeer(employeer) {
  return dispatch => {
    axios.post(`${ROOT_URL}/${EMPLOYEERS_URL}`, employeer).then( response => {
      dispatch({
        type : CREATE_EMPLOYEER,
        payload : response.data
      })
    }).catch(errorDispatch)
  }
}

export function getEmployeer(id) {
  return dispatch => {
    axios.get(`${ROOT_URL}/${EMPLOYEERS_URL}/${id}`).then( response => {
      dispatch({
        type :  GET_EMPLOYEER,
        payload : response.data
      })
    }).catch(errorDispatch)
  }
}

export function updateEmployeer(employeer) {
  return dispatch => {
    axios.put(`${ROOT_URL}/${EMPLOYEERS_URL}`, employeer)
    .then( response => {
      dispatch({
        type :  UPDATE_EMPLOYEER,
        payload : response.data
      })
    }).catch(errorDispatch)
  }
}


export function deleteEmployeer(employeer) {
  return dispatch => {
    axios.delete(`${ROOT_URL}/${EMPLOYEERS_URL}/${employeer.id}`)
    .then( response => {
      dispatch({
        type :  DELETE_EMPLOYEER,
        payload : employeer
      })
    }).catch(errorDispatch)
  }
}

export function clearActualEmployeer() {
  return dispatch => {
    return dispatch({
      type : CLEAR_ACTUAL_EMPLOYEER
    })
  }
}

export function filterEmployeer(searchString) {
  return dispatch => {
    axios.get(`${ROOT_URL}/${EMPLOYEERS_URL}`).then(response => {
      dispatch({
        type : FETCH_EMPLOYEERS,
        payload : response.data.filter((employeer) => {
          return employeer.id == searchString || employeer.name.indexOf(searchString) != -1 //TODO: mover filtro para consulta no servidor 'FindLike'.
        })
      })
    }).catch(errorDispatch)
  }
}
