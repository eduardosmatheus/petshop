import axios from 'axios'

import {CLEAR_ACTUAL_APPOINTMENT, FETCH_APPOINTMENTS, CREATE_APPOINTMENT,
  GET_APPOINTMENT, UPDATE_APPOINTMENT, DELETE_APPOINTMENT,
  ERROR, ROOT_URL, errorDispatch} from './'

export const APPOINTMENTS_URL = 'appointments'

export function fetchAppointments() {
  return dispatch => {
    axios.get(`${ROOT_URL}/${APPOINTMENTS_URL}`).then(response => {
      dispatch({
        type : FETCH_APPOINTMENTS,
        payload : response.data
      })
    }).catch(errorDispatch)
  }
}

export function createAppointments(appointments) {
  return dispatch => {
    axios.post(`${ROOT_URL}/${APPOINTMENTS_URL}`, appointments).then( response => {
      dispatch({
        type : CREATE_APPOINTMENT,
        payload : response.data
      })
    }).catch(errorDispatch)
  }
}

export function getAppointments(id) {
  return dispatch => {
    axios.get(`${ROOT_URL}/${APPOINTMENTS_URL}/${id}`).then( response => {
      dispatch({
        type :  GET_APPOINTMENT,
        payload : response.data
      })
    }).catch(errorDispatch)
  }
}

export function updateAppointments(appointments) {
  return dispatch => {
    axios.put(`${ROOT_URL}/${APPOINTMENTS_URL}`, appointments)
    .then( response => {
      dispatch({
        type :  UPDATE_APPOINTMENT,
        payload : response.data
      })
    }).catch(errorDispatch)
  }
}


export function deleteAppointments(appointments) {
  return dispatch => {
    axios.delete(`${ROOT_URL}/${APPOINTMENTS_URL}/${appointments.id}`)
    .then( response => {
      dispatch({
        type :  DELETE_APPOINTMENT,
        payload : appointments
      })
    }).catch(errorDispatch)
  }
}

export function clearActualAppointments() {
  return dispatch => {
    return dispatch({
      type : CLEAR_ACTUAL_APPOINTMENT
    })
  }
}

export function filterAppointments(searchString) {
  return dispatch => {
    axios.get(`${ROOT_URL}/${APPOINTMENTS_URL}`).then(response => {
      dispatch({
        type : FETCH_APPOINTMENTS,
        payload : response.data.filter((appointments) => {
          return appointments.id == searchString || appointments.name.indexOf(searchString) != -1 //TODO: mover filtro para consulta no servidor 'FindLike'.
        })
      })
    }).catch(errorDispatch)
  }
}
