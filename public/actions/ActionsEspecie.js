import axios from 'axios'

import {CLEAR_ACTUAL_ESPECIE, FETCH_ESPECIES, CREATE_ESPECIE,
  GET_ESPECIE, UPDATE_ESPECIE, DELETE_ESPECIE,
  ERROR, ROOT_URL, errorDispatch} from './'

export const ESPECIES_URL = 'especies'

export function fetchEspecies() {
  return dispatch => {
    axios.get(`${ROOT_URL}/${ESPECIES_URL}`).then(response => {
      dispatch({
        type : FETCH_ESPECIES,
        payload : response.data
      })
    }).catch(errorDispatch)
  }
}

export function createEspecie(especie) {
  console.log(especie);
  return dispatch => {
    axios.post(`${ROOT_URL}/${ESPECIES_URL}`, especie).then( response => {
      dispatch({
        type : CREATE_ESPECIE,
        payload : response.data
      })
    }).catch(errorDispatch)
  }
}

export function getEspecie(id) {
  return dispatch => {
    axios.get(`${ROOT_URL}/${ESPECIES_URL}/${id}`).then( response => {
      dispatch({
        type :  GET_ESPECIE,
        payload : response.data
      })
    }).catch(errorDispatch)
  }
}

export function updateEspecie(especie) {
  return dispatch => {
    axios.put(`${ROOT_URL}/${ESPECIES_URL}`, especie)
    .then( response => {
      dispatch({
        type :  UPDATE_ESPECIE,
        payload : response.data
      })
    }).catch(errorDispatch)
  }
}


export function deleteEspecie(especie) {
  return dispatch => {
    axios.delete(`${ROOT_URL}/${ESPECIES_URL}/${especie.id}`)
    .then( response => {
      dispatch({
        type :  DELETE_ESPECIE,
        payload : especie
      })
    }).catch(errorDispatch)
  }
}

export function clearActualEspecie() {
  return dispatch => {
    return dispatch({
      type : CLEAR_ACTUAL_ESPECIE
    })
  }
}

export function filterEspecie(searchString) {
  return dispatch => {
    axios.get(`${ROOT_URL}/${ESPECIES_URL}`).then(response => {
      dispatch({
        type : FETCH_ESPECIES,
        payload : response.data.filter((especie) => {
          return especie.id == searchString || especie.description.indexOf(searchString) != -1 //TODO: mover filtro para consulta no servidor 'FindLike'.
        })
      })
    }).catch(errorDispatch)
  }
}
