import axios from 'axios'

import {FETCH_BREEDS, CREATE_BREED, GET_BRRED, UPDATE_BREED, DELETE_BREED, ERROR, ROOT_URL, errorDispatch} from './'
export const BREEDS_URL = 'breeds'

export function fetchBreeds() {
  return dispatch => {
    axios.get(`${ROOT_URL}/${BREEDS_URL}`).then(response => {
      dispatch({
        type : FETCH_BREEDS,
        payload : response.data
      })
    }).catch(errorDispatch)
  }
}

export function createBreed(props) {
  return dispatch => {
    axios.post(`${ROOT_URL}/${BREEDS_URL}`, props.name, { headers : {'Content-Type' : 'text/plain'} }).then( response => {
      dispatch({
        type : CREATE_BREED,
        payload : response.data
      })
    }).catch(errorDispatch)
  }
}

export function getBreed(id) {
  return dispatch => {
    axios.get(`${ROOT_URL}/${BREEDS_URL}/${id}`).then( response => {
      dispatch({
        type :  GET_BRRED,
        payload : response.data
      })
    }).catch(errorDispatch)
  }
}

export function updateBreed(breed) {
  console.log('breed: ', breed);
  return dispatch => {
    axios.put(`${ROOT_URL}/${BREEDS_URL}/edit`, breed.name, { headers : {'Content-Type' : 'text/plain'} }).then( response => {
      dispatch({
        type :  UPDATE_BRRED,
        payload : response.data
      })
    }).catch(errorDispatch)
  }
}


export function deleteBreed(breed) {
  return dispatch => {
    axios.delete(`${ROOT_URL}/${BREEDS_URL}/${breed}`, breed,
      {
        headers : {
          'Content-Type' : 'application/json',
          'Access-Control-Request-Origin': '*',
          'Access-Control-Request-Methods': 'DELETE'
        }
      }


    ).then( response => {
      dispatch({
        type :  DELETE_BREED,
        payload : response.data
      })
    }).catch(errorDispatch)
  }
}
